# Testando Storm UI do Apache Storm

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

### Criando os códigos em java, que estão aqui no repo:
```bash
vim TopologyMain.java
vim Spout.java
vim Bolt.java
```
Crie fora do docker!

### Crie uma pasta no Nimbus para armazenar os códigos:
```bash
docker exec nimbus mkdir -p /apache-storm-2.5.0/examples/trab-fppd
```

### Copie os códigos criados para dentro do Nimbus:
```bash
docker cp TopologyMain.java nimbus:/apache-storm-2.5.0/examples/trab-fppd
docker cp Spout.java nimbus:/apache-storm-2.5.0/examples/trab-fppd
docker cp Bolt.java nimbus:/apache-storm-2.5.0/examples/trab-fppd
```

### Acessando o Nimbus:
```bash
docker exec -it nimbus /bin/bash
```

### Instalando dependencias JAVA:
```bash
apt-get update
apt-get install default-jdk
```

### Acesse o diretorio onde estão os arquivos:
```bash
cd /apache-storm-2.5.0/examples/trab-fppd
```
- Para listar os arquivos e conferir se estão lá: "ls"

### Execute: 
```bash
javac -cp "/apache-storm-2.5.0/lib/*" TopologyMain.java Spout.java Bolt.java
jar cf myTopology.jar *.class
storm jar myTopology.jar TopologyMain
```

### Ao finalizar, verifique se contém essa linha no final do log: 
```bash
... [main] INFO  o.a.s.StormSubmitter - Finished submitting topology: Topology
```
- Se tiver, está tudo correto! Caso contrário, verifique novamente os passos ou entre em contato para analisarmos o caso.


# Analise do Storm UI
### Verifique todos os summarys, em especial: 
- Supervisor Summary
- Topology Summary

#### Agora tem uma topologia e um dos slots ocupados. 
#### Para ver a topologia, clique: Topology Visualization >> Show Visualization


