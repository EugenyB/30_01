package main;

import java.io.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        // факториал числа n = 1*2*3*...*n
        int n = 100;
        BigInteger f = BigInteger.ONE;
        for (int i = 1; i <=n ; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        System.out.println(f);

        Map<String, String> map = System.getenv();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("prop.txt"));
            System.out.println(properties.get("user"));
            System.out.println(properties.get("birthday"));
            properties.setProperty("qwe","abracadabra");
            properties.store(new BufferedWriter(new FileWriter("prop.txt")), "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Locale.setDefault(Locale.US);
        System.out.println(Locale.getDefault());
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println("Tomorrow = " + (date.plusDays(1).getDayOfWeek()));
        LocalTime now = LocalTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("HH mm ss")));
    }
}
