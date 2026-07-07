# Hands-On 6: Load List of Countries from Spring XML

## Objectives
* Demonstrate injection of collection types (`<list>`, `<ref>`) in Spring Configuration

## Steps
1. Update `country.xml` to define multiple countries and a list collection containing references to those countries:
   ```xml
   <bean id="in" class="com.cognizant.springlearn.Country">
       <property name="code" value="IN" />
       <property name="name" value="India" />
   </bean>

   <bean id="us" class="com.cognizant.springlearn.Country">
       <property name="code" value="US" />
       <property name="name" value="United States" />
   </bean>

   <bean id="de" class="com.cognizant.springlearn.Country">
       <property name="code" value="DE" />
       <property name="name" value="Germany" />
   </bean>

   <bean id="jp" class="com.cognizant.springlearn.Country">
       <property name="code" value="JP" />
       <property name="name" value="Japan" />
   </bean>

   <bean id="countryList" class="java.util.ArrayList">
       <constructor-arg>
           <list>
               <ref bean="in" />
               <ref bean="us" />
               <ref bean="de" />
               <ref bean="jp" />
           </list>
       </constructor-arg>
   </bean>
   ```
2. Implement `displayCountries()` in `SpringLearnApplication.java` to fetch `countryList` and print it using debug logging.
