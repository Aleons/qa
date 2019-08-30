package rest;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/group")
public class GroupRest {

    private Gson gson;

    public GroupRest(Gson gson) {
        this.gson = gson;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String add(@RequestBody String json){

        return "";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody String json){

        return "";
    }

    @RequestMapping(value = "/getAllGroups", method = RequestMethod.GET)
    public String getAllUser(){
        return "gson.toJson(new UserDaoImpl().getAllUsers());";
    }

}
