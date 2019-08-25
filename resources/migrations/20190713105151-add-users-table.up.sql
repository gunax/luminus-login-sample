CREATE TABLE users
(username VARCHAR(20) NOT NULL UNIQUE,
 password NOT NULL UNIQUE);

 --;;

CREATE UNIQUE INDEX username_index ON users(username);
