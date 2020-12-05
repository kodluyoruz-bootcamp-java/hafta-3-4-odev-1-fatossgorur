import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Map<String,City> cityMaps = new HashMap<>();

        City moscow = new Moscow("Moscow","MOW",+3);
        City newyork = new Newyork("New York","NYC",-5);
        City london = new London("London","LON",0);
        City berlin = new Berlin("Berlin","BER",+1);
        City newdelhi = new NewDelhi("New Delhi","DEL",+5.3);

        cityMaps.put("MOW",moscow);
        cityMaps.put("NYC",newyork);
        cityMaps.put("LON",london);
        cityMaps.put("BER",berlin);
        cityMaps.put("DEL",newdelhi);

        //Sehir ismine gore siralama
         List<City> list = new ArrayList<>(cityMaps.values());
         Collections.sort(list);
         for( City c : list) {
             System.out.println(c);
         }



        //ExecutorService executorService = Executors.newFixedThreadPool(5);




    }

}

