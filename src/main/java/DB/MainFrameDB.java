package DB;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrameDB extends JFrame {
    private JButton addWorker;
    private JButton deleteWorker;
    private JButton changeWorker;
    private JButton findWorker;
    private JButton closeProgramm;
    private final static String[] header = {"Name", "Surname", "Passport"};
    private JTable result;

    MainFrameDB (List<String> workers) {
        this.setSize(800,500);
        this.setTitle("Workers storage");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(5,1));
        addWorker = new JButton("Добавить работника");
        addWorker.setActionCommand("addWorker");

        deleteWorker = new JButton("Удалить работника");
        deleteWorker.setActionCommand("deleteWorker");
        changeWorker = new JButton("Изменить работника");
        changeWorker.setActionCommand("changeWorker");

        findWorker = new JButton("Найти работника");
        findWorker.setActionCommand("findWorker");
        closeProgramm = new JButton("Закрыть программу");
        buttonPanel.add(addWorker);
        buttonPanel.add(deleteWorker);
        buttonPanel.add(changeWorker);
        buttonPanel.add(findWorker);
        buttonPanel.add(closeProgramm);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(1, 1));
        WorkersTableModel model = new WorkersTableModel(workers, header);

        result = new JTable(model);
        leftPanel.add(new JScrollPane(result));
        this.add(leftPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.EAST);

        this.addComponentListener(null);
        this.setVisible(true);
    }
}
