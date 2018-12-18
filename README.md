# spring boot demo
`这是一个只包含基本配置的spring boot项目`

## base0分支
包含了最基本的配置
1. mysql数据库
2. 集成了 Druid连接池 / Lombok / Mybatis / Swagger
3. 继承了基本的Dao，使用了PageHelper分页插件
4. 包含了最简单的logback.xml配置文件(基本的控制台和文件日志)
注：logback日志配置这一块我不太熟
5. 

## mybatis-generator-core
https://github.com/jinse95/mybatis-generator-core
做了一些修改 详见readme文件

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
