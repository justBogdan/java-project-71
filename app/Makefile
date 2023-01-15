.PHONY:build

run-dist:
	build/install/app/bin/app -h

build:
    gradle build
report:
    gradle jacocoTestReport
    gradle jacocoTestCoverageVerification