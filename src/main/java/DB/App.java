package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Workers",
                    "postgres", "");


        WorkerStorageDB.viewAllWorkers(connection);

        new MainFrameDB(WorkerStorageDB.getWorkers());
        connection.setAutoCommit(false);
        connection.close();
    }

}
