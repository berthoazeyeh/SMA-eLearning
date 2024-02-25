package models;

import java.time.LocalTime;

import jade.util.leap.Serializable;

public class Cours implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String enseignant;
	private LocalTime heureDebut;
	private LocalTime heureFin;

	// Constructeur
	public Cours(String nom, String enseignant, LocalTime heureDebut, LocalTime heureFin) {
		this.nom = nom;
		this.enseignant = enseignant;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}

	// Getters et Setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(String enseignant) {
		this.enseignant = enseignant;
	}

	public LocalTime getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}

	public LocalTime getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(LocalTime heureFin) {
		this.heureFin = heureFin;
	}
}
