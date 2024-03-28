# qnp-test
test di qnp

postmant terlampir

1. code ada di package user 
  - di controller UserController method nya list, add, del, get

2. code ada di pacakage user dan post
  - di controller UserController method nya init
  - di controller PostController method nya init

3. code ada di package ratelimit

ada api user/lemot hit api berikut 10 kali lebih
curl http://localhost:8080/user/lemot &

maka response lebih dari 10 akan tidak akan diproses dan di beri status 429

