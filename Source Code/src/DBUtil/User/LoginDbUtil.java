package DBUtil.User;


import DAO.Implementation.CompteDAOImplBean;
import DAO.Local.ICompteDAOLocal;
import DAO.Local.IPersonneDAOLocal;
import Entities.Compte;

import javax.ejb.EJB;
import javax.ejb.Singleton;

@Singleton
public class LoginDbUtil {

    @EJB
    ICompteDAOLocal iCompteDAOLocal;


    public Compte authenticate(String login, String password) {
        try {
            return iCompteDAOLocal.authenticate(login, password);
        } catch (Exception ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
        }
    }
}