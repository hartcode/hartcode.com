var express = require('express');
var app = express();

app.set('view engine', 'ejs');

app.get('/', function(req, res) {
  res.render('index');
});

app.get('/products', function(req, res) {
  res.render('products');
});

app.get('/hire', function(req, res) {
  res.render('hire');
});

app.get('/about', function(req, res) {
  res.render('about');
});

app.get('/careers', function(req, res) {
  res.render('careers');
});

app.get('/contact', function(req, res) {
  res.render('contact');
});

app.get('/privacy', function(req, res) {
  res.render('privacy');
});

app.get('/terms', function(req, res) {
  res.render('terms');
});

app.use(express.static(__dirname + '/html'));

app.listen(8811);
