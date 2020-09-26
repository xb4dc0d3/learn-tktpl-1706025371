package id.ac.ui.cs.mobileprogramming.nux.helloworld.Utils;

import java.util.Random;

public class ChangeTextUtils {

    public String generateText(){
        String[] randomText = {"Aloha World",
                            "Have A Good Day",
                            "Keep Smile",
                            "Ciao Mondo",
                            "Bonjour le monde"};
        Random rand = new Random();
        return  randomText[rand.nextInt(randomText.length)];
    }
}
