#!/bin/sh
docker run -it -v $(pwd):/home/root --network host node:9-alpine yarn --cwd /home/root $@ 