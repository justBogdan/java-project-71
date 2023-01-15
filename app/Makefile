.PHONY:build
.DEFAULT_GOAL:= build-run
run-dist:
	build/install/app/bin/app -h
build:
	./gradlew clean build
report:
	./gradlew jacocoTestReport