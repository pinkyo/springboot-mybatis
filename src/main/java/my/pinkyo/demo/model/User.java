package my.pinkyo.demo.model;

import my.pinkyo.demo.valiation.Insert;
import my.pinkyo.demo.valiation.Update;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.UUID;

/**
 * user model
 * @author MyE430cKns
 *
 */
public class User {
	@Null(groups = {Update.class, Insert.class})
	private UUID id;
	private String name;
	private Sex sex;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
}
