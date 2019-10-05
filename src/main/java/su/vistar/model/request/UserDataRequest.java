package su.vistar.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Setter(AccessLevel.PROTECTED)
public class UserDataRequest implements Serializable {
    private final String password;
    private final String name;
    private final String surname;
    private final String secondName;
    private final String email;
    private final String phone;
}