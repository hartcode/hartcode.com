import React from 'react';
import SocialMenu from './menu/social/social-menu.js';
export default class Footer extends React.Component {

  render() {
  var github = {username:"hartcode"};
  var facebook = {username:"hartcodellc"};
  var twitter = {username:"hartcode"};
    return (
      <div className="footer">
        <ul className="menu">
          <li><a href="/">Home</a></li>
          <li><a href="/careers">Careers</a></li>
          <li><a href="/contact">Contact Us</a></li>
          <li><a href="/privacy">Privacy</a></li>
          <li><a href="/terms-of-use">Terms</a></li>
        </ul>
        <SocialMenu facebook={facebook} twitter={twitter} github={github} />
      </div>
    );
  }
}
