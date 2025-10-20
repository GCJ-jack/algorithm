package validation;

public class LengthValidatorHandler implements ValidatorHandler{

    private final int length;

    public LengthValidatorHandler(int length){
        this.length = length;
    }
    @Override
    public void validate(Object value, ValidatorContext validatorContext) {
        if(value instanceof String stringValue){
            if(stringValue.length()!= length){
                validatorContext.appendError("你的字符串长度是" + stringValue.length() + "应该是" + length);
            }
        }
    }
}
