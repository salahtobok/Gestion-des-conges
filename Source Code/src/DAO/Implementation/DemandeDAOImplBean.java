package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IDemandeDAOLocal;
import Entities.Demande;

import javax.ejb.Stateless;

@Stateless(name = "DemandeDAOImplEJB")
public class DemandeDAOImplBean extends GenericFacade<Demande> implements IDemandeDAOLocal {
    public DemandeDAOImplBean() {
    }
}
