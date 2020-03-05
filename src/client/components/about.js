import React from 'react'
import Header from './header.js'
import Footer from './footer.js'
import alex from '../images/alex.png'
import SocialMenu from './menu/social/social-menu.js'

/**
 *
 */
export function renderRoot() {
  return (
    <div>
      <Header />
      <div className="body">
        <h1>About Us</h1>
        <p>
          {' '}
          We are small game studio located in the very heart of the midwest.
        </p>
        {founder()}
      </div>
      <Footer />
    </div>
  )
}

/**
 *
 */
function founder() {
  const github = { dark: 'true', username: 'hartalex' }
  const facebook = { username: 'alexander.hart7' }
  const twitter = { username: 'hartalex0' }

  return (
    <React.Fragment>
      <h2> Our Founder</h2>
      <img className="founder" src={alex} />
      <h3>Alexander Hart</h3>
      <SocialMenu facebook={facebook} twitter={twitter} github={github} />
      {founderDesc()}
    </React.Fragment>
  )
}

/**
 *
 */
function founderDesc() {
  return (
    <React.Fragment>
      <p>
        Alex started programming at an early age. He was in middle school when
        he discovered Basic code in the back of a PC Kids magazine. From there
        Alex started writing his own programs and games in QBasic. From an early
        age he loved computers and then taught himself C and C++. He went off to
        college to get a bachelor of arts degree in computer science with a
        minor in art. Since then he has worked as a developer for 11 years in
        the private sector.
      </p>
      <p>
        He got into programming computers as a way to make video games, and now
        he is following his dream. Alex is commited to making fun and exciting
        experiences through the medium of video games.
      </p>
      <p>
        Alex has always been a maker and loves to create games, software, art,
        soap, and scones.
      </p>
    </React.Fragment>
  )
}
