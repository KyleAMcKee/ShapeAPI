# Shape API

Java Spring Boot REST backend that generates different shapes with labels. A React frontend allows users to interact with the database and add / edit / delete previously saved shapes.

A live version can be found at http://shapes.kylemckee.io

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Node, NPM, and Java are required to run the project locally.


For Node:

```
On a Mac with Homebrew:
brew install node
```

```
On Linux:
sudo apt-get install nodejs npm
```

```
On Windows:
https://nodejs.org/en/download/ - download and install NodeJS here
```

Java can be found here:
```
https://www.java.com/en/download/
```

### Installing

To begin clone the repository and install the dependencies for the client

```
git clone <this repository> <name>
cd <name>/client
npm install
```

## Running the program

To start the server:

```
cd <name>
mvn clean install
java -jar target\shape-api-0.0.1-SNAPSHOT.jar
```

To start the client (**The client must run on port 3000 (default) for the server to accept requests**):

```
cd <name>/client
npm run start
```

You'll now be able to interact with the server through forms at http://localhost:3000

Server can be reached at http://localhost:8080

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Java web framework
* [React](https://reactjs.org/) - JavaScript user interface library
* [Apache Derby](https://db.apache.org/derby/) - Open source relational database
* [Maven](https://maven.apache.org/) - Build Management

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
