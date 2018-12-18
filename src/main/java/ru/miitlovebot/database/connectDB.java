package ru.miitlovebot.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class connectDB {
    private static final String url = "jdbc:mysql://localhost:3306/meetlive?useUnicode=true&characterEncoding=utf-8";
    private static final String user = "root";
    private static final String password = "";

    // JDBC variables for opening and managing connection
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    @SuppressWarnings("finally")
    public List<String> selectPhoneFromDB() {

        String query = "select phone_number from users";
        List<String> listphone = new ArrayList<String>();

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            //   System.out.println("success");
            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String phone = rs.getString(1);
                listphone.add(phone);
                //    System.out.println( phone);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }

            return listphone;
        }
    }

    @SuppressWarnings("finally")
    public String selectSubscribe(String chat_ID) {

        String query = "select Subscribe from users where `chat_id`= '" + chat_ID + "'";
        String subscr = "";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            //   System.out.println("success");
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                subscr = rs.getString(1);

            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }

            return subscr;
        }
    }

    @SuppressWarnings("finally")
    public List<String> selectChatIdFromDB() {

        String query = "select chat_id from users where subscribe=1";
        List<String> listphone = new ArrayList<String>();

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String chatid = rs.getString(1);
                listphone.add(chatid);
                //System.out.println( chatid);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }

            return listphone;
        }
    }

    @SuppressWarnings("finally")
    public String selectChatIdFromPhoto(String photo) {

        String query = "select chat_id from users where photo='" + photo + "'";

        String chatid = "";
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                chatid = rs.getString(1);


            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }

            return chatid;
        }
    }

    @SuppressWarnings("finally")
    public List<String> selectALLChatId() {

        String query = "select chat_id from users ";
        List<String> listphone = new ArrayList<String>();

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String chatid = rs.getString(1);
                listphone.add(chatid);
                //     System.out.println( chatid);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }

            return listphone;
        }
    }


    @SuppressWarnings("finally")
    public String selectStateFromDB(String chat_id) {

        String query = "select State from users where `chat_id`='" + chat_id + "'";

        String state = "99";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            rs.next();

            state = rs.getString(1);


        } catch (SQLException sqlEx) {
            //  sqlEx.printStackTrace();

        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }

            return state;
        }
    }

    @SuppressWarnings("finally")
    public List<String> selectPeople(String chat_id) {

        String query = "SELECT `chat_id`,`first_name`,`photo`,`descriprion`,`age` FROM `users`"
                + " where sex!='" + selectSexMe(chat_id) + "' AND `descriprion`!='NULL' ORDER BY RAND() LIMIT 1";
        List<String> infoall = new ArrayList<String>();
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            rs.next();
            for (int i = 1; i < 6; i++)
                infoall.add(rs.getString(i));


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }

            return infoall;
        }


    }

    @SuppressWarnings("finally")
    public List<String> selectMe(String chatid) {

        String query = "SELECT `chat_id`,`first_name`,`photo`,`descriprion`,`age` FROM `users` where `chat_id`= '" + chatid + "'";
        List<String> infoall = new ArrayList<String>();
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            rs.next();
            for (int i = 1; i < 6; i++)
                infoall.add(rs.getString(i));


        } catch (SQLException sqlEx) {
            // sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }

            return infoall;
        }


    }

    @SuppressWarnings("finally")
    public List<String> selectALLPhoto() {

        String query = "SELECT `photo` FROM `users`";
        List<String> infoall = new ArrayList<String>();
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {

                infoall.add(rs.getString(1));
            }


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }

            return infoall;
        }


    }

    @SuppressWarnings("finally")
    public String selectSexMe(String chatid) {

        String query = "SELECT `sex` FROM `users` where `chat_id`= '" + chatid + "'";
        String sex = "";
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            rs.next();
            sex = rs.getString(1);


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }

            return sex;
        }


    }

    @SuppressWarnings("finally")
    public List<String> selectMeEnd(String chatid) {

        String query = "SELECT `first_name`,`phone_number` FROM `users` where `chat_id`= '" + chatid + "'";
        List<String> infoall = new ArrayList<String>();
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            rs.next();
            for (int i = 1; i < 3; i++)
                infoall.add(rs.getString(i));


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }

            return infoall;
        }


    }

    public void InsertUserToDB(String chatid, String phone, String name, String lastname, String nick) {

        //String chatid,String phone,String name,String lastname,String nick,int sub
        String query = "INSERT INTO `users`(`chat_id`, `phone_number`, `first_name`, `last_name`, `Nick_name`) "
                + "VALUES (" + chatid + ",'" + phone + "','" + name + "','" + lastname + "','" + nick + "')";
        UpdateSQL(query);


    }

    public void DeleteUserToDB(String chatid) {


        String query = "DELETE FROM `users` WHERE `chat_id`='" + chatid + "'";
        UpdateSQL(query);


    }

    public void UpdatePhotoAll(String photo, int i) {
        //String chatid,String phone,String name,String lastname,String nick,int sub
        //String query = "UPDATE `users` SET `Subscribe`= " + Subscribe + "WHERE 'chat_id' = '"+chatid;
        String query = "UPDATE `users` SET `photo`= '" + photo + "' WHERE `num` = " + i;

        UpdateSQL(query);
    }

    public void UpdateLocation(String chatid, String location) {
        //String chatid,String phone,String name,String lastname,String nick,int sub
        //String query = "UPDATE `users` SET `Subscribe`= " + Subscribe + "WHERE 'chat_id' = '"+chatid;
        String query = "UPDATE `users` SET `location`= '" + location + "' WHERE `chat_id` = '" + chatid + "'";

        UpdateSQL(query);
    }

    public void UpdateState(String chat_id, int state) {
        String query = "UPDATE `users` SET `State`= " + state + " WHERE `chat_id` = '" + chat_id + "'";

        UpdateSQL(query);
    }

    public void UpdateSex(String chat_id, int state) {
        String query = "UPDATE `users` SET `Sex`= " + state + " WHERE `chat_id` = '" + chat_id + "'";

        UpdateSQL(query);
    }

    public void UpdatePhoto(String chat_id, String photo) {
        String query = "UPDATE `users` SET `photo`= '" + photo + "' WHERE `chat_id` = '" + chat_id + "'";

        UpdateSQL(query);
    }

    public void UpdateDiscription(String chat_id, String text) {
        String query = "UPDATE `users` SET `descriprion`= '" + text + "' WHERE `chat_id` = '" + chat_id + "'";

        UpdateSQL(query);
    }

    public void UpdateAge(String chat_id, int state) {
        String query = "UPDATE `users` SET `Age`= " + state + " WHERE `chat_id` = '" + chat_id + "'";

        UpdateSQL(query);
    }

    public void UpdateSQL(String query) {
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            //  System.out.println("success");
            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            stmt.executeUpdate(query);


        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }

        }
    }

    ;

    public void UpdateSubscribe(String chatid, int Subscribe) {
        //String chatid,String phone,String name,String lastname,String nick,int sub
        //String query = "UPDATE `users` SET `Subscribe`= " + Subscribe + "WHERE 'chat_id' = '"+chatid;
        String query = "UPDATE `users` SET `Subscribe`= " + Subscribe + " WHERE `chat_id` = '" + chatid + "'";

        UpdateSQL(query);
    }


    public void InsertNewToDB(String title, String data, String description, String image, String urlnew) {
        //String chatid,String phone,String name,String lastname,String nick,int sub
        String query = "INSERT INTO `news`( `title`, `data`, `description`, `image`, `url`) "
                + "VALUES ('" + title + "','" + data + "','" + description + "','" + image + "','" + urlnew + "')";

        UpdateSQL(query);
    }
}
