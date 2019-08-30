package dao;


import model.Admin;

public interface AdminDao {

    String add(Admin admin);

    String addToken(Admin admin);

    void getAdminByToken(String token);

    void deleteToken(String token);

}
