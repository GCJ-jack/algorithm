
import java.util.Random;

public class WeatherStation {


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
            tvStation.publish(new WeatherUpdateEvent(info));
            Thread.sleep(3000);
        }
    }
}
