package logic;

import dao.GroupDao;
import model.Group;
import rest.Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class GroupDaoImpl implements GroupDao {

    private EntityManager em;
    private final static EntityManagerFactory emf = Main.emf;

    @Override
    public void add(Group group) {
        this.em = emf.createEntityManager();
        String status;
        try {
            em.getTransaction().begin();
            em.persist(group);
            em.getTransaction().commit();
            status = "Успех";
        } catch (Exception e) {
            status = e.getMessage();
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public List<Group> getAllGroup() {
        this.em = emf.createEntityManager();
        return em.createQuery("from Group", Group.class).getResultList();    }

    @Override
    public void addUser(String nameGroup, String mail) {
        this.em = emf.createEntityManager();
        String status;
        Group group = get(nameGroup);
        if(group!=null) {
            try {
                em.getTransaction().begin();
                em.persist(group);
                em.getTransaction().commit();
                status = "Успех";
            } catch (Exception e) {
                status = e.getMessage();
                em.getTransaction().rollback();
            }
            em.close();
        }
        status = "Такой группы нет";
    }

    @Override
    public Group get(String name) {
        this.em = emf.createEntityManager();
        return em.createQuery("from User where mail = :mail", Group.class).setParameter("mail",name).getSingleResult();
    }

}
