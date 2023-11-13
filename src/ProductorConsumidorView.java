import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ProductorConsumidorView extends JFrame implements ActionListener, ItemListener, Runnable {
    private JButton startButton;
    private JTextField mainCounter;
    private ConfigurationPanel configPanel;
    private StatisticsPanel statsPanel;

    ProductorConsumidorController controller;

    public ProductorConsumidorView(ProductorConsumidorController controller) {
       this.controller = controller;
       configureJFrame();
       addComponentsToPanel(this.getContentPane());
       setVisible(true);
    }

    private void addComponentsToPanel(Container panel){
        GridBagConstraints c = new GridBagConstraints();
        Font font1 = new Font("SansSerif", Font.BOLD, 20);

        startButton = new JButton("Play");
        mainCounter = new JTextField("0");
        configPanel = new ConfigurationPanel();
        statsPanel = new StatisticsPanel();

        startButton.addActionListener(this);


        c.insets = new Insets(5, 5, 5, 5);
        startButton.setPreferredSize(new Dimension(100,50));
        startButton.setFont(font1);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(startButton, c);

        mainCounter.setPreferredSize(new Dimension(100,50));
        mainCounter.setFont(font1);
        mainCounter.setHorizontalAlignment(JTextField.CENTER);
        c.gridx++;
        panel.add(mainCounter, c);

        // CONFIG PANEL
        c.gridx = 0;
        c.gridy ++;
        panel.add(configPanel, c);

        // STATS PANEL
        c.gridx ++;
        panel.add(statsPanel, c);

    }

    private void configureJFrame(){
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);
        setLocationRelativeTo(null);
    }

    public void run() {
        while(true){
            mainCounter.setText(String.valueOf(controller.getMainCounter().getValor()));
            statsPanel.getPeCounter().setText(String.valueOf(controller.getPeCounter().getValor()));
            statsPanel.getPfCounter().setText(String.valueOf(controller.getPfCounter().getValor()));
            statsPanel.getCeCounter().setText(String.valueOf(controller.getCeCounter().getValor()));
            statsPanel.getCfCounter().setText(String.valueOf(controller.getCfCounter().getValor()));
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play":
                this.getMainCounter().setText("0");
                controller.play();
                break;
            default:
                System.err.println("Acción NO tratada: " + e);
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

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public JTextField getMainCounter() {
        return mainCounter;
    }

    public void setMainCounter(JTextField mainCounter) {
        this.mainCounter = mainCounter;
    }

    public ProductorConsumidorController getController() {
        return controller;
    }

    public void setController(ProductorConsumidorController controller) {
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
