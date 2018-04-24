#!/bin/sh
docker run -v $(pwd):/home/root node:9-alpine yarn --cwd /home/root $@ 
