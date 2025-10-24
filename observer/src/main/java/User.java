import java.util.function.Consumer;

public class User implements EventListener{

    private String name;

    private Consumer<String> consumer;

    public User(String name, Consumer<String> consumer){
        this.name = name;
        this.consumer = consumer;
    }

    public void ReceiveInfo(String info){
        consumer.accept(info);
    }


    @Override
    public void onEvent(Event event) {
        if (event instanceof WeatherUpdateEvent) {
            ReceiveInfo(event.source().toString());
        }
    }

}
