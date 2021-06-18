#!/usr/bin/env bash
javac -cp src/ src/app/*.java
java -cp src/ app.Application
find . -type f -name "*.class" -exec rm -f {} \;