import validation.Validator;

public class Main {

    public static void main(String[] args) throws Exception {
        User user = new User("to", 210);

        new Validator().validate(user);

    }
}
