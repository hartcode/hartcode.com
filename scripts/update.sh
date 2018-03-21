#!/bin/bash
git merge master
./updateDepends.sh
npm run lint
npm run build
