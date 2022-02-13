package com.connect.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.connect.backend.Controllers.DisplayController;
import com.connect.backend.Controllers.DisplayedGrads;
import com.connect.backend.Controllers.Graduate;

import org.junit.jupiter.api.Test;

public class DisplayTest {
    boolean equals(List<DisplayedGrads> expected, List<DisplayedGrads> actual) {
        if (expected.size() != actual.size())
            return false;
        for (int i = 0; i < expected.size(); i++) {
            DisplayedGrads expectedGrad = expected.get(i);
            DisplayedGrads actualGrad = actual.get(i);
            if (!expectedGrad.equalsTo(actualGrad)) {
                System.out.println(i);
                return false;
            }
        }
        return true;
    }

    @Test
    void selectGraduate() {
        DisplayController controller = new DisplayController();
        Graduate actual = controller.selectGraduate("Ahmed@gmail.com");
        assertEquals("Ahmed Samir", actual.name);
        assertEquals("01270627231", actual.phone);
        assertEquals("Ahmed@gmail.com", actual.mail);
        assertEquals("2023-01-01", actual.graduationYear);
        assertEquals("23", actual.age);
        assertEquals("Meta", actual.experience.get(0).companyName);
        assertEquals("London", actual.experience.get(0).location);
    }

    @Test
    void DisplayWithoutSearchNULL() {
        DisplayController controller = new DisplayController();
        List<DisplayedGrads> actual = controller.Display(null);
        List<DisplayedGrads> expected = new ArrayList<>();
        expected.add(new DisplayedGrads("Ahmed Samir", "Ahmed@gmail.com", "Meta", "London",
                "https://scontent.fcai21-4.fna.fbcdn.net/v/t39.30808-6/212990641_2066485583492708_1606143835716174366_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=BILwHj7jftEAX_joLdk&_nc_ht=scontent.fcai21-4.fna&oh=00_AT8G5KrBWacD8R-8U4HqncBvC2DEEAW7BSEHZs1Ex-spxg&oe=61D80F25"));
        expected.add(new DisplayedGrads("Abdelrahman Elmeniawy", "elmeniawy@gmail.com", "google", "ss", "ss"));
        expected.add(new DisplayedGrads("Moaz Ahmed", "moaz@gmail.com", "google", "dss", "ssss"));
        expected.add(new DisplayedGrads("neno google", "neno@gmail.com", "ggg", "egy", "sssxccv"));
        assertTrue(equals(expected, actual));
    }

    @Test
    void DisplayWithoutSearchBlank0() {
        DisplayController controller = new DisplayController();
        List<DisplayedGrads> actual = controller.Display("");
        List<DisplayedGrads> expected = new ArrayList<>();
        expected.add(new DisplayedGrads("Ahmed Samir", "Ahmed@gmail.com", "Meta", "London",
                "https://scontent.fcai21-4.fna.fbcdn.net/v/t39.30808-6/212990641_2066485583492708_1606143835716174366_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=BILwHj7jftEAX_joLdk&_nc_ht=scontent.fcai21-4.fna&oh=00_AT8G5KrBWacD8R-8U4HqncBvC2DEEAW7BSEHZs1Ex-spxg&oe=61D80F25"));
        expected.add(new DisplayedGrads("Abdelrahman Elmeniawy", "elmeniawy@gmail.com", "google", "ss", "ss"));
        expected.add(new DisplayedGrads("Moaz Ahmed", "moaz@gmail.com", "google", "dss", "ssss"));
        expected.add(new DisplayedGrads("neno google", "neno@gmail.com", "ggg", "egy", "sssxccv"));
        assertTrue(equals(expected, actual));
    }

    @Test
    void DisplayWithoutSearchBlank1() {
        DisplayController controller = new DisplayController();
        List<DisplayedGrads> actual = controller.Display(" ");
        List<DisplayedGrads> expected = new ArrayList<>();
        expected.add(new DisplayedGrads("Ahmed Samir", "Ahmed@gmail.com", "Meta", "London",
                "https://scontent.fcai21-4.fna.fbcdn.net/v/t39.30808-6/212990641_2066485583492708_1606143835716174366_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=BILwHj7jftEAX_joLdk&_nc_ht=scontent.fcai21-4.fna&oh=00_AT8G5KrBWacD8R-8U4HqncBvC2DEEAW7BSEHZs1Ex-spxg&oe=61D80F25"));
        expected.add(new DisplayedGrads("Abdelrahman Elmeniawy", "elmeniawy@gmail.com", "google", "ss", "ss"));
        expected.add(new DisplayedGrads("Moaz Ahmed", "moaz@gmail.com", "google", "dss", "ssss"));
        expected.add(new DisplayedGrads("neno google", "neno@gmail.com", "ggg", "egy", "sssxccv"));
        assertTrue(equals(expected, actual));
    }

    @Test
    void DisplayWithoutSearchBlank2() {
        DisplayController controller = new DisplayController();
        List<DisplayedGrads> actual = controller.Display("      ");
        List<DisplayedGrads> expected = new ArrayList<>();
        expected.add(new DisplayedGrads("Ahmed Samir", "Ahmed@gmail.com", "Meta", "London",
                "https://scontent.fcai21-4.fna.fbcdn.net/v/t39.30808-6/212990641_2066485583492708_1606143835716174366_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=BILwHj7jftEAX_joLdk&_nc_ht=scontent.fcai21-4.fna&oh=00_AT8G5KrBWacD8R-8U4HqncBvC2DEEAW7BSEHZs1Ex-spxg&oe=61D80F25"));
        expected.add(new DisplayedGrads("Abdelrahman Elmeniawy", "elmeniawy@gmail.com", "google", "ss", "ss"));
        expected.add(new DisplayedGrads("Moaz Ahmed", "moaz@gmail.com", "google", "dss", "ssss"));
        expected.add(new DisplayedGrads("neno google", "neno@gmail.com", "ggg", "egy", "sssxccv"));
        assertTrue(equals(expected, actual));
    }

    @Test
    void DisplayWithSearch0() {
        DisplayController controller = new DisplayController();
        List<DisplayedGrads> actual = controller.Display("google");
        List<DisplayedGrads> expected = new ArrayList<>();
        expected.add(new DisplayedGrads("Abdelrahman Elmeniawy", "elmeniawy@gmail.com", "google", "ss", "ss"));
        expected.add(new DisplayedGrads("Moaz Ahmed", "moaz@gmail.com", "google", "dss", "ssss"));
        expected.add(new DisplayedGrads("neno google", "neno@gmail.com", "ggg", "egy", "sssxccv"));
        assertTrue(equals(expected, actual));
    }

    @Test
    void DisplayWithSearch1() {
        DisplayController controller = new DisplayController();
        List<DisplayedGrads> actual = controller.Display("Meta");
        List<DisplayedGrads> expected = new ArrayList<>();
        expected.add(new DisplayedGrads("Ahmed Samir", "Ahmed@gmail.com", "Meta", "London",
                "https://scontent.fcai21-4.fna.fbcdn.net/v/t39.30808-6/212990641_2066485583492708_1606143835716174366_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=BILwHj7jftEAX_joLdk&_nc_ht=scontent.fcai21-4.fna&oh=00_AT8G5KrBWacD8R-8U4HqncBvC2DEEAW7BSEHZs1Ex-spxg&oe=61D80F25"));
        expected.add(new DisplayedGrads("Abdelrahman Elmeniawy", "elmeniawy@gmail.com", "google", "ss", "ss"));
        assertTrue(equals(expected, actual));
    }

    @Test
    void DisplayWithSearch2() {
        DisplayController controller = new DisplayController();
        List<DisplayedGrads> actual = controller.Display("Ahmed");
        List<DisplayedGrads> expected = new ArrayList<>();
        expected.add(new DisplayedGrads("Ahmed Samir", "Ahmed@gmail.com", "Meta", "London",
                "https://scontent.fcai21-4.fna.fbcdn.net/v/t39.30808-6/212990641_2066485583492708_1606143835716174366_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=BILwHj7jftEAX_joLdk&_nc_ht=scontent.fcai21-4.fna&oh=00_AT8G5KrBWacD8R-8U4HqncBvC2DEEAW7BSEHZs1Ex-spxg&oe=61D80F25"));
        expected.add(new DisplayedGrads("Moaz Ahmed", "moaz@gmail.com", "google", "dss", "ssss"));
        assertTrue(equals(expected, actual));
    }

    @Test
    void DisplayWithSearch3() {
        DisplayController controller = new DisplayController();
        List<DisplayedGrads> actual = controller.Display("2023");
        List<DisplayedGrads> expected = new ArrayList<>();
        expected.add(new DisplayedGrads("Ahmed Samir", "Ahmed@gmail.com", "Meta", "London",
                "https://scontent.fcai21-4.fna.fbcdn.net/v/t39.30808-6/212990641_2066485583492708_1606143835716174366_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=BILwHj7jftEAX_joLdk&_nc_ht=scontent.fcai21-4.fna&oh=00_AT8G5KrBWacD8R-8U4HqncBvC2DEEAW7BSEHZs1Ex-spxg&oe=61D80F25"));
        expected.add(new DisplayedGrads("Moaz Ahmed", "moaz@gmail.com", "google", "dss", "ssss"));
        assertTrue(equals(expected, actual));
    }

    @Test
    void DisplayWithSearchNotExist0() {
        DisplayController controller = new DisplayController();
        List<DisplayedGrads> actual = controller.Display("2019");
        List<DisplayedGrads> expected = new ArrayList<>();
        assertTrue(equals(expected, actual));
    }

    @Test
    void DisplayWithSearchNotExist2() {
        DisplayController controller = new DisplayController();
        List<DisplayedGrads> actual = controller.Display("Apple");
        List<DisplayedGrads> expected = new ArrayList<>();
        assertTrue(equals(expected, actual));
    }

}
