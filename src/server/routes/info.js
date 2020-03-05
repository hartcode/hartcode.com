/**
 * Health Check Express Endpoint.
 * Returns the environment var COMMIT as a json object.
 *
 * @param {object} _req - Express request object.
 * @param {object} res - Express response.object.
 * @returns {undefined}
 */
export default function(_req, res) {
  res.json({ commit: process.env.COMMIT })
}
