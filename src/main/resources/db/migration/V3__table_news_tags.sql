CREATE TABLE news_tags (
  id BIGINT AUTO_INCREMENT NOT NULL,
  news_id BIGINT NOT NULL,
  tag_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (news_id) REFERENCES news(id),
  FOREIGN KEY (tag_id) REFERENCES tag(id)
);