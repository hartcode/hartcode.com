import info from './info.js'
import index from './index.js'
import products from './products.js'
import hire from './hire.js'
import about from './about.js'
import careers from './careers.js'
import contact from './contact.js'
import privacy from './privacy.js'
import termsofuse from './termsofuse.js'
import enduserlicenseagreement from './enduserlicenseagreement.js'

module.exports = function(app) {
  app.get('/', index)
  app.get('/products', products)
  app.get('/hire', hire)
  app.get('/about', about)
  app.get('/careers', careers)
  app.get('/contact', contact)
  app.get('/privacy', privacy)
  app.get('/terms-of-use', termsofuse)
  app.get('/end-user-license-agreement', enduserlicenseagreement)
  app.get('/info', info)
}
