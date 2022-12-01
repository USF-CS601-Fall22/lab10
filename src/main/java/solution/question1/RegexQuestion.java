package solution.question1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexQuestion {

    /**
     * Write a function that takes an html file that contains information
     * about books in paragraph tags (such as input/books.html) and prints
     * information about each book to the console.
     * You are required to use regex groups (use Pattern and Matcher) for this problem.
     * Your code must be general.
     * @param filename
     */
    public static void extractBookInfo(String filename) {
        Pattern p = Pattern.compile("<p>([^<]*?)</p>");

        // Alternative solution:
        // Pattern p = Pattern.compile("<p>(.*?)</p>", Pattern.DOTALL);
        // DOTALL means . matches any character including a newline character

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            // concatenate all lines together (separted by the newline character)
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }

            // Repeatedly apply the pattern
            Matcher m = p.matcher(sb.toString());
            while (m.find())
                System.out.println(m.group(1));
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        RegexQuestion.extractBookInfo("input/books.html");
    }
}
