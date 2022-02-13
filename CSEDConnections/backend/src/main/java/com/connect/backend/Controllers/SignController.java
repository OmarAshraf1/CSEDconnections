package com.connect.backend.Controllers;

import com.connect.backend.DatabaseLayer.Database;

public class SignController {
    private char type;
    
    public static Graduate user;
    public SignController(char t) {
        type = t;
    }

    public boolean signIn(String email, String password) {
        Data data = new Data(type);

        boolean validSignIn= data.checkSignIn(email, password);
        if(validSignIn){
            user =data.opengraduate(email);
            //System.out.println("--->"+user.mail.toString());
        }
        return validSignIn;
    }

    public int signUp(Graduate newGrad) {
        Data data = new Data(type);
        if (data.existsBefore(newGrad.mail))
            return 2;
        if (data.createnewGrad(newGrad))
            return 0;
        return 1;
    }

    public int signUp(Student newStudent) {
        Data data = new Data(type);
        if (data.existsBefore(newStudent.mail))
            return 2;
        if (data.createnewStudent(newStudent))
            return 0;
        return 1;
    }
    public void addsocial(String email,String facebook,String linkedin) {
       Database database = new Database() ;
       database.AddSocialdb(email, facebook, linkedin);
       
       
    }


}
