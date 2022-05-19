const express = require("express"); // express라이브러리 사용

const app = express(); // 객체를 만듬
app.use(express.urlencoded({ extended: true }));
app.set("view engine", "ejs");

var db;
const MongoClient = require("mongodb").MongoClient;

MongoClient.connect(
  "mongodb+srv://admin:qwer1234@cluster0.2xnrj.mongodb.net/?retryWrites=true&w=majority",
  function (err, client) {
    if (err) {
      return console.log(err);
    }
    db = client.db("todoapp");

    app.listen(8080, function () {
      console.log("listening on port 8080");
    });
  }
);

app.get("/pet", function (요청, 응답) {
  응답.send("펫용품 페이지입니다.");
});

app.get("/beauty", function (요청, 응답) {
  응답.send("뷰티용품 사세요");
});

app.get("/", function (요청, 응답) {
  응답.sendFile(__dirname + "/index.html");
});

app.get("/write", function (요청, 응답) {
  응답.sendFile(__dirname + "/write.html");
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
  });
});
