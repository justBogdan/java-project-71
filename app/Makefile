.PHONY:build
.PHONY:gradle
GRADLEW ?= ./gradlew
run-dist:
	build/install/app/bin/app -h

build:
	$(GRADLEW) build --info
report:
	$(GRADLEW) jacocoTestReport
	$(GRADLEW) jacocoTestCoverageVerification