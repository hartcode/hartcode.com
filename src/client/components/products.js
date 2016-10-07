import React from 'react';
import Header from './header.js';
import Footer from './footer.js';

export function renderRoot() {
    return (
      <div>
      <Header/>
      <div className="body">
        <h1>Products</h1>
        <p>
          We are currently working on our first title called "Well Wishing".
        </p>
        <h2>Well Wishing</h2>
        <p>
          Stay tuned for more updates.
        </p>
      </div>
      <Footer/>
      </div>
    );}