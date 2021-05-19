#!/usr/bin/env bash
cp config/Dockerfile $1/Dockerfile
cd $1

mvn clean install

docker build . -t 146.185.210.230:5000/$1:$2
docker push 146.185.210.230:5000/$1:$2


rm Dockerfile
