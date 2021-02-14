package id.ac.ui.cs.mobileprogramming.nux.helloworld;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {

    private static final String BOOK_URL =
            "https://raw.githubusercontent.com/benoitvallon/100-best-books/master/books.json";

    public static String getBookName(String bookName) {

        URL url = null;
        BufferedReader reader = null;
        HttpURLConnection httpURLConnection = null;
        String result = null;

        try {
            url = new URL(BOOK_URL);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            // Get the InputStream.
            InputStream inputStream = httpURLConnection.getInputStream();

            // Create a buffered reader from that input stream.
            reader = new BufferedReader(new InputStreamReader(inputStream));
            result = reader.toString();

            // String Builder reserve result
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                builder.append(line);
                builder.append("\n");

                // if book contains the title found
                if (line.contains("title") && line.contains(bookName)) {
                    result = line.toLowerCase().replace(",","");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
