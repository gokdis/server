# server

## Prerequisities

* Debian GNU/Linux

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

## Quickstart

* Start Cassandra

```sh
docker run --rm -d --name cassandra --hostname cassandra --network cassandra cassandra
```

* Start Spring Boot

```sh
./mvnw clean spring-boot:run # or run ServerApplication.java on Eclipse Theia
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

* Import the SAR file into Insomnia or Postman to see the available endpoints.
