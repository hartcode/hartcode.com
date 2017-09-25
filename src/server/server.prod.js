import express from 'express'
import routes from './routes/routes'
import path from 'path'
const port = process.env.PORT || 8811
const app = express()

app.set('view engine', 'ejs')

routes(app)

app.use(express.static(path.join(__dirname, '/../../build/client/')))

app.listen(port)
