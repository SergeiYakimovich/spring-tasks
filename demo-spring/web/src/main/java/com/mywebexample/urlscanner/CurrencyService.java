package com.mywebexample.urlscanner;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Scanner;

@Component
public class CurrencyService {
    public void getCurrencyRate(String currency) {
        try {
            URL url = new URL("https://www.nbrb.by/api/exrates/rates/" + currency + "?parammode=2");
            Scanner scanner = new Scanner((InputStream) url.getContent());
            String result = "";
            while (scanner.hasNext()){
                result +=scanner.nextLine();
            }

            JSONObject object = new JSONObject(result);
            CurrencyModel model = new CurrencyModel();
            model.setCur_ID(object.getInt("Cur_ID"));
            model.setDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(object.getString("Date")));
            model.setCur_Abbreviation(object.getString("Cur_Abbreviation"));
            model.setCur_Scale(object.getInt("Cur_Scale"));
            model.setCur_Name(object.getString("Cur_Name"));
            model.setCur_OfficialRate(object.getDouble("Cur_OfficialRate"));

            System.out.println("Official rate of BYN to " + model.getCur_Abbreviation() + "\n" +
                    "on the date: " + getFormatDate(model) + "\n" +
                    "is: " + model.getCur_OfficialRate() + " BYN per " + model.getCur_Scale() + " " + model.getCur_Abbreviation());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String getFormatDate(CurrencyModel model) {
        return new SimpleDateFormat("dd MMM yyyy").format(model.getDate());
    }
}
