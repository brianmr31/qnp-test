# qnp-test
test di qnp

## run project 

```bash
./mvnw spring-boot:run

mvnw.cmd spring-boot:run
```

## Postman
import qnp.postman_collection.json

# Question answer

## Create restful Api with CRUD
  - the answer is in the UserController class in the findAllPage(), saveUser(), getUserById() and delUserById()

## Create an endpoint that fetch 2
  - the answer is in the UserController class in the init()
  - the answer is in the PostController class in the init()

## Add rate-limiter to those endpoint 
  - the answer is in the RateLimitFilter 

### To Test rate-limit 
  1. Request Api with background request. 
  ```bash
    curl http://localhost:8080/user/lemot &
  ```
  2. Make Request more then 10 times 
  3. The response 11th will be 429
  4. Noted this only on api /user/lemot. because I made a rate limit based on a queue with 10 quotas. If the request is still executed then the 11th request is rejected

## Add JWT validation for those endpoints.
  - the answer is in the class JwtAuthorizationFilter for check all request then class JwtUtil to claim data on jwttoken
  
### to Test Jwttoken
  1. You need login to url /rest/auth/login to create token. 
  2. After you get the token, add on Header Authentication Header
  3. Set Authorzation Bearer Token do it to akses all endpoint
  4. Noted username password can be filled in whatever, this is just a validation test for the endpoint
