#!/bin/bash

# Build docker image
docker build -t code-asm .

# Run docker container
docker run -d -p 10004:1337 --name code-asm code-asm
