import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.net.URL;

public class PrelimLabWork3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PrelimGUI3D());
    }
}

class PrelimGUI3D extends JFrame {
    JTextField attendanceField, lw1Field, lw2Field, lw3Field;
    JTextArea outputArea;
    JButton computeBtn;
    final int TOTAL_MEETINGS = 30;

    Color bgDark = new Color(15, 15, 15);
    Color cardDark = new Color(28, 28, 28);
    Color schoolMaroon = new Color(139, 0, 0);
    Color neonCyan = new Color(0, 255, 255);

    public PrelimGUI3D() {
        setTitle("UPHSD Grade Portal - Responsive");
        setMinimumSize(new Dimension(400, 600)); 
        setSize(500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainWrapper = new JPanel(new GridBagLayout());
        mainWrapper.setBackground(bgDark);
        setContentPane(mainWrapper);

        GridBagConstraints outerGbc = new GridBagConstraints();
        outerGbc.gridx = 0;
        outerGbc.gridy = 0;
        outerGbc.weightx = 1.0;
        outerGbc.weighty = 1.0;
        outerGbc.fill = GridBagConstraints.BOTH; 
        outerGbc.insets = new Insets(20, 20, 20, 20);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);
        mainWrapper.add(contentPanel, outerGbc);

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setOpaque(false);
        header.setAlignmentX(Component.CENTER_ALIGNMENT);

        try {
            ImageIcon rawIcon = new ImageIcon(new URL("https://upload.wikimedia.org/wikipedia/en/2/25/University_of_Perpetual_Help_System_DALTA_logo.png"));
            Image scaledImage = rawIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            JLabel logoLabel = new JLabel(new ImageIcon(scaledImage));
            logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            header.add(logoLabel);
        } catch (Exception e) {}

        JLabel title = new JLabel("PRELIM GRADE SYSTEM");
        title.setFont(new Font("Montserrat", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.add(Box.createRigidArea(new Dimension(0, 10)));
        header.add(title);

        contentPanel.add(header);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(cardDark);
        card.setBorder(new CompoundBorder(
            new LineBorder(schoolMaroon, 2),
            new EmptyBorder(20, 20, 20, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        addInputRow(card, gbc, "ATTENDANCE:", attendanceField = styledField(), 0);
        addInputRow(card, gbc, "LAB WORK 1:", lw1Field = styledField(), 1);
        addInputRow(card, gbc, "LAB WORK 2:", lw2Field = styledField(), 2);
        addInputRow(card, gbc, "LAB WORK 3:", lw3Field = styledField(), 3);

        contentPanel.add(card);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        computeBtn = new JButton("COMPUTE GRADES");
        computeBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50)); // Mag-uunat base sa width
        computeBtn.setBackground(schoolMaroon);
        computeBtn.setForeground(Color.WHITE);
        computeBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        computeBtn.setFocusPainted(false);
        computeBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(computeBtn);

        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBackground(Color.BLACK);
        outputArea.setForeground(neonCyan);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        
        JScrollPane scroll = new JScrollPane(outputArea);
        scroll.setPreferredSize(new Dimension(100, 200)); // Base height
        scroll.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY), "CALCULATION LOG", 0, 0, null, Color.LIGHT_GRAY));
        contentPanel.add(scroll);

        computeBtn.addActionListener(e -> computeGrades());
        setVisible(true);
    }

    private void addInputRow(JPanel p, GridBagConstraints c, String label, JTextField f, int y) {
        c.gridy = y;
        c.gridx = 0; c.weightx = 0.3;
        JLabel l = new JLabel(label);
        l.setForeground(Color.LIGHT_GRAY);
        l.setFont(new Font("SansSerif", Font.BOLD, 11));
        p.add(l, c);

        c.gridx = 1; c.weightx = 0.7;
        p.add(f, c);
    }

    private JTextField styledField() {
        JTextField tf = new JTextField();
        tf.setBackground(new Color(40, 40, 40));
        tf.setForeground(Color.WHITE);
        tf.setCaretColor(Color.WHITE);
        tf.setBorder(new LineBorder(new Color(70, 70, 70)));
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return tf;
    }

    private void computeGrades() {
        outputArea.setText("Logic processing...\nCalculations complete.");
    }
}