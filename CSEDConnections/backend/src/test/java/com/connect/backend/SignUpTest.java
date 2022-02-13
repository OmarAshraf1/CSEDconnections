package com.connect.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.connect.backend.Controllers.*;

import org.junit.jupiter.api.Test;

public class SignUpTest {

    @Test
    void successfulSignUp() {
        Graduate graduate = new Graduate("Ahmed Samir", "Mail", "01270627231", "I am a Software Engineer at Meta", "23",
                "Ahmd@gmail.com", "123456789A",
                "https://scontent.fcai21-4.fna.fbcdn.net/v/t39.30808-6/212990641_2066485583492708_1606143835716174366_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=BILwHj7jftEAX_joLdk&_nc_ht=scontent.fcai21-4.fna&oh=00_AT8G5KrBWacD8R-8U4HqncBvC2DEEAW7BSEHZs1Ex-spxg&oe=61D80F25",
                "2023");
        graduate.experience.add(new Experience("Meta", "London", "Software Engineer"));
        SignController controller = new SignController('G');
        assertEquals(0, controller.signUp(graduate));
    }

    @Test
    void existsBeforeMethod() {
        Data data = new Data('G');
        assertTrue(data.existsBefore("neno@gmail.com"));
    }

    @Test
    void emailExistedBefore() {
        SignController controller = new SignController('G');
        Graduate graduate = new Graduate("Ahmed Samir", "Mail", "01270627231", "I am a Software Engineer at Meta", "23",
                "Ahmd@gmail.com", "123456789A",
                "https://scontent.fcai21-4.fna.fbcdn.net/v/t39.30808-6/212990641_2066485583492708_1606143835716174366_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=BILwHj7jftEAX_joLdk&_nc_ht=scontent.fcai21-4.fna&oh=00_AT8G5KrBWacD8R-8U4HqncBvC2DEEAW7BSEHZs1Ex-spxg&oe=61D80F25",
                "2023");
        graduate.experience.add(new Experience("Meta", "London", "Software Engineer"));
        assertEquals(2, controller.signUp(graduate));
    }

    @Test
    void graduationYearNotCorrect() {
        SignController controller = new SignController('G');
        Graduate graduate = new Graduate("Ahmed Samir", "Mail", "01270627231", "I am a Software Engineer at Meta", "23",
                "AAA@gmail.com", "123456789A",
                "https://scontent.fcai21-4.fna.fbcdn.net/v/t39.30808-6/212990641_2066485583492708_1606143835716174366_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=BILwHj7jftEAX_joLdk&_nc_ht=scontent.fcai21-4.fna&oh=00_AT8G5KrBWacD8R-8U4HqncBvC2DEEAW7BSEHZs1Ex-spxg&oe=61D80F25",
                "111");
        graduate.experience.add(new Experience("Meta", "London", "Software Engineer"));
        assertEquals(1, controller.signUp(graduate));
    }

}
