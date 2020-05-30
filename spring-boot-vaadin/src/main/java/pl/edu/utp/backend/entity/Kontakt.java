package pl.edu.utp.backend.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Kontakt extends AbstractEntity implements Cloneable {
	public enum Status {
		Zarzadzajacy, BrakKontaktu, Kontakt, Klient, Nieaktywny
	}

	@NotNull
	@NotEmpty
	private String imie;

	@NotNull
	@NotEmpty
	private String nazwisko = "";

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Firma firma;

	@Enumerated(EnumType.STRING)
	@NotNull
	private Kontakt.Status status;

	@Email
	@NotNull
	@NotEmpty
	private String email = "";

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public Firma getFirma() {
		return firma;
	}

	public void setFirma(Firma firma) {
		this.firma = firma;
	}

	public Kontakt.Status getStatus() {
		return status;
	}

	public void setStatus(Kontakt.Status status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return new StringBuilder().append(imie).append(" ").append(nazwisko).toString();
	}

}