package com.client.management.util;

public abstract class IdNumberValidator {

    public static boolean isSouthAfrican(String idNumber) {

        if (isValidLength(idNumber)) {

            char character = idNumber.charAt(10);
            return character == '0' ? true : false;

        }

        return false;

    }

    private static boolean isValidLength(String idNumber) {
        return idNumber.length() == 13 ? true : false;
    }
}
