import CustomUI.CustomTable;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ConfigurationPanel extends JPanel {
    private JSlider producerTSlider, consumerTSlider;
    private JCheckBox producerRCheckbox, consumerRCheckbox;
    private CustomTable amountsTable;

    public ConfigurationPanel() {
        configurePanel();
        addComponentsToPanel();
    }

    public void addComponentsToPanel() {
        GridBagConstraints c = new GridBagConstraints();
        Font tableTitleFont = new Font("SansSerif", Font.BOLD, 16);

        // LABEL Creation
        JLabel producerRTime = new JLabel("Randomize producer time", SwingConstants.CENTER);
        JLabel consumerRTime = new JLabel("Randomize consumer time", SwingConstants.CENTER);
        JLabel producerQtyLabel = new JLabel("Producer Amount", SwingConstants.CENTER);
        JLabel consumerQtyLabel = new JLabel("Consumer Amount", SwingConstants.CENTER);
        JLabel amountsLabel = new JLabel("Agents and Product Amounts", SwingConstants.CENTER);


        // COMPONENT Initialization
        producerTSlider = new JSlider(1,100);
        consumerTSlider = new JSlider(1,100);
        producerRCheckbox = new JCheckBox();
        consumerRCheckbox = new JCheckBox();
        amountsTable = new CustomTable("Amounts");


        // DEFAULT Config
        amountsLabel.setFont(tableTitleFont);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;

        // AMOUNTS Table
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 0, 5);
        add(amountsLabel, c);                                         // Label

        c.gridy++;
        add(amountsTable.getTableHeader(), c);                        // Header

        c.gridy++;
        c.insets = new Insets(0, 5, 5, 5);
        add(amountsTable, c);                                         // Table

        c.insets = new Insets(2, 2, 2, 2);

        // PRODUCER TIME Config
        c.gridx = 0;
        c.gridy++;
        c.gridwidth = 1;
        add(producerRTime, c);                              // Label

        c.gridx++;
        add(producerRCheckbox, c);                          // Checkbox

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy++;
        add(producerTSlider, c);                             // Slider

        c.gridwidth = 1;


        // CONSUMER TIME Config
        c.gridx = 0;
        c.gridy++;
        add(consumerRTime, c);                               // Label

        c.gridx++;
        add(consumerRCheckbox, c);                           // Checkbox

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy++;
        add(consumerTSlider, c);                             // Slider

        c.gridwidth = 1;

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

    public JSlider getProducerTSlider() {
        return producerTSlider;
    }

    public void setProducerTSlider(JSlider producerTSlider) {
        this.producerTSlider = producerTSlider;
    }

    public JSlider getConsumerTSlider() {
        return consumerTSlider;
    }

    public void setConsumerTSlider(JSlider consumerTSlider) {
        this.consumerTSlider = consumerTSlider;
    }

    public JCheckBox getProducerRCheckbox() {
        return producerRCheckbox;
    }

    public void setProducerRCheckbox(JCheckBox producerRCheckbox) {
        this.producerRCheckbox = producerRCheckbox;
    }

    public JCheckBox getConsumerRCheckbox() {
        return consumerRCheckbox;
    }

    public void setConsumerRCheckbox(JCheckBox consumerRCheckbox) {
        this.consumerRCheckbox = consumerRCheckbox;
    }

    public CustomTable getAmountsTable() {
        return amountsTable;
    }

    public void setAmountsTable(CustomTable amountsTable) {
        this.amountsTable = amountsTable;
    }
}
