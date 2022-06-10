import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

function App() {
  let [글제목, 글제목변경] = useState([
    "남자 코트 추천",
    "강남 우동 맛집",
    "파이썬 독학",
  ]);
  let [logo, setLogo] = useState("ReactBlog");
  let [따봉, 따봉변경] = useState([0, 0, 0]);
  let [modal, setModal] = useState(false);
  let [modalnum, setModalnum] = useState(0);

  return (
    <div className="App">
      <div className="black-nav">
        <h4>{logo}</h4>
      </div>

      <button
        onClick={() => {
          let copy2 = [...글제목];
          글제목변경(copy2.sort());
        }}
      >
        가나다순 정렬
      </button>
      <button
        onClick={() => {
          let copy = [...글제목];
          copy[0] = "여자코트 추천";
          글제목변경(copy);
        }}
      >
        수정버튼
      </button>
      {글제목.map(function (a, i) {
        return (
          <div className="list">
            <h4
              onClick={() => {
                {
                  modalnum === i
                    ? modal === true
                      ? setModal(false)
                      : setModal(true)
                    : modal === true
                    ? setModal(true)
                    : setModal(true);
                  setModalnum(i);
                }
              }}
            >
              {a}
              <span
                onClick={() => {
                  let copy = [...따봉];
                  copy[i] = copy[i] + 1;
                  따봉변경(copy);
                }}
              >
                👍
              </span>{" "}
              {따봉[i]}
            </h4>
            <p>2월 17일 발행</p>
          </div>
        );
      })}
      {modal === true ? (
        <Modal modalnum={modalnum} 글제목={글제목} 글제목변경={글제목변경} />
      ) : null}
    </div>
  );
}
function Modal(props) {
  return (
    <div className="modal">
      <h4>{props.글제목[props.modalnum]}</h4>
      <p>날짜</p>
      <p>상세내용</p>
    </div>
  );
}

export default App;
