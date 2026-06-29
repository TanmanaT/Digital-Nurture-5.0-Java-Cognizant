# Hands-on 3: Hibernate Annotation Configuration Walkthrough

Replaces XML mapping descriptors with annotations directly on the Java bean classes.

### 1. JPA & Hibernate Annotations
*   `@Entity`: Specifies that the class is mapped to a database table.
*   `@Table`: Defines the mapping table name (e.g. `@Table(name="EMPLOYEE")`).
*   `@Id`: Specifies the primary key of the entity.
*   `@GeneratedValue`: Defines key generation strategies (e.g. `GenerationType.IDENTITY`).
*   `@Column`: Customizes database column properties (e.g. `@Column(name="salary")`).

### 2. Configuration Properties
Configured in `hibernate.cfg.xml` or `application.properties`:
*   `Dialect`: Translates HQL/JPQL queries to vendor-specific database SQL (e.g. `org.hibernate.dialect.MySQL8Dialect`).
*   `Driver`: Database driver class name (e.g. `com.mysql.cj.jdbc.Driver`).
*   `Connection URL`: Database location descriptor (e.g. `jdbc:mysql://localhost:3306/ormlearn`).
*   `Username / Password`: Authentication credentials.
