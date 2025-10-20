import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation {


//    public void subscribe(User user){
//        users.add(user);
//    }

    private final TVStation tvStation;

    public WeatherStation(TVStation tvStation){
        this.tvStation = tvStation;
    }
    public String getInfo(){
        if(new Random().nextBoolean()){
            return "下雨";
        }
        return  "冰雹";
    }

    public void start() throws InterruptedException{
        while (true){
            String info = getInfo();
            tvStation.onInfoUpdate(info);
            Thread.sleep(3000);
        }
    }
}
