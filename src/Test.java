import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
    private static HttpURLConnection con;

    public static void main(String[] args) throws IOException {
        var url = "https://api.telegram.org/bot1026183017:AAGCW0XLPWU8MgVNoq2ORB-SE6i2-trQ0gY/sendMessage?chat_id=543560094&text=salom";

        try {

            var myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            con.getInputStream();

        } finally {

            con.disconnect();
        }
    }
}
