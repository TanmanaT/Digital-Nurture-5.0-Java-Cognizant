# Hands-On 5: Global Exception Handler

## Objectives
* Intercept validation exceptions using a central `@ControllerAdvice` handler class.

## Steps
1. Create `com.cognizant.springlearn.GlobalExceptionHandler` extending `ResponseEntityExceptionHandler`:
   ```java
   @ControllerAdvice
   public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
       private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

       @Override
       protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
               HttpHeaders headers, HttpStatus status, WebRequest request) {
           Map<String, Object> body = new LinkedHashMap<>();
           body.put("timestamp", new Date());
           body.put("status", status.value());
           
           List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                   .map(DefaultMessageSourceResolvable::getDefaultMessage)
                   .collect(Collectors.toList());
           body.put("errors", errors);
           return new ResponseEntity<>(body, headers, status);
       }
   }
   ```
2. Replace manual validator lookup in `CountryController` with `@Valid` annotation:
   ```java
   public Country addCountry(@RequestBody @Valid Country country)
   ```
