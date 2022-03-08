package org.example.spring_azure_app.router;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TestRunNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TestRunNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String testRunNotFoundHandler(TestRunNotFoundException ex) {
        return ex.getMessage();
    }
}
