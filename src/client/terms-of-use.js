import { renderRoot } from './components/terms-of-use.js'
import { render } from 'react-dom'
import Analytics from './components/analytics.js'
Analytics.analytics()

const root = document.getElementById('root')
if (root !== null) {
  render(renderRoot(), root)
}
