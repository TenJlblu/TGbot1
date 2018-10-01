package my_bot;

import java.util.*;

public class Resource{

    public final HashMap<String, ArrayList<String>> Variants =  new HashMap<String, ArrayList<String>>();;

    public void Fill(){
        ArrayList<String> helpVariants = new ArrayList<String>();
        helpVariants.addAll(Arrays.asList("help", "start", "help me", "let's start", "hi", "hello", "let's go", "go"));
        String helpString = "Hi, What do you want? I am busy, but I think, I can find one minute for you\n" +
                "If you want know? what date is it? write \"/date\"\n";
        this.Variants.put(helpString, helpVariants);
    }
}
