# SpringMVCHibernate

http://www.journaldev.com/3531/spring-mvc-hibernate-mysql-integration-crud-example-tutorial

mysql:

CREATE TABLE `Person` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `Nationality` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


ALTER TABLE Person
add id_nationality int(11) unsigned; 

ALTER TABLE Person
ADD FOREIGN KEY (id_nationality) REFERENCES Nationality(id);

ALTER TABLE Person
DROP FOREIGN KEY person_ibfk_1;


useful links:
http://rogerdudler.github.io/git-guide/

https://www.formget.com/form-validation-using-ajax/

https://github.com/spring-projects

http://www.dineshonjava.com/2013/05/spring-crud-example-using-one-to-one.html#.V3I8taLOVLU

http://www.dineshonjava.com/2013/05/spring-crud-example-using-one-to-one.html#

http://howtodoinjava.com/spring/spring-mvc/spring-mvc-populate-and-validate-dropdown-example/

http://howtodoinjava.com/spring/spring-mvc/spring-bean-validation-example-with-jsr-303-annotations/

http://stackoverflow.com/questions/6181277/how-do-i-set-the-selected-value-in-a-spring-mvc-formselect-from-the-controller


