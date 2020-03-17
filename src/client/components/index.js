import React from 'react'
import Header from './header.js'
import Footer from './footer.js'

/**
 * Renders the index component.
 *
 * @returns {object} The index component in jsx.
 */
export function renderRoot() {
  return (
    <div>
      <Header />
      <div className="body">
        <div>
          <a href="/products">
            <div className="products">
              <h1>Products</h1>
            </div>
          </a>
          <a href="/hire">
            <div className="hire">
              <h1>Hire us</h1>
            </div>
          </a>
        </div>
      </div>
      <Footer />
    </div>
  )
}
