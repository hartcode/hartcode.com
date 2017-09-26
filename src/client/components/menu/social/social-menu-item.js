import React from 'preact-compat'
export default class SocialMenuItem extends React.Component {
  render () {
    return (
      <a href={ this.props.url }><img className="socialMenuItem" src={this.props.image} /></a>
    )
  }
}
