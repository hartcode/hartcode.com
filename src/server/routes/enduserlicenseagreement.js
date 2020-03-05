/**
 * End User License Agreement Page Express Route.
 *
 * @param {object} _req - Express request object.
 * @param {object} res - Express response.object.
 * @returns {undefined}
 */
export default function(_req, res) {
  res.render('main', {
    bodyClass: 'end-user-license-agreement',
    jsFile: 'enduserlicenseagreement.js',
    title: 'End User License Agreement'
  })
}
