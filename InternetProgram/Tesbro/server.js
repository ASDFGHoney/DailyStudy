const express = require("express"); // express라이브러리 사용
require("dotenv").config();

const app = express(); // 객체를 만듬

const http = require("http").createServer(app);
const { Server } = require("socket.io");
const io = new Server(http);

app.use("/public", express.static("public"));
app.use(express.urlencoded({ extended: true }));
app.engine("html", require("ejs").renderFile);
app.set("view engine", "ejs");
const methodOverride = require("method-override");
app.use(methodOverride("_method"));

var db;
const MongoClient = require("mongodb").MongoClient;

MongoClient.connect(
  process.env.DB_URL,
  { useUnifiedTopology: true },
  function (err, client) {
    if (err) {
      return console.log("🚀 ~ file: server.js ~ line 20 ~ err", err);
    }
    db = client.db("tesbro");

    http.listen(process.env.PORT, function () {
      console.log("listening on 8080");
    });
  }
);

function 로그인했니(req, res, next) {
  if (req.user) {
    next();
  } else {
    res.redirect("/login");
  }
}
function 로그인했니2(req, res, next) {
  if (req.user) {
    next();
  } else {
    res.redirect("/login");
  }
}

const passport = require("passport");
const LocalStrategy = require("passport-local").Strategy;
const session = require("express-session");

app.use(
  session({ secret: "비밀코드", resave: true, saveUninitialized: false })
);
app.use(passport.initialize());
app.use(passport.session());

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
            return done(null, false, {
              message: "존재하지 않는 아이디입니다.",
            });
          if (입력한비번 == 결과.pw) {
            return done(null, 결과);
          } else {
            return done(null, false, { message: "비번이 틀렸습니다" });
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

app.get("/", function (req, res) {
  db.collection("menu")
    .find()
    .toArray(function (에러, 결과) {
      console.log(결과);
      res.render("index.ejs", { posts: 결과, user: req.user });
    });
});

app.get("/game", 로그인했니, function (req, res) {
  res.render("game.html");
});

let multer = require("multer");
var storage = multer.diskStorage({
  destination: function (req, file, cb) {
    cb(null, "./public/image");
  },
  filename: function (req, file, cb) {
    cb(null, file.originalname);
  },
  filefilter: function (req, file, cb) {},
});
var upload = multer({ storage: storage });

app.get("/upload", (req, res) => {
  res.render("upload.ejs");
});

app.post("/upload", upload.single("foodimg"), (req, res) => {
  console.log(
    "🚀 ~ file: server.js ~ line 120 ~ app.post ~ req.file",
    req.file
  );
  db.collection("menu").insertOne(
    {
      file: req.file.filename,
      name: req.body.foodname,
      exp: req.body.foodex,
    },
    function (에러, 결과) {
      res.redirect("/");
    }
  );
});
app.get("/coupon", (req, res) => {
  db.collection("coupon").insertOne(
    { per: "10% discount" },
    function (에러, 결과) {
      console.log(
        "🚀 ~ file: server.js ~ line 143 ~ app.get ~ 결과",
        결과.ops[0]._id
      );
      res.render("coupon.ejs", { id: 결과.ops[0]._id });
    }
  );
});

app.get("/image/:imageName", function (req, res) {
  res.sendFile(__dirname + "/public/image/" + req.params.imageName);
});

//회원 관리
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
app.get("/register", function (req, res) {
  res.render("register.ejs");
});
app.post("/register", function (req, res) {
  db.collection("login").insertOne(
    {
      id: req.body.id,
      pw: req.body.pw,
      name: req.body.name,
      mail: req.body.mail,
    },
    function (에러, 결과) {
      res.redirect("/login");
    }
  );
});

app.get("/mypage", 로그인했니, function (요청, 응답) {
  console.log(요청.user);
  응답.render("mypage.ejs", { 사용자: 요청.user });
});

// QnA

app.get("/write", function (요청, 응답) {
  응답.render("write.ejs");
});
app.get("/menuupdate", function (요청, 응답) {
  응답.render("upload.ejs");
});
app.get("/list", 로그인했니, function (요청, 응답) {
  // 디비에 저장된 post라는 collection안의 모든 데이터를 꺼내주세요.
  db.collection("post")
    .find()
    .toArray(function (에러, 결과) {
      console.log(결과);
      응답.render("list.ejs", { posts: 결과, user: 요청.user });
    });
});
app.post("/add", function (요청, 응답) {
  db.collection("counter").findOne(
    { name: "게시물갯수" },
    function (에러, 결과) {
      console.log(결과.totalPost);
      var 총게시물갯수 = 결과.totalPost;

      var 저장할거 = {
        _id: 총게시물갯수 + 1,
        작성자: 요청.user._id,
        제목: 요청.body.title,
        내용: 요청.body.comment,
      };
      db.collection("post").insertOne(
        저장할거, //auto increment
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

          db.collection("chatroom").insertOne(
            {
              postId: 총게시물갯수 + 1,
              title: 저장할거.제목,
              date: new Date(),
            },
            function (err, result) {
              console.log(
                "🚀 ~ file: server.js ~ line 206 ~ db.collection ~ err",
                err
              );
            }
          );
        }
      );
    }
  );

  응답.redirect("/list");

  console.log(요청.body.comment);
  console.log(요청.body.title);
});
app.delete("/delete", function (요청, 응답) {
  console.log(요청.body);
  요청.body._id = parseInt(요청.body._id);

  var 삭제할데이터 = { _id: 요청.body._id, 작성자: 요청.user._id };

  db.collection("post").deleteOne(삭제할데이터, function (에러, 결과) {
    console.log("삭제완료");
    응답.status(200).send({ message: "성공했습니다." }); // 200 요청 성공이라는 뜻, 400 요청 실패
  });
});

