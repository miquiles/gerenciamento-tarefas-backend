package gerenciamento.tarefas.backend.util;

import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.servlet.tags.EditorAwareTag;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {



    public static Date formatDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        var dateFormat = format.parse(date);
        return dateFormat;

    }

    public static LocalDate formateDate(String date){
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }

    public static Long duration (LocalDate deadline) throws ParseException {
        var currentDay = LocalDate.now();
        return ChronoUnit.DAYS.between(currentDay, deadline);

    }

    public static Long durationHours(LocalDate deadline){
        var currentDay = LocalDate.now();
        return ChronoUnit.HOURS.between(currentDay, deadline);
    }
}
