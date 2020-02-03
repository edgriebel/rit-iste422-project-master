#!/bin/sh
javac -cp lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar -d build src/java/*.java
javac -cp lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar:build -d build test/java/*.java
java -cp .:lib/junit-4.12.jar:build:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore EdgeConnectorTest
java -cp build RunEdgeConvert