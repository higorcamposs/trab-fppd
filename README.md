# Configurando em seu ambiente

## OBS: Necessário ter o docker para seguir com os proximos passos
```bash
apt install docker
apt install docker.io
```

### Execute os comandos abaixo: 

```bash
docker pull higorcamposs/trab-fppd-storm:latest
docker pull higorcamposs/trab-fppd-zookeeper:latest
```
### Após isso, você irá criar o arquivo docker-compose.yml
Sugestão: Crie uma pasta e lá você adiciona o arquivo docker-compose.yml, que está aqui no repositório. 
```bash
mkdir /home/docker
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

### Acesso o Storm UI
```bash
SEU_IP:8080
```

