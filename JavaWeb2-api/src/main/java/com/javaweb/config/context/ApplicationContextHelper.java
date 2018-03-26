package com.javaweb.config.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextHelper implements ApplicationContextAware { 
	
    private static ApplicationContext ac;    

    public void setApplicationContext( ApplicationContext applicationContext ) throws BeansException {    
    	ac = applicationContext;    
    }  
        
    public static ApplicationContext getApplicationContext(){  
        return ac;  
    }  
   
    public static Object getBean(String beanName) {    
        return ac.getBean(beanName);    
    }  
    
}   