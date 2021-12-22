package classes;

import java.sql.*;

public class DB_manipulator {
    public static Connection initializeDatabase() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DB2048", "postgres", "coltulderai.8");

            Statement statement = connection.createStatement();
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS INT_leaderboard
                    (
                        name VARCHAR(50)
                            constraint ch_name_length check ( LENGTH(name) <= 20 ),
                        date_of_play TIMESTAMP,
                        score NUMERIC(5)
                        constraint ch_score check ( score >= 0 )
                    );
                                        
                    CREATE TABLE IF NOT EXISTS INT_players
                    (
                        playerid   numeric(3)
                            constraint pk_player PRIMARY KEY,
                        name VARCHAR(50)
                            constraint ch_name_length check ( LENGTH(name) <= 50 )

                    );


                    CREATE TABLE IF NOT EXISTS INT_Boards
                    (
                        playerid    numeric(3)
                            constraint fk_board_player references INT_players (playerid),
                        boardid numeric(3)
                            constraint pk_boards PRIMARY KEY,
                        score numeric(4)
                            constraint ch_score check ( score >= 0 )
                    );


                    CREATE TABLE IF NOT EXISTS INT_squares
                    (
                        squareid numeric(2),
                        boardid numeric(3)
                            constraint fk_boards references INT_boards(boardid),
                        value numeric(4),
                        constraint pk_squares PRIMARY KEY(squareid, boardid)
                    );

                    CREATE SEQUENCE IF NOT EXISTS seq_player_id START WITH 1 INCREMENT BY 1;
                    CREATE SEQUENCE IF NOT EXISTS seq_board_id START WITH 1 INCREMENT BY 1;

                    """);
            statement.close();
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void newSaveGame(Connection connection, int score, String name, Square[][] squares) {
        int squareid = 1;

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO  int_players values (nextval('seq_player_id'),'" + name + "')");
            statement.executeUpdate("INSERT INTO int_boards values (currval('seq_player_id'),nextval('seq_board_id')," + score + ")");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    statement.executeUpdate("INSERT INTO int_squares values (" + squareid++ + ",currval('seq_board_id')," + squares[i][j].getValue() + ")");
                }
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void replaceSaveGame(Connection connection, int score, String name, Square[][] squares) {
        int squareid = 1;
        int playerid = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT playerid FROM int_players WHERE name ='" + name + "'");
            while (resultSet.next()) {
                playerid = resultSet.getInt(1);
            }
            statement.executeUpdate("UPDATE int_boards SET score=" + score + " WHERE boardid=" + playerid + "");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    statement.executeUpdate("UPDATE int_squares SET value =" + squares[i][j].getValue() + " WHERE boardid =" + playerid + " AND squareid=" + squareid++ + "");
                }
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkSaveGameExists(Connection connection, String name) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT playerid FROM int_players WHERE name ='" + name + "'");
            while (resultSet.next()) {


                statement.close();
                resultSet.close();
                return true;
            }
            resultSet.close();
            statement.close();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ResultSet loadGame(Connection connection, String name) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT value FROM int_squares sq" +
                    " JOIN int_boards ib on sq.boardid = ib.boardid " +
                    " JOIN int_players ip on ip.playerid = ib.playerid" +
                    " WHERE ip.name='" + name + "'");
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//     public static void checkSaveGameExists(Connection connection, int score, String name, Square[][] squares){
//        int playerid;
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT playerid FROM int_players WHERE name ='"+name+"'");
//            while (resultSet.next()){
//
//                playerid=resultSet.getInt(1);
//                replaceSaveGame(connection,score,name,squares,playerid);
//                statement.close();
//                resultSet.close();
//                return;
//            }
//            resultSet.close();
//            statement.close();
//            newSaveGame(connection,score,name,squares);
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//    }

    public static void insertValues(Connection connection, int score, String name) {

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(" INSERT INTO INT_leaderboard VALUES ('" + name + "',current_timestamp," + score + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ResultSet getScoresTable(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, to_char(date_of_play,'YYYY-MM-DD HH:MI:SS'),score FROM int_leaderboard ORDER BY score DESC FETCH FIRST 5 ROWS ONLY ");
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getScoresName(Connection connection, String name) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, to_char(date_of_play,'YYYY-MM-DD HH:MI:SS'),score FROM int_leaderboard WHERE name='" + name + "' ORDER BY score DESC FETCH FIRST 5 ROWS ONLY ");
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
