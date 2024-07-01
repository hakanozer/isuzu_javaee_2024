
package com.works.configs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity notValidException( MethodArgumentNotValidException ex ) {
        return new ResponseEntity(parseError(ex.getFieldErrors()), HttpStatus.BAD_REQUEST);
    }
    
    
    private List parseError( List<FieldError> errors ) {
        List list = new ArrayList();
        for( FieldError item: errors ) {
            String field = item.getField();
            String defaultMessage = item.getDefaultMessage();
            Object rejectedValue = item.getRejectedValue();
            Map<String, Object> hm = new LinkedHashMap<>();
            hm.put("field", field);
            hm.put("defaultMessage", defaultMessage);
            hm.put("rejectedValue", rejectedValue);
            list.add(hm);
        }
        return list;
    }
    
    
}
