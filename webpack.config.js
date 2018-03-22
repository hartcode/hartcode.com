const webpack = require('webpack')
const path = require('path')

module.exports = {
  plugins: [
    new webpack.DefinePlugin({
      'process.env': {
        NODE_ENV: JSON.stringify('production')
      }
    })
  ],
  optimization: {
    splitChunks: {
      cacheGroups: {
        commons: {
          test: /[\\/]node_modules[\\/]/,
          name: 'vendors',
          chunks: 'all'
        }
      }
    }
  },
  entry: {
    index: './src/client/index.js',
    contact: './src/client/contact.js',
    about: './src/client/about.js',
    careers: './src/client/careers.js',
    hire: './src/client/hire.js',
    products: './src/client/products.js',
    privacy: './src/client/privacy.js',
    termsofuse: './src/client/terms-of-use.js',
    enduserlicenseagreement: './src/client/end-user-license-agreement.js',
    style: [
      './node_modules/bootstrap/dist/css/bootstrap.min.css',
      './src/client/css/main.css'
    ],
    favicon: './src/client/images/favicon.ico'
  },
  output: {
    path: path.join(__dirname, '/build/client'),
    filename: '[name].js'
  },
  module: {
    rules: [
      {
        test: /\.css$/,
        use: [
          'style-loader', 'css-loader'
        ]
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
            options: {name: 'favicon.ico'}
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

        use: [{
          loader: 'babel-loader',

          options: {
            presets: ['react', 'minify']
          }
        }]
      }
    ]
  }
}
