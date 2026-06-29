# Hands-on 1: Introduction to HQL and JPQL

### 1. JPQL (Java Persistence Query Language)
*   A query language defined by the JPA specification.
*   Deals with Java objects and properties rather than relational database tables and columns.
*   Independent of the database type.

### 2. HQL (Hibernate Query Language)
*   A powerful object-oriented query language specific to Hibernate.
*   JPQL is a strict subset of HQL. Every JPQL query is a valid HQL query, but the reverse is not true.
*   Unlike JPQL, HQL supports `INSERT INTO ... SELECT` statements.
