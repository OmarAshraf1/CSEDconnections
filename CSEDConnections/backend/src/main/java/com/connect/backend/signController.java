package com.connect.backend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RequestMapping("api")
@RestController
public class signController {

    /*
     * @PostMapping("/signup")
     * public String signup(@RequestBody String info) {
     * JsonParser jsonObject = new
     * JsonParser().parse(info).getAsJsonObject().get("body").getAsJsonObject();
     * String email = jsonObject.get("email").getAsString();
     * String password = jsonObject.get("pass1word").getAsString();
     * String username = jsonObject.get("username").getAsString();
     * String x = "";
     * Gson gson = new Gson();
     * String json = "";
     * 
     * return info;
     * }
     */
    @GetMapping("/signUp/graduate")
    public String SignUpGraduate(@RequestParam(value = "name") String name,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "age") String age,
            @RequestParam(value = "gender") String gender,
            @RequestParam(value = "profilePicture") String profilePicture,
            @RequestParam(value = "about") String about,
            @RequestParam(value = "graduationyear") String graduationyear,
            @RequestParam(value = "company") String company,
            @RequestParam(value = "location") String location,
            @RequestParam(value = "position") String position,
            @RequestParam(value = "phone") String phone,
            @RequestParam(value = "pass1word") String pass1word) {
        Database database = new Database();
        boolean existedmail = database.checkEmail(email);
        if (!existedmail)
            return "Email existed before!";
        
        Graduate grad = new Graduate(name, gender, phone, about, age, email, pass1word, profilePicture, graduationyear);
		grad.addExperience(new Experience(company, location, position));

        if (database.insertGraduate(grad)) {
            return "Signed up Sucssefully!";
        }
        return "Error";
    }

    @GetMapping("/signUp/student")
    public String SignUpStudent(@RequestParam(value = "name") String name,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "age") String age,
            @RequestParam(value = "gender") String gender,
            @RequestParam(value = "profilePicture") String profilePicture,
            @RequestParam(value = "about") String about,
            @RequestParam(value = "level") String level,
            @RequestParam(value = "expectedgraduationyear") String expectedgraduationyear,
            @RequestParam(value = "phone") String phone,
            @RequestParam(value = "pass1word") String pass1word) {
        return "true";
    }


    @GetMapping("/signin")
    public String Login(@RequestParam(value = "email") String email,
            @RequestParam(value = "pass1word") String password) {
        Database database = new Database();
        boolean success = database.checkUser(email, password);
        System.out.println(success);
        if (success) {
            return "Successfully Logged In";
        }
        return "email or password is not correct!";
    }

}
