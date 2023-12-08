# Configurando em seu ambiente

## OBS: Necessário ter o docker para seguir com os proximos passos
```bash
apt install docker
apt install docker.io
apt install docker-compose
```

### Execute os comandos abaixo: 

```bash
docker pull higorcamposs/trab-fppd-storm:latest
docker pull higorcamposs/trab-fppd-zookeeper:latest
```
### Após isso, você irá criar o arquivo docker-compose.yml
Sugestão: Na sua pasta docker: adicione o arquivo docker-compose.yml, que está aqui no repositório. 
```bash
cd /home/docker
vi docker-compose.yml
```

### Iniciando o docker
```bash
docker-compose up
```

### Confira o status do docker
```bash
docker ps
```

### Verifique seu ip
```bash
ip a
```

### Acesse o Storm UI
```bash
SEU_IP:8080
```

# Analise do Storm UI

### Verifique todos os summarys, em especial: 
- Supervisor Summary
- Topology Summary

#### Não há topologia e todos os slots dos supervisores estão disponiveis!

# Criando tarefas no Storm Cluster

### Acessando o Nimbus:
```bash
docker exec -it nimbus /bin/bash
```

### Criando pasta para colar os códigos:
```bash
mkdir examples/trab-fppd
cd examples/trab-fppd
```

### Copie e cole os códigos:
```bash
vim topologyMain.java
vim spout.java
```


docker cp topologyMain.java nimbus:/apache-storm-2.5.0/examples/trab-fppd
docker cp spout.java nimbus:/apache-storm-2.5.0/examples/trab-fppd
docker cp boult.java nimbus:/apache-storm-2.5.0/examples/trab-fppd



