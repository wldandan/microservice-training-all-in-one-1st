# Zuul Server

```
./build-all.sh
docker-compose up
```

### route events

Event Service

```
curl http://localhost:8081/events
```

Edge Server

```
curl http://localhost:8765/api/events

```

### route reviews

Review Service

```
curl 'http://localhost:8082/reviews?eventId=1' 
```

Edge Server

```
curl 'http://localhost:8765/api/reviews?eventId=1' 
```