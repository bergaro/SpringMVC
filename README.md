# SpringMVC

### - Задача 1 - Migration
### - Задача 2 - Данные не удаляются

### Rq (insert post):

POST http://localhost:8080/api/posts
Content-Type: application/json

{
"id": 1,
"content": "Sth. Post",
"removed": false
}

### Rs (insert post):

HTTP/1.1 200
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Thu, 22 Jul 2021 17:02:22 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
"id": 1,
"content": "Sth. Post",
"removed": false
}

Response code: 200; Time: 32ms; Content length: 46 bytes

### Rq (get all posts):

GET http://localhost:8080/api/posts

### Rs (get all posts):

HTTP/1.1 200
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Thu, 22 Jul 2021 17:04:22 GMT
Keep-Alive: timeout=60
Connection: keep-alive

[
{
"id": 1,
"content": "Sth. Post",
"removed": false
},
{
"id": 2,
"content": "Sth. Post",
"removed": false
},
{
"id": 3,
"content": "Sth. Post",
"removed": false
}
]

### Rq (delete posts id-3):

DELETE http://localhost:8080/api/posts/3

### Rs (delete post id-3):

HTTP/1.1 200
Content-Length: 0
Date: Thu, 22 Jul 2021 17:05:24 GMT
Keep-Alive: timeout=60
Connection: keep-alive

Response body is empty

Response code: 200; Time: 96ms; Content length: 0 bytes

### Rq (get all posts):

GET http://localhost:8080/api/posts

### Rs (get all posts):

HTTP/1.1 200
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Thu, 22 Jul 2021 17:06:54 GMT
Keep-Alive: timeout=60
Connection: keep-alive

[
{
"id": 1,
"content": "Sth. Post",
"removed": false
},
{
"id": 2,
"content": "Sth. Post",
"removed": false
}
]

Response code: 200; Time: 64ms; Content length: 95 bytes

### Rq (get post where id=2):

GET http://localhost:8080/api/posts/2

### Rs (get post where id=2):

HTTP/1.1 200
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Thu, 22 Jul 2021 17:07:27 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
"id": 2,
"content": "Sth. Post",
"removed": false
}

Response code: 200; Time: 88ms; Content length: 46 bytes

### Rq (get post where id=3[deleted post]):

GET http://localhost:8080/api/posts/3

### Rs (get post where id=3[deleted post]):

HTTP/1.1 404
Content-Type: text/html;charset=utf-8
Content-Language: en
Content-Length: 719
Date: Thu, 22 Jul 2021 17:08:13 GMT
Keep-Alive: timeout=60
Connection: keep-alive

<!doctype html>
<html lang="en">
<head><title>HTTP Status 404 – Not Found</title>