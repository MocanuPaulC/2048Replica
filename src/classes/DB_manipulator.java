package classes;

import java.sql.*;

public class DB_manipulator {
    public static Connection initializeDatabase(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DB2048","postgres","coltulderai.8");

            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS INT_leaderboard(" +
                    "name VARCHAR(50) ," +
                    "date_of_play TIMESTAMP," +
                    "score NUMERIC(5))");
            statement.close();
            return connection;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void insertValues(Connection connection, int score, String name){

        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(" INSERT INTO INT_leaderboard VALUES ('"+name+"',current_timestamp," +score +")");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static ResultSet getScores(Connection connection){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM int_leaderboard ORDER BY score DESC FETCH FIRST 5 ROWS ONLY ");
            return resultSet;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
