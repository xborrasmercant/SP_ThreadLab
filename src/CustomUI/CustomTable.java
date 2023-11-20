package CustomUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CustomTable extends JTable {

    public CustomTable(String tableType) {
        if (tableType.equals("Agent")) {
            createAgentTableStructure();
        } else if (tableType.equals("Thread")) {
            createThreadTableStructure();
        } else if (tableType.equals("Amounts")) {
            createAmountsTableStructure();
        }
    }

    public void createAgentTableStructure () {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Agent Type");
        model.addColumn("Started");
        model.addColumn("Terminated");
        model.addColumn("Processing");
        model.addColumn("Items");


        model.addRow(new Object[]{"Producer", "0", "0", "0", "0"});
        model.addRow(new Object[]{"Consumer", "0", "0", "0", "0"});

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

    public void createAmountsTableStructure () {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Agent Type");
        model.addColumn("Agents Qty");
        model.addColumn("Product Qty");

        model.addRow(new Object[]{"Producer", "200", "100"});
        model.addRow(new Object[]{"Consumer", "400", "100"});

        setModel(model);
    }

}
