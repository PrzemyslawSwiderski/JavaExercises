package com.pswiderski;

import java.util.ArrayList;
import java.util.List;

public class PermGenerator {

    public List<String> generate(String inputStr) {
        List<String> results = new ArrayList<>();
        perm("", inputStr, results);
        return results;
    }

    private void perm(String inputString, String rest, List<String> results) {
        if (rest.length() <= 1) {
            results.add(inputString + rest);
            return;
        }

        for (int i = 0; i < rest.length(); i++) {
            String processed = swapLetters(rest, 0, i);
            perm(inputString + processed.charAt(0), processed.substring(1), results);
        }

    }

    private String swapLetters(String inputStr, int i, int j) {

        char[] c = inputStr.toCharArray();

        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return new String(c);
    }

}
