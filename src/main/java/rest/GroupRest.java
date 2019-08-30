package rest;

import com.google.gson.Gson;
import logic.GroupDaoImpl;
import logic.UserDaoImpl;
import model.Group;
import model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/group")
public class GroupRest {

    private Gson gson;

    public GroupRest(Gson gson) {
        this.gson = new Gson();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String add(@RequestBody String json){
        Map<String, Object> resp = new HashMap<>();
        try {
            Map<String, Object> map = gson.fromJson(json, Map.class);
            Group group = new Group();

            group.setName((String) map.get("nameGroup"));
            new GroupDaoImpl().add(group);

            resp.put("status","Успех");
        }
        catch (Exception e){
            resp.put("status","Ошибка");
            resp.put("message",e.getMessage());
        }
        return gson.toJson(resp);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody String json){
        Map<String, Object> resp = new HashMap<>();
        try {
            Map<String, Object> map = gson.fromJson(json, Map.class);
            Group group = new Group();

            new GroupDaoImpl().addUser((String) map.get("nameGroup"),(String) map.get("mail"));

            resp.put("status","Успех");
        }
        catch (Exception e){
            resp.put("status","Ошибка");
            resp.put("message",e.getMessage());
        }
        return gson.toJson(resp);
    }

    @RequestMapping(value = "/getAllGroups", method = RequestMethod.GET)
    public String getAllUser(){
        return gson.toJson(new UserDaoImpl().getAllUsers());
    }

}
