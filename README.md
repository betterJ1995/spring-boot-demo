# spring boot demo
`这是一个只包含基本配置的spring boot项目`

## base分支
包含了最基本的配置
1. mysql数据库
2. 集成了 druid连接池 / Lombok / Mybatis-Plus / Swagger 
3. 包含了最简单的logback.xml配置文件(基本的控制台和文件日志)
4. 基本的多数据源配置（若不需要，则直接删除SlaveMysqlConfig即可）

## 可能会用到的包
- redis
```
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-redis</artifactId>
```
- excel导出（基于poi但是使用极其方便）
```
    <groupId>com.alibaba</groupId>
    <artifactId>easyexcel</artifactId>
```
