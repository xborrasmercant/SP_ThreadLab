package CustomUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CustomTable extends JTable {

    public CustomTable(String tableType) {
        if (tableType.equals("Agent")) {
            createAgentTableStructure();
        } else if (tableType.equals("Thread")) {
            createThreadTableStructure();
        }
    }

    public void createAgentTableStructure () {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Agent");
        model.addColumn("Started");
        model.addColumn("Terminated");

        model.addRow(new Object[]{"Producer", "0", "0"});
        model.addRow(new Object[]{"Consumer", "0", "0"});

        setModel(model);
    }

    public void createThreadTableStructure () {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Status");
        model.addColumn("Total");
        model.addColumn("Average");

        model.addRow(new Object[]{"Created", "0", "0"});
        model.addRow(new Object[]{"Started", "0", "0"});

        setModel(model);
    }
}
