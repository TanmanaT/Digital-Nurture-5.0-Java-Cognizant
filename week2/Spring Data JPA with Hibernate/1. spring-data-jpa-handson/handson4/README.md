# Hands-on 4: Differences between JPA, Hibernate, and Spring Data JPA

| Aspect | Java Persistence API (JPA) | Hibernate | Spring Data JPA |
|---|---|---|---|
| **Type** | Specification (JSR 338) | ORM Tool / JPA Provider | Abstraction Layer / Framework |
| **Boilerplate** | Medium | High (requires manual transaction & session management) | Low (auto-generates standard CRUD queries) |
| **Key APIs** | `EntityManager`, `EntityTransaction` | `SessionFactory`, `Session`, `Transaction` | `JpaRepository`, `CrudRepository` |

### Code Comparison

#### Hibernate Code:
```java
public Integer addEmployee(Employee employee){
   Session session = factory.openSession();
   Transaction tx = null;
   Integer employeeID = null;
   try {
      tx = session.beginTransaction();
      employeeID = (Integer) session.save(employee); 
      tx.commit();
   } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace(); 
   } finally {
      session.close(); 
   }
   return employeeID;
}
```

#### Spring Data JPA Code:
```java
// Interface
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}

// Service
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
```
