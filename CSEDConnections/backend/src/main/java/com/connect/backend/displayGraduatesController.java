package com.connect.backend;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class displayGraduatesController {
    Database database = new Database() ;
    @CrossOrigin("*")
    @PostMapping("/get_graduates")
    public String showgraduates(@RequestBody String contact)   {
        
        List<DisplayedGrads> grads = database.getGraduates() ;
        
         //System.out.println(tuple.getString("email"));  
        Gson gson = new Gson();     
       // Type listType = new TypeToken<List<DisplayedGrads>>() {
      //  }.getType(); 
        java.lang.reflect.Type listType = new TypeToken<List<DisplayedGrads>>(){}.getType() ;
        String json = gson.toJson(grads,listType);
        return json ;

    }
}
