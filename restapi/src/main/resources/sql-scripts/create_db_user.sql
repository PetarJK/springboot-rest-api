CREATE USER 'petarjk'@'localhost' IDENTIFIED BY 'petarjk';

GRANT ALL PRIVILEGES ON * . * TO 'petarjk'@'localhost';

ALTER USER 'petarjk'@'localhost' IDENTIFIED WITH mysql_native_password BY 'petarjk';