import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    String text = "The price is $100";
    String regex = "\\d+";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    while(matcher.find())
    {
        System.out.println("Found number: " + matcher.group());
    }
}
