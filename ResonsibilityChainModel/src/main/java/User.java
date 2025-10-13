import annotation.Length;
import annotation.Max;
import annotation.Min;
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

    @Length(3)
    private final String name;

    @Max(17)
    @Min(20)
    private final Integer age;


}
