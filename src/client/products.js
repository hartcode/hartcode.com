// js dependencies
import '../../node_modules/jquery/src/jquery.js'
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js';
import { renderRoot } from './components/products.js';

import React from 'react';
import { render } from 'react-dom';

var root = document.getElementById('root');
if (root !== null) {
  render(renderRoot(), root);
}
