# Configurando em seu ambiente
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
