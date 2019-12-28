package DAO.Remote;

import DAO.IGenericDAO;
import Entities.Personne;

import javax.ejb.Remote;

@Remote
public interface IPersonneDAO extends IGenericDAO<Personne> {
}
