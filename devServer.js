var express = require('express');
    serveStatic = require('serve-static');

var app = express();

app.use(serveStatic("./src"));
app.listen(8811);
