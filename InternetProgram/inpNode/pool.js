const mysql = require("mysql");

let pool = mysql.createPool({
  host: "localhost",
  user: "root",
  port: 3306,
  password: "open9711@@",
  database: "HWDB",
  connectionLimit: 15,
});

module.exports = pool;
