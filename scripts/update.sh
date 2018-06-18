#!/bin/bash
openssl aes-256-cbc -K $encrypted_3b5afcaadad7_key -iv $encrypted_3b5afcaadad7_iv -in secrets.tar.enc -out secrets.tar -d
git config --global user.email "travis@travis-ci.org"
git config --global user.name "Travis CI"
tar xvf secrets.tar
chmod 400 travis
eval "$(ssh-agent -s)"
ssh-add travis
git remote add deploy git@github.com:hartcode/hartcode.com.git
git pull deploy HEAD:master
git merge master -X theirs
./updateDepends.sh
npm run lint
npm run build
git add package*
npm --no-git-tag-version version patch -f
git commit -m "Cron Auto Update Dependencies [ci skip]"
git push deploy HEAD:update
git checkout master
git merge update
git push deploy HEAD:master
