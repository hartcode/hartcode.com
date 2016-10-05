const express = require('express');
const routes = require('./routes/routes');
const port = process.env.PORT || 8811;
const app = express();

app.set('view engine', 'ejs');

routes(app);

app.use(express.static(__dirname + '/../../build/client/'));

app.listen(port);
