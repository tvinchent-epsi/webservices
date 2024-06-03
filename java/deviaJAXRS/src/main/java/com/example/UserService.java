package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class UserService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getUsers() {
        List<String> users = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/securite";
            String utilisateur = "root";
            String motDePasse = "";
            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            Statement declaration = connexion.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet resultat = declaration.executeQuery(sql);
            while (resultat.next()) {
                users.add(resultat.getString("login"));
            }
            connexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
