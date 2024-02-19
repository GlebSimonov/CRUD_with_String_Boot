package web.webproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.webproject.model.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private EntityManager entityManager;
    @PersistenceContext
    private void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public void editUser(User user, int id) {
        user.setId(id);
        entityManager.merge(user);
    }
    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }
}
