package com.connect.backend.DatabaseLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connect.backend.Controllers.DisplayedGrads;
import com.connect.backend.Controllers.Experience;
import com.connect.backend.Controllers.Graduate;
import com.connect.backend.Controllers.Social;
import com.connect.backend.Controllers.Student;
import com.connect.backend.Controllers.post;

public class Database {
    private String url = "jdbc:mysql://127.0.0.1:3306/csedconnections";
    private String username = "root";
    private String password = "root";
    private String tableName;

    public Database() {
    }

    public Database(char type) {
        tableName = (type == 'S') ? "student" : "graduate";
    }

    String loggeduser = null;

    public boolean signIn(String email, String pass) {
        loggeduser = email;
        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            String q = "select email" +
                    " from " + tableName +
                    " where email = '" + email + "'" +
                    " AND password = '" + pass + "'";
            System.out.println(q);
            ResultSet result = statement.executeQuery(q);

            boolean exist = result.next();

            connection.close();
            System.out.println("Database connection closed!");
            return exist;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public boolean existsBefore(String email) {

        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            System.out.println("select email" +
                    " from " + tableName +
                    " where email = '" + email + "'");
            ResultSet result = statement.executeQuery("select email" +
                    " from " + tableName +
                    " where email = '" + email + "'");

            boolean exist = result.next();

            connection.close();
            System.out.println("Database connection closed!");
            return exist;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public boolean signUp(Graduate graduate) {
        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            Experience experience = graduate.experience.get(0);
            try {
                String query = "insert into graduate values ('" + graduate.mail + "' , '" + graduate.name + "' , '"
                        + graduate.age
                        + "' , '" + graduate.gender + "' , '" + graduate.phone + "' , '" + graduate.password + "' , '"
                        + graduate.img + "' , '"
                        + graduate.about + "' , '" + graduate.graduationYear + "' )";
                System.out.println(query);
                statement.executeUpdate(query);
                System.out.println("hhh");
                statement.executeUpdate(
                        "insert into experience values ('" + graduate.mail + "' , '" + experience.companyName + "' , '"
                                + experience.location + "' , '" + experience.position + "','" + experience.startDate
                                + "','" + experience.endDate + "')");
            } catch (Exception e) {
                System.out.println("insertion failed");
                return false;
            }

            System.out.println("inserted successfully ");
            connection.close();
            System.out.println("Database connection closed!");
            return true;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public boolean signUp(Student student) {
        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            System.out.println("inserted successfully ");
            connection.close();
            System.out.println("Database connection closed!");
            return true;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public List<Graduate> getGraduates() {
        List<Graduate> displayedGrads = new ArrayList<>();

        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet tuple = statement.executeQuery(
                    "select * " +
                            "from graduate JOIN experience " +
                            "on experience.email=graduate.email");

            while (tuple.next()) {
                System.out.println("33333333333333");
                Graduate grad = new Graduate();
                try {
                    grad.mail = tuple.getString("email");
                    grad.img = tuple.getString("imageURL");
                    grad.name = tuple.getString("name");
                    grad.gender = tuple.getString("gender");
                    grad.phone = tuple.getString("phone");
                    grad.about = tuple.getString("about");
                    grad.age = tuple.getString("Bdate");
                    grad.graduationYear = tuple.getString("grad_year");
                    Experience experience = new Experience(tuple.getString("company"),
                            tuple.getString("location"), tuple.getString("start_date"),
                            tuple.getString("end_date"), tuple.getString("position"));
                    grad.experience.add(experience);
                    System.out.println("1111111111111111111");
                    /*
                     * ResultSet extuple = statement.executeQuery(
                     * "select * from experience where email = '" + grad.mail + "'");
                     * while (extuple.next()) {
                     * Experience experience = new Experience(extuple.getString("company"),
                     * extuple.getString("location"), extuple.getString("start_date"),
                     * extuple.getString("end_date"), extuple.getString("position"));
                     * grad.experience.add(experience);
                     * 
                     * }
                     */
                    System.out.println("2222222222222222222");
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                // System.out.println(gradtemp.name);
                displayedGrads.add(grad);

            }

            connection.close();
            System.out.println("Database connection closed!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return displayedGrads;
    }

    public Graduate opengraduateDB(String email) {
        Graduate grad = new Graduate();
        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet tuple = statement.executeQuery(
                    "select * " +
                            "from graduate JOIN experience " +
                            "on experience.email=graduate.email" +
                            " where graduate.email='" + email + "'");

            while (tuple.next()) {
                System.out.println("33333333333333");
                grad.mail = tuple.getString("email");
                grad.img = tuple.getString("imageURL");
                grad.name = tuple.getString("name");
                grad.gender = tuple.getString("gender");
                grad.phone = tuple.getString("phone");
                grad.about = tuple.getString("about");
                grad.age = tuple.getString("Bdate");
                grad.graduationYear = tuple.getString("grad_year");
                Experience experience = new Experience(tuple.getString("company"),
                        tuple.getString("location"), tuple.getString("start_date"),
                        tuple.getString("end_date"), tuple.getString("position"));
                grad.experience.add(experience);
                System.out.println("1111111111111111111");
            }

            connection.close();
            System.out.println("Database connection closed!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return grad;
    }

    public void createPost(String email, String name, String post) {

        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            String q = "insert into posts values ('" + email + "' ,' " + name + " ' ,'" + post + "')";
            System.out.println(q);
            statement.executeUpdate(q);

            connection.close();
            System.out.println("Database connection closed!");

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public List<post> getPosts() {
        List<post> posts = new ArrayList<>();

        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet tuple = statement.executeQuery(
                    "select * from posts ");

            while (tuple.next()) {
                System.out.println("33333333333333");
                post POST = new post();
                try {
                    POST.email = tuple.getString("email");
                    POST.name = tuple.getString("name");
                    POST.post = tuple.getString("post");

                    System.out.println("2222222222222222222");
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                // System.out.println(gradtemp.name);
                posts.add(POST);

            }

            connection.close();
            System.out.println("Database connection closed!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return posts;
    }

    public void AddSocialdb(String email, String facebook, String linkedin) {

        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            String q = "insert into sociallinks values ('" + email + "' ,' " + facebook + " ' ,'" + linkedin + "')";
            System.out.println(q);
            statement.executeUpdate(q);

            connection.close();
            System.out.println("Database connection closed!");

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public Social getsocialdb(String email) {
        Social social = new Social();
        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet tuple = statement.executeQuery(
                    "select * " +
                            "from graduate JOIN sociallinks " +
                            "on sociallinks.email=graduate.email" +
                            " where graduate.email='" + email + "'");

            while (tuple.next()) {
                System.out.println("33333333333333");
                social.facebook = tuple.getString("facebook");
                social.linkedin = tuple.getString("linkedin");

                System.out.println("1111111111111111111");
            }

            connection.close();
            System.out.println("Database connection closed!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return social;
    }
}
