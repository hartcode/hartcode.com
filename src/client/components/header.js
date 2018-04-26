import React from 'react'
import logo from '../images/logo.png'
import navbar from 'bootstrap' // eslint-disable-line no-unused-vars
export default class Header extends React.Component {
  render () {
    return (
      <div className="header">
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
          <img src={ logo } width="180" height="180"/>
          <div className="company-title mr-auto">
            <h1>HartCode</h1>
            <h2>Game Studio</h2>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
              <li className="nav-item"><a className="nav-link" href="/products">Products</a></li>
              <li className="nav-item"><a className="nav-link" href="/hire">Hire Us</a></li>
              <li className="nav-item"><a className="nav-link" href="/about">About</a></li>
            </ul>
          </div>
        </nav>
      </div>
    )
  }
}
