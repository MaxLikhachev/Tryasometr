package su.vistar.model.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Setter(AccessLevel.NONE)
public class UserDataResponse implements Serializable {
    private final String username;
    private final String name;
    private final String surname;
    private final String secondName;
    private final String email;
    private final String phone;
}