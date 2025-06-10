package com.neosoft.EmployeeProcess.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NullOrNotBlankValidator implements ConstraintValidator<NullOrNotBlank, String> {
    private int min;
    private int max;
    private String isMandatory;
    private String isEmail;
    private String isContactNumber;


    @Override
    public void initialize(NullOrNotBlank parameters) {
        min = parameters.min();
        max = parameters.max();
        isMandatory = parameters.isMandatory();
        isEmail=parameters.isEmail();
        isContactNumber = parameters.isContactNumber();

    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (ValidationUtil.isBlank(value)) {
            return !isMandatory.equals("yes");
        }
        if (isEmail.equals("yes") && !EmailValidator.isValidEmail(value)) {
            return false;
        }
        if (isContactNumber.equals("yes") && !ValidationUtil.isValidContactNumber(value)) {
            return false;
        }

        if (min == 0 & max == 0)
            return true;

        int length = value.length();
        return length >= min && length <= max;
    }

}






//private String isContactNumber;
//isContactNumber = parameters.isContactNumber();
//        if (isContactNumber.equals("yes") && !ValidationUtil.isValidContactNumber(value)) {
//            return false;
//        }
