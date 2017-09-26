import React from 'react'
import Header from './header.js'
import Footer from './footer.js'

export function renderRoot () {
  return (
    <div>
      <Header/>
      <div className="body">
        <h1>Contact Us</h1>
        <p>
          Send us an email at <a href="mailto:contact@hartcode.com">contact@hartcode.com</a>.
        </p>
      </div>
      <Footer/>
    </div>
  )
}
