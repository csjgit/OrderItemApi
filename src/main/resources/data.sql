DROP TABLE IF EXISTS OrderItem;

CREATE TABLE OrderItem (
id INT AUTO_INCREMENT  PRIMARY KEY,
  ProductCode VARCHAR(250) NOT NULL,
  ProductName VARCHAR(250) NOT NULL,
  Quantity int NOT NULL
);