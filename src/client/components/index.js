import React from 'react';
import { render } from 'react-dom';

export function renderIndex() {
    return (
      <div className="body">
        <div>
          <a href="/products"><div className='products'><h1>Products</h1></div></a>
          <a href="/hire"><div className='hire'><h1>Hire us</h1></div></a>
        </div>
      </div>
    );}
