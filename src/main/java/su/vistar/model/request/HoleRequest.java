package su.vistar.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Setter(AccessLevel.PROTECTED)
public class HoleRequest implements Serializable {
    private final float distance;
}
