import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabView extends JFrame implements ActionListener, ItemListener, Runnable {
    private ProductPanel prodPanel;
    private ConfigurationPanel configPanel;
    private StatisticsPanel statsPanel;

    LabController controller;

    public LabView(LabController controller) {
       this.controller = controller;
       configureJFrame();
       addComponentsToPanel(this.getContentPane());
       setVisible(true);
    }

    private void addComponentsToPanel(Container panel){
        GridBagConstraints c = new GridBagConstraints();

        // COMPONENTS Initialization
        prodPanel = new ProductPanel();
        configPanel = new ConfigurationPanel();
        statsPanel = new StatisticsPanel();

        // ACTION LISTENERS Addition
        prodPanel.getStartButton().addActionListener(this);

        // DEFAULT Config
        c.fill = GridBagConstraints.VERTICAL;


        // PRODUCT Panel
        c.insets = new Insets(5, 5, 5, 5);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(prodPanel, c);

        // CONFIG Panel
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy ++;
        panel.add(configPanel, c);

        // STATS Panel
        c.gridx ++;
        panel.add(statsPanel, c);

    }

    private void configureJFrame(){
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
    }

    public void run() {
        while(true){
            prodPanel.getProductCounter().setText(String.valueOf(controller.getProductCounter().getValor()));

            statsPanel.getAgentTable().setValueAt(String.valueOf(controller.getPeCounter().getValor()),0, 1);
            statsPanel.getAgentTable().setValueAt(String.valueOf(controller.getPfCounter().getValor()),0, 2);
            statsPanel.getAgentTable().setValueAt(String.valueOf(controller.getCeCounter().getValor()),1, 1);
            statsPanel.getAgentTable().setValueAt(String.valueOf(controller.getCfCounter().getValor()),1, 2);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Start":
                System.out.println("ACTION - Start button pressed");

                int producerAmount = Integer.parseInt(configPanel.getProducerQtyField().getText());
                int consumerAmount = Integer.parseInt(configPanel.getConsumerQtyField().getText());
                int producerTime = configPanel.getProducerTSlider().getValue();
                int consumerTime = configPanel.getConsumerTSlider().getValue();

                System.out.println("Producer Amount: " + producerAmount + " | Consumer Amount: " + consumerAmount);
                System.out.println("Producer Time: " + producerTime + " ms | Consumer Time: " + consumerTime + " ms");

                controller.getModel().setProducerAmount(producerAmount);
                controller.getModel().setConsumerAmount(consumerAmount);
                controller.getModel().setProducerTime(producerTime);
                controller.getModel().setConsumerTime(consumerTime);


                prodPanel.getProductCounter().setText("0");
                controller.play();
                break;
            default:
                System.err.println("ACTION - Not treated action: " + e);
        }
    }
    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        int estado = itemEvent.getStateChange();
        if (estado == ItemEvent.SELECTED) {
        } else {
        }
    }

    public void modifyTextField (JTextField txtField, int width, int height) {
        txtField.setPreferredSize(new Dimension(width,height));
        txtField.setHorizontalAlignment(JTextField.CENTER);
    }

    public ProductPanel getProdPanel() {
        return prodPanel;
    }

    public void setProdPanel(ProductPanel prodPanel) {
        this.prodPanel = prodPanel;
    }

    public LabController getController() {
        return controller;
    }

    public void setController(LabController controller) {
        this.controller = controller;
    }

    public ConfigurationPanel getConfigPanel() {
        return configPanel;
    }

    public void setConfigPanel(ConfigurationPanel configPanel) {
        this.configPanel = configPanel;
    }

    public StatisticsPanel getStatsPanel() {
        return statsPanel;
    }

    public void setStatsPanel(StatisticsPanel statsPanel) {
        this.statsPanel = statsPanel;
    }
}
