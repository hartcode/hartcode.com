import React from 'react'
import Header from './header.js'
import Footer from './footer.js'
import treasurefighterimage from '../images/TreasureFighter.gif'
import soyouwanttobuildasnowmanimage from '../images/soyouwanttobuildasnowmanimage.png'
import moneydropimage from '../images/moneydropimage.png'
import zomboneimage from '../images/zomboneimage.png'
/**
 * Renders the product page.
 *
 * @returns {object} The product page.
 */
export function renderRoot() {
  return (
    <div>
      <Header />
      <div className="body">
        <h1>Products</h1>
        <h2>Treasure Fighter - In Development</h2>
        <img src={treasurefighterimage} />
        <p>
          The King has a big problem, it seems that all of his treasure has come
          to life and is now attacking people. You play a janitor who is
          mistaken for a knight, and sent down into the castle depths to subdue
          the King&apos;s treasure. This side scrolling game focuses on short
          casual battles with various treasure based enemies.
          <ul>
            <li>
              Jump, Slash, Kick, and Crouch your way to victory whilest battling
              treasure.
            </li>
            <li>Collect loot!</li>
            <li>Purchase upgrades at the castle armory.</li>
            <li>Life Hearts, you need em, we got em.</li>
            <li>Coming Soon!</li>
          </ul>
        </p>
        <h2>So You Want To Build A Snowman</h2>
        <img src={soyouwanttobuildasnowmanimage} />
        <p>
          <a href="https://alexhart.itch.io/so-you-want-to-build-a-snowman">
            https://alexhart.itch.io/so-you-want-to-build-a-snowman
          </a>
        </p>
        <p>
          Take control of the coolest person in the snow globe, the snowman.
          Life is great for this little snowman until someone shakes the snow
          globe and all of his pieces fall off. Now it&apos;s up to you to track
          down all of the pieces of the snowman, and put him back together.
        </p>
        <ul>
          <li> Explore the tiny world of a snow globe.</li>
          <li>Collect zany objects to rebuild a snowman</li>
          <li>Clear Objectives</li>
          <li>Replay again to build a new snowman with different pieces.</li>
          <li>For All Ages</li>
          <li>Made in a little over 12 hours.</li>
          <li>No pesky audio to mute.</li>
          <li>Uses Standard FPS controls - Mouse Look, WASD movement</li>
          <li>
            Open Source - if you find a bug please post an issue on github{' '}
            <a href="https://github.com/hartalex/soyouwanttobuildasnowman">
              https://github.com/hartalex/soyouwanttobuildasnowman
            </a>
          </li>
          <li>This game was created during Ludum Dare 38. ldjam.com</li>
        </ul>
        <h2>Money Drop</h2>
        <img src={moneydropimage} />
        <p>
          <a href="https://alexhart.itch.io/money-drop">
            https://alexhart.itch.io/money-drop
          </a>
        </p>
        <p>Catch as much money as you can while avoiding the bombs.</p>
        <ul>
          <li>See who can get the highest score</li>
        </ul>
        <h2>Zombone</h2>
        <img src={zomboneimage} />
        <p>
          <a href="https://alexhart.itch.io/zombone">
            https://alexhart.itch.io/zombone
          </a>
        </p>
        <p>You are alone in a graveyard trying to survive a zombie attack.</p>
        <ul>
          <li>Zombies!</li>
          <li>See who can get the highest score</li>
        </ul>
      </div>
      <Footer />
    </div>
  )
}
