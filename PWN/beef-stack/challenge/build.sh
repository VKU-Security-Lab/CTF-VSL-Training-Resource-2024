#!/bin/bash

# Build docker image
docker build -t beef-stack .

# Run docker container
docker run -d -p 10001:1337 --name beef-stack beef-stack
