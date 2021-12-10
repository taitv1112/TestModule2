package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static Pattern pattern;
    private static Matcher matcher;
    public static final String GENDER = "nam|nu|NAM|NU$";
    public static final String NUMBER = "^\\d+$";
    public static final String PHONE = "^(84|0[3|5|7|8|9])+([0-9]{8})\\b$";
    public static final String NAME = "^\\pL+[\\pL\\pZ\\pP]{0,}$";
    public static final String DATE="^([0-2][0-9]||3[0-1])/(0[1-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
    public static final String EMAIL="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    static Scanner sc = new Scanner(System.in);

    public static boolean validateAll(String value, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static String validate(String guide, String guideError, String regex) {
        while (true) {
            System.out.println(guide);
            ;
            String value = sc.nextLine();
            if (validateAll(value, regex)) {
                return value;
            } else {
                System.err.println(guideError);
            }
        }
    }

    public static String validateNotNull(String guide, String guideError) {
        while (true) {
            System.out.println(guide);
            String value = sc.nextLine();
            if (!value.trim().equals("")) {
                return value;
            } else {
                System.err.println(guideError);
            }
        }
    }


}
