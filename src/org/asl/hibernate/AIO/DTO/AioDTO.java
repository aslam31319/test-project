package org.asl.hibernate.AIO.DTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity

public class AioDTO implements Serializable {
	@Id
	@GenericGenerator(name = "id", strategy = "org.asl.hibernate.AIO.Util.MyGenerator")
	@GeneratedValue(generator = "id")
	private int id;
	private String name;
	//@Id
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "AioDTO [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

}
