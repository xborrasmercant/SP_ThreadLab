package CustomUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AgentsTable extends JTable {

    public AgentsTable() {
        createTableStructure();
    }

    public void createTableStructure () {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Agent");
        model.addColumn("Started");
        model.addColumn("Terminated");

        model.addRow(new Object[]{"Producer", "0", "0"});
        model.addRow(new Object[]{"Consumer", "0", "0"});

        setModel(model);
    }
}
