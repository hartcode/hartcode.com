// js dependencies
import '../../node_modules/jquery/src/jquery.js'
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js'
import { renderRoot } from './components/about.js'
import { render } from 'preact-compat'
import Analytics from './components/analytics.js'
Analytics.analytics()

const root = document.getElementById('root')
if (root !== null) {
  render(renderRoot(), root)
}
