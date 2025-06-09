package com.neosoft.EmployeeProcess.annotations;

import org.apache.commons.lang3.StringUtils;

public class ValidationUtil {
    public static boolean isBlank(final CharSequence cs) {
        return StringUtils.isBlank(cs);
    }
}
