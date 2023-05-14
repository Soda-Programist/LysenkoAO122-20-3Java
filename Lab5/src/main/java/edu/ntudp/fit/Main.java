package edu.ntudp.fit;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres","151280");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM \"students\"");
            int month = 1;
            while (resultSet.next()){
                if (resultSet.getDate(5).getMonth()==(month-1)){
                    System.out.println(resultSet.getString(1)+". "+
                            resultSet.getString(3)+" "+
                            resultSet.getString(2).substring(0,1)+"."+
                            resultSet.getString(4).substring(0,1)+". "+
                            resultSet.getString(5)+" "+
                            resultSet.getString(6));
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}