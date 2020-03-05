import info from './info'

module.exports = function(app) {
  app.get('/', (req, res) => {
    res.render('main', {
      bodyClass: 'index',
      jsFile: 'index.js',
      title: ''
    })
  })

  app.get('/products', (req, res) => {
    res.render('main', {
      bodyClass: 'products',
      jsFile: 'products.js',
      title: 'Products'
    })
  })

  app.get('/hire', (req, res) => {
    res.render('main', {
      bodyClass: 'hire',
      jsFile: 'hire.js',
      title: 'Hire Us'
    })
  })

  app.get('/about', (req, res) => {
    res.render('main', {
      bodyClass: 'about',
      jsFile: 'about.js',
      title: 'About Us'
    })
  })

  app.get('/careers', (req, res) => {
    res.render('main', {
      bodyClass: 'careers',
      jsFile: 'careers.js',
      title: 'Careers'
    })
  })

  app.get('/contact', (req, res) => {
    res.render('main', {
      bodyClass: 'contact',
      jsFile: 'contact.js',
      title: 'Contact Us'
    })
  })

  app.get('/privacy', (req, res) => {
    res.render('main', {
      bodyClass: 'privacy',
      jsFile: 'privacy.js',
      title: 'Privacy Policy'
    })
  })

  app.get('/terms-of-use', (req, res) => {
    res.render('main', {
      bodyClass: 'terms-of-use',
      jsFile: 'termsofuse.js',
      title: 'Terms of Use'
    })
  })

  app.get('/end-user-license-agreement', (req, res) => {
    res.render('main', {
      bodyClass: 'end-user-license-agreement',
      jsFile: 'enduserlicenseagreement.js',
      title: 'End User License Agreement'
    })
  })

  app.get('/info', info)
}
