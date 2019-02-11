#!/bin/bash
curl -LO https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl
chmod +x ./kubectl
sed -i "s/(TRAVIS_BRANCH)/$TRAVIS_BRANCH/g" kube.conf.json
sed -i "s/(TRAVIS_COMMIT)/$TRAVIS_COMMIT/g" kube.conf.json
./kubectl apply -f kube.conf.json