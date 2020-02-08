#!/bin/sh

javac -cp lib/junit-4.12.jar:lib/hamcrest-core-1.3.java -d build src/java/*.java test/java/*.java

java -cp build:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore EdgeConnectorTest
java -cp build RunEdgeConvert
