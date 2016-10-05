import '../../node_modules/jquery/src/jquery.js'
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js';
import './css/main.css';
import './css/navbar.css';
document.getElementsByName('facebook').forEach(function(img){
 img.src = require('./images/facebook.png');});
document.getElementsByName('twitter').forEach(function(img){
 img.src = require('./images/twitter.png');});
document.getElementsByName('logo').forEach(function(img){
 img.src = require('./images/logo.png');});
document.getElementsByName('alex').forEach(function(img){
 img.src = require('./images/alex.png');});
