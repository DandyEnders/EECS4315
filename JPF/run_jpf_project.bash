#!/bin/bash

cd $1
javac $1.java
jpf $1.jpf
