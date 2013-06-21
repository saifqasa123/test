import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getNextMonth(new Date()));

    }
    private static String getNextMonth(Date nowDate) {
        Calendar currentMonth = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM");
        System.out.println("Curret month of date : "
                + dateFormat.format(currentMonth.getTime()));
        // Increment month
        currentMonth.add(Calendar.MONTH, 1);
        String date = dateFormat.format(currentMonth.getTime());
        System.out.println("Next month : "
        + dateFormat.format(currentMonth.getTime()));
        return date;
    }

}
