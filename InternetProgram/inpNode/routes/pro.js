const express = require("express");
const pool = require("../pool.js");

let router = express.Router();

router.get("/v1/login/:uname&:upwd", (req, res) => {
  var $uname = req.params.uname;
  var $upwd = req.params.upwd;
  var sql = "select * from websites where id=? and name=?";

  pool.query(sql, [$uname, $upwd], (err, results) => {
    if (err) {
      throw err;
    }
    console.log(results);
    if (results.length > 0) {
      res.send("1");
    } else {
      res.send("0");
    }
  });
});
module.exports = router;
