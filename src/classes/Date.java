package classes;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Date {
    private String Date;

    public String getDate() {
        return Date;
    }

    public void setDate(String input) {
        if (input.length() == 0) {
            //this is an auto current date generator with a check for no inputs from the user
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            this.Date = dtf.format(now);
        } else {
            System.out.println(toString());
        }
    }

    @Override
    public String toString() {
        return "YOU CAN'T INPUT ANY DATE!";
    }
}
