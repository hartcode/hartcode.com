import '../../node_modules/jquery/src/jquery.js'
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js'
import { renderRoot } from './components/hire.js'
import { render } from 'react-dom'
import Analytics from './components/analytics.js'
Analytics.analytics()

var root = document.getElementById('root')
if (root !== null) {
  render(renderRoot(), root)
}
