package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerStorageDB{

    private static String name;
    private static String surname;
    private static int passport;

    private static List<String> workers = new ArrayList<>();

    public static void viewAllWorkers(Connection connection) throws SQLException {
        Statement statement  = connection.createStatement();

        boolean success = statement.execute("SELECT * FROM workers;");
        if (success) {
            //Объект с данными-результатами запроса
            ResultSet resultSet = statement.getResultSet();

            //метод next переключается на следующую строчку и возвращает true,
            //если в ней есть результат
            while (resultSet.next()) {
                name = resultSet.getString("name");
                surname = resultSet.getString("surname");
                passport  = resultSet.getInt("passport");
                workers.add(name + "," + surname + "," + passport);
            }

        }

    }

    public static List<String> getWorkers() {
        return workers;
    }

    /*public static void setWorkers(List<String> workers) {
        WorkerStorageDB.workers = workers;
    }*/

    public static String getName() {
        return name;
    }

    /*public static void setName(String name) {
        WorkerStorageDB.name = name;
    }*/

    public static String getSurname() {
        return surname;
    }

    /*public static void setSurname(String surname) {
        WorkerStorageDB.surname = surname;
    }*/

    public static int getPassport() {
        return passport;
    }

    /*public static void setPassport(int passport) {
        WorkerStorageDB.passport = passport;
    }*/

}
