


.PHONY: createdir
createdir:
	mkdir _output

.PHONY: build/all
build/all: createdir build/sqli

.PHONY: build/sqli
build/sqli:
	mvn -f $(EXECUTE_DIR)/backend/demo/pom.xml compile package

