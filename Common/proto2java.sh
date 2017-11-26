#!/usr/bin/env bash

mkdir -p ./src
protoc --java_out=./src ./proto/*