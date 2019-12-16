SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS messages;

CREATE TABLE messages (
  id                    INT(11) NOT NULL AUTO_INCREMENT,
  msg               VARCHAR(50) NOT NULL,
  time_create_at        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO messages (msg)
VALUES
('Hello'),
('Good day'),
('Cheers'),
('Goodbye');