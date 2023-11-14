import CustomUI.CustomTable;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StatisticsPanel extends JPanel{
    private CustomTable agentTable, threadTable;

    public StatisticsPanel() {
        configurePanel();
        addComponentsToPanel();
    }

    public void addComponentsToPanel() {
        GridBagConstraints c = new GridBagConstraints();
        Font tableTitleFont = new Font("SansSerif", Font.BOLD, 16);


        // LABEL Creation
        JLabel agentsLabel = new JLabel("Agents Involved Table", SwingConstants.CENTER);
        JLabel threadsLabel = new JLabel("Thread Time Table", SwingConstants.CENTER);

        // COMPONENTS Initialization
        agentTable = new CustomTable("Agent");
        threadTable = new CustomTable("Thread");

        // DEFAULT Config
        agentsLabel.setFont(tableTitleFont);
        threadsLabel.setFont(tableTitleFont);
        c.fill = GridBagConstraints.HORIZONTAL;


        // AGENTS Table
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 0, 5);
        add(agentsLabel, c);                                        // Label

        c.gridy++;
        add(agentTable.getTableHeader(), c);                        // Header

        c.gridy++;
        c.insets = new Insets(0, 5, 5, 5);
        add(agentTable, c);                                         // Table

        // THREAD Table
        c.gridx = 0;
        c.gridy++;
        c.insets = new Insets(5, 5, 0, 5);
        add(threadsLabel, c);                                       // Label

        c.gridy++;
        add(threadTable.getTableHeader(), c);                       // Header

        c.gridy++;
        c.insets = new Insets(0, 5, 5, 5);
        add(threadTable, c);                                        //Table

    }

    public void configurePanel() {
        Border blackBorder = BorderFactory.createLineBorder(Color.black);
        setBorder(blackBorder);
        setLayout(new GridBagLayout());
    }

    public CustomTable getAgentTable() {
        return agentTable;
    }

    public void setAgentTable(CustomTable agentTable) {
        this.agentTable = agentTable;
    }

    public CustomTable getThreadTable() {
        return threadTable;
    }

    public void setThreadTable(CustomTable threadTable) {
        this.threadTable = threadTable;
    }
}