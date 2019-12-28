package Entities;

import Enumeration.EtatCompte;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Compte implements Serializable {


    /*-----------------
     Declaration
    ---------------*/


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompte ;


    @Column(name = "login", unique = true)
    @NotNull
    private String login;


    @Column(name = "mot_de_passe")
    @Size(min = 8 , max = 20)
    @NotNull
    private String motDePasse;

    @Column(name = "code_activation")
    @Size(min = 4 , max = 8)
    @NotNull
    private String code_activation;



    @NotNull
    @Enumerated(EnumType.STRING)
    private EtatCompte etatCompte;

    @OneToOne
    @JoinColumn(name = "idPersonne")
    private Personne personne ;


     /*------------
    Getters & Setters
    -------------*/

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public EtatCompte getEtatCompte() {
        return etatCompte;
    }

    public void setEtatCompte(EtatCompte etatCompte) {
        this.etatCompte = etatCompte;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }


     /*------------
    Constructeur
    -------------*/

    public Compte(@NotNull String login, @Size(min = 8, max = 20) @NotNull String motDePasse, @NotNull EtatCompte etatCompte) {
        this.login = login;
        this.motDePasse = motDePasse;
        this.etatCompte = etatCompte;
    }

    public Compte() {
    }

    public String getCode_activation() {
        return code_activation;
    }

    public void setCode_activation(String code_activation) {
        this.code_activation = code_activation;
    }
}
