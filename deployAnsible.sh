#!/bin/bash

if [ $TRAVIS_BRANCH == 'prod' ] || [ $TRAVIS_BRANCH == $TRAVIS_TAG ]; then
  export PORT=8811
fi
if [ $TRAVIS_BRANCH == 'test' ] || [ $TRAVIS_BRANCH == $TRAVIS_TAG ]; then
  export PORT=8711
fi
export ANSIBLE_HOST_KEY_CHECKING=False
openssl dgst -md5 ansible
openssl dgst -md5 ansible.pub
chmod 400 ansible
ssh-add ansible
ansible-playbook -i inventory.yml .ansible-deploy.yml
