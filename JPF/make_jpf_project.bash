#!/bin/bash

read -d '' JAVAFILE << EOF
public class $1 {
	public static void main (String [] args){
			
	}
}
EOF

read -d '' JPFFILE << EOF
target = $1
classpath = .
EOF


rm -rf $1
mkdir $1
cd $1
echo "$JAVAFILE" > $1.java
echo "$JPFFILE" > $1.jpf
javac $1.java
