create table book (
  id bigint not null auto_increment,
  title varchar(250) not null,
  number_of_pages INTEGER,
  author varchar(250),
  isbn varchar(250),
  create_at datetime,
  update_at datetime,

  primary key (id)
) engine=InnoDB default charset=utf8;

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;