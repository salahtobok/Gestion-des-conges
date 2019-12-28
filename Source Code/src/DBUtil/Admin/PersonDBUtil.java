package DBUtil.Admin;

import DAO.Local.IPersonneDAOLocal;
import Entities.Compte;
import Entities.Embeddable.Adresse;
import Entities.Personne;
import Enumeration.EtatCompte;
import Http.Controller.SMTP.SMTPController;
import com.github.javafaker.Faker;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.Date;
import java.util.List;

@Singleton
public class PersonDBUtil {


    @EJB
    IPersonneDAOLocal iPersonneDAOLocal;


    @EJB
    SMTPController smtpController;

    Faker faker = new Faker();

    public List<Personne> loadPersonList() {


        try {

            return iPersonneDAOLocal.findAll();
        } catch (Exception ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
        }
        return null;
    }

    //*Creation patien methods*//
    public boolean createPerson(Personne Person) {
        try {
            Person.getCompte().setLogin(Person.getNumeroTelephone());

             iPersonneDAOLocal.create(Person);


            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
        }
    }


    public Personne createFakePerson() {


        try {


            Adresse adresse = new Adresse();

            Compte compte = new Compte();
            compte.setMotDePasse(faker.code().isbnRegistrant().toString());
            compte.setCode_activation(String.valueOf(faker.random().nextInt(6548, 31654789)));

            compte.setEtatCompte(EtatCompte.NONACTIF);



            Personne Person = new Personne();

            Person.setAdresse(adresse);
            Person.setCompte(compte);

            compte.setPersonne(Person);

            return Person;
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
        }
    }


    public boolean updatePerson(Personne selectedPerson) {
        try {


            iPersonneDAOLocal.edit(selectedPerson);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {

        }
    }

    public boolean deletePerson(Personne selectedPerson) {
        try {


            iPersonneDAOLocal.remove(selectedPerson);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {

        }
    }



}

