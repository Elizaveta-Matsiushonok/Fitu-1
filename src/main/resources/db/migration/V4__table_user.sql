CREATE TABLE user(
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  password VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL,
  account_non_expired BOOLEAN NOT NULL,
  account_non_locked BOOLEAN NOT NULL,
  credentials_non_expired BOOLEAN NOT NULL,
  enabled BOOLEAN NOT NULL,
  authorities VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
)