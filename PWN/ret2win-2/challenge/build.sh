#!/bin/bash

# Build docker image
docker build -t ret2win .

# Run docker container
docker run -d -p 10002:1337 --name ret2win ret2win
