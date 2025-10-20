import java.util.function.Consumer;

public class User {

    private String name;

    private Consumer<String> consumer;

    public User(String name, Consumer<String> consumer){
        this.name = name;
        this.consumer = consumer;
    }

    public void ReceiveInfo(String info){
        consumer.accept(info);
    }

}
