const webpack = require('webpack');
const path = require('path');

module.exports = {
    entry: "./src/client/client.js",
    output: {
        path: __dirname + '/build/client',
        filename: "bundle.js"
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
