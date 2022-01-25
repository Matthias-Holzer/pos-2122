#! /bin/bash

set -ex

cd $HOME
mkdir config-repo-holzer
cd config-repo-holzer
git init .
echo info.foo: bar > application.properties
git add -A .
git commit -m "Add application.properties"