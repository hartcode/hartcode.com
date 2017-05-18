import React from 'react'
export default class SocialMenuItem extends React.Component {
  render () {
    return (
          <a href={ this.props.url }><img className="socialMenuItem" src={this.props.image} /></a>
    )
  }
}
