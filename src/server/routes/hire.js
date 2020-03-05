/**
 * Hire Page Express Route.
 *
 * @param {object} _req - Express request object.
 * @param {object} res - Express response.object.
 * @returns {undefined}
 */
export default function(_req, res) {
  res.render('main', {
    bodyClass: 'hire',
    jsFile: 'hire.js',
    title: 'Hire Us'
  })
}
