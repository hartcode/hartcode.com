import React from 'react'
import SocialMenu from './menu/social/social-menu.js'
export default class Footer extends React.Component {
  render() {
    const github = { username: 'hartcode' }
    const facebook = { username: 'hartcodellc' }
    const twitter = { username: 'hartcode' }

    return (
      <div className="footer">
        <ul className="menu">
          <li>
            <a href="/">Home</a>
          </li>
          <li>
            <a href="/careers">Careers</a>
          </li>
          <li>
            <a href="/contact">Contact Us</a>
          </li>
        </ul>
        <SocialMenu facebook={facebook} twitter={twitter} github={github} />
      </div>
    )
  }
}
