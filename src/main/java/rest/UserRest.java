package rest;

import com.google.gson.Gson;
import logic.UserDaoImpl;
import model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserRest {

    private Gson gson;


    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public String getAllUser(){
        return gson.toJson(new UserDaoImpl().getAllUsers());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody String json){
        Map <String, Object> resp = new HashMap<>();
        try {
            Map<String, Object> map = gson.fromJson(json, Map.class);
            User user = new User();
            Double number = (Double) map.get("number");
            user.setMail((String) map.get("mail"));
            user.setLastName((String) map.get("lastName"));
            user.setFirstName((String) map.get("firstName"));
            user.setBirthDate((String) map.get("birthDate"));
            user.setNumber(number.intValue());
            user.setNameChildren((List<String>) map.get("nameChildren"));
            user.setGender((String) map.get("gender"));
            new UserDaoImpl().add(user);
            resp.put("status","Успех");
        }
        catch (Exception e){
            resp.put("status","Ошибка");
            resp.put("message",e.getMessage());
        }
        return gson.toJson(resp);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody String json){
        Map <String, Object> resp = new HashMap<>();
        try {
            Map<String, Object> map = gson.fromJson(json, Map.class);
            Double number = (Double) map.get("number");
            User user = new User();
            user.setMail((String) map.get("mail"));
            user.setLastName((String) map.get("lastName"));
            user.setFirstName((String) map.get("firstName"));
            user.setBirthDate((String) map.get("birthDate"));
            user.setNumber(number.intValue());
            user.setNameChildren((List<String>) map.get("nameChildren"));
            user.setGender((String) map.get("gender"));
            if(map.get("oldMail") == null){
                resp.put("message","Вы не указали mail существующего пользователя!");
            }

            new UserDaoImpl().update((String) map.get("oldMail"), user);
            resp.put("status","Успех");
            return gson.toJson(resp);

        }
        catch (Exception e){
            resp.put("message","Такого пользователя нет");
            return gson.toJson(resp);
        }


    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(@RequestParam(name="mail") String mail){

        try {
            User user = new UserDaoImpl().get(mail);
            if (user == null)
                throw new Exception();
            return gson.toJson(user);
        }

        catch (Exception e){
            Map <String, Object> resp = new HashMap<>();
            resp.put("message","Такого пользователя нет");
            return gson.toJson(resp);
        }

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@RequestParam(name="mail") String mail){
        Map <String, Object> resp = new HashMap<>();
        try {
            new UserDaoImpl().delete(mail);
            resp.put("status","Пользователь успешно удален");
        }
        catch (Exception e){
            resp.put("message","Такого пользователя нет");
        }

        return gson.toJson(resp);
    }


}
