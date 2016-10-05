import express from 'express';
import routes from './routes/routes';
var port = process.env.PORT || 8811;
var app = express();

app.set('view engine', 'ejs');

routes(app);

app.use(express.static(__dirname + '/../static'));

app.listen(port);
