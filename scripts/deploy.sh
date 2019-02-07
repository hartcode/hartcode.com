#!/bin/bash
npm run build
pip install ansible --user
openssl aes-256-cbc -K $encrypted_3b5afcaadad7_key -iv $encrypted_3b5afcaadad7_iv -in secrets.tar.enc -out secrets.tar -d
tar xvf secrets.tar
./deployToGCS.sh hartcode.com
./deployKubernetes.sh
