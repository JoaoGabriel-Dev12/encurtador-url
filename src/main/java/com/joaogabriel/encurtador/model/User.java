package com.joaogabriel.encurtador.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import com.joaogabriel.encurtador.model.dtos.StatusUser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_tb")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String usename;
	private String email;
	private String senha;
	private OffsetDateTime dataUltimoLogin;
	private StatusUser status;

	public User() {
	}

	public User(Long id, String usename, String email, String senha, OffsetDateTime dataUltimoLogin,
			StatusUser status) {
		this.id = id;
		this.usename = usename;
		this.email = email;
		this.senha = senha;
		this.dataUltimoLogin = dataUltimoLogin;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsename() {
		return usename;
	}

	public void setUsename(String usename) {
		this.usename = usename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public OffsetDateTime getDataUltimoLogin() {
		return dataUltimoLogin;
	}

	public void setDataUltimoLogin(OffsetDateTime dataUltimoLogin) {
		this.dataUltimoLogin = dataUltimoLogin;
	}

	public StatusUser getStatus() {
		return status;
	}

	public void setStatus(StatusUser status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", usename=" + usename + ", email=" + email + ", senha=" + senha
				+ ", dataUltimoLogin=" + dataUltimoLogin + ", status=" + status + "]";
	}

}
