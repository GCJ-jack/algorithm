package validation;

import annotation.Length;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.lang.reflect.Field;

public class Validator {

    private ValidatorChain buildValidateChain(Field field){

        ValidatorChain validatorChain = new ValidatorChain();

        Max max = field.getAnnotation(Max.class);

        if(max!=null){
            validatorChain.addLastHandler(new MaxValidatorHandler((int) max.value()));
        }

        Min min = field.getAnnotation(Min.class);

        if(min!=null){
            validatorChain.addLastHandler(new MinValidatorHandler((int) min.value()));
        }

        Length length = field.getAnnotation(Length.class);

        if(length != null){
            validatorChain.addLastHandler(new MinValidatorHandler(length.value()));
        }

        return validatorChain;
    }

    public void validate(Object bean)throws Exception{
        Class<?> beanClass = bean.getClass();

        for(Field field:beanClass.getDeclaredFields()){
            field.setAccessible(true);
            ValidatorChain validatorChain = buildValidateChain(field);
            validatorChain.validate(field.get(bean));
        }
    }
}
