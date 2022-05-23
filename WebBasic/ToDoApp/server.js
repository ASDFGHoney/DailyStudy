const express = require("express"); // express라이브러리 사용

const app = express(); // 객체를 만듬
app.use(express.urlencoded({ extended: true }));
app.set("view engine", "ejs");

app.use("/public", express.static("public"));
const methodOverride = require("method-override");
app.use(methodOverride("_method"));

var db;
const MongoClient = require("mongodb").MongoClient;

require("dotenv").config();

MongoClient.connect(process.env.DB_URL, function (err, client) {
  if (err) {
    return console.log(err);
  }
  db = client.db("todoapp");

  app.listen(process.env.PORT, function () {
    console.log("listening on port 8080");
  });
});

app.get("/pet", function (요청, 응답) {
  응답.send("펫용품 페이지입니다.");
});

app.get("/beauty", function (요청, 응답) {
  응답.send("뷰티용품 사세요");
});

app.get("/", function (요청, 응답) {
  응답.render("index.ejs");
});

app.get("/write", function (요청, 응답) {
  응답.render("write.ejs");
});

// 어떤 사람이 /add 경로로 post 요청을 하면 data두개를 post라는 이름을 가진 collecrion에 두개 데이터 저장하기
app.post("/add", function (요청, 응답) {
  db.collection("counter").findOne(
    { name: "게시물갯수" },
    function (에러, 결과) {
      console.log(결과.totalPost);
      var 총게시물갯수 = 결과.totalPost;

      db.collection("post").insertOne(
        { _id: 총게시물갯수 + 1, 제목: 요청.body.title, 날짜: 요청.body.date }, //auto increment
        function (에러, 결과) {
          console.log("저장완료");
          db.collection("counter").updateOne(
            { name: "게시물갯수" },
            { $inc: { totalPost: 1 } }, // $set 는 operater
            function (에러, 결과) {
              if (에러) {
                return console.log(에러);
              }
            }
          );
        }
      );
    }
  );

  응답.send("전송완료");
  console.log(요청.body.date);
  console.log(요청.body.title);
});

app.get("/list", function (요청, 응답) {
  // 디비에 저장된 post라는 collection안의 모든 데이터를 꺼내주세요.
  db.collection("post")
    .find()
    .toArray(function (에러, 결과) {
      console.log(결과);
      응답.render("list.ejs", { posts: 결과 });
    });
});

app.delete("/delete", function (요청, 응답) {
  console.log(요청.body);
  요청.body._id = parseInt(요청.body._id);

  db.collection("post").deleteOne(요청.body, function (에러, 결과) {
    console.log("삭제완료");
    응답.status(200).send({ message: "성공했습니다." }); // 200 요청 성공이라는 뜻, 400 요청 실패
  });
});

app.get("/detail/:id", function (요청, 응답) {
  db.collection("post").findOne(
    { _id: parseInt(요청.params.id) },
    function (에러, 결과) {
      console.log("🚀 ~ file: server.js ~ line 93 ~ 결과", 결과);
      응답.render("detail.ejs", { data: 결과 });
    }
  );
});

app.get("/edit/:id", function (req, res) {
  db.collection("post").findOne(
    { _id: parseInt(req.params.id) },
    function (에러, 결과) {
      console.log("🚀 ~ file: server.js ~ line 107 ~ 결과", 결과);

      res.render("edit.ejs", { post: 결과 });
    }
  );
});

app.put("/edit", function (req, res) {
  // 폼에 담긴 제목 데이터, 날짜 데이러를 가지고 db.collection에다가 업데이트
  db.collection("post").updateOne(
    { _id: parseInt(req.body.id) },
    { $set: { 제목: req.body.title, 날짜: req.body.date } },
    function (에러, 결과) {
      console.log("수정완료");
      res.redirect("/list");
    }
  );
});

const passport = require("passport");
const LocalStrategy = require("passport-local").Strategy;
const session = require("express-session");

app.use(
  session({ secret: "비밀코드", resave: true, saveUninitialized: false })
);
app.use(passport.initialize());
app.use(passport.session());

app.get("/login", function (req, res) {
  res.render("login.ejs");
});
app.post(
  "/login",
  passport.authenticate("local", {
    failureRedirect: "/fail",
  }),
  function (req, res) {
    res.redirect("/");
  }
);

app.get("/mypage", 로그인했니, function (요청, 응답) {
  console.log(요청.user);
  응답.render("mypage.ejs", { 사용자: 요청.user });
});

function 로그인했니(요청, 응답, next) {
  if (요청.user) {
    next();
  } else {
    응답.send("로그인 안하셨는데요?");
  }
}

passport.use(
  new LocalStrategy(
    {
      usernameField: "id",
      passwordField: "pw",
      session: true,
      passReqToCallback: false,
    },
    function (입력한아이디, 입력한비번, done) {
      //console.log(입력한아이디, 입력한비번);
      db.collection("login").findOne(
        { id: 입력한아이디 },
        function (에러, 결과) {
          if (에러) return done(에러);

          if (!결과)
            return done(null, false, { message: "존재하지않는 아이디요" });
          if (입력한비번 == 결과.pw) {
            return done(null, 결과);
          } else {
            return done(null, false, { message: "비번틀렸어요" });
          }
        }
      );
    }
  )
);

passport.serializeUser(function (user, done) {
  done(null, user.id);
});

passport.deserializeUser(function (아이디, done) {
  // 디비에서 user.id로 유저를 찾은 뒤에 유저정보를 아래 중괄호에 넣음
  db.collection("login").findOne({ id: 아이디 }, function (에러, 결과) {
    done(null, 결과);
  });
});

app.get("/search", (요청, 응답) => {
  console.log(요청.query.value);
  db.collection("post")
    .find({ 제목: 요청.query.value })
    .toArray((에러, 결과) => {
      응답.render("search.ejs", { posts: 결과 });
    });
});
