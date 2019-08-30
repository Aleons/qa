package rest;

import com.google.gson.Gson;
import logic.AdminDaoImpl;
import logic.UserDaoImpl;
import model.Admin;
import model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AuthRe {

    private Gson gson;

    public AuthRe(Gson gson) {
        this.gson = new Gson();
    }



    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String add(@RequestBody String json){
        Map <String, Object> resp = new HashMap<>();
        try {
            Map<String, Object> map = gson.fromJson(json, Map.class);
            Admin admin = new Admin();
            admin.setLogin((String) map.get("login"));
            admin.setPassword((String) map.get("password"));
            resp.put("status","Успех");
        }
        catch (Exception e){
            resp.put("status","Ошибка");
            resp.put("message",e.getMessage());
        }
        return gson.toJson(resp);
    }


    @RequestMapping(value = "/auth", method = RequestMethod.DELETE)
    public String auth(@RequestParam(name="mail") String mail){

        return "Error 500";
    }


    @RequestMapping(value = "/exit", method = RequestMethod.DELETE)
    public String delete(@RequestParam(name="mail") String mail){
       return " {“status” : “Ошибка”}";
    }


}
