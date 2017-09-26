import React from 'preact-compat'
import Header from './header.js'
import Footer from './footer.js'

export function renderRoot () {
  return (
    <div>
      <Header/>
      <div className="body">
        <h1>Careers</h1>
        <p>
          We have no employment opportunities at this time.
        </p>
      </div>
      <Footer/>
    </div>
  )
}
