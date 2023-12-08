# Configurando em seu ambiente
Execute os comandos abaixo: 
Após isso, você irá criar o arquivo docker-compose.yml
```bash
docker pull higorcamposs/trab-fppd-storm:latest
docker pull higorcamposs/trab-fppd-zookeeper:latest

```
#### docker-compose up -d

## docker-compose.yml
```bash
version: '3'

services:
  zookeeper:
    image: higorcamposs/trab-fppd-zookeeper:latest
    container_name: zookeeper
    ports:
      - "2181:2181"

  nimbus:
    image: higorcamposs/trab-fppd-storm:latest
    container_name: nimbus
    depends_on:
      - zookeeper
    environment:
      - "NIMBUS_SEEDS=zookeeper"
      - "NIMBUS_HOST=nimbus"
      - "STORM_LOCAL_DIR=/tmp/storm"
    ports:
      - "3772:3772"
      - "3773:3773"
      - "6627:6627"
    command: storm nimbus

  supervisor:
    image: higorcamposs/trab-fppd-storm:latest
    container_name: supervisor
    depends_on:
      - nimbus
    environment:
      - "NIMBUS_SEEDS=zookeeper"
      - "STORM_LOCAL_DIR=/tmp/storm"
    command: storm supervisor

  ui:
    image: higorcamposs/trab-fppd-storm:latest
    container_name: ui
    depends_on:
      - nimbus
    ports:
      - "8080:8080"
    command: storm ui

