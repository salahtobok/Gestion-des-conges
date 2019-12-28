package DAO.Remote;

import DAO.IGenericDAO;
import Entities.Demande;

import javax.ejb.Remote;

@Remote
public interface IDemandeDAO extends IGenericDAO<Demande> {
}
