package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IPersonneDAOLocal;
import Entities.Personne;

import javax.ejb.Stateless;

@Stateless(name = "PersonneDAOImplEJB")
public class PersonneDAOImplBean extends GenericFacade<Personne> implements IPersonneDAOLocal {
    public PersonneDAOImplBean() {
    }
}
