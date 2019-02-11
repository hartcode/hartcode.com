const MAX_CONTAINERS = 5

const { spawnSync } = require('child_process')
const gcloud = spawnSync('gcloud', [
  'container',
  'images',
  'list-tags',
  "--format='json'",
  'gcr.io/hartonline-cloud/hartcode.com'
])
if (gcloud.status === 0) {
  // array of images in gcloud
  const arr = JSON.parse(gcloud.stdout)
  if (arr.length > MAX_CONTAINERS) {
    console.log(`Found ${MAX_CONTAINERS - arr.length} images to delete.`)
    for (var i = MAX_CONTAINERS; i < arr.length; i++) {
      const image = arr[i]
      const d = spawnSync('gcloud', [
        'container',
        'images',
        'delete',
        `gcr.io/hartonline-cloud/hartcode.com@${image.digest}`,
        '--force-delete-tags'
      ])
      if (d.status === 0) {
        console.log(`Successfully deleted image gcr.io/hartonline-cloud/hartcode.com@${image.digest}`)
      } else {
        console.error(`Failed to delete image gcr.io/hartonline-cloud/hartcode.com@${image.digest}`)
        console.error(d.stderr.toString())
        return -1
      }
    }
  } else {
    console.log(`There are only ${arr.length} images in the cloud.  None to Delete.`)
    return 0
  }
} else {
  console.error(gcloud.stderr.toString())
  return -1
}
