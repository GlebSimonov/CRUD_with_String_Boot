package web.webproject.serice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.webproject.dao.UserDAO;
import web.webproject.model.User;


import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void editUser(User user, int id) {
        userDAO.editUser(user, id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(int id) {
        return userDAO.getById(id);
    }

}
