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

        private static final String COOKIE_FILE_PATH = System.getProperty("user.home") + "/cookies.json";

    public static void saveCookies(Page page) {
        List<Cookie> cookies = page.context().cookies();
        try (FileWriter fileWriter = new FileWriter(COOKIE_FILE_PATH)) {
            fileWriter.write(new Gson().toJson(cookies));
            System.out.println("Cookies saved to: " + COOKIE_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Failed to save cookies: " + e.getMessage());
        }
    }

    public static void loadCookies(Page page) {
        try (FileReader fileReader = new FileReader(COOKIE_FILE_PATH)) {
            List<Cookie> cookies = new Gson().fromJson(fileReader, new TypeToken<List<Cookie>>() {}.getType());
            page.context().addCookies(cookies);
            System.out.println("Cookies loaded from: " + COOKIE_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Failed to load cookies: " + e.getMessage());
        }
    }

        public static String getCookieFilePath() {
            return COOKIE_FILE_PATH;
        }
    }