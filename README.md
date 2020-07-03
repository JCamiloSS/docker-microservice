# Docker-microservice

Docker-microservice is a spring boot application deployed in docker and connected to mysql.

## Description

This solution was designed using a modularized maven project, with two spring-boot modules, to facilitate deployment in docker containers. In turn we use docker-compose to manage and communicate the containers of the applications and the database.

This decision was made due to its easy configuration through yaml files.

## Prerequisites

- Java 1.8 
- Docker [Install](https://docs.docker.com/engine/install/)
- Docker-compose [Install](https://docs.docker.com/compose/install/)

## Download

To download the project in a console write git clone https://github.com/JCamiloSS/docker-microservice.git


## Installation
Type cd docker-microservice, then execute de command 
```bash
docker-compose build
```

## Run it

To start the application type the command 
```bash
docker-compose up
```

Enter the following url [http://localhost:8050/swagger-ui.html](http://localhost:8050/swagger-ui.html) and [http://localhost:8060/swagger-ui.html](http://localhost:8060/swagger-ui.html). Here you will find the description of the services and you can run them to test the available endpoints.

To run the main service go to [http://localhost:8050/swagger-ui.html](http://localhost:8050/swagger-ui.html) and in the order-controller Press tryout Paste the following payload

```json
{
  "clientId":"15864",
  "date":"2016-06-24",
  "direction":"Carrera 8 # 3 - 24",
  "products":[
    {
      	"id":"1",
    	"quantity":"10",
    	"cost":"2500"
    },
    {
      	"id":"2",
    	"quantity":"10",
    	"cost":"2800"
    }
   ]
}
```
and press execute and you can see the result. If you want to see the created orders you can visit the swagger in [http://localhost:8060/swagger-ui.html](http://localhost:8060/swagger-ui.html) and execute the /bill/{orderId} endpoint changing the orderId obtained in the previous executions. 

## Additional notes

- To unsubscribe the services press Ctrl + C
- Make sure that in some cases you need to run the Docker and Docker-compose Commands as administrator. (In the case of Ubuntu with sudo, for Windows it was not necessary, but it is necessary to run the terminal as Administrator)
- If after running docker-compose up you get the error "port is already allocated" run docker ps and copy the name of the container to stop, then run docker stop container_name and try again
