package com.strings;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class RansomMagazineNote {
    public static void main(String[] args) {
        String[] magazine = {"give", "me", "one", "grand", "today", "night"};
        String[] note = {"give", "one", "grand", "one", "today"};

        checkMagazine(magazine, note);
    }

    static void checkMagazine(String[] magazineWords, String[] notes) {

        Map<String, Long> magazine = Arrays.stream(magazineWords)
                .collect(Collectors.groupingBy(f -> f, Collectors.counting()));

        String exists = "No";
        for(String note : notes) {
            if (Objects.isNull(magazine.get(note))) {
                exists = "No";
                break;
            } else {
                exists = "Yes";
                magazine.remove(note);
            }
        }

        System.out.println(exists);

    }
}
