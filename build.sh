#!/bin/sh
javac -cp lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar build/src/java/*.java
javac -cp lip/junit-4.12.jar:lib/hamcrest-core-1.3.jar build/test/java/*.java
java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore EdgeConnectorTest
cd build/src/java/
java RunEdgeConvert  
