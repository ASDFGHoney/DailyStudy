// required modules
const express = require("express");
const bodyParser = require("body-parser");
const proRouter = require("./routes/pro.js");
// create a web server instance
let app = express();

app.listen(8081);
app.use(express.static("pro"));
app.use(bodyParser.urlencoded({ extended: false }));

app.use("/pro", proRouter);
