import React from 'react';
import twitter from '../images/twitter.png';
import facebook from '../images/facebook.png';
import githublight from '../images/githublight.png';

export default class Footer extends React.Component {

  render() {
    return (
      <div className="footer">
        <ul className="menu">
          <li><a href="/">Home</a></li>
          <li><a href="/careers">Careers</a></li>
          <li><a href="/contact">Contact Us</a></li>
          <li><a href="/privacy">Privacy</a></li>
          <li><a href="/terms-of-use">Terms</a></li>
        </ul>
        <ul className="menu">
          <li><a href="https://facebook.com/hartcodellc"><img src={facebook} width="32" height="32"/></a></li>
          <li><a href="https://twitter.com/hartcode"><img src={twitter} width="32" height="32"/></a></li>
          <li><a href="https://github.com/hartcode"><img src={githublight} width="32" height="32"/></a></li>
        </ul>
      </div>
    );
  }
}
