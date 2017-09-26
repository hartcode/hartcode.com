import React from 'react'
import Header from './header.js'
import Footer from './footer.js'
import zombiehunterimage from '../images/zombie-hunter.gif'
export function renderRoot () {
  return (
    <div>
      <Header/>
      <div className="body">
        <h1>Products</h1>
        <p>
          We are currently working on our first title called "Zombie Hunter 1000".
        </p>
        <h2>Zombie Hunter 1000</h2>
        <p>
        The human race has fallen to a zombie apocalypse.

        In a desperate attempt to save humanity an advanced Artificial Intelligence was developed
        in hopes of finding a cure.
        A cure was found, but it was too late, the last humans have become mindless zombies.
        With the humans gone, the Artificial Intelligence created 'Zombie Hunter' class robots to deliver the cure to the humans.
        As a Zombie Hunter it's up to YOU to save humanity.
        </p>
        <p>Zombie Hunter 1000 is a nostalgic text-based action adventure game.</p>
        <p>Explore explorations, Quest quests, and Achieve achievements.</p>

        <img src={zombiehunterimage} />
      </div>
      <Footer/>
    </div>
  )
}
