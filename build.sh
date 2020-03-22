#!/bin/sh
javac -cp lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar *.java
if [ $? -ne 0 ] ; then echo "Error in prior step, exiting..."; exit $?; fi
java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore AllTests
if [ $? -ne 0 ] ; then echo "Error in prior step, exiting..."; exit $?; fi
java RunEdgeConvert
