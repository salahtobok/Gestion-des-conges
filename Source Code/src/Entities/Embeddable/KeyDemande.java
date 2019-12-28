package Entities.Embeddable;

import Entities.Personne;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class KeyDemande implements Serializable {

    /*-----------------
      Declaration
     ---------------*/




    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDemande;

    /*------------
    Getters & Setters
    -------------*/


    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }
/*------------
    Constructeur
    -------------*/

    public KeyDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public KeyDemande() {
    }
}
