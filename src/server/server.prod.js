import express from 'express'
import routes from './routes/routes.js'
import path from 'path'
const defaultPort = 8811
const port = process.env.PORT || defaultPort
const app = express()

app.set('view engine', 'ejs')

routes(app)

app.use(express.static(path.join(__dirname, '/../../build/client/')))

app.listen(port)
