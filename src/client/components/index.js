import React, { Component } from 'react';
export default class Index extends Component {
  render() {
    return (
      <div class="body">
        <div>
          <a href="/products"><div class='products'><h1>Products</h1></div></a>
          <a href="/hire"><div class='hire'><h1>Hire us</h1></div></a>
        </div>
      </div>
    );
  }
}
