import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class LabView extends JFrame implements ActionListener, Runnable {
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
            // PRODUCT Updating
            prodPanel.getProductStockField().setText(String.valueOf(controller.getProductStock().getStockValue()));

            // AGENT TABLE Updating
            statsPanel.getAgentTable().setValueAt(String.valueOf(controller.getPeCounter().getStockValue()),0, 1);
            statsPanel.getAgentTable().setValueAt(String.valueOf(controller.getPfCounter().getStockValue()),0, 2);
            statsPanel.getAgentTable().setValueAt(String.valueOf(controller.getCeCounter().getStockValue()),1, 1);
            statsPanel.getAgentTable().setValueAt(String.valueOf(controller.getCfCounter().getStockValue()),1, 2);

            // THREAD TABLE Updating
            statsPanel.getThreadTable().setValueAt((getLabModel().getAgentElapsedTime() + " ns"),0, 1);
            statsPanel.getThreadTable().setValueAt((getAgentAvgTime() + " ns"),0, 2);
            statsPanel.getThreadTable().setValueAt((getLabModel().getThreadElapsedTime() + " ns"),1, 1);
            statsPanel.getThreadTable().setValueAt((getThreadAvgTime() + " ns"),1, 2);

            // TOTAL ELAPSED TIME Updating
            statsPanel.getElapsedTimeField().setText((getLabModel().getTotalElapsedTime() + " ms"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Start":

                System.out.println("ACTION - Start Button Pressed");
                int producerAmount, consumerAmount, producerTime, consumerTime;

                producerAmount = Integer.parseInt(configPanel.getProducerQtyField().getText());
                consumerAmount = Integer.parseInt(configPanel.getConsumerQtyField().getText());

                // Randomization CheckBoxes
                if (configPanel.getProducerRCheckbox().isSelected()) {
                    producerTime = (int) (Math.random()*100) + 1;
                }
                else {
                    producerTime = configPanel.getProducerTSlider().getValue();
                }

                if (configPanel.getConsumerRCheckbox().isSelected()) {
                    consumerTime = (int) (Math.random()*100) + 1;
                }
                else {
                    consumerTime = configPanel.getConsumerTSlider().getValue();
                }

                // Setting Final Values
                controller.getModel().setProducerAmount(producerAmount);
                controller.getModel().setConsumerAmount(consumerAmount);
                controller.getModel().setProducerTime(producerTime);
                controller.getModel().setConsumerTime(consumerTime);

                controller.play();

                System.out.println("Producer Amount: " + producerAmount + " | Consumer Amount: " + consumerAmount);
                System.out.println("Producer Time: " + producerTime + " ms | Consumer Time: " + consumerTime + " ms");
                System.out.println("Created Total Time: " + getLabModel().getAgentElapsedTime() + " ns |" + " Created Average Time: " + getAgentAvgTime() + " ns");
                System.out.println("Started Total Time: " + getLabModel().getThreadElapsedTime() + " ns |" + " Started Average Time: " + getThreadAvgTime() + " ns");
                System.out.println("Total Elapsed Time: " + getLabModel().getTotalElapsedTime() + " ms");
                System.out.println("=============================================");
                break;
            default:
                System.err.println("ACTION - Not treated action: " + e);
        }
    }

    public LabModel getLabModel() {
        return controller.getModel();
    }

    public long getAgentAvgTime() {
        return getLabModel().getAgentElapsedTime() / (getLabModel().getProducerAmount() + getLabModel().getConsumerAmount());
    }

    public long getThreadAvgTime() {
        return getLabModel().getThreadElapsedTime() / (getLabModel().getProducerAmount() + getLabModel().getConsumerAmount());
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
