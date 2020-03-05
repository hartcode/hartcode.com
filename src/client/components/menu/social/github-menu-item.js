import React from 'react'
import PropTypes from 'prop-types'
import githublight from '../../../images/githublight.png'
import github from '../../../images/github.png'
import SocialMenuItem from './social-menu-item.js'
export default class GithubMenuItem extends React.Component {
  render() {
    const url = `https://github.com/${this.props.username}`
    let image = githublight
    if (this.props.dark === 'true') {
      image = github
    }

    return <SocialMenuItem url={url} image={image} />
  }
}

GithubMenuItem.propTypes = {
  dark: PropTypes.bool,
  username: PropTypes.string
}
