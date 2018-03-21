import { renderRoot } from './components/end-user-license-agreement.js'
import { render } from 'react-dom'
import Analytics from './components/analytics.js'
Analytics.analytics()

var root = document.getElementById('root')
if (root !== null) {
  render(renderRoot(), root)
}
