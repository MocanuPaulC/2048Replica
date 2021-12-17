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
    public static ResultSet getScoresTable(Connection connection){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, to_char(date_of_play,'YYYY-MM-DD HH:MI:SS'),score FROM int_leaderboard ORDER BY score DESC FETCH FIRST 5 ROWS ONLY ");
            return resultSet;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getScoresName(Connection connection, String name){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, to_char(date_of_play,'YYYY-MM-DD HH:MI:SS'),score FROM int_leaderboard WHERE name='"+name+"' ORDER BY score DESC FETCH FIRST 5 ROWS ONLY ");
            return resultSet;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
