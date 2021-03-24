#!/bin/bash

javac *.java
jpf StateExplosion.jpf 0 | grep states
jpf StateExplosion.jpf 1 | grep states
jpf StateExplosion.jpf 2 | grep states
jpf StateExplosion.jpf 3 | grep states
jpf StateExplosion.jpf 4 | grep states
jpf StateExplosion.jpf 5 | grep states
jpf StateExplosion.jpf 6 | grep states
jpf StateExplosion.jpf 7 | grep states
jpf StateExplosion.jpf 8 | grep states
jpf StateExplosion.jpf 9 | grep states
jpf StateExplosion.jpf 10 | grep states 
jpf StateExplosion.jpf 11 | grep states
jpf StateExplosion.jpf 12 | grep states
jpf StateExplosion.jpf 13 | grep states
jpf StateExplosion.jpf 14 | grep states
