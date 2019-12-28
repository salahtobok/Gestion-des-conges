package DAO;

import Entities.Compte;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class GenericFacade<T> implements IGenericDAO<T> {

    @PersistenceContext(unitName = "GCPersistenceUnit")
    protected EntityManager entityManager;

    private Class<T> entityClass;

    public GenericFacade() {

        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        this.entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];

    }

    @Override
    public void create(Object entity) {
            entityManager.persist(entity);
    }

    @Override
    public void edit(Object entity) {
             entityManager.merge(entity);
    }

    @Override
    public void remove(Object entity) {
        System.out.println("SALAH");
//        entityManager.merge(entity);
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));

        }

    @Override
    public T find(Object id) {
        return entityManager.find(this.entityClass, id);
    }

    @Override
    public List findAll() {

        Query query = entityManager.createQuery("select entity from " + this.entityClass.getSimpleName() + " entity");
        return query.getResultList();
    }

    @Override
    public Long count() {

        Query query = entityManager.createQuery("select count(entity) from " + this.entityClass.getSimpleName() + " entity");

        return (Long) query.getSingleResult();
    }

    @Override
    public T authenticate(Object login, Object password) {
        Query query =
                entityManager.createQuery("Select c FROM Compte c WHERE c.login = :login " +
                        "AND c.motDePasse = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        return  (T) query.getSingleResult();

    }

    @Override
    public List<T> findUserLeaveById(Object id) {
        Query query =
                entityManager.createQuery("Select d FROM Demande d WHERE d.personne.id = :id ");
        query.setParameter("id", id);
        return  query.getResultList();
    }

}