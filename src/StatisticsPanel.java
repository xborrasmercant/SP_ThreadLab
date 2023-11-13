import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StatisticsPanel extends JPanel{
    private JTextField peCounter, ceCounter, pfCounter, cfCounter, startTime, endTime;

    public StatisticsPanel() {
        configurePanel();
        addComponentsToPanel();
    }

    public void addComponentsToPanel() {
        GridBagConstraints c = new GridBagConstraints();

        // Label creation
        JLabel pe = new JLabel("Productores empezados:");
        JLabel ce = new JLabel("Consumidores empezados:");
        JLabel pf = new JLabel("Productores finalizados:");
        JLabel cf = new JLabel("Consumidores finalizados:");
        JLabel start = new JLabel("Started:");
        JLabel end = new JLabel("Ended:");

        // Initialization of components
        this.peCounter = new JTextField("0");
        this.ceCounter = new JTextField("0");
        this.pfCounter = new JTextField("0");
        this.cfCounter = new JTextField("0");
        this.startTime = new JTextField("0");
        this.endTime = new JTextField("0");

        // PRODUCTORES EMPEZADOS
        c.gridx = 0;
        c.gridy++;
        add(pe, c);

        c.gridx++;
        modifyTextField(peCounter, 50, 25);
        add (peCounter, c);

        // CONSUMIDORES EMPEZADOS
        c.gridx = 0;
        c.gridy++;
        add(ce, c);

        c.gridx++;
        modifyTextField(ceCounter, 50, 25);
        add (ceCounter, c);

        // PRODUCTORES FINALIZADOS
        c.gridx = 0;
        c.gridy++;
        add(pf, c);

        c.gridx++;
        modifyTextField(pfCounter, 50, 25);
        add (pfCounter, c);


        // PRODUCTORES FINALIZADOS
        c.gridx = 0;
        c.gridy++;
        add(cf, c);

        c.gridx++;
        modifyTextField(cfCounter, 50, 25);
        add (cfCounter, c);


        // START

        c.gridx = 0;
        c.gridy++;
        add(start, c);

        c.gridx++;
        modifyTextField(startTime, 50, 25);
        add (startTime, c);


        // END
        c.gridx = 0;
        c.gridy++;
        add(end, c);

        c.gridx++;
        modifyTextField(endTime, 50, 25);
        add (endTime, c);


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

    public JTextField getPeCounter() {
        return peCounter;
    }

    public void setPeCounter(JTextField peCounter) {
        this.peCounter = peCounter;
    }

    public JTextField getCeCounter() {
        return ceCounter;
    }

    public void setCeCounter(JTextField ceCounter) {
        this.ceCounter = ceCounter;
    }

    public JTextField getPfCounter() {
        return pfCounter;
    }

    public void setPfCounter(JTextField pfCounter) {
        this.pfCounter = pfCounter;
    }

    public JTextField getCfCounter() {
        return cfCounter;
    }

    public void setCfCounter(JTextField cfCounter) {
        this.cfCounter = cfCounter;
    }

    public JTextField getStartTime() {
        return startTime;
    }

    public void setStartTime(JTextField startTime) {
        this.startTime = startTime;
    }

    public JTextField getEndTime() {
        return endTime;
    }

    public void setEndTime(JTextField endTime) {
        this.endTime = endTime;
    }
}