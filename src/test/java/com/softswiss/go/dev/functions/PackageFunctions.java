package com.softswiss.go.dev.functions;

import static framework.RegexMatcher.regexGetMatch;
import static framework.RegexMatcher.regexGetMatchGroup;

public class PackageFunctions {
    private static final String VERSION_REGEX = "Version:\\s*(.*?)\\s*\\|";
    private static final String PUBLISHED_REGEX = "Published:\\s*(.*?)\\s*\\|";
    private static final String MODULE_REGEX = "(?<=Module:).*";

    private PackageFunctions() {
    }

    public static String getVersionFromInfo(String source) {
        return regexGetMatchGroup(source, VERSION_REGEX, 1);
    }

    public static String getPublishedFromInfo(String source) {
        return regexGetMatchGroup(source, PUBLISHED_REGEX, 1);
    }

    public static String getModuleFromInfo(String source) {
        return regexGetMatch(source, MODULE_REGEX).trim();
    }
}