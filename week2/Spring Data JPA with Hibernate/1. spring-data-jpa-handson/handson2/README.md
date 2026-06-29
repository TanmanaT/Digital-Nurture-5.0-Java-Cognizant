# Hands-on 2: Hibernate XML Configuration Walkthrough

This walkthrough outlines how object-to-relational mapping is handled in Hibernate using XML configuration files.

### 1. Mapping XML (e.g., `Employee.hbm.xml`)
Defines the mapping between Java objects and database columns:
```xml
<hibernate-mapping>
   <class name="Employee" table="EMPLOYEE">
      <meta attribute="class-description">This class contains the employee detail.</meta>
      <id name="id" type="int" column="id">
         <generator class="native"/>
      </id>
      <property name="firstName" column="first_name" type="string"/>
      <property name="lastName" column="last_name" type="string"/>
      <property name="salary" column="salary" type="int"/>
   </class>
</hibernate-mapping>
```

### 2. Configuration XML (`hibernate.cfg.xml`)
Sets database driver, credentials, dialects, and specifies mapping resources:
```xml
<hibernate-configuration>
   <session-factory>
      <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
      <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
      <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/ormlearn</property>
      <property name="hibernate.connection.username">root</property>
      <property name="hibernate.connection.password">root</property>
      <mapping resource="Employee.hbm.xml"/>
   </session-factory>
</hibernate-configuration>
```

### 3. Core API Objects & Methods:
*   **SessionFactory**: Heavyweight thread-safe object used to create database sessions.
*   **Session**: Represents a physical database connection. Used for save, get, update, and delete.
*   **Transaction**: Manages transaction boundary:
    *   `beginTransaction()`: Starts a new transaction.
    *   `commit()`: Commits changes.
    *   `rollback()`: Reverts changes on exception.
*   **Operations**:
    *   `session.save(entity)`: Inserts a new record.
    *   `session.get(Class, id)`: Fetches record by primary key.
    *   `session.delete(entity)`: Deletes the record.
