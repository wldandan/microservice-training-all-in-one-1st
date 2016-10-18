## Docker环境

### 启动应用
```
docker-compose up --build
```

### 访问应用

* 访问Eureka Server(查看注册的服务和支撑组件)
http://localhost:8011

* 访问配置中心(查看Event serviece在profile是'docker'场景下的配置信息。注意在docker profile下，使用的是github的config-repo，所以确保网络畅通)
htp://localhost:8012/event/docker 

* 访问Event Service(访问EventService首页，HAL-browser显示EventService提供的接口)
http://localhost:9000/events

* 加载测试数据，刷新上一步的访问
db-seed/seed.sh
http://localhost:9000/events
http://localhost:9000/events/57c811115d6fe2b86380d538

* 访问Event-composite(查看event-composite返回的结果)
http://localhost:9030/events/57c811115d6fe2b86380d538

* 访问Turbine Server
http://localhost:8030/hystrix
输入'http://localhost:8030/turbine.stream?cluster=default'
使用siege，启动请求测试，查看Hystrix的断路器变化
```siege http://localhost:9030/events/57c811115d6fe2b86380d538```

## 非Docker环境

### 启动应用

* 启动MongoDB
* 启动Eureka Server
* 启动多个Service(EventService,ReviewService,RecommendationService,CompositeService)
* 启动Turbine Server

### 访问应用

* 访问Eureka Server(查看注册的服务和支撑组件)
http://localhost:8011

* 访问配置中心(使用的是本地配置文件存储配置项)
htp://localhost:8012/event/docker 

* 访问Event Service(访问EventService首页，HAL-browser显示EventService提供的接口)
http://localhost:9000/events

* 加载测试数据，并刷新上一步的访问页面
```mongoimport --db test --collection event --type json --file events-with-id.json```

http://localhost:9000/events
http://localhost:9000/events/57c811115d6fe2b86380d538

* 访问Event-composite(查看event-composite返回的结果)
http://localhost:9030/events/57c811115d6fe2b86380d538

* 访问Turbine Server
http://localhost:8030/hystrix
输入'http://localhost:8030/turbine.stream?cluster=default'
使用siege，启动请求测试，查看Hystrix的断路器变化
```siege http://localhost:9030/events/57c811115d6fe2b86380d538```