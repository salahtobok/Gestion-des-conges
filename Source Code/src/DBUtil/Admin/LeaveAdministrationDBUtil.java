package DBUtil.Admin;

import DAO.Local.IDemandeDAOLocal;
import DAO.Local.IPersonneDAOLocal;
import Entities.Compte;
import Entities.Demande;
import Entities.Embeddable.Adresse;
import Entities.Embeddable.KeyDemande;
import Entities.Personne;
import Enumeration.EtatCompte;
import Http.Controller.SMTP.SMTPController;
import com.github.javafaker.Faker;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.Date;
import java.util.List;

@Singleton
public class LeaveAdministrationDBUtil {


    @EJB
    IDemandeDAOLocal iDemandeDAOLocal;


    @EJB
    SMTPController smtpController;

    Faker faker = new Faker();

    public List<Demande> loadDemandList() {


        try {

            return iDemandeDAOLocal.findAll();
        } catch (Exception ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
        }
        return null;
    }

    //*Creation patien methods*//
    public boolean createDemande(Demande demande) {
        try {
//            Person.getCompte().setLogin(Person.getNumeroTelephone());

            iDemandeDAOLocal.create(demande);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
        }
    }


    public Demande createFakeDemand() {


        try {



            Demande demande = new Demande();

            KeyDemande keyDemande = new KeyDemande();
            keyDemande.setDateDemande(new Date());


            demande.setKeyDemande(keyDemande);


            return demande;
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
        }
    }


    public boolean updateDemande(Demande selectedDemande) {
        try {


            iDemandeDAOLocal.edit(selectedDemande);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {

        }
    }

    public boolean deleteDemande(Demande selectedDemande) {
        try {

            System.out.println("DDDDDDDDDDDD" + selectedDemande.getIdDemande());

            iDemandeDAOLocal.remove(selectedDemande);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {

        }
    }



}

