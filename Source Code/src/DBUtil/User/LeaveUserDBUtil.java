package DBUtil.User;

import DAO.Local.IDemandeDAOLocal;
import Entities.Demande;
import Entities.Embeddable.KeyDemande;
import Entities.Personne;
import Enumeration.EtatDemande;
import Http.Controller.SMTP.SMTPController;
import SessionUtil.SessionUtils;
import com.github.javafaker.Faker;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.Date;
import java.util.List;

@Singleton
public class LeaveUserDBUtil {


    @EJB
    IDemandeDAOLocal iDemandeDAOLocal;


    @EJB
    SMTPController smtpController;

    Faker faker = new Faker();

    public List<Demande> loadDemandList() {


        try {
            Object userId = SessionUtils.getUserAccount().getPersonne().getIdPersonne();
            return iDemandeDAOLocal.findUserLeaveById(userId);
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
            System.out.println("HHHHHHHHHHHHHH  : "+demande.getLieu());

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
            Personne personne = SessionUtils.getUserAccount().getPersonne();

            KeyDemande keyDemande = new KeyDemande();
            keyDemande.setDateDemande(new Date());


            demande.setPersonne(personne);
            demande.setKeyDemande(keyDemande);
            demande.setEtatDemande(EtatDemande.Ne_pas_permettre);

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

