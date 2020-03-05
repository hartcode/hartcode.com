import React from 'react'
import PropTypes from 'prop-types'
import facebook from '../../../images/facebook.png'
import SocialMenuItem from './social-menu-item.js'
export default class FacebookMenuItem extends React.Component {
  render() {
    const url = `https://facebook.com/${this.props.username}`

    return <SocialMenuItem url={url} image={facebook} />
  }
}
FacebookMenuItem.propTypes = {
  username: PropTypes.string
}
