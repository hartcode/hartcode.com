import React from 'react'
import PropTypes from 'prop-types'
import twitter from '../../../images/twitter.png'
import SocialMenuItem from './social-menu-item.js'
export default class TwitterMenuItem extends React.Component {
  render() {
    const url = `https://twitter.com/${this.props.username}`

    return <SocialMenuItem url={url} image={twitter} />
  }
}

TwitterMenuItem.propTypes = {
  username: PropTypes.string
}
