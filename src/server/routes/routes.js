import info from './info'

module.exports = function (app) {
  app.get('/', function (req, res) {
    res.render('main', {
      title: '',
      bodyClass: 'index',
      jsFile: 'index.js'
    })
  })

  app.get('/products', function (req, res) {
    res.render('main', {
      title: 'Products',
      bodyClass: 'products',
      jsFile: 'products.js'
    })
  })

  app.get('/hire', function (req, res) {
    res.render('main', {
      title: 'Hire Us',
      bodyClass: 'hire',
      jsFile: 'hire.js'
    })
  })

  app.get('/about', function (req, res) {
    res.render('main', {
      title: 'About Us',
      bodyClass: 'about',
      jsFile: 'about.js'
    })
  })

  app.get('/careers', function (req, res) {
    res.render('main', {
      title: 'Careers',
      bodyClass: 'careers',
      jsFile: 'careers.js'
    })
  })

  app.get('/contact', function (req, res) {
    res.render('main', {
      title: 'Contact Us',
      bodyClass: 'contact',
      jsFile: 'contact.js'
    })
  })

  app.get('/privacy', function (req, res) {
    res.render('main', {
      title: 'Privacy Policy',
      bodyClass: 'privacy',
      jsFile: 'privacy.js'
    })
  })

  app.get('/terms-of-use', function (req, res) {
    res.render('main', {
      title: 'Terms of Use',
      bodyClass: 'terms-of-use',
      jsFile: 'termsofuse.js'
    })
  })

  app.get('/end-user-license-agreement', function (req, res) {
    res.render('main', {
      title: 'End User License Agreement',
      bodyClass: 'end-user-license-agreement',
      jsFile: 'enduserlicenseagreement.js'
    })
  })

  app.get('/info', info)
}
