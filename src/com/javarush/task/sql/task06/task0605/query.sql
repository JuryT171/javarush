-- Write your code here:
CREATE TABLE users ( user_id INT not null AUTO_INCREMENT,
                     first_name VARCHAR(255) NOT NULL,
                     last_name VARCHAR(255) NOT NULL,
                     date DATETIME NOT NULL DEFAULT now(),
                     weight FLOAT (10)  NULL,
                     PRIMARY KEY  (user_id);