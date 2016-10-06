import React from 'react';
import Header from './header.js';
import Footer from './footer.js';
import facebook from '../images/facebook.png';
import twitter from '../images/twitter.png';
import github from '../images/github.png';
import alex from '../images/alex.png';

export function renderRoot() {
    return (
      <div>
      <Header/>
      <div className="body">
        <h1>About Us</h1>
        <p> We are small game studio located in the very heart of the midwest.</p>

        <h2> Our Founder</h2>
        <img src={alex} />
        <h3>Alexander Hart</h3>
        <ul className="menu">
          <li><a href="https://facebook.com/alexander.hart7"><img src={facebook} width="32" height="32"/></a></li>
          <li><a href="https://twitter.com/hartalex0"><img src={twitter} width="32" height="32"/></a></li>
          <li><a href="https://github.com/hartalex"><img src={github} width="32" height="32"/></a></li>
        </ul>
        <p>
          Alex started programming at an early age. He was in middle school when he discovered basic code in the back of a PC Kids magazine. From there Alex started writing his own programs and games in QBasic. From an early age he loved computers and then taught himself C and C++. He went off to college to get a bachelor of arts degree in computer science with a minor in art. Since then he has worked as a developer for 11 years in the private sector.
        </p>
        <p>
          He got into programming computers as a way to make video games, and now he is following his dream.
        </p>
        <p>
          Alex has always been a maker, and loves to create things, programs, and food for people.
        </p>
      </div>
      <Footer/>
      </div>
    );}
