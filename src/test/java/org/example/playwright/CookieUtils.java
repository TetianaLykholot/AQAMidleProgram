package org.example.playwright;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.Cookie;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CookieUtils {

    public static void saveCookies(Page page, String fileName) {
        List<Cookie> cookies = page.context().cookies();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(new Gson().toJson(cookies));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadCookies(Page page, String fileName) {
        try (FileReader fileReader = new FileReader(fileName)) {
            List<Cookie> cookies = new Gson().fromJson(fileReader, new TypeToken<List<Cookie>>() {
            }.getType());
            page.context().addCookies(cookies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}