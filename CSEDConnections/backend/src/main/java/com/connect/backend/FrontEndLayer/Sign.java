package com.connect.backend.FrontEndLayer;

import com.connect.backend.Controllers.Experience;
import com.connect.backend.Controllers.Graduate;
import com.connect.backend.Controllers.SignController;
import com.connect.backend.DatabaseLayer.Database;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
//@RequestMapping("api")
@RestController
public class Sign {
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
    public String signUpGraduate(@RequestParam(value = "name") String name,
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
            @RequestParam(value = "pass1word") String pass1word,
            @RequestParam(value = "facebook") String facebook,
            @RequestParam(value = "linkedin") String linkedin
            ) {
        
        System.out.println("signup!!1");
        Graduate grad = new Graduate(name, gender, phone, about, age, email, pass1word, profilePicture, graduationyear);
        SignController controller = new SignController('G');
        
        grad.addExperience(new Experience(company, location, position));
        int result = controller.signUp(grad);

        System.out.println(result + "signup!!2");
        controller.addsocial(email, facebook, linkedin);
        if (result == 0) {
            return "Signed up Sucssefully!";
        } else if (result == 2) {
            return "Email existed before!";
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

    @GetMapping("/signinGrad")
    public String signInGrad(@RequestParam(value = "email") String email,
            @RequestParam(value = "pass1word") String password) {
        SignController controller = new SignController('G');
        if (controller.signIn(email, password)) {
            return "Successfully Logged In";
        }
        return "email or password is not correct!";
    }

    @GetMapping("/signinStudent")
    public String signInStudent(@RequestParam(value = "email") String email,
            @RequestParam(value = "pass1word") String password) {

        SignController controller = new SignController('S');
        if (controller.signIn(email, password)) {
            return "Successfully Logged In";
        }
        return "email or password is not correct!";
    }

}
