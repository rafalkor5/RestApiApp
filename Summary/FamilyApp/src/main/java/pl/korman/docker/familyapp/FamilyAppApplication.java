package pl.korman.docker.familyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.io.IOException;

@SpringBootApplication
public class FamilyAppApplication {

    @Bean
    Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    public static void main(String[] args) {
        SpringApplication.run(FamilyAppApplication.class, args);
    }

    @ControllerAdvice
    public static class CustomErrorHandler {

        @ExceptionHandler(ConstraintViolationException.class)
        public void handleConstraintViolationException(ConstraintViolationException exception,
                                                       ServletWebRequest webRequest) throws IOException {
            webRequest.getResponse().sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        }
    }
}

