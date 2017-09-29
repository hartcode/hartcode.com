#!/bin/bash

if [ $TRAVIS_BRANCH == 'prod' ] || [ $TRAVIS_BRANCH == $TRAVIS_TAG ]; then
  export ANSIBLE_HOST_KEY_CHECKING=False
  openssl dgst -md5 ansible
  openssl dgst -md5 ansible.pub
  chmod 400 ansible
  ssh-add ansible
  ansible-playbook -i inventory.yml .ansible-deploy.yml
else
  echo "Branch not allowed to deploy with Ansible"
fi
