import React from 'react'
import Header from './header.js'
import Footer from './footer.js'

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
    fetch('http://api.test.hartcode.com/careers')
      .then((response) => {
        return response.json()
      })
      .then((res) => {
        const data = res.data
        console.log(data)
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
