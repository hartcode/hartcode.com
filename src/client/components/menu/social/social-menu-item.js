import React from 'react';
export default class SocialMenuItem extends React.Component {
  render() {
    return (
          <a href={ this.props.url }><img src={this.props.image} width="32" height="32"/></a>
    );
  }
}
