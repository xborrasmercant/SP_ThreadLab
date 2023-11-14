import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ConfigurationPanel extends JPanel {
    private JSlider producerTSlider, consumerTSlider;
    private JCheckBox producerRCheckbox, consumerRCheckbox;
    private JTextField producerQtyField, consumerQtyField;

    public ConfigurationPanel() {
        configurePanel();
        addComponentsToPanel();
    }

    public void addComponentsToPanel() {
        GridBagConstraints c = new GridBagConstraints();

        // LABEL Creation
        JLabel producerRTime = new JLabel("Randomize producer time", SwingConstants.CENTER);
        JLabel consumerRTime = new JLabel("Randomize consumer time", SwingConstants.CENTER);
        JLabel producerQtyLabel = new JLabel("Producer Amount", SwingConstants.CENTER);
        JLabel consumerQtyLabel = new JLabel("Consumer Amount", SwingConstants.CENTER);

        // COMPONENT Initialization
        this.producerTSlider = new JSlider(1,100);
        this.consumerTSlider = new JSlider(1,100);
        this.producerRCheckbox = new JCheckBox();
        this.consumerRCheckbox = new JCheckBox();
        this.producerQtyField = new JTextField("100");
        this.consumerQtyField = new JTextField("100");

        // DEFAULT Config
        modifyTextField(producerQtyField, 50, 25);
        modifyTextField(consumerQtyField, 50, 25);
        c.insets = new Insets(2, 2, 2, 2);

        // PRODUCER Amount
        c.gridx = 0;
        c.gridy = 0;
        add(producerQtyLabel, c);                           // Label

        c.gridy++;
        add(producerQtyField, c);                           // TextField

        // CONSUMER Amount
        c.gridx++;
        c.gridy = 0;
        add(consumerQtyLabel, c);                           // Label

        c.gridy++;
        add(consumerQtyField, c);                           // TextField

        c.fill = GridBagConstraints.HORIZONTAL;

        // PRODUCER TIME Config
        c.gridx = 0;
        c.gridy++;
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

    public JTextField getProducerQtyField() {
        return producerQtyField;
    }

    public void setProducerQtyField(JTextField producerQtyField) {
        this.producerQtyField = producerQtyField;
    }

    public JTextField getConsumerQtyField() {
        return consumerQtyField;
    }

    public void setConsumerQtyField(JTextField consumerQtyField) {
        this.consumerQtyField = consumerQtyField;
    }
}
