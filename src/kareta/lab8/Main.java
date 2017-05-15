package kareta.lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vitya on 26.04.17.
 */
public class Main {

    public static final String PATTERN = "[0-9]+\\*E[0-9]+";

    public static void main(String[] args) {
        System.out.println("Path?");
        String path = new Scanner(System.in).next();
        File file = new File(path);

        String content = null;
        try {
            content = new Scanner(file).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            return;
        }

        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(content);

        System.out.println("Found: ");
        while (matcher.find()) {
            String found = matcher.group();
            System.out.println(found);
        }
    }
}
