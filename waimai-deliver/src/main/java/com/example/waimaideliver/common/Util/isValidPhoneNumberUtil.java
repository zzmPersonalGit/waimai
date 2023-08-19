package com.example.waimaideliver.common.Util;

import java.util.regex.Pattern;

public class isValidPhoneNumberUtil {

    private isValidPhoneNumberUtil(){}

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if ((phoneNumber != null) && (!phoneNumber.isEmpty())) {
            return Pattern.matches("^1[3-9]\\d{9}$", phoneNumber);
        }
        return false;
    }

}
