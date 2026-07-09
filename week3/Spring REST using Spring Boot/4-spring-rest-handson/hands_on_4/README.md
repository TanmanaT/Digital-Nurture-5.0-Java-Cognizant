# Hands-On 4: Validating Request Fields

## Objectives
* Implement field-level constraint validations in the domain model.

## Steps
1. Add validation annotations to the `code` field in `Country.java`:
   ```java
   @NotNull
   @Size(min=2, max=2, message="Country code should be 2 characters")
   private String code;
   ```
2. Implement validation manually inside `CountryController.addCountry()` using `ValidatorFactory`:
   ```java
   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
   Validator validator = factory.getValidator();
   Set<ConstraintViolation<Country>> violations = validator.validate(country);
   if (!violations.isEmpty()) {
       throw new ResponseStatusException(HttpStatus.BAD_REQUEST, violations.toString());
   }
   ```
