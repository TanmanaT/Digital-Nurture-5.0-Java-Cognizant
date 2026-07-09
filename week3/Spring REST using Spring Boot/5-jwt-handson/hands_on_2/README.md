# Hands-On 2: Users, Roles, and Role-Based Authorization

## Objectives
* Set up in-memory users with role permissions (`ADMIN`, `USER`).

## Steps
1. Configure AuthenticationManagerBuilder and BCryptPasswordEncoder in `SecurityConfig`:
   ```java
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication()
           .withUser("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN")
           .and()
           .withUser("user").password(passwordEncoder().encode("pwd")).roles("USER");
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }
   ```
2. Restrict endpoints based on role:
   ```java
   @Override
   protected void configure(HttpSecurity httpSecurity) throws Exception {
       httpSecurity.csrf().disable().httpBasic().and()
           .authorizeRequests().antMatchers("/countries").hasRole("USER");
   }
   ```
3. Test using user/pwd (role USER - status 200) and admin/pwd (role ADMIN - status 403).
