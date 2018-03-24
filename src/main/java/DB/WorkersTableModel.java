package DB;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class WorkersTableModel extends AbstractTableModel {

    public static String[] header;
    public static List<String> workers = new ArrayList<>(WorkerStorageDB.getWorkers());
    public static String name;
    public static String surname;
    public static String passport;
    WorkersTableModel(List<String> workers, String[] header) {
        this.workers = workers;
        this.header = header;
    }

    public String getColumnName(int c) {
        return header[c];
    }

    public int getRowCount() {
        return workers.size();
    }

    public int getColumnCount() {
        return header.length;
    }

    public Object getValueAt(int r, int c) {
        String[] temp;
        temp = workers.get(r).split(",");
        switch (c) {
            case 0:
                return temp[0];
            case 1:
                return temp[1];
            case 2:
                return temp[2];
            default:
                return "";
        }
    }
}
