package net.bounceme.noagenda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;
import org.json.JSONObject;

public class NoAgenda {  //json.org

    private final List<JSONObject> jsons = new ArrayList<>();

    public static void main(String[] args) throws MalformedURLException, IOException {
        List<URL> urls = new ArrayList<>();
        new NoAgenda().iterateURLs(urls);
    }

    private void printJsons() {
        for (JSONObject json : jsons) {
            out.println(json);
        }
    }

    private void iterateURLs(List<URL> urls) throws MalformedURLException, IOException {
    //    urls.add(new URL("https://www.flickr.com/photos/"));
        urls.add(new URL("http://www.javascriptkit.com/dhtmltutors/javascriptkit.json"));
        urls.add(new URL("http://api.wunderground.com/api/54f05b23fd8fd4b0/geolookup/conditions/forecast/q/US/CO/Denver.json"));
        for (URL url : urls) {
            connect(url);
        }
        printJsons();
    }

    private void connect(URL url) throws IOException {
        out.println(url);
        String line = null;
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));
        while ((line = in.readLine()) != null) {
            sb.append(line + "\n");
        }
        in.close();
        //out.println(sb);
        JSONObject json = new JSONObject(sb.toString());
        jsons.add(json);
    }
}
