import React from 'react'
import githublight from '../../../images/githublight.png'
import github from '../../../images/github.png'
import SocialMenuItem from './social-menu-item.js'
export default class FacebookMenuItem extends React.Component {
  render () {
    var url = 'https://github.com/' + this.props.username
    var image = githublight
    if (this.props.dark === 'true') {
      image = github
    }
    return (
          <SocialMenuItem url={url} image={image}/>
    )
  }
}
