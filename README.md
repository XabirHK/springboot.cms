# Xabir

Todo


## How to run in docker

### Using docker-compose

* Run full stack

```
docker-compose up
```

* Check status

```
docker-compose ps
docker ps
```


* Shutdown

```
docker-compose down
```

----

More details

### Build docker images

```
docker build -t xabirmvn -f dockerfiles/Dockerfile.maven .
docker build -t xabirmysql -f dockerfiles/Dockerfile.mysql .
```

### Want to test java app only

```
cd ${your project root directory}

docker run -it --rm --name myapp -v "$(pwd)":/workdir -v "$HOME/.m2":/root/.m2 -w /workdir -p 8080:8080 xabirmvn bash

# you're now inside a maven container with your source code, you can run mvn commands as you'd do in your local machine
# ex: mvn clean, mvn package.
# Note: maven repo is mounted from your $HOME directory. Therefore, we're using the same repo for all containers.
```

## Want to test database

```
docker run -it --rm myapp-mysql bash
```

You have to start the mysql server manully

TODO:

- [ ] volume directory not created
- [ ] Initial script for database
