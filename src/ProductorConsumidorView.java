import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ProductorConsumidorView extends JFrame implements ComponentListener, ActionListener, ItemListener, Runnable {
    JButton startButton;

    JTextField textField;

    ProductorConsumidorController controller;

    public ProductorConsumidorView(ProductorConsumidorController controller) {
        this.controller = controller;

        this.startButton = new JButton("Play");
        this.startButton.addActionListener(this);

        this.textField = new JTextField("0");

        this.configureJFrame();

        this.setVisible(true);
    }

    private void addComponentsToPane(Container panel){
        GridBagConstraints c = new GridBagConstraints();

        JLabel label = new JLabel("Valor del contador: ");

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;

        panel.add(this.startButton, c);

        c.gridx++;
        panel.add(label, c);
        c.gridx++;
        panel.add(this.textField, c);
    }

    private void configureJFrame(){
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.addComponentsToPane(this.getContentPane());
    }

    public void run() {
        while(true){
            try{
                Thread.sleep(100);
                this.getTextField().setText(String.valueOf(controller.getContador().getValor()));
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play":
                this.getTextField().setText("0");
                controller.play();
                break;
            default:
                System.err.println("Acción NO tratada: " + e);
        }
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
        //System.out.println("Frame hidden");
    }


    @Override
    public void componentMoved(ComponentEvent ce) {
        // System.out.println("Frame moved");
    }


    @Override
    public void componentResized(ComponentEvent ce) {
        // System.out.println("Frame resized");
    }


    @Override
    public void componentShown(ComponentEvent ce) {
        // System.out.println("Frame Shown");
    }


    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        int estado = itemEvent.getStateChange();
        if (estado == ItemEvent.SELECTED) {
        } else {
        }
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public ProductorConsumidorController getController() {
        return controller;
    }

    public void setController(ProductorConsumidorController controller) {
        this.controller = controller;
    }
}
