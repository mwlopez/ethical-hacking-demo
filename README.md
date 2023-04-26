# Demonstration of Ethical Hacking

This repository was made for studio use only, the main focus of this project is to show bad development practices and how to solve them.

## Tools and requirements

For test and use, the following tools are needed:

* VS-Code (for development use only, if needed).
* Docker 20.10+
* Docker Componse
* NodeJS v18.12.1+
* Java 17+
* Python 3+

## Types of attacks

### Sql injections. 

This example shows us in java how to see the problem and how to fix it.

At bellow we can see a simple attack using curl.
[![asciicast](https://asciinema.org/a/kHvnArzQszxHK02RFQ60OlS5s.png)](https://asciinema.org/a/kHvnArzQszxHK02RFQ60OlS5s)

#### Curl Commands

This command execute a simple curl for the user *marcelo* with a wrong password.
```bash
curl -X POST http://localhost:8080/sql -H "Content-Type: application/json" -d "{ \"input\": \"marcelo\", \"password\": \"test1\"}"
```

We get a empty response.

Now we execute same example, but now with right password

```bash
curl -X POST http://localhost:8080/sql -H "Content-Type: application/json" -d "{ \"input\": \"marcelo\", \"password\": \"test\"}"
```

We get a response with username.

Now we send a wrong password, but the request is a sql injection.
```bash
curl -X POST http://localhost:8080/sql -H "Content-Type: application/json" -d "{ \"input\": \"marcelo' --\", \"password\": \"test1\"}"
```

For our surprise we got a right response. Finally we can conclude, we are hacked.
