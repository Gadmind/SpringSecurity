# SpringBoot2.X整合SpringSecurity

## SpringSecurity简介

相对于ApacheShiro的轻量级安全框架来说，SpringSecurity更像是一个重量级的安全感框架，相对于Shiro来说Security对系统安全方面的权限颗粒度划分的更为详细。

创建SpringBoot项目并引入相关依赖

```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-test</artifactId>
</dependency>
```

