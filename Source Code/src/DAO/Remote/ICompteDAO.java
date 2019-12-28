package DAO.Remote;

import DAO.IGenericDAO;
import Entities.Compte;

import javax.ejb.Remote;

@Remote
public interface ICompteDAO extends IGenericDAO<Compte> {
}
