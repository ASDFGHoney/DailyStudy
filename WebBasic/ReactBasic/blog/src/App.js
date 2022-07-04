import logo from './logo.svg';
import { useState } from 'react'
import './App.css';

function App() {
  let post = "강남 우동 맛집";
  var data = "red";
  let [글제목, b] = useState(["남자 코트 추천", "강남 우동 맛집", "파이썬 독학"]);
  let [좋아요, a] = useState([0, 0, 0])

  return (
    <div className='App'>
      <div className='black-nav'>
        <div>블로그임</div>
      </div>
      <div className='list'>
        <h4> {글제목[0]} <span>👍</span> {좋아요[0]} </h4>
        <p>2월 17일 발행</p>
      </div>
      <div className='list'>
        <h4> {글제목[0]} <span>👍</span> {좋아요[0]} </h4>
        <p>2월 17일 발행</p>
      </div>
      <div className='list'>
        <h4> {글제목[0]} <span>👍</span> {좋아요[0]} </h4>
        <p>2월 17일 발행</p>
      </div>
    </div>
  );
}

export default App;
