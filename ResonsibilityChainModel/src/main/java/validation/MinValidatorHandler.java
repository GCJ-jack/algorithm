package validation;

public class MinValidatorHandler implements ValidatorHandler{

    private final int min;

    public MinValidatorHandler(int min){
        this.min = min;
    }

    @Override
    public void validate(Object value, ValidatorContext validatorContext) {
        Object name = validatorContext.get("name");

        if(name != null){
            System.out.println("之前有" + name + "校验过");
        }

        if(value instanceof Integer minValue){
            if(minValue < min){
                validatorContext.appendError("你的值是" + minValue + "不能小于" + min);
            }
        }
    }
}
