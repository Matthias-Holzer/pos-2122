# Wisdom Animals
by Matthias Holzer

## A microservice spring boot application
* feature/s1-f2_multimodule_build
* feature/s1-f3_introducing_feign
* feature/s1-f4_service_registry

## Idea
Generating Calendar Quotes with a sweet ascii 
art animal from one microservice and one wisdom
quote from another microservice

![random.png](screenshots/random.png)

## Microservices
* animal-service 
* quotes-service
* wisdomAnimal-service

## Eureka
Ports are all defined specific, for debug purpose. 
In production, they will all be set to 0, and handed 
out by eureka.

![eureka.png](screenshots/eureka.png)