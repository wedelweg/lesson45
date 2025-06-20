package validator.utils;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class PasswordValidator {

    private static final List<Predicate<String>> RULES = List.of(
            Pattern.compile(".*[A-Z].*").asPredicate(),
            Pattern.compile(".*[a-z].*").asPredicate(),
            Pattern.compile(".*[0-9].*").asPredicate(),
            Pattern.compile(".*[!?@#].*").asPredicate(),
            Pattern.compile("^[a-zA-Z0-9!?@#]+$").asPredicate()
    );

    public static boolean isStrong(String password) {
        //if (password == null) return false
        return password !=null
                && password.length() >= 8
                && RULES.stream().allMatch((rule -> rule.test(password)));
        //return RULES.stream().allMatch(rule -> rule.test(password));
    }
}