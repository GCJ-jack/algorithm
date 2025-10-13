package validation;

public class MaxValidatorHandler implements ValidatorHandler{

    private final int max;

    public MaxValidatorHandler(int max){
        this.max = max;
    }
    @Override
    public void validate(Object value, ValidatorContext validatorContext) {
        if(value instanceof Integer maxValue){
            if(maxValue > max){
                validatorContext.appendError("你的值是" + maxValue + "不能大于" + max);
            }
        }

        validatorContext.put("name","chaojun");
        validatorContext.doNext(20);
    }
}
