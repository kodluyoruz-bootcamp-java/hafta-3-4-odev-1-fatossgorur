import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class City implements IClock,Comparable<City>{

    public String cityName;
    public String cityCode;
    public int GMT;

    public City(String cityName, String cityCode, int GMT) {
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.GMT = GMT;
    }

    @Override
    public void showTime() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        while (true) {
            LocalTime time = LocalTime.now().minusHours(3);
            time = time.plusHours(this.getGMT());

            System.out.print(this.getCityName() + " --> " + time.format(formatter) + "\r");
            try {
                TimeUnit.NANOSECONDS.sleep(1_000_000_000 - time.getNano());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    @Override
    public int compareTo(City o) {
       return this.cityName.compareTo(o.cityName);
    }

    @Override
    public String toString() {
        return "Sehir Kodu = " + cityCode
                + " ---> Sehir Adi = " + cityName ;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public int getGMT() {
        return GMT;
    }

    public void setGMT(int GMT) {
        this.GMT = GMT;
    }

}
