import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AttendanceTracker {

    // Store mouse points for signature
    static ArrayList<Point> points = new ArrayList<>();
    private static JLabel liveClockLabel;

    public static void main(String[] args) {

        // Main JFrame
        JFrame frame = new JFrame("Attendance Tracker");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(230, 240, 255));

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        formPanel.setBackground(new Color(230, 240, 255));

        // Components
        JLabel nameLabel = new JLabel("Attendance Name:");
        JLabel courseLabel = new JLabel("Course / Year:");
        JLabel timeInLabel = new JLabel("Current Time:");

        JTextField nameField = new JTextField();
        
        // Dropdown para sa Course
        String[] courses = {"-- Select Course --", "BSIT-1", "BSIT-2", "BSCS-1", "BSCS-2", "BSCPE-1", "BSHM-1"};
        JComboBox<String> courseDropdown = new JComboBox<>(courses);

        // Live Clock Label
        liveClockLabel = new JLabel();
        liveClockLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        startClock(); // Start the timer

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(courseLabel);
        formPanel.add(courseDropdown);
        formPanel.add(timeInLabel);
        formPanel.add(liveClockLabel);

        // Signature panel
        JPanel signaturePanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(2)); // Kapal ng pirma
                for (int i = 1; i < points.size(); i++) {
                    Point p1 = points.get(i - 1);
                    Point p2 = points.get(i);
                    if (p1 != null && p2 != null) {
                        g.drawLine(p1.x, p1.y, p2.x, p2.y);
                    }
                }
            }
        };
        signaturePanel.setPreferredSize(new Dimension(400, 150));
        signaturePanel.setBackground(Color.WHITE);
        signaturePanel.setBorder(BorderFactory.createTitledBorder("Draw E-Signature"));

        signaturePanel.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) { points.add(null); }
        });
        signaturePanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) { 
                points.add(e.getPoint()); 
                signaturePanel.repaint(); 
            }
        });

        // Attendance list (JList)
        DefaultListModel<String> attendanceListModel = new DefaultListModel<>();
        JList<String> attendanceList = new JList<>(attendanceListModel);
        JScrollPane scrollPane = new JScrollPane(attendanceList);
        scrollPane.setPreferredSize(new Dimension(250, 200));
        scrollPane.setBorder(BorderFactory.createTitledBorder("Attendance Log"));

        // Buttons
        JButton submitButton = new JButton("Submit Attendance");
        JButton clearButton = new JButton("Clear Signature");

        submitButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String course = (String) courseDropdown.getSelectedItem();
            String timeIn = liveClockLabel.getText();

            if(name.isEmpty() || courseDropdown.getSelectedIndex() == 0 || points.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Pakikumpleto ang Name, Course, at Signature!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                // Add to JList
                attendanceListModel.addElement(name + " - " + course + " - " + timeIn);
                
                // Clear fields
                nameField.setText("");
                courseDropdown.setSelectedIndex(0);
                points.clear();
                signaturePanel.repaint();
            }
        });

        clearButton.addActionListener(e -> {
            points.clear();
            signaturePanel.repaint();
        });

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        // Assemble
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(signaturePanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(scrollPane, BorderLayout.EAST);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Live Clock Function
    private static void startClock() {
        Timer timer = new Timer(1000, e -> {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("h:mm:ss a"));
            liveClockLabel.setText(time);
        });
        timer.start();
    }
}