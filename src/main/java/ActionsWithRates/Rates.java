package ActionsWithRates;

import ActionsWithRates.Calculator;
import ActionsWithRates.Model;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Rates {

    public static String getRates(int date) throws IOException {
        URL url = new URL("https://belarusbank.by/api/kurs_cards");
        Scanner scanner = new Scanner((InputStream) url.getContent());
        String rateInfo = "";
        while (scanner.hasNext()) {
            rateInfo += scanner.nextLine();
        }
        Model currentRate = getModel(rateInfo,date);
        Model prevRate = getModel(rateInfo,date+3);
        return "Курсы валют по состоянию на: " + currentRate.getTime() +
                "\nUSD in " + Calculator.calculate_difference(currentRate.getUSD_IN(),prevRate.getUSD_IN()) +
                "\nUSD out " + Calculator.calculate_difference(currentRate.getUSD_OUT(),prevRate.getUSD_OUT()) +
                "\nEUR in " + Calculator.calculate_difference(currentRate.getEUR_IN(),prevRate.getEUR_IN()) +
                "\nEUR out " + Calculator.calculate_difference(currentRate.getUSD_OUT(),prevRate.getUSD_OUT());

    }

    private static Model getModel(String rateInfo,int date) {
        Model rate = new Model();
        JSONArray updatesArray = new JSONArray(rateInfo);
        JSONObject lastUpdate = updatesArray.getJSONObject(date);
        rate.setTime(lastUpdate.getString("kurs_date_time"));
        rate.setUSD_IN(lastUpdate.getFloat("USDCARD_in"));
        rate.setUSD_OUT(lastUpdate.getFloat("USDCARD_out"));
        rate.setEUR_IN(lastUpdate.getFloat("EURCARD_in"));
        rate.setEUR_OUT(lastUpdate.getFloat("EURCARD_out"));
        return rate;
    }


}
