#!/bin/bash
npm run build
pip install ansible --user
openssl aes-256-cbc -K $encrypted_3b5afcaadad7_key -iv $encrypted_3b5afcaadad7_iv -in secrets.tar.enc -out secrets.tar -d
tar xvf secrets.tar

if [ ! -d ${HOME}/google-cloud-sdk ]; then
  rm -rf $HOME/google-cloud-sdk;
  export CLOUDSDK_CORE_DISABLE_PROMPTS=1;
  curl https://sdk.cloud.google.com | bash;
fi;

gcloud auth activate-service-account --key-file client-secret.json;
curl -LO https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl
chmod +x ./kubectl
gcloud config set project hartonline-cloud
gcloud config set compute/zone us-central1-c
gcloud container clusters get-credentials test
sed -i "s/(TRAVIS_BRANCH)/$TRAVIS_BRANCH/g" kube.conf.json
sed -i "s/(TRAVIS_COMMIT)/$TRAVIS_COMMIT/g" kube.conf.json
./kubectl apply -f kube.conf.json