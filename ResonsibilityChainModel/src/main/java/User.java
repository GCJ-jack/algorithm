import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@Data
@Getter
@Setter
public class User {

    private final String name;

    private final Integer age;


}
