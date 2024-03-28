# qnp-test
test di qnp

run project 
./mvnw spring-boot:run

postmant terlampir di qnp.postman_collection.json

1. code ada di package user 
  - di controller UserController method nya list, add, del, get

2. code ada di pacakage user dan post
  - di controller UserController method nya init
  - di controller PostController method nya init

3. code ada di package ratelimit

ada api user/lemot hit api berikut 10 kali lebih
curl http://localhost:8080/user/lemot &

maka response lebih dari 10 akan tidak akan diproses dan di beri status 429

4. code ada di class SecurityConfig, AuthAuthenticationProvider, AuthController
  localhost:8080/rest/auth/login 
    email & password isi bebas masih di hardcode asal bisa login
    setelah login dpt token
    nnt token tadi akan di letakkan di Authorzation Bearer Token untuk request ke tiap endpoint

  validasi di Endpoint di config di SecurityConfig & di filter JwtAuthorizationFilter
