package dao;

import model.Group;

import java.util.List;

public interface GroupDao {

    void add(Group group);

    List<Group> getAllGroup();

    void addUser(String nameGroup, String mail);

    Group get(String mail);

}
