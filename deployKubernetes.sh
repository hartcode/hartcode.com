#!/bin/bash

if [ ! -d ${HOME}/google-cloud-sdk ]; then
  rm -rf $HOME/google-cloud-sdk;
  export CLOUDSDK_CORE_DISABLE_PROMPTS=1;
  curl https://sdk.cloud.google.com | bash;
fi;

gcloud auth activate-service-account --key-file client-secret.json;
gcloud components install kubectl
gcloud config set compute/zone us-central1-c
gcloud container clusters get-credentials test
sed -i "s/(TRAVIS_BRANCH)/$TRAVIS_BRANCH/g" kube.conf.json
sed -i "s/(TRAVIS_COMMIT)/$TRAVIS_COMMIT/g" kube.conf.json
kubectl apply -f kube.conf.json