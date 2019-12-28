package Entities;

import Entities.Embeddable.KeyDemande;
import Enumeration.EtatDemande;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Demande implements Serializable {


    /*-----------------
    Declaration
   ---------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDemande ;


    @Embedded
    private KeyDemande keyDemande;


    @Column(nullable = false,length = 25)
    private String lieu;


    @NotNull
    @Enumerated(EnumType.STRING)
    private EtatDemande etatDemande;

    @ManyToOne
    @JoinColumn(name = "idPersonne")
    private Personne personne ;


    /*------------
    Getters & Setters
    -------------*/

    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public KeyDemande getKeyDemande() {
        return keyDemande;
    }

    public void setKeyDemande(KeyDemande keyDemande) {
        this.keyDemande = keyDemande;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public EtatDemande getEtatDemande() {
        return etatDemande;
    }

    public void setEtatDemande(EtatDemande etatDemande) {
        this.etatDemande = etatDemande;
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

    public Demande() {
    }

    public Demande(Personne personne, Date dateDemande, String lieu) {
        this.keyDemande = new KeyDemande( dateDemande);
        this.lieu = lieu;
    }


}
