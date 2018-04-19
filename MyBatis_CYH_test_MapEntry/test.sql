DROP TABLE IF EXISTS employee;
CREATE TABLE IF NOT EXISTS employee(
  id INT PRIMARY KEY,
  name VARCHAR(40)
);

INSERT INTO employee(id, name) VALUES (1, 'Alice');
