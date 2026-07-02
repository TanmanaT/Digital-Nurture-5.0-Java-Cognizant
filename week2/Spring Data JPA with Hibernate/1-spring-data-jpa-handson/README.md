# Part 1: Spring Data JPA Hands-on

Objectives
Explain the need and benefit of ORM
ORM (Object-Relational Mapping), makes it easier to develop code that interacts with database, abstracts the database system, transactionality
ORM Pros and Cons - https://blog.bitsrc.io/what-is-an-orm-and-why-you-should-use-it-b2b6f75f5e2a
What is ORM? - https://en.wikipedia.org/wiki/Object-relational_mapping
 
Demonstrate the need and benefit of Spring Data JPA
Evolution of ORM solutions, Hibernate XML Configuration, Hibernate Annotation Configuration, Spring Data JPA, Hibernate benefits, open source, light weight, database independent query
With H2 in memory database - https://www.mkyong.com/spring-boot/spring-boot-spring-data-jpa/
With MySQL - https://www.mkyong.com/spring-boot/spring-boot-spring-data-jpa-mysql-example/
XML Configuration Example -https://www.tutorialspoint.com/hibernate/hibernate_examples.htm
Hibernate Configuration Example -https://www.tutorialspoint.com/hibernate/hibernate_annotations.htm
 
Explain about core objects of hibernate framework
Session Factory, Session, Transaction Factory, Transaction, Connection Provider
Hibernate Architecture Reference - https://www.tutorialspoint.com/hibernate/hibernate_architecture.htm
 
Explain ORM implementation with Hibernate XML Configuration and Annotation Configuration
XML Configuration - persistence class, mapping xml, configuration xml, loading hibernate configuration xml file; Annotation Configuration - persistence class, @Entity, @Table, @Id, @Column, hibernate configuration xml file Loading hibernate configuration and interacting with database get the session factory, open session, begin transaction, commit transaction, close session
XML Configuration Example - https://www.tutorialspoint.com/hibernate/hibernate_examples.htm
Hibernate Configuration Example - https://www.tutorialspoint.com/hibernate/hibernate_annotations.htm
 
Explain the difference between Java Persistence API, Hibernate and Spring Data JPA
JPA (Java Persistence API), JPA is a specification (JSR 338), JPA does not have implementation, Hibernate is one of the implementation for JPA, Hibernate is a ORM tool, Spring Data JPA is an abstraction above Hibernate to remove boiler plate code when persisting data using Hibernate.
Difference between Spring Data JPA and Hibernate - https://dzone.com/articles/what-is-the-difference-between-hibernate-and-sprin-1
Intro to JPA - https://www.javaworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html
 
Demonstrate implementation of DML using Spring Data JPA on a single database table
Hibernate log configuration and ddl-auto configuration, JpaRepsitory.findById(), defining Query Methods, JpaRespository.save(), JpaRepository.deleteById()
Spring Data JPA Ref Repository methods - https://docs.spring.io/spring-data/jpa/docs/2.2.0.RELEASE/reference/html/#repositories.core-concepts
Query methods - https://docs.spring.io/spring-data/jpa/docs/2.2.0.RELEASE/reference/html/#repositories.query-methods

## Exercises Included:
- [Hands on 1 - Spring Data JPA - Quick Example Software Pre-requisites](./handson-1/README.md)
- [Hands on 2 - Hibernate XML Config implementation walk through SME to provide explanation on the sample Hibernate implementation available in the link below:https://www.tutorialspoint.com/hibernate/hibernate_examples.htmExplanation Topics](./handson-2/README.md)
- [Hands on 3 - Hibernate Annotation Config implementation walk through SME to provide explanation on the sample Hibernate implementation available in the link below:https://www.tutorialspoint.com/hibernate/hibernate_annotations.htmExplanation Topics](./handson-3/README.md)
- [Hands on 4 - Difference between JPA, Hibernate and Spring Data JPA Java Persistence API (JPA)](./handson-4/README.md)
- [Hands on 5 - Implement services for managing Country An application requires for features to be implemented with regards to country. These features needs to be supported by implementing them as service using Spring Data JPA.](./handson-5/README.md)
- [Hands on 6 - Find a country based on country code  ](./handson-6/README.md)
- [Hands on 7 - Add a new country  ](./handson-7/README.md)
- [Hands on 8 - Update a country based on code  ](./handson-8/README.md)
- [Hands on 9 - Delete a country based on code  ](./handson-9/README.md)
