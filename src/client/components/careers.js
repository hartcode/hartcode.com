import React from 'react'
import Header from './header.js'
import Footer from './footer.js'
import config from '../../config.js'

/**
 *
 */
export function renderRoot () {
  return <Careers />
}
export default class Careers extends React.Component {
  constructor () {
    super()
    this.state = {
      data: '...'
    }
  }

  componentDidMount () {
    fetch(`${config.apiUrl}/careers`)
      .then((response) => response.json())
      .then((res) => {
        const { data } = res
        this.setState({
          data
        })
      })
  }

  render () {
    return (
      <div>
        <Header />
        <div className="body">
          <h1>Careers</h1>
          <p>{this.state.data}</p>
        </div>
        <Footer />
      </div>
    )
  }
}
