#!/bin/bash

if [ $TRAVIS_BRANCH == 'prod' ] || [ $TRAVIS_BRANCH == $TRAVIS_TAG ]; then
  export PORT=8811
fi
if [ $TRAVIS_BRANCH == 'test' ]; then
  export PORT=8711
fi

if [ ! -d ${HOME}/google-cloud-sdk ]; then
  rm -rf $HOME/google-cloud-sdk;
  export CLOUDSDK_CORE_DISABLE_PROMPTS=1;
  curl https://sdk.cloud.google.com | bash;
fi;

gcloud auth activate-service-account --key-file client-secret.json;
gcloud container clusters get-credentials test
kubectl apply -f kube.conf.json
