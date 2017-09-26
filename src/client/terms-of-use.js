import '../../node_modules/jquery/src/jquery.js'
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js'
import { renderRoot } from './components/terms-of-use.js'
import { render } from 'preact-compat'
import Analytics from './components/analytics.js'
Analytics.analytics()

var root = document.getElementById('root')
if (root !== null) {
  render(renderRoot(), root)
}
