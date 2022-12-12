## JWT Token Authentication in Spring Boot Microservices
How JWT work?
1. Posts /login username and password to server
2. Server authenticates username and password
3. If valided -> server generates JWT
4. Sends token to client
5. Client stores token in browser session store
6. Client sends token in subsequence requests for proteced resources
7. Server verifies this token
8. On successful verification send requested resource
