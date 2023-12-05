DROP TABLE IF EXISTS weather, users;

CREATE TABLE users (
  id serial PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,     -- Username
  password varchar(32) NOT NULL,      -- Password (hashed, not plain-text)
  salt varchar(256) NOT NULL		  -- Password Salt
);


CREATE TABLE weather (
    id serial PRIMARY KEY,
    user_id int NOT NULL,
    zipcode int NOT NULL,
    main varchar(200) NOT NULL,
    description varchar (300) NOT NULL,
    temperature numeric(5, 2),
    CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES users (id)
);