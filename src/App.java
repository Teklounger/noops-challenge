import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import java.net.Proxy;

import org.json.JSONArray;
import org.json.JSONObject;

public class App {
    public static void main(String[] args) {
        try {
            App.call_me();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void call_me() throws Exception {
        String url = "http://api.noopschallenge.com/hexbot";
        URL obj = new URL(url);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("3.193.18.80", 80));
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection(proxy);
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = connection.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        JSONObject hexbotresponse = new JSONObject(response.toString());
        JSONArray colorarray = hexbotresponse.getJSONArray("colors");
        JSONObject color = colorarray.getJSONObject(0);
        System.out.println("result after Reading JSON Response");
        System.out.println(color.getString("value"));
    }

}
