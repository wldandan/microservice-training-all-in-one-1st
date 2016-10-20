## 基本介绍

该部分内容包括了课程中提到的报名系统相关的服务以及相关的支撑组件

#### 由业务拆分的服务

* Event Service
* Review Service
* Recommendation Service
* Event Composite Service

#### 相关支撑组件
* Eureka Server
* Config Server
* Turbine Server
* Edge Server

## 如何使用


### 1.Docker环境下

1.启动应用

```docker-compose up --build```

2.加载测试数据

```db-seed/seed.sh```

3.访问应用

| 组件或者服务    | 端口号         | 访问地址| 描述信息| 
|:------------- |:------------|:-------|:-------|
|注册中心 Eureka Server|8010|http://localhost:8010|查看注册的服务和支撑组件|
|配置中心 Spring Cloud Config Server|8012|htp://localhost:8012/event/docker|访问profile=docker场景下的EventService配置信息。注意在该场景下，使用的是github的config-repo，请确保网络畅通|
|Event Service|9000|http://localhost:9000/events|使用浏览器访问EventService首页以及使用Curl访问EventService首页|
|Review Service|9010|http://localhost:9010/reviews|使用浏览器访问ReviewService首页以及使用Curl访问ReviewService首页|
|Recommendation Service|9020|http://localhost:9020/recommendation|使用浏览器访问RecommendationService首页以及使用Curl访问RecommendationService|
|Event Composite Service|9030|http://localhost:9030/events/57c811115d6fe2b86380d538|查看Event聚合后的明细|
|断路器管理中心 Turbine Server|8011|http://localhost:8030/hystrix|```输入http://localhost:8030/turbine.stream?cluster=default```;使用siege模拟请求测试，查看Hystrix Dashboard的变化,命令如下所示```siege http://localhost:9030/events/57c811115d6fe2b86380d538```|
|API Gateway Edge Server|8040|http://localhost:8040/api/events/events或者http://localhost:8040/api/events/events/57c811115d6fe2b86380d538|访问Edge Server, http://localhost:8040/api/event-composite/events/57c811115d6fe2b86380d538

***

### 2.非Docker环境

###1.安装并启动依赖

* MongoDB
* RabbitMQ

###2.启动应用

在不同组件或者服务内执行
```Java -jar build/libs/xxxxx.jar```或者```./gradlew bootRun```

###3.加载测试数据

```mongoimport --db test --collection event --type json --file events-with-id.json```


###4.访问应用


3.访问应用

| 组件或者服务    | 端口号         | 访问地址| 描述信息| 
|:------------- |:------------|:-------|:-------|
|注册中心 Eureka Server|8010|http://localhost:8010|查看注册的服务和支撑组件|
|配置中心 Spring Cloud Config Server|8012|htp://localhost:8012/event/docker|访问profile=docker场景下的EventService配置信息。注意在该场景下，使用的是github的config-repo，请确保网络畅通|
|Event Service|9000|http://localhost:9000/events|使用浏览器访问EventService首页以及使用Curl访问EventService首页|
|Review Service|9010|http://localhost:9010/reviews|使用浏览器访问ReviewService首页以及使用Curl访问ReviewService首页|
|Recommendation Service|9020|http://localhost:9020/recommendation|使用浏览器访问RecommendationService首页以及使用Curl访问RecommendationService|
|Event Composite Service|9030|http://localhost:9030/events/57c811115d6fe2b86380d538|查看Event聚合后的明细|
|断路器管理中心 Turbine Server|8011|http://localhost:8030/hystrix|```输入http://localhost:8030/turbine.stream?cluster=default```;使用siege模拟请求测试，查看Hystrix Dashboard的变化,命令如下所示```siege http://localhost:9030/events/57c811115d6fe2b86380d538```|
|API Gateway Edge Server|8040|http://localhost:8040/api/events/events或者http://localhost:8040/api/events/events/57c811115d6fe2b86380d538|访问Edge Server, http://localhost:8040/api/event-composite/events/57c811115d6fe2b86380d538

