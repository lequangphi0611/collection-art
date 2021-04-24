package com.collectionart.app.collectionart.utils;

public class StringUtils {

    public static String applyPrefix(CharSequence prefix, CharSequence target) {
        return new StringBuilder(prefix).append(target).toString();
    }

}
