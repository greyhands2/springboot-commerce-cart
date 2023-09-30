package com.starq.commercecart.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
   private static final long serialVersionUID = 1L;
   private String resourceName;
   private String fieldName;
   private Object fieldValue;
   
   public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue){
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
        this.fieldName = fieldName;
        this.resourceName = resourceName;
        this.fieldValue = fieldValue;
   } 
   

   public String getResourceName(){
    return this.resourceName;
   }

   public String getFieldName(){
    return this.fieldName;
   }

   public Object getFieldValue(){
    return this.fieldValue;
   }
}