app.get("/search", (요청, 응답) => {
  var 검색조건 = [
    {
      $search: {
        index: "titleSearch",
        text: {
          query: 요청.query.value,
          path: "제목",
        },
      },
    },
    { $project: { 제목: 1, _id: 0, score: { $meta: "searchScore" } } },
  ];

  db.collection("post")
    .aggregate(검색조건)
    .toArray((에러, 결과) => {
      console.log("🚀 ~ file: server.js ~ line 227 ~ .toArray ~ 결과", 결과);
      응답.render("search.ejs", { posts: 결과 });
    });
});

app.post("/chat", 로그인했니, (req, res) => {
  console.log(
    "🚀 ~ file: server.js ~ line 260 ~ app.get ~ req.body._id",
    typeof req.body._id
  );
  db.collection("chatroom").findOne(
    { postId: parseInt(req.body._id) },
    function (err, chatroom) {
      console.log(
        "🚀 ~ file: server.js ~ line 262 ~ app.get ~ chatroom",
        chatroom
      );

      res.render("chat.ejs", { posts: chatroom });
    }
  );
});

app.post("/message", 로그인했니, function (req, res) {
  var 저장할거 = {
    parent: req.body.parent,
    content: req.body.content,
    userid: req.user._id,
    date: new Date(),
  };

  db.collection("message")
    .insertOne(저장할거)
    .then(() => {
      console.log("db저장성공");
      res.send("db저장성공");
    });
});

app.get("/message/:id", 로그인했니, function (요청, 응답) {
  응답.writeHead(200, {
    Connection: "keep-alive",
    "Content-Type": "text/event-stream",
    "Cache-Control": "no-cache",
  });

  db.collection("message")
    .find({ parent: 요청.params.id })
    .toArray()
    .then((결과) => {
      응답.write("event: test\n");
      응답.write("data: " + JSON.stringify(결과) + "\n\n");
    });
  const pipeline = [{ $match: { "fullDocument.parent": 요청.params.id } }];
  const collection = db.collection("message");
  const changeStream = collection.watch(pipeline);
  changeStream.on("change", (result) => {
    console.log(
      "🚀 ~ file: server.js ~ line 338 ~ changeStream.on ~ result.fullDocument",
      result.fullDocument
    );
    응답.write("event: test\n");
    응답.write("data: " + JSON.stringify([result.fullDocument]) + "\n\n");
  });
});

io.on("connection", function (socket) {
  console.log("연결되었어요");

  socket.on("room1-send", function (data) {
    io.to("room1").emit("broadcast", data);
  });
  socket.on("joinroom", function (data) {
    socket.join("room1");
  });
  socket.on("user-send", function (data) {
    console.log(data);
    io.emit("broadcast", data);
  });
});
