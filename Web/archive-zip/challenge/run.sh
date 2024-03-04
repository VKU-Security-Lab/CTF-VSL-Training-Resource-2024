#!/bin/bash

random_string=$(head /dev/urandom | tr -dc 'a-zA-Z0-9' | fold -w 8 | head -n 1)

echo "VSL{fake_flag_fake_flag}" > "/$random_string-flag.txt"

exec /usr/local/tomcat/bin/catalina.sh run
