
public class City implements Clock,Comparable<City>{

    public String cityName;
    public String cityCode;
    public double GMT;

    public City(String cityName, String cityCode, double GMT) {
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.GMT = GMT;
    }

    @Override
    public void showTime() {

    }

    @Override
    public int compareTo(City o) {
       return this.cityName.compareTo(o.cityName);
    }

    @Override
    public String toString() {
        return "Sehir Adi = " + cityName
                + " , Sehir Kodu = " + cityCode
                + " , GMT = " + GMT ;
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

    public double getGMT() {
        return GMT;
    }

    public void setGMT(double GMT) {
        this.GMT = GMT;
    }

}
