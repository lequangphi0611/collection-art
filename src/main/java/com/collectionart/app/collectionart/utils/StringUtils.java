package com.collectionart.app.collectionart.utils;

import com.collectionart.app.collectionart.operation.Operator;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private static final String NULL_STR = "null";

    public static String applyPrefix(CharSequence prefix, CharSequence target) {
        return String.valueOf(prefix) + target;
    }

    public static <T> List<T> findMatch(CharSequence charSequence, Matcher matcher, Operator<String, T> operator) {
        List<T> result = new ArrayList<>();
        while (matcher.find()) {
            String found = charSequence.subSequence(matcher.start(), matcher.end()).toString();
            result.add(operator.apply(found));
        }
        return result;
    }

    public static String toString(@Nullable Object obs) {
        if (obs == null) {
            return NULL_STR;
        }

        if(obs instanceof String) {
            return (String) obs;
        }

        return obs.toString();
    }

}
