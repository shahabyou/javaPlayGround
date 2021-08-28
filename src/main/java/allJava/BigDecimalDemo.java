package main.java.allJava;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class BigDecimalDemo {
    public static void main(String[] args) {
        double money = 100.1;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(money);
        System.out.println(moneyString);

        BigDecimal decimal = new BigDecimal(1000000);
        formatter.setMaximumFractionDigits(0);
         moneyString = formatter.format(decimal);
        System.out.println(moneyString);



    }
}
