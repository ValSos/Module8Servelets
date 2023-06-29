package org.example;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.TimeZone;

public class Main {

    public static boolean isValidTimezone(String timezone) {
        try {
            ZoneId.of(timezone);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void test(String timezone) {

        if (timezone.contains("+")){
            timezone = timezone.replace("+", URLEncoder.encode("+", StandardCharsets.UTF_8));
        } else {
            timezone = timezone.replace("-", URLEncoder.encode("-", StandardCharsets.UTF_8));
        }
        ZoneId zoneId = ZoneId.of(timezone);
        ZonedDateTime now = ZonedDateTime.now(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        String formattedTime = now.format(formatter);



        System.out.println(formattedTime);
    }


    public static void main(String[] args) {
        Main main = new Main();
        //System.out.println(ZoneId.getAvailableZoneIds());
        System.out.println(isValidTimezone("UTC+2"));
        System.out.println(isValidTimezone("Hi"));
    }
}