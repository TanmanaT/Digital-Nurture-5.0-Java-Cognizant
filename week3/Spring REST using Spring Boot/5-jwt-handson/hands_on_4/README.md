# Hands-On 4: Read and Decode Authorization Header

## Objectives
* Parse "Basic " encoded credentials using Java 8 Base64 decoder.

## Steps
1. Add a helper method in `AuthenticationController`:
   ```java
   private String getUser(String authHeader) {
       String encodedCredentials = authHeader.substring(6);
       byte[] decoded = Base64.getDecoder().decode(encodedCredentials);
       String credentials = new String(decoded);
       return credentials.split(":")[0]; // return username
   }
   ```
2. Retrieve the username during `/authenticate` call and verify in logs.
