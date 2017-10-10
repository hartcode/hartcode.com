import React from 'react'
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
          We occasionally post videos of things we are working on <a href="https://www.youtube.com/user/hartac83/">Youtube</a>.
        </p>
        <p>
          Also we have 3D art up on <a href="https://sketchfab.com/hartalex">Sketchfab</a>.
        </p>
        <p>
          Checkout our open source repositories at <a href="https://github.com/hartalex/">Github</a>.
        </p>
        <p>
          Send us an email at <a href="mailto:contact@hartcode.com">contact@hartcode.com</a>.
        </p>
      </div>
      <Footer/>
    </div>
  )
}
