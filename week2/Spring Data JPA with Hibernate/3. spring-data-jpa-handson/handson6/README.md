# Hands-on 6: Criteria Query

Criteria Queries provide a programmatic, type-safe approach to dynamically assemble query restrictions (`WHERE` clauses). This is particularly useful in multi-attribute search forms (e.g. retail sites like Amazon).

### Key Components of Criteria API:
*   **CriteriaBuilder**: Used to construct search criteria, conditions, ordering, etc.
*   **CriteriaQuery**: The query object itself, defining select targets and groupings.
*   **Root**: Represents the entity schema (e.g., the `FROM` clause).
*   **Predicates**: Individual logical conditions (e.g., `equal`, `like`, `greaterThan`).

### Code Example:
```java
EntityManager em = getEntityManager();
CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Product> cq = cb.createQuery(Product.class);
Root<Product> root = cq.from(Product.class);

List<Predicate> predicates = new ArrayList<>();

if (searchKeyword != null) {
    predicates.add(cb.like(root.get("name"), "%" + searchKeyword + "%"));
}
if (minPrice != null) {
    predicates.add(cb.greaterThanOrEqualTo(root.get("price"), minPrice));
}

cq.select(root).where(cb.and(predicates.toArray(new Predicate[0])));
TypedQuery<Product> query = em.createQuery(cq);
List<Product> results = query.getResultList();
```
