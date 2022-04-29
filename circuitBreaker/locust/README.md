# gatling

테스트 작성이 빠르고 형상관리가 편리하다 들어서 채택  
https://docs.locust.io/en/1.5.2/running-locust-docker.html

# How to Use
1. 로컬 IP 확인
mac  
```shell
$ ifconfig | grep inet
```

2. locust/locustfile.py 파일의 {{ ip }} 를 로컬 IP로 수정
3. locust 폴더로 이동 후 
   ```shell
   docker-compose up
   ```
4. localhost:8089 접속

5. load test setting
- Number of users : 300
- Spawn rate : 100

6. Start swarming

### 참고

- minikube 사용시   
  locust 파일 위치에서 mount 해준 후 docker-compose 실행
  ```shell
  $ minikube mount ./:/host
  ```

- minikube command
  - config 확인
  ```shell
  $ cat $HOME/.kube/config
  ```
  
