# 分布式事务测试代码

## 数据库
* 测试数据库 ```h2database```
* 生产数据库 ```mysql```

## 框架 
* spring cloud 
* mybatis
* hmily(tcc框架)

## 目录结构
+ common    通用类包 ```通用bean```
+ configuration 启动配置包 ```启动需要的配置```
+ controller    控制器包 ```所有控制器及增强控制器```
+ dao   数据库操作包 ```数据库CRUD```
+ dto   DTO包 ```用来传输的bean```
+ entity    PO包 ```数据库中表对应的bean```
+ exception 异常包 ```所有异常```
+ form  请求参数包 ```前端请求表单对应bean```
+ mapper    转换包 ```DTO转PO PO转DTP FROM转DTO```
+ service   服务包 ```所有业务操作```

## 工具类
* lombok ```简化bean GET/SET```
* mapstruct ```简化DTO，PO，FROM数据转换```

## 测试
* junit
* mockito

## 注意点
