import webpackDevMiddleware from 'webpack-dev-middleware'
import webpackHotMiddleware from 'webpack-hot-middleware'
import webpack from 'webpack'
import config from '../../webpack.config'
import express from 'express'
import routes from './routes/routes'
import path from 'path'
const port = process.env.PORT || 8811
const app = express()

app.set('view engine', 'ejs')

if (process.env.NODE_ENV !== 'production') {
  const compiler = webpack(config)
  app.use(
    webpackDevMiddleware(compiler, {
      noInfo: false,
      quiet: false,
      stats: {
        colors: true
      }
    })
  )

  app.use(webpackHotMiddleware(compiler))
}

routes(app)

app.use(express.static(path.join(__dirname, '/../../build/client/')))

app.listen(port)
