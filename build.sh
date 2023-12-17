#!/bin/bash

./gradlew bootJar || exit 1
docker build -t jinyoungsung/spring:latest . || exit 1
docker push jinyoungsung/spring:latest || exit 1
