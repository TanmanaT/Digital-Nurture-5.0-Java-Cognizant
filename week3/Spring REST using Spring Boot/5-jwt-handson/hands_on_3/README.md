# Hands-On 3: Create Authentication Controller

## Objectives
* Setup `/authenticate` endpoint that accepts authorization header details.

## Steps
1. Create `com.cognizant.springlearn.controller.AuthenticationController`:
   ```java
   @RestController
   public class AuthenticationController {
       @GetMapping("/authenticate")
       public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
           Map<String, String> map = new HashMap<>();
           map.put("token", "");
           return map;
       }
   }
   ```
2. Configure security to allow access to `/authenticate` for both `USER` and `ADMIN` roles.
3. Test with basic credentials and verify authorization format returned.
