# java_request

## 使い方

### GET

```java
Request req = new Request();
req.req("URL", Request.METHOD_GET, "");
```

### POST

```java
Request req = new Request();
req.req("URL", Request.METHOD_POST, "parameter");
```
`parameter`の指定はGETの時にURLの末尾についているアレみたいな感じで書いてください。<br>
パラメータ名_1=値_1&パラメータ名_2=値_2&……
