import React from 'react';
import logo from '../images/logo.png';
export default class Header extends React.Component {

  render() {
    return (
      <div className="header">
        <nav className="navbar navbar-default">
          <div className="container-fluid">
            <div className="navbar-header">
              <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu-collapse" aria-expanded="false">
                <span className="sr-only">Toggle navigation</span>
                <span className="icon-bar"></span>
                <span className="icon-bar"></span>
                <span className="icon-bar"></span>
              </button>
              <img name="logo" src={ logo } width="180" height="180"/>
              <div className="company-title">
                <h1>HartCode</h1>
                <h2>Game Studio</h2>
              </div>
            </div>
            <div className="collapse navbar-collapse" id="menu-collapse">
              <ul className="nav navbar-nav navbar-right">
                <li className="li-products"><a href="/products">Products</a></li>
                <li className="li-hire"><a href="/hire">Hire Us</a></li>
                <li className="li-about"><a href="/about">About HartCode</a></li>
              </ul>
            </div>
          </div>
        </nav>
      </div>
    );
  }
}
