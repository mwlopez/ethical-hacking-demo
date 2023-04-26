.PHONY: deploy/sqli
deploy/sqli:
	cp $(EXECUTE_DIR)/backend/demo/target/app.jar $(EXECUTE_DIR)/_output
	cp $(EXECUTE_DIR)/backend/demo/docker/Dockerfile  $(EXECUTE_DIR)/_output
	docker build -t demo/sqli -f $(EXECUTE_DIR)/_output/Dockerfile $(EXECUTE_DIR)/_output