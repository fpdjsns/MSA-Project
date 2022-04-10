# Spring Cloud Config Project

## Server 모듈

Cloud Config Server Application  
config-files github url : https://github.com/fpdjsns/MSA-config-files.git

## Client 모듈

Config-Server 모듈을 테스트하는 Client Server  
server 모듈을 먼저 띄운 후 client 모듈을 실행 시켜 결과를 확인한다.  
`TestRouter.http` 파일로 테스트 API 실행 가능  
`spring.profiles.active` dev, alpha 로 환경 변경해가며 테스트  
