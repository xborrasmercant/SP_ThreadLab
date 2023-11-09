import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ProductorConsumidorView extends JFrame implements ActionListener, ItemListener, Runnable {
    private JButton startButton;
    private JTextField mainCounter;
    private JTextField peCounter, ceCounter, pfCounter, cfCounter, startTime, endTime;

    ProductorConsumidorController controller;

    public ProductorConsumidorView(ProductorConsumidorController controller) {
       this.controller = controller;
        configureJFrame();
        addComponentsToPane(this.getContentPane());
        setVisible(true);
    }

    private void addComponentsToPane(Container panel){
        GridBagConstraints c = new GridBagConstraints();
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        JLabel pe = new JLabel("Productores empezados:");
        JLabel ce = new JLabel("Consumidores empezados:");
        JLabel pf = new JLabel("Productores finalizados:");
        JLabel cf = new JLabel("Consumidores finalizados:");
        JLabel start = new JLabel("Started:");
        JLabel end = new JLabel("Ended:");

        this.startButton = new JButton("Play");
        this.mainCounter = new JTextField("0");
        this.peCounter = new JTextField("0");
        this.ceCounter = new JTextField("0");
        this.pfCounter = new JTextField("0");
        this.cfCounter = new JTextField("0");
        this.startTime = new JTextField("0");
        this.endTime = new JTextField("0");
        this.startButton.addActionListener(this);

        c.insets = new Insets(5, 5, 5, 5);
        this.startButton.setPreferredSize(new Dimension(100,50));
        this.startButton.setFont(font1);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(this.startButton, c);

        this.mainCounter.setPreferredSize(new Dimension(100,50));
        this.mainCounter.setFont(font1);
        this.mainCounter.setHorizontalAlignment(JTextField.CENTER);
        c.gridx++;
        panel.add(this.mainCounter, c);

        // PRODUCTORES EMPEZADOS
        c.gridx = 0;
        c.gridy++;
        panel.add(pe, c);

        c.gridx++;
        modifyTextField(peCounter, 50, 25);
        panel.add (peCounter, c);

        // CONSUMIDORES EMPEZADOS
        c.gridx = 0;
        c.gridy++;
        panel.add(ce, c);

        c.gridx++;
        modifyTextField(ceCounter, 50, 25);
        panel.add (ceCounter, c);

        // PRODUCTORES FINALIZADOS
        c.gridx = 0;
        c.gridy++;
        panel.add(pf, c);

        c.gridx++;
        modifyTextField(pfCounter, 50, 25);
        panel.add (pfCounter, c);


        // PRODUCTORES FINALIZADOS
        c.gridx = 0;
        c.gridy++;
        panel.add(cf, c);

        c.gridx++;
        modifyTextField(cfCounter, 50, 25);
        panel.add (cfCounter, c);


        // START

        c.gridx = 0;
        c.gridy++;
        panel.add(start, c);

        c.gridx++;
        modifyTextField(startTime, 50, 25);
        panel.add (startTime, c);


        // END
        c.gridx = 0;
        c.gridy++;
        panel.add(end, c);

        c.gridx++;
        modifyTextField(endTime, 50, 25);
        panel.add (endTime, c);

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
            peCounter.setText(String.valueOf(controller.getPeCounter().getValor()));
            pfCounter.setText(String.valueOf(controller.getPfCounter().getValor()));
            ceCounter.setText(String.valueOf(controller.getCeCounter().getValor()));
            cfCounter.setText(String.valueOf(controller.getCfCounter().getValor()));
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
}
