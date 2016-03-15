.PHONY: default clean compile compile-test test

SRC = $(shell find src -name '*.java' -type f)
TEST = $(shell find test -name '*.java' -type f)
SRC_CP = 
TEST_CP = lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar

TEST_CLASS = algLin.HelderTest

default: clean test

clean:
	rm -rf _build

compile:
	@mkdir -p _build/src
	javac -cp '$(SRC_CP)' -d _build/src $(SRC)

compile-test: compile
	@mkdir -p _build/test
	javac -cp _build/src:$(TEST_CP) -d '_build/test' $(TEST)

test: compile-test
	java -cp _build/src:_build/test:$(SRC_CP):$(TEST_CP) org.junit.runner.JUnitCore $(TEST_CLASS)

