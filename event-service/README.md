## 本地环境运行

* 安装MongoDB

```
brew install mongodb
```


* 启动MongoDB

```
mongod --config /usr/local/etc/mongod.conf
```

* 导入测试数据
```
mongoimport --db test --collection event --type json --file db-seed/events-with-id.json
```

* 启动应用

```
./gradlew bootRun
```

## Docker环境中运行

* 生成Jar包

```./gradlew clean build```

* 使用Docker-compose运行

```
./docker-compose up --build
```

* 导入测试数据
```
./db-seed/seed.sh
```

## 其他
 
### 创建一条Event活动

```
START_AT=$(date +"%Y-%m-%d") && END_AT=$(date +"%Y-%m-%d") && curl -H "Content-type: application/json" -d "{\"name\": \"测试活动\", \"numberLimit\": 20, \"mainPhoto\": \"http://localhost/image/main_photo.png\", \"introduction\": \"活动介绍\", \"startAt\": \"$START_AT\", \"endAt\": \"$END_AT\"}" http://localhost:8080/events
```

### 更新一条Event活动

```
START_AT=$(date +"%Y-%m-%d") && END_AT=$(date +"%Y-%m-%d") && curl -H "Content-type: application/json" -d "{\"name\": \"测试活动-updated\", \"numberLimit\": 20, \"mainPhoto\": \"http://localhost/image/main_photo.png\", \"introduction\": \"活动介绍\", \"startAt\": \"$START_AT\", \"endAt\": \"$END_AT\"}" http://localhost:8080/events/{id}
```