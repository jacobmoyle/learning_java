package com.candidate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {
    private static java.lang.String miscPattern() { return "\\sat\\s"; }
    private static String importPattern() { return "imported"; }
    private static String importText() { return "\\simported"; }
    private static String countPattern() { return "^\\d+"; }
    private static String costPattern() { return "[0-9]{1,}+\\.[0-9]{2,}"; }

    public static String itemName(String input) {
        String result = input
                .replaceAll(costPattern(), "")
                .replaceAll(importText(), "")
                .replaceAll(countPattern(), "")
                .replaceAll(miscPattern(), "")
                .trim();

        return result;
    }
    public static String itemImported(String input) {
        return String.valueOf(input.contains(importPattern()));
    }
    public static String itemCount(String input) {
        return findPattern(countPattern(), input);
    }
    public static String itemBaseCost(String input) {
        return findPattern(costPattern(), input);
    }
    public static String[] getItemRows(String input) {
        return input.split("\\r?\\n");
    }
    public static String findPattern(String regex, String input) {
        Pattern regexPattern = Pattern.compile(regex);
        Matcher matcher = regexPattern.matcher(input);

        while (matcher.find()) {
            if(matcher.group().length() != 0) { return matcher.group().trim(); }
        }
        return "";
    }

}
