import java.util.ArrayList;
import java.util.List;

public class TVStation {

    private final List<User> users = new ArrayList<>();

    public void subscribe(User user){
        users.add(user);
    }

    public void onInfoUpdate(String info){
        for(User user:users){
            user.ReceiveInfo(info);
        }
    }
}
