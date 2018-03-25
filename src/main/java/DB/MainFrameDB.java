package DB;

import Collection.*;
import publicClasses.AddWorkerFrame;
import publicClasses.Worker;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrameDB extends JFrame implements ActionListener, ComponentListener {

    private JButton addWorker, deleteWorker, changeWorker, findWorker, closeProgramm;
    private final static String[] header = {"Name", "Surname", "Passport"};
    private JTable table;
    public static WorkersTableModel model;

    MainFrameDB (List<Worker> workers) {
        this.setSize(800,500);
        this.setTitle("Workers storage");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(5,1));
        addWorker = new JButton("Добавить работника");
        addWorker.setActionCommand("addWorker");
        addWorker.addActionListener(this);
        deleteWorker = new JButton("Удалить работника");
        deleteWorker.setActionCommand("deleteWorker");
        deleteWorker.addActionListener(this);
        changeWorker = new JButton("Изменить работника");
        changeWorker.setActionCommand("changeWorker");
        changeWorker.addActionListener(this);

        findWorker = new JButton("Найти работника");
        findWorker.setActionCommand("findWorker");
        findWorker.addActionListener(this);
        closeProgramm = new JButton("Закрыть программу");
        closeProgramm.addActionListener(this);

        buttonPanel.add(addWorker);
        buttonPanel.add(deleteWorker);
        buttonPanel.add(changeWorker);
        buttonPanel.add(findWorker);
        buttonPanel.add(closeProgramm);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(1, 1));
        model = new WorkersTableModel(workers, header);

        table = new JTable(model);
        leftPanel.add(new JScrollPane(table));
        this.add(leftPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.EAST);

        this.addComponentListener(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String res = e.getActionCommand();

        switch (res) {
            case "addWorker":
                new AddWorkerFrame();
                break;
            case "deleteWorker":
                int selectRow = table.getSelectedRow();
                if (selectRow > -1) {
                    WorkersTable.workers.remove(selectRow);
                    MainFrame.workersTable.fireTableDataChanged();
                } else {
                    new DeleteWorkerFrame();
                }
                break;
            case "changeWorker":
                Worker changed = null;
                int selectedRow = table.getSelectedRow();
                if (selectedRow > -1) {
                    changed  = WorkersTable.workers.get(selectedRow);
                }
                new ChangeWorkerFrame(changed);
                break;
            case "findWorker":
                new FindWorkerFrame();
                break;
            default:
                this.dispose();
                break;
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        revalidate();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        revalidate();
    }

    @Override
    public void componentShown(ComponentEvent e) {
        revalidate();
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        revalidate();
    }
}
