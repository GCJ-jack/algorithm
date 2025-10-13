import validation.Validator;

public class Main {

    public static void main(String[] args) throws Exception {
        User user = new User("tom", 210);
        Validator validator = new Validator();
        validator.validate(user);
    }
}
