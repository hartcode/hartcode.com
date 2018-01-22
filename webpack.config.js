const webpack = require('webpack');
const path = require('path');
const CommonsChunkPlugin = require("webpack/lib/optimize/CommonsChunkPlugin");
const ExtractTextPlugin = require("extract-text-webpack-plugin");
const UglifyJSPlugin = require('uglifyjs-webpack-plugin')

module.exports = {
    plugins: [
      new webpack.HotModuleReplacementPlugin(),
      new ExtractTextPlugin("style.css"),
      new webpack.DefinePlugin({
        'process.env': {
           NODE_ENV: JSON.stringify('production')
         }
      }),
      new CommonsChunkPlugin(
	      { name: 'commons',
	chunks: ['index', 'contact', 'about', 'careers', 'hire', 'products', 'privacy', 'termsofuse', 'enduserlicenseagreement'],
        filename: 'commons.js'
      })
    ],
    entry: {
      index: "./src/client/index.js",
      contact: "./src/client/contact.js",
      about: "./src/client/about.js",
      careers: "./src/client/careers.js",
      hire: "./src/client/hire.js",
      products: "./src/client/products.js",
      privacy: "./src/client/privacy.js",
      termsofuse: "./src/client/terms-of-use.js",
      enduserlicenseagreement: "./src/client/end-user-license-agreement.js",
      css: [
            "./node_modules/bootstrap/dist/css/bootstrap.min.css",
            "./src/client/css/main.css",
            "./src/client/css/navbar.css"
          ],
      favicon: "./src/client/images/favicon.ico"
    },
    output: {
        path: __dirname + '/build/client',
        filename: "[name].js"
    },
    module: {
        rules: [
            {
              test: /\.css$/,
              use: ['style-loader', 'css-loader']
            },
            {
              test: /.*\.(gif|png|jpe?g|svg)$/i,
              use: [
		      {
			      loader: 'file-loader',
			      options: {}
		      }
	      ]
            },
            {
              test: /.*favicon\.(ico)$/i,
              use: [
		      {
			      loader: 'file-loader',
			      options: {name:'favicon.ico'}
		      }
	      ]
            },
            {
              test: /.*\.(ttf|eot|woff|woff2|zip)$/i,
              use: [
		      {
			      loader: 'file-loader',
			      options: {}
		      }
	      ]
            },
            {
              test: /\.js$/,
              exclude: /(node_modules)/,
              loader: 'babel-loader',
		    options: {
			    presets: ['react','minify']
		    }
            }
        ]
    }
};
