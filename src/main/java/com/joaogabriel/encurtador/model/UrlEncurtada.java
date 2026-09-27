package com.joaogabriel.encurtador.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "urlencurtada_tb")
public class UrlEncurtada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String codigo;
	@Column(nullable = false)
	private String urlOriginal;
	@Column(nullable = false)
	private Long cliques;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public UrlEncurtada() {
	}

	public UrlEncurtada(Long id, String codigo, String urlOriginal, User user) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.urlOriginal = urlOriginal;
		this.cliques = 0L;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getUrlOriginal() {
		return urlOriginal;
	}

	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}

	public Long getCliques() {
		return cliques;
	}

	public void setCliques(Long cliques) {
		this.cliques = cliques;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		UrlEncurtada other = (UrlEncurtada) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "UrlEncurtada [id=" + id + ", codigo=" + codigo + ", urlOriginal=" + urlOriginal + "]";
	}

}
