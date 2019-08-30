package dao;

import model.User;

import java.util.List;

public interface UserDao {

    String add(User user);

    User get(String mail);

    String update (String mail, User user);

    String delete(String mail);

    List<User> getAllUsers();



}
