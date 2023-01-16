package com.example.demo.validation.validator;

import com.example.demo.payload.request.RegisterRequest;
import com.example.demo.validation.constraint.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        RegisterRequest user = (RegisterRequest) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
