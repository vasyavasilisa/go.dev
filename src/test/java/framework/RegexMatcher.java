package framework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher {
    private RegexMatcher() {
    }

    public static String regexGetMatch(String text, String regex) {
        return regexGetMatchGroup(text, regex, 0);
    }

    public static String regexGetMatchGroup(String text, String regex, int groupIndex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        return m.find() ? m.group(groupIndex) : null;
    }
}