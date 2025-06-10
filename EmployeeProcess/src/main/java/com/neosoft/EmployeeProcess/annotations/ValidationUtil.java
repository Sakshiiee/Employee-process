package com.neosoft.EmployeeProcess.annotations;

import org.apache.commons.lang3.StringUtils;

public class ValidationUtil {
    public static boolean isBlank(final CharSequence cs) {
        return StringUtils.isBlank(cs);
    }
    public static boolean isValidContactNumber(String value) {
        return value != null && value.matches("\\d{10}");
    }


}





































//    public static boolean isValidContactNumber(String value) {
//        return value != null && value.matches("\\d{10}");
//    }