package su.vistar.model.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Setter(AccessLevel.NONE)
public class SectionResponse implements Serializable {
    private long id;
    private float factor;
}
