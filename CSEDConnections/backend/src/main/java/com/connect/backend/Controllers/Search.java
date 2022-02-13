package com.connect.backend.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Search {
    public List<post> searchPosts(List<post> p, String s) {

        List<post> result = new ArrayList<>();

        for (int i = 0; i < p.size(); ++i) {
            System.out.println(p.get(i).toString());
            if (match(p.get(i).toString(), s)) {
                result.add(p.get(i));
            }

        }
        return result;
    }

    List<Graduate> searchGraduates(List<Graduate> g, String s) {

        List<Graduate> result = new ArrayList<>();

        for (int i = 0; i < g.size(); ++i) {
            if (match(g.get(i).toString(), s) || match(g.get(i).experience.toString(), s)) {
                result.add(g.get(i));
            }

        }
        return result;
    }

    boolean match(String text, String s) {

        String keyWords[] = s.split(" ");

        // search in the text for s
        for (String word : keyWords) {
            System.out.println("=======" + word);
            if (Pattern.matches(new String("(.*)" + word + "(.*)"), text))
                return true;
        }

        return false;
    }
}
