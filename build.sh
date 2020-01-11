#!/bin/sh
javac -cp lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar *.java
echo java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore EdgeConnectorTest
java RunEdgeConvert
