CREATE TABLE articles_tags (
  id BIGINT AUTO_INCREMENT NOT NULL,
  article_id BIGINT NOT NULL,
  tag_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (article_id) REFERENCES article(id),
  FOREIGN KEY (tag_id) REFERENCES tag(id)
);