import CustomUI.CustomTable;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StatisticsPanel extends JPanel{
    private JTextField peCounter, ceCounter, pfCounter, cfCounter, startTime, endTime;
    private CustomTable agentTable, threadTable;

    public StatisticsPanel() {
        configurePanel();
        addComponentsToPanel();
    }

    public void addComponentsToPanel() {
        GridBagConstraints c = new GridBagConstraints();

        // LABEL Creation
        JLabel pe = new JLabel("Productores empezados:");
        JLabel ce = new JLabel("Consumidores empezados:");
        JLabel pf = new JLabel("Productores finalizados:");
        JLabel cf = new JLabel("Consumidores finalizados:");
        JLabel start = new JLabel("Started:");
        JLabel end = new JLabel("Ended:");

        // COMPONENTS Initialization
        this.peCounter = new JTextField("0");
        this.ceCounter = new JTextField("0");
        this.pfCounter = new JTextField("0");
        this.cfCounter = new JTextField("0");
        this.startTime = new JTextField("0");
        this.endTime = new JTextField("0");
        agentTable = new CustomTable("Agent");
        threadTable = new CustomTable("Thread");

        // DEFAULT Config
        c.fill = GridBagConstraints.HORIZONTAL;

        // AGENTS Table
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 0, 5);
        add(agentTable.getTableHeader(), c);

        c.gridy++;
        c.insets = new Insets(0, 5, 5, 5);
        add(agentTable, c);

        // THREAD Table
        c.gridx = 0;
        c.gridy++;
        c.insets = new Insets(5, 5, 0, 5);
        add(threadTable.getTableHeader(), c);

        c.gridy++;
        c.insets = new Insets(0, 5, 5, 5);
        add(threadTable, c);

      /*
        c.fill = GridBagConstraints.NONE;


        // STARTED PRODUCERS
        c.gridx = 0;
        c.gridy++;
        add(pe, c);

        c.gridx++;
        modifyTextField(peCounter, 50, 25);
        add (peCounter, c);

        // STARTED CONSUMERS
        c.gridx = 0;
        c.gridy++;
        add(ce, c);

        c.gridx++;
        modifyTextField(ceCounter, 50, 25);
        add (ceCounter, c);

        // ENDED PRODUCERS
        c.gridx = 0;
        c.gridy++;
        add(pf, c);

        c.gridx++;
        modifyTextField(pfCounter, 50, 25);
        add (pfCounter, c);


        // ENDED CONSUMERS
        c.gridx = 0;
        c.gridy++;
        add(cf, c);

        c.gridx++;
        modifyTextField(cfCounter, 50, 25);
        add (cfCounter, c);


        // START Time
        c.gridx = 0;
        c.gridy++;
        add(start, c);

        c.gridx++;
        modifyTextField(startTime, 50, 25);
        add (startTime, c);


        // END Time
        c.gridx = 0;
        c.gridy++;
        add(end, c);

        c.gridx++;
        modifyTextField(endTime, 50, 25);
        add (endTime, c);
*/

    }

    public void configurePanel() {
        Border blackBorder = BorderFactory.createLineBorder(Color.black);
        setBorder(blackBorder);
        setLayout(new GridBagLayout());
    }

    public void modifyTextField (JTextField txtField, int width, int height) {
        txtField.setPreferredSize(new Dimension(width,height));
        txtField.setHorizontalAlignment(JTextField.CENTER);
    }

    public JTextField getPeCounter() {
        return peCounter;
    }

    public void setPeCounter(JTextField peCounter) {
        this.peCounter = peCounter;
    }

    public JTextField getCeCounter() {
        return ceCounter;
    }

    public void setCeCounter(JTextField ceCounter) {
        this.ceCounter = ceCounter;
    }

    public JTextField getPfCounter() {
        return pfCounter;
    }

    public void setPfCounter(JTextField pfCounter) {
        this.pfCounter = pfCounter;
    }

    public JTextField getCfCounter() {
        return cfCounter;
    }

    public void setCfCounter(JTextField cfCounter) {
        this.cfCounter = cfCounter;
    }

    public JTextField getStartTime() {
        return startTime;
    }

    public void setStartTime(JTextField startTime) {
        this.startTime = startTime;
    }

    public JTextField getEndTime() {
        return endTime;
    }

    public void setEndTime(JTextField endTime) {
        this.endTime = endTime;
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