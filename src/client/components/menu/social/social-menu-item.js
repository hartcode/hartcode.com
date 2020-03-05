import React from 'react'
import PropTypes from 'prop-types'
export default class SocialMenuItem extends React.Component {
  render() {
    return (
      <a href={this.props.url}>
        <img className="socialMenuItem" src={this.props.image} />
      </a>
    )
  }
}
SocialMenuItem.propTypes = {
  image: PropTypes.string,
  url: PropTypes.string
}
