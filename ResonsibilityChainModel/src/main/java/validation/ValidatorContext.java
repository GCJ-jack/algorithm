package validation;

import exception.ValidatorException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Getter
@Setter
public class ValidatorContext {

    private final List<String> errorList = new ArrayList<>();

    private boolean stop;

    private int index;

    private Object value;

    private Map<String,Object> date = new HashMap<>();

    public ValidatorContext(Object value){
        this.value = value;
    }

    public void appendError(String msg){
        errorList.add(msg);
    }

    public void stopChain() {
        this.stop = true;
    }

    public void doNext(Object value) {
        index++;
        this.value = value;
    }

    public int currentIndex() {
        return index;
    }

    public boolean shouldStop() {
        return this.stop;
    }

    public void put(String key, Object value) {
        this.date.put(key, value);
    }

    public Object get(String key) {
        return this.date.get(key);
    }

    public void throwExceptionIfNecessary() throws ValidatorException {
        if (errorList.isEmpty()) {
            return;
        }
        throw new ValidatorException(errorList.toString());
    }
}
