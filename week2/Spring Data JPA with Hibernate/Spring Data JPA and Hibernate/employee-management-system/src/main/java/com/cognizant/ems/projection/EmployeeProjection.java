package com.cognizant.ems.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {
    String getName();
    String getEmail();
    
    // Dynamic value expression
    @Value("#{target.name + ' - ' + target.email}")
    String getContactDetails();
}
