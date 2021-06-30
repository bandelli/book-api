set foreign_key_checks = 0;
delete from book;
set foreign_key_checks = 1;
alter table book auto_increment = 1;

INSERT INTO book.book (title,number_of_pages,author,isbn,create_at,update_at) VALUES
('quia pariatur consequatur',496,'Ms. Neal Kling','1624834424','2021-06-28 01:53:44',NULL),
('voluptas atque iure',949,'Ms. Lamar Huels','1624834425','2021-06-28 01:53:45',NULL),
('voluptates rem fugit',272,'Geraldine Parker','1624834426','2021-06-28 01:53:46',NULL),
('quasi magni corrupti',1,'Margaret Hagenes','1624834427','2021-06-28 01:53:47',NULL),
('aut blanditiis quia',822,'Otis Farrell','1624834428','2021-06-28 01:53:48',NULL);