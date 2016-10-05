module.exports = function(app) {

app.get('/', function(req, res) {
  res.render('index', {
    title: "",
    bodyClass: "index"
  });
});

app.get('/products', function(req, res) {
  res.render('products', {
    title: "Products",
    bodyClass: 'products'
  });
});

app.get('/hire', function(req, res) {
  res.render('hire', {
    title: "Hire Us",
    bodyClass: "hire"
  });
});

app.get('/about', function(req, res) {
  res.render('about', {
    title: "About Us",
    bodyClass: "about"
  });
});

app.get('/careers', function(req, res) {
  res.render('careers', {
    title: "Careers",
    bodyClass: "careers"
  });
});

app.get('/contact', function(req, res) {
  res.render('contact', {
    title: "Contact Us",
    bodyClass: "contact"
  });
});

app.get('/privacy', function(req, res) {
  res.render('privacy', {
    title: "Privacy Policy",
    bodyClass: "privacy"
  });
});

app.get('/terms-of-use', function(req, res) {
  res.render('terms-of-use', {
    title: "Terms of Use",
    bodyClass: "terms-of-use"
  });
});

app.get('/end-user-license-agreement', function(req, res) {
  res.render('end-user-license-agreement', {
    title: "End User License Agreement",
    bodyClass: "index"
  });
});
}
