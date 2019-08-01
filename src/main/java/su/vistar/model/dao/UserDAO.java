package su.vistar.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserDAO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	protected long id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;

	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String second_name;
	@Column
	private String email;
	@Column
	private String phone;

	@OneToMany
	public List<CarDAO> cars;

	public long getID() {
		return this.id;
	}

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() { return this.name; }
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() { return this.surname; }
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSecondName() {
		return this.second_name;
	}
	public void setSecondName(String second_name) {
		this.second_name = second_name;
	}

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() { return this.phone; }
	public void setPhone(String pnone) { this.phone = phone; }

	public List<CarDAO> getCars() { return this.cars; }
	public void setCars(List<CarDAO> cars) { this.cars = cars; }
}