# Part 2: Query Methods and Entity Relationships

Objectives 
Demonstrate implementation of Query Methods feature of Spring Data JPA
Query Methods - Search by containing text, sorting, filter with starting text, fetch between dates, greater than or lesser than, top
Query methods - https://docs.spring.io/spring-data/jpa/docs/2.2.0.RELEASE/reference/html/#jpa.query-methods.query-creation 
Demonstrate implementation of O/R Mapping
```java
@ManyToOne, @JoinColumn, @OneToMany, FetchType.EAGER, FetchType.LAZY, @ManyToMany, @JoinTable, mappedBy
```
Relationships reference - https://www.baeldung.com/spring-data-rest-relationships

## Exercises Included:
- [Hands on 1 - Write queries on country table using Query Methods Following are the list of queries that is required for an application. Implement these queries using Query Methods feature of Spring Data JPA. Click here for reference. Include appropriate methods in OrmLearnApplication and test the same.  ](./handson-1/README.md)
- [Hands on 2 - Write queries on stock table using Query Methods With one year stock data of Facebook, Google and Netflix, we need to implement Spring Data JPA Query Methods for the following scenarios:Sample DataSample data for implementing this hands on is provided to you in the platform](./handson-2/README.md)
- [Hands on 3 - Create payroll tables and bean mapping To demonstrate one to many, many to one and many to many relationships in Hibernate, a schema with entities employee, department and skill will be used. In this hands on we will setup the tables and data, which forms the basis for learning the mappings in Hibernate.Schema StructureFollow steps below to create necessary tables:](./handson-3/README.md)
- [Hands on 4 - Implement many to one relationship between Employee and Department Follow steps below to defined many to one relationship and perform persistence operations:Preparation of Service Classes](./handson-4/README.md)
- [Hands on 5 - Implement one to many relationship between Employee and Department Department.java](./handson-5/README.md)
- [Hands on 6 - Implement many to many relationship between Employee and Skill Many to Many mapping defintion ](./handson-6/README.md)
