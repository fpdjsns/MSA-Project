# Spring Cloud Config Project

[Spring Cloud Config](https://cloud.spring.io/spring-cloud-config/reference/html/) playground  

## How to Use
1. IP 설정
```
- server.src.main.resources.application.yml
- client.src.main.resources.application.yml
- kafka.docker-compose.yml
```  
위 파일들의 `{{your.host.name}}` 에 사용하고자 하는 IP를 입력한다.  

보통 로컬 IP인 `127.0.0.1`을 사용하지만 minikube로 docker를 사용하고 있다면
```shell
$ minikube ip
```
응답값을 ip 주소로 사용해야 한다.

2. kafka 띄우기
```shell
$ ./kafka/docker-compose
```
3. server 모듈 bootrun
4. client 모듈 bootrun

## 모듈
### Server 모듈

Cloud Config Server Application  
config-files github url : https://github.com/fpdjsns/MSA-config-files.git

- **github webhook** 등록
1. \[개인 도메인이 존재하지 않는 경우] ngrok 사용  
  [ngrok](https://dashboard.ngrok.com/get-started/setup) 설치 & 회원가입
```shell
ngrok http 8888
```
  config server 포트인 8888 포트 포워딩 도메인 주소 get  

2. github webhook event 등록  
   config-files github 웹훅 추가  
   | 항목 | 내용 |   
   | --- | --- |   
   | payload URL | {{config-server 도메인주소}}/monitor |  
   | Content-type | application-json |
   | Secret |  |
   | trigger | Just the push event. |
   
### Client 모듈

Config-Server 모듈을 테스트하는 Client Server  
server 모듈을 먼저 띄운 후 client 모듈을 실행 시켜 결과를 확인한다.  
`TestRouter.http` 파일로 테스트 API 실행 가능  
`spring.profiles.active` dev, alpha 로 환경 변경해가며 테스트  

### Kafka

local에서 docker로 카프카를 띄우기 위함

## Memo

### Spring Cloud Bus  
  AMQP, kafka, redis 사용 가능.  
  해당 프로젝트에서는 Kafka 사용
