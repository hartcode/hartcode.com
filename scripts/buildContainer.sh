#!/bin/bash
npm run build
docker build --build-arg COMMIT=$TRAVIS_COMMIT --build-arg TAG=$TRAVIS_BRANCH -t gcr.io/hartonline-cloud/hartcode.com:$TRAVIS_BRANCH-$TRAVIS_COMMIT .;
gcloud docker -- push gcr.io/hartonline-cloud/hartcode.com:$TRAVIS_BRANCH-$TRAVIS_COMMIT;