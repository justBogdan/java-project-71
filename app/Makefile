.PHONY:build
.DEFAULT_GOAL:= build-run
GRADLEW ?= ./gradlew
run-dist:
	build/install/app/bin/app -h

build:
	make -C app install
report:
	make -C app report