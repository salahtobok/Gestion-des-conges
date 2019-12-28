package Entities;

import Entities.Embeddable.Adresse;
import Enumeration.Civility;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Personne implements Serializable {

    /*-----------------
      Declaration
     ---------------*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonne;

    @NotNull
    @Column(name = "numero_assurance", unique = true, nullable = false)
    private String numeroAssurance ;

    @NotNull
    @Size(min = 3, max = 20)
    private String nom ;

    @NotNull
    @Size(min = 3, max = 50)
    private String prenom ;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "date_naissance")
    private Date dateNaissance ;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "lieu_naissance")
    private String lieuNaissance ;

    @Column(nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    private Civility sexe;

    @Column(name = "numero_telephone", unique = true)
    @NotNull
    private String numeroTelephone;

    @Email
    @Column(unique = true)
    private String email;

    @Transient
    private int age;


    @Embedded
    private Adresse adresse ;


    @OneToOne(mappedBy = "personne" , cascade = CascadeType.ALL)
    private Compte compte ;


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "personne" ,  orphanRemoval = true)
    private Set<Demande> demandeSet = new HashSet<>() ;


     /*------------
    Getters & Setters
    -------------*/

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNumeroAssurance() {
        return numeroAssurance;
    }

    public void setNumeroAssurance(String numeroAssurance) {
        this.numeroAssurance = numeroAssurance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public Civility getSexe() {
        return sexe;
    }

    public void setSexe(Civility sexe) {
        this.sexe = sexe;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Set<Demande> getDemandeSet() {
        return demandeSet;
    }

    public void setDemandeSet(Set<Demande> demandeSet) {
        this.demandeSet = demandeSet;
    }

/*------------
    Constructeur
    -------------*/

    public Personne() {
    }
}
