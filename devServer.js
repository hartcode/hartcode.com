var connect = require('connect'),
    serveStatic = require('serve-static');

var app = connect();

app.use(serveStatic("./src"));
app.listen(8811);