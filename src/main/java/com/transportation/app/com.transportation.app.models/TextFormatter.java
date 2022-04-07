package com.transportation.app.com.transportation.app.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFormatter {
    public static boolean CheckPatternCode(String inputText){
        String regex = "[A-Z0-9_]+";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the username is empty
        // return false
        if ( inputText == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given username
        // and regular expression.
        Matcher m = p.matcher( inputText);

        // Return if the username
        // matched the ReGex
        return m.matches();

    }
    public static boolean CheckNamePattern(String inputText){
        String regex = "[a-zA-Z0-9_\\-]*";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the username is empty
        // return false
        if ( inputText == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given username
        // and regular expression.
        Matcher m = p.matcher( inputText);

        // Return if the username
        // matched the ReGex
        return m.matches();

    }
}
