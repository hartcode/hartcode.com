import React from 'react';
import FacebookMenuItem from './facebook-menu-item.js';
import TwitterMenuItem from './twitter-menu-item.js';
import GithubMenuItem from './github-menu-item.js';
export default class SocialMenu extends React.Component {
  render() {
    return (
        <ul className="menu">
          <li><FacebookMenuItem username={this.props.facebook.username}/></li>
          <li><TwitterMenuItem username={this.props.twitter.username}/></li>
          <li><GithubMenuItem username={this.props.github.username} dark={this.props.github.dark}/></li>
        </ul>
    );
  }
}
