/**
 * Terms Of Use Page Express Route.
 *
 * @param {object} _req - Express request object.
 * @param {object} res - Express response.object.
 * @returns {undefined}
 */
export default function(_req, res) {
  res.render('main', {
    bodyClass: 'terms-of-use',
    jsFile: 'termsofuse.js',
    title: 'Terms of Use'
  })
}
