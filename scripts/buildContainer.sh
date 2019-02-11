#!/bin/bash
npm run build
docker build --build-arg COMMIT=$TRAVIS_COMMIT --build-arg TAG=$TRAVIS_BRANCH -t gcr.io/hartonline-cloud/hartcode.com:$TRAVIS_BRANCH-$TRAVIS_COMMIT .;
openssl aes-256-cbc -K $encrypted_3b5afcaadad7_key -iv $encrypted_3b5afcaadad7_iv -in secrets.tar.enc -out secrets.tar -d
tar xvf secrets.tar
if [ ! -d ${HOME}/google-cloud-sdk ]; then
  rm -rf $HOME/google-cloud-sdk;
  export CLOUDSDK_CORE_DISABLE_PROMPTS=1;
  curl https://sdk.cloud.google.com | bash;
fi;
gcloud auth activate-service-account --key-file client-secret.json;
gcloud docker -- push gcr.io/hartonline-cloud/hartcode.com:$TRAVIS_BRANCH-$TRAVIS_COMMIT;