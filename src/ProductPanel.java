import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ProductPanel extends JPanel{
    private JButton startButton;
    private JTextField productCounter;


    public ProductPanel() {
        configurePanel();
        addComponentsToPanel();
    }

    public void addComponentsToPanel() {
        GridBagConstraints c = new GridBagConstraints();
        Font font1 = new Font("SansSerif", Font.BOLD, 20);

        // COMPONENTS Initialization
        startButton = new JButton("Start");
        productCounter = new JTextField("0");

        // START Button
        c.insets = new Insets(5, 5, 5, 5);
        startButton.setPreferredSize(new Dimension(100,50));
        startButton.setFont(font1);
        c.gridx = 0;
        c.gridy = 0;
        add(startButton, c);

        // PRODUCT Counter
        productCounter.setPreferredSize(new Dimension(100,50));
        productCounter.setFont(font1);
        productCounter.setHorizontalAlignment(JTextField.CENTER);
        c.gridx++;
        add(productCounter, c);
    }

    public void configurePanel() {
        Border blackBorder = BorderFactory.createLineBorder(Color.black);
        setBorder(blackBorder);
        setLayout(new GridBagLayout());
    }


    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public JTextField getProductCounter() {
        return productCounter;
    }

    public void setProductCounter(JTextField productCounter) {
        this.productCounter = productCounter;
    }
}
