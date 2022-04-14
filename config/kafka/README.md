# Kafka

- [wurstmeister/kafka](https://hub.docker.com/r/wurstmeister/kafka)

kafka의 ip는 로컬로 띄우기 때문에 보통 `127.0.0.1`을 사용하지만
minikube로 docker를 사용하고 있다면 
```shell
$ minikube ip
```
응답값을 ip 주소로 사용해야 한다.

## 명령어

### kafka

- start a cluster
```shell
$ docker-compose up -d
```
- destroy a cluster
```shell
$ docker-compose stop
```

- 접속
```shell
$ docker exec -it local-kafka /bin/sh
```

- 로그 확인
```shell
$ cd /kafka/logs/{topicname-partition}
$ tail -f {file name}.log
```

### [참고] topic

- 생성

```shell
$ ./bin/kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic <name>
```

- 리스트 조회

```shell
$ ./bin/kafka-topics.sh --list --zookeeper zookeeper:2181
```

- 상세 조회

```shell
$ ./bin/kafka-topics.sh --zookeeper zookeeper:2181 --topic <name> --describe
```

### Producer

```shell
$ ./bin/kafka-console-producer.sh --broker-list localhost:8108 --topic <name>
```

### Consumer

```shell
$ ./bin/kafka-console-consumer.sh --bootstrap-server localhost:8108 --topic <name> --from-beginning
```
