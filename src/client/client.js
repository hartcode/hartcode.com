require('../../node_modules/jquery/src/jquery.js')
require('../../node_modules/bootstrap/dist/css/bootstrap.min.css');
require('../../node_modules/bootstrap/dist/js/bootstrap.min.js');
require('./css/main.css');
require('./css/navbar.css');
document.getElementsByName('facebook').forEach(function(img){
 img.src = require('./images/facebook.png');});
document.getElementsByName('twitter').forEach(function(img){
 img.src = require('./images/twitter.png');});
document.getElementsByName('logo').forEach(function(img){
 img.src = require('./images/logo.png');});
document.getElementsByName('alex').forEach(function(img){
 img.src = require('./images/alex.png');});
