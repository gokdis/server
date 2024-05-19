# server

## Prerequisities

* Install a GNU/Linux distribution such as Debian

[https://www.debian.org/](https://www.debian.org/releases/stable/installmanual)

* Get OpenJDK 17

```sh
sudo apt install default-jdk
```

* Get Docker

```sh
sudo apt install docker && sudo groupadd docker && sudo usermod -aG docker $USER && newgrp docker
```

* Get Cassandra using Docker

```sh
docker pull cassandra && docker network create cassandra
```

* Update hosts

```sh
echo '127.0.0.1 gokdis.ecosys.eu' | sudo tee -a /etc/hosts
```

* Create a new keystore file in the src/main/resources/ssl directory as needed in production

## Quickstart

* Start Cassandra

```sh
docker run --rm -d --name cassandra --hostname cassandra --network cassandra cassandra
```
* Create the src/main/resources/application.properties file with the following template:
```properties
cassandra.contactpoints=172.18.0.2,127.0.0.1
cassandra.keyspace=supermarket
cassandra.schemaaction=recreate_drop_unused

management.endpoints.web.cors.allowedheaders=*
management.endpoints.web.cors.allowedmethods=GET
management.endpoints.web.cors.allowedorigins=http://localhost:5173/ # Vite
management.endpoints.web.exposure.include=*

server.port=443
server.ssl.keyalias=keyalias
server.ssl.keystore=src/main/resources/ssl/keystore.p12
server.ssl.keystorepassword=keystorepassword
server.ssl.keystoretype=pkcs12
```
* Start Spring Boot

```sh
./mvnw clean spring-boot:run # or run ServerApplication.java on an IDE such as Eclipse
```

* Run tests

```sh
mvn clean test
```

* Build

```sh
mvn clean package
```

* Log in at [https://gokdis.ecosys.eu/](https://gokdis.ecosys.eu/login)

* Import the HAR file into Insomnia or Postman to see the available endpoints