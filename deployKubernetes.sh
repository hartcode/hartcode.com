#!/bin/bash

if [ $TRAVIS_BRANCH == 'prod' ] || [ $TRAVIS_BRANCH == $TRAVIS_TAG ]; then
  export PORT=8811
fi
if [ $TRAVIS_BRANCH == 'test' ]; then
  export PORT=8711
fi

gcloud config set compute/zone us-central1-c
gcloud container clusters get-credentials test
kubectl apply -f kube.conf.json
