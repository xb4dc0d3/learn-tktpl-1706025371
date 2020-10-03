package id.ac.ui.cs.mobileprogramming.nux.helloworld;

import android.util.Log;
import java.io.BufferedReader;
import java.net.HttpURLConnection;

public class NetworkUtils {

    private static final String TWITTER_URL = "https://www.instagram.com/";
    private static final String FACEBOOK_URL = "https://www.facebook.com/";
    private static final String INSTAGRAM_URL = "https://www.twitter.com/";

    private String getTwitterUsername(String username) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String result = null;
        return "Not Implemented Twitter\n";
    }

    private String getFacebookUsername(String username) {

        return "Not Implemented Facebook\n";
    }

    private String getInstagramUsername(String username) {

        return "Not implement instagram\n";
    }

    public static String getUsername(String queryUsername) {
        NetworkUtils net = new NetworkUtils();
        String resultFacebook = net.getFacebookUsername(queryUsername);
        String resultInstagram = net.getInstagramUsername(queryUsername);
        String resultTwitter = net.getTwitterUsername(queryUsername);

        Log.d("Result Twitter", resultTwitter);
        return resultFacebook + " " + resultInstagram +" "+resultTwitter;
    }
}
