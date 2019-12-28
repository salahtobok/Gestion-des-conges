package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.ICompteDAOLocal;
import Entities.Compte;

import javax.ejb.Stateless;

@Stateless(name = "CompteDAOImplEJB")
public class CompteDAOImplBean extends GenericFacade<Compte> implements ICompteDAOLocal {
    public CompteDAOImplBean() {
    }
}
