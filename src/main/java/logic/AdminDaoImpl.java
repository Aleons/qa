package logic;

import dao.AdminDao;
import model.Admin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdminDaoImpl implements AdminDao {

    private EntityManager em;
    private final static EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");


    @Override
    public String add(Admin admin) {
        this.em = emf.createEntityManager();
        String status;
        try {
            em.getTransaction().begin();
            em.persist(admin);
            em.getTransaction().commit();
            status = "Успех";
        } catch (Exception e) {
            status = e.getMessage();
            em.getTransaction().rollback();
        }
        em.close();
        return status;
    }

    @Override
    public String addToken(Admin admin) {
        this.em = emf.createEntityManager();
        String status;
        try {
            em.getTransaction().begin();
            em.persist(admin);
            em.getTransaction().commit();
            status = "Успех";
        } catch (Exception e) {
            status = e.getMessage();
            em.getTransaction().rollback();
        }
        em.close();
        return status;
    }

    @Override
    public void getAdminByToken(String token) {
        this.em = emf.createEntityManager();
        //return em.createQuery("from User where mail = :mail",User.class).setParameter("mail",token).getSingleResult();
    }

    @Override
    public void deleteToken(String token) {
        String status;
        try {
            em.getTransaction().begin();
            em.remove(token);
            em.getTransaction().commit();
            status = "Успех";
        } catch (Exception e) {
            status = e.getMessage();
            em.getTransaction().rollback();
        }
        em.close();
        //return status;
    }
}
