const express = require("express"); // express라이브러리 사용

const app = express(); // 객체를 만듬
app.use(express.urlencoded({ extended: true }));

app.listen(8080, function () {
  console.log("listening on port 8080");
}); // 서버를 열고 function을 실행

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

app.post("/add", function (요청, 응답) {
  응답.send("전송완료");
  console.log(요청.body);
});
