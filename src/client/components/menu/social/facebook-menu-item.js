import React from 'react'
import facebook from '../../../images/facebook.png'
import SocialMenuItem from './social-menu-item.js'
export default class FacebookMenuItem extends React.Component {
  render () {
    var url = 'https://facebook.com/' + this.props.username
    return (
          <SocialMenuItem url={url} image={facebook}/>
    )
  }
}
