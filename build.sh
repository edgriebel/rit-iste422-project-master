#!/bin/sh

SRC_DIR="src/java"
TEST_DIR="test/java"
BUILD_DIR="build"


javac -cp lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \
	$SRC_DIR/*.java $TEST_DIR/*.java \
	-d $BUILD_DIR

java -cp $BUILD_DIR:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar \
	org.junit.runner.JUnitCore \
	EdgeConnectorTest

java -cp $BUILD_DIR \
	RunEdgeConvert

