const webpack = require('webpack');
const path = require('path');
const CommonsChunkPlugin = require("webpack/lib/optimize/CommonsChunkPlugin");

module.exports = {
    plugins: [
      new webpack.HotModuleReplacementPlugin(),
      new webpack.optimize.UglifyJsPlugin(),
      new webpack.optimize.DedupePlugin(),
      new CommonsChunkPlugin("commons.js")
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
      enduserlicenseagreement: "./src/client/end-user-license-agreement.js"
    },
    output: {
        path: __dirname + '/build/client',
        filename: "[name].js"
    },
    module: {
        loaders: [
            {
              test: /\.css$/,
              loader: "style-loader!css-loader!resolve-url-loader"
            },
            {
              test: /.*\.(gif|png|jpe?g|svg|ico)$/i,
              loaders: ['file?hash=sha512&digest=hex&name=[hash].[ext]','image-webpack']
            },
            {
              test: /.*\.(ttf|eot|woff|woff2)$/i,
              loaders: ['file?hash=sha512&digest=hex&name=[hash].[ext]']
            },
            {
              test: /\.js$/,
              exclude: /(node_modules)/,
              loader: 'babel', // 'babel-loader' is also a valid name to reference
              query: {
              presets: ['latest']
            }
        }
        ]
    }
};
