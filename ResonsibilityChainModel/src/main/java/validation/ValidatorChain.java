package validation;

import exception.ValidatorException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public class ValidatorChain {

    private final List<ValidatorHandler> validatorHandlers = new ArrayList<>();

    public void validate(Object value) throws ValidatorException {
        ValidatorContext validatorContext = new ValidatorContext(value);

        while (true){
            int index = validatorContext.currentIndex();
            if(index == validatorHandlers.size()){
                break;
            }

            ValidatorHandler validatorHandler = validatorHandlers.get(index);

            validatorHandler.validate(validatorContext.getValue(),validatorContext);

            if(index == validatorContext.getIndex()){
                break;
            }
        }

        validatorContext.throwExceptionIfNecessary();
    }


    public void addLastHandler(ValidatorHandler handler) {
        this.validatorHandlers.add(handler);
    }
}
