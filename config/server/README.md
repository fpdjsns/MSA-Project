# Config-Server

`config-client-dev.yml` 파일이 수정된 경우.

### AS-IS
```json
[
  "config:client-dev",
  "config-client:dev",
  "config-client-dev"
]
```

깃헙 웹훅으로 config-files 가 변경되면 /monitor API가 자동 호출하게 하였으나  
뒤에 환경(dev)이 붙은 어플리케이션만 refresh가 된다.

### TO-BE
```json
[
  "config-client", 
  "config:client-dev",
  "config-client:dev",
  "config-client-dev"
]
```
PropertyPathEndpoint.guessServiceName(String path) 에서 path에서 위 3가지 파일명을 만든다.  
PropertyPathEndpoint.guessApplicationName(String path) 함수를 추가로 만들어 "-{{env}}.yml" 접미사를 제거한 파일명을 추가하게 수정하였다.  
env는 기본은 [dev, alpha, real, beta] 이며, `spring.cloud.config.monitor.custom.profiles` 프로퍼티로 수정가능하다.  
