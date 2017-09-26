import React from 'preact-compat'
import Header from './header.js'
import Footer from './footer.js'

export function renderRoot () {
  return (
    <div>
      <Header/>
      <div className="body">
        <h1>Hire Us</h1>
        <p>
          We are always looking for more opportunities in the game development industry.
        </p>
        <p>
          We wear many hats and are available to Code, Create, Write, or Design anything you might need.
        </p>
        <p>
          Send us an email at <a href="mailto:contact@hartcode.com">contact@hartcode.com</a>.
        </p>
      </div>
      <Footer/>
    </div>
  )
}
