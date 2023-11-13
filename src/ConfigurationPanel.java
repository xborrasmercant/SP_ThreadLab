import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ConfigurationPanel extends JPanel {
    private JSlider producerTSlider, consumerTSlider;
    private JCheckBox producerRCheckbox, consumerRCheckbox;
    private JTextField producerAmount, consumerAmount;

    public ConfigurationPanel() {
        configurePanel();
        addComponentsToPanel();

    }

    public void addComponentsToPanel() {
        GridBagConstraints c = new GridBagConstraints();

        // Label creation
        JLabel producerRTime = new JLabel("Randomize producer time");
        JLabel consumerRTime = new JLabel("Randomize consumer time");
        JLabel producerALabel = new JLabel("Producer Amount");
        JLabel consumerALabel = new JLabel("Consumer Amount");

        // Initialization of components
        this.producerTSlider = new JSlider(0,100);
        this.consumerTSlider = new JSlider(0,100);
        this.producerRCheckbox = new JCheckBox();
        this.consumerRCheckbox = new JCheckBox();

        // PRODUCERS Config
        c.gridx = 0;
        c.gridy++;
        add(producerRTime, c); // Label

        c.gridx++;
        add(producerRCheckbox, c); // Checkbox

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy++;
        add(producerTSlider, c); // Slider

        c.gridwidth = 1;


        // CONSUMERS Config
        c.gridx = 0;
        c.gridy++;
        add(consumerRTime, c); // Label

        c.gridx++;
        add(consumerRCheckbox, c); // Checkbox

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy++;
        add(consumerTSlider, c); // Slider

        c.gridwidth = 1;

    }

    public void configurePanel() {
        Border blackBorder = BorderFactory.createLineBorder(Color.black);
        setBorder(blackBorder);
        setLayout(new GridBagLayout());
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
}
