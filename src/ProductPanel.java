import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ProductPanel extends JPanel{
    private JToggleButton start_TButton;
    private JButton restart_Button;
    private JTextField productStock_Field;
    private JCheckBox synchronizeThreads_CB;
    private JCheckBox stockPositive_CB;



    public ProductPanel() {
        configurePanel();
        addComponentsToPanel();
    }

    public void addComponentsToPanel() {
        GridBagConstraints c = new GridBagConstraints();
        Font font1 = new Font("SansSerif", Font.BOLD, 18);
        Font titleFont = new Font("SansSerif", Font.BOLD, 22);

        // LABEL Creation
        JLabel synchronizeThreads_Label = new JLabel("Synchronize Threads", SwingConstants.CENTER);
        JLabel stockPositive_Label = new JLabel("Positive Stock", SwingConstants.CENTER);
        JLabel productStock_Label = new JLabel("Item Stock", SwingConstants.CENTER);

        // COMPONENTS Initialization
        start_TButton = new JToggleButton("Start");
        restart_Button = new JButton("Restart");
        productStock_Field = new JTextField("0");
        synchronizeThreads_CB = new JCheckBox();
        stockPositive_CB = new JCheckBox();

        // DEFAULT Config
        c.insets = new Insets(5, 15, 5, 15);
        productStock_Field.setPreferredSize(new Dimension(100,50));
        productStock_Field.setFont(font1);
        productStock_Field.setHorizontalAlignment(JTextField.CENTER);
        start_TButton.setPreferredSize(new Dimension(100,50));
        start_TButton.setFont(font1);
        restart_Button.setPreferredSize(new Dimension(100,50));
        restart_Button.setFont(font1);
        productStock_Label.setFont(titleFont);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 4;


        // PRODUCT STOCK
        c.gridx = 0;
        c.gridy = 0;
        add(productStock_Label, c);                                                  // Stock Label

        c.gridy++;
        add(productStock_Field, c);                                                  // Stock Counter

        // START Button
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(5, 5, 5, 5);

        c.gridwidth = 2;

        c.gridx = 0;
        c.gridy++;
        add(start_TButton, c);                                                        // Start Button

        // RESTART Button
        c.gridx++;
        add(restart_Button, c);                                                        // Restart Button


        // SYNCHRONIZED Threads
        c.gridwidth = 1;

        c.gridx = 0;
        c.gridy++;
        add(synchronizeThreads_Label, c);                                              // Synchronized Label

        c.gridx++;
        add(synchronizeThreads_CB, c);                                                 // Synchronized CheckBox


        // POSITIVE Stock
        c.gridx++;
        add(stockPositive_Label, c);                                                    // PositiveStock Label

        c.gridx++;
        add(stockPositive_CB, c);                                                    // PositiveStock Checkbox

    }

    public void configurePanel() {
        Border blackBorder = BorderFactory.createLineBorder(Color.black);
        setBorder(blackBorder);
        setLayout(new GridBagLayout());
    }


    public JToggleButton getStartButton() {
        return start_TButton;
    }

    public void setStartButton(JToggleButton start_TButton) {
        this.start_TButton = start_TButton;
    }

    public JTextField getProductStockField() {
        return productStock_Field;
    }

    public void setProductStockField(JTextField productStock_Field) {
        this.productStock_Field = productStock_Field;
    }

    public JToggleButton getStart_TButton() {
        return start_TButton;
    }

    public void setStart_TButton(JToggleButton start_TButton) {
        this.start_TButton = start_TButton;
    }

    public JButton getRestart_Button() {
        return restart_Button;
    }

    public void setRestart_Button(JButton restart_Button) {
        this.restart_Button = restart_Button;
    }

    public JTextField getProductStock_Field() {
        return productStock_Field;
    }

    public void setProductStock_Field(JTextField productStock_Field) {
        this.productStock_Field = productStock_Field;
    }

    public JCheckBox getSynchronizeThreads_CB() {
        return synchronizeThreads_CB;
    }

    public void setSynchronizeThreads_CB(JCheckBox synchronizeThreads_CB) {
        this.synchronizeThreads_CB = synchronizeThreads_CB;
    }

    public JCheckBox getStockPositive_CB() {
        return stockPositive_CB;
    }

    public void setStockPositive_CB(JCheckBox stockPositive_CB) {
        this.stockPositive_CB = stockPositive_CB;
    }
}
