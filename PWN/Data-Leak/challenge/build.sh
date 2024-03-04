#!/bin/bash

# Build docker image
docker build -t leak-char .

# Run docker container
docker run -d -p 10003:1337 --name leak-char leak-char
