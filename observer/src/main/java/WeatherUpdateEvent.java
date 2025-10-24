public class WeatherUpdateEvent extends BaseEvent{

    private String info;

    public WeatherUpdateEvent(String info){
        this.info = info;
    }

    @Override
    public Object source(){
        return info;
    }
}
