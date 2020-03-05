import info from './info'
import index from './index'
import products from './products'
import hire from './hire'
import about from './about'
import careers from './careers'
import contact from './contact'
import privacy from './privacy'
import termsofuse from './termsofuse'
import enduserlicenseagreement from './enduserlicenseagreement'

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
