package logic;

import dao.UserDao;
import model.User;
import rest.Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private EntityManager em;
    private final static EntityManagerFactory emf = Main.emf;

    @Override
    public String add(User user) {
        this.em = emf.createEntityManager();
        String status;
            try {
                em.getTransaction().begin();
                em.persist(user);
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
    public User get(String mail) {
        this.em = emf.createEntityManager();
        return em.createQuery("from User where mail = :mail", User.class).setParameter("mail",mail).getSingleResult();
    }

    @Override
    public String update(String mail, User user) {
        this.em = emf.createEntityManager();
        String status;
        try {
            User userOld = get(mail);
            delete(userOld.getMail());
            add(user);
            status = "Успех";
        } catch (Exception e) {
            status = e.getMessage();
            em.getTransaction().rollback();
        }
        em.close();
        return status;

    }

    @Override
    public String delete(String mail) {
        String status;
        try {
            User user = get(mail);
            em.getTransaction().begin();
            em.remove(user);
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
    public List<User> getAllUsers() {
        this.em = emf.createEntityManager();
        return em.createQuery("from User", User.class).getResultList();

    }


}
