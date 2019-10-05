package su.vistar.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserData implements Serializable {
    @Id
    @Setter(AccessLevel.PROTECTED)
    @NotNull
    private String username;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    @NotNull
    @JsonIgnore
    private String password;
    @Column
    private String email;
    @Column
    //@NotNull
    private String phone;
    @Column
    private String secondName;
    @Column
    @NotNull
    @Setter(AccessLevel.NONE)
    private String authorities;

    public UserData(String username, String password, String authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }
}