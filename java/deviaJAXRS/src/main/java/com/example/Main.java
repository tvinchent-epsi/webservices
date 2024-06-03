package com.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello MySQL!");
        try {
            // Étape 1: Charger le pilote JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Étape 2: Établir une connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/securite";
            String utilisateur = "root";
            String motDePasse = "";
            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

            // Étape 3: Créer une déclaration
            Statement declaration = connexion.createStatement();

            // Étape 4: Exécuter une requête
            String sql = "SELECT * FROM user";
            ResultSet resultat = declaration.executeQuery(sql);

            // Étape 5: Traiter le résultat
            while (resultat.next()) {
                System.out.println(resultat.getString("login"));
            }

            // Étape 6: Fermer la connexion
            connexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}