import { renderRoot } from './components/index.js'
import { render } from 'react-dom'
import Analytics from './components/analytics.js'
Analytics.analytics()

var root = document.getElementById('root')
if (root !== null) {
  render(renderRoot(), root)
}
