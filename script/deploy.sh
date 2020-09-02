#!/usr/bin/env bash

workDir=$(cd $(dirname $0); pwd)
cd ${workDir}/..

mvn clean
mvn -DskipTests=true deploy -pl seazen-retrofit-sdk -am
