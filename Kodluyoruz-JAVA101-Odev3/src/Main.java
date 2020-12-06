import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //Seçilen şehir kodları bir arraylistte tutulur
        List<String> selectCityCode = new ArrayList<>();


        Map<String,City> cityMaps = new HashMap<>();
        City moscow = new Moscow("Moscow","MOW",3);
        City newyork = new Newyork("New York","NYC",-5);
        City london = new London("London","LON",0);
        City berlin = new Berlin("Berlin","BER",1);
        City newdelhi = new NewDelhi("New Delhi","DEL",5); //5:30

        List<String> citiesCodes = new ArrayList<>();
        citiesCodes.add(moscow.getCityCode());
        citiesCodes.add(newyork.getCityCode());
        citiesCodes.add(newdelhi.getCityCode());
        citiesCodes.add(london.getCityCode());
        citiesCodes.add(berlin.getCityCode());

        cityMaps.put(moscow.getCityCode(), moscow);
        cityMaps.put(newyork.getCityCode(), newyork);
        cityMaps.put(london.getCityCode(), london);
        cityMaps.put(berlin.getCityCode(), berlin);
        cityMaps.put(newdelhi.getCityCode(), newdelhi);

        //Sehir ismine gore map siralama
         List<City> list = new ArrayList<>(cityMaps.values());
         Collections.sort(list);
         for( City c : list) {
             System.out.println(c);
         }

         ExecutorService executorService = Executors.newFixedThreadPool(5);

        System.out.println("Saatini görmek istediğiniz şehrin kodunu girin");
        System.out.print("(En az 3-En fazla 5) : ");

        int selected;
        while (true) {
            try {
                selected = scan.nextInt();

                while (selected < 3 || selected > 5) {
                    System.out.println("Hatalı giriş.Lütfen 3-5 arasında seçim yapınız..");
                    selected = scan.nextInt();
                }
                scan.nextLine();
                System.out.println("Lütfen şehir kodunu girin");

                for (int i = 1; i <= selected; i++) {
                    System.out.print(i+ ".şehir kodu : " );
                    String cityCode = scan.nextLine().toUpperCase();

                    while (cityCode.length() != 3 || !(citiesCodes.contains(cityCode))) {
                        System.out.println("Lütfen doğru şehir kodunu girin..");
                        System.out.print(i+ ".şehir kodu : " );
                        cityCode = scan.nextLine().toUpperCase();
                    }
                    selectCityCode.add(cityCode);

                }

                List<City> selectCityList = new LinkedList<>();
                for (int i = 0; i < selectCityCode.size(); i++) {
                    City selectCity = valueByKey(cityMaps, selectCityCode.get(i));
                    selectCityList.add(selectCity);
                }
                Collections.sort(selectCityList);


                for (City c : selectCityList) {
                    Runnable timeThread = new TimeThread(c);
                    executorService.execute(timeThread);
                }
                executorService.shutdown();

            } catch (InputMismatchException e) {
                scan.nextLine();
            }

        }

    }


    public static City valueByKey(Map<String, City> map, String key) {
        for (Map.Entry<String, City> entry : map.entrySet()) {
            if (Objects.equals(key, entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

}




