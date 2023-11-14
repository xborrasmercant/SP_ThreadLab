import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ProductPanel extends JPanel{
    private JButton startButton;
    private JTextField productStockField;


    public ProductPanel() {
        configurePanel();
        addComponentsToPanel();
    }

    public void addComponentsToPanel() {
        GridBagConstraints c = new GridBagConstraints();
        Font font1 = new Font("SansSerif", Font.BOLD, 20);

        // COMPONENTS Initialization
        startButton = new JButton("Start");
        productStockField = new JTextField("0");

        // START Button
        c.insets = new Insets(5, 5, 5, 5);
        startButton.setPreferredSize(new Dimension(100,50));
        startButton.setFont(font1);
        c.gridx = 0;
        c.gridy = 0;
        add(startButton, c);                                                        // Button

        // PRODUCT Counter
        productStockField.setPreferredSize(new Dimension(100,50));
        productStockField.setFont(font1);
        productStockField.setHorizontalAlignment(JTextField.CENTER);
        c.gridx++;
        add(productStockField, c);                                                  // TextField
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

    public JTextField getProductStockField() {
        return productStockField;
    }

    public void setProductStockField(JTextField productStockField) {
        this.productStockField = productStockField;
    }
}
