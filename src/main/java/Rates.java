import com.google.inject.internal.asm.$ClassVisitor;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Rates {

    public static String getRates() throws IOException {
        URL url = new URL("https://belarusbank.by/api/kurs_cards");
        Scanner scanner = new Scanner((InputStream) url.getContent());
        String result = "";
        while (scanner.hasNext()) {
            result += scanner.nextLine();
        }
        Model model = new Model();
        JSONArray updatesArray = new JSONArray(result);
        JSONObject lastUpdate = updatesArray.getJSONObject(0);
        model.setTime(lastUpdate.getString("kurs_date_time"));
        model.setUSD_IN(lastUpdate.getFloat("USDCARD_in"));
        model.setUSD_OUT(lastUpdate.getFloat("USDCARD_out"));
        model.setEUR_IN(lastUpdate.getFloat("EURCARD_in"));
        model.setEUR_OUT(lastUpdate.getFloat("EURCARD_out"));
        return "Last update " + model.getTime() +
                "\nUSD in " + model.getUSD_IN() +
                "\nUSD out " + model.getUSD_OUT() +
                "\nEUR in " + model.getEUR_IN() +
                "\nEUR out " + model.getEUR_OUT();

    }

}
