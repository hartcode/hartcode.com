// css
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './css/main.css';
import './css/navbar.css';

// js dependencies
import '../../node_modules/jquery/src/jquery.js'
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js';
//import './components/index.js'

document.getElementsByName('facebook').forEach(function(img){
 img.src = require('./images/facebook.png');});
document.getElementsByName('twitter').forEach(function(img){
 img.src = require('./images/twitter.png');});
document.getElementsByName('github').forEach(function(img){
 img.src = require('./images/github.png');});
document.getElementsByName('githublight').forEach(function(img){
 img.src = require('./images/githublight.png');});
document.getElementsByName('logo').forEach(function(img){
 img.src = require('./images/logo.png');});
document.getElementsByName('alex').forEach(function(img){
 img.src = require('./images/alex.png');});
