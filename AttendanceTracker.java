import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AttendanceTracker {

    // Store mouse points for signature
    static ArrayList<Point> points = new ArrayList<>();

    public static void main(String[] args) {

        // Create main JFrame window
        JFrame frame = new JFrame("Attendance Tracker");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with background color
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(230, 240, 255));

        // Form panel for input fields
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        formPanel.setBackground(new Color(230, 240, 255));

        // Labels
        JLabel nameLabel = new JLabel("Attendance Name:");
        JLabel courseLabel = new JLabel("Course / Year:");
        JLabel timeInLabel = new JLabel("Time In:");

        Font labelFont = new Font("Segoe UI", Font.BOLD, 13);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 13);

        nameLabel.setFont(labelFont);
        courseLabel.setFont(labelFont);
        timeInLabel.setFont(labelFont);

        // Text fields
        JTextField nameField = new JTextField();
        JTextField courseField = new JTextField();
        JTextField timeInField = new JTextField();
        timeInField.setFont(fieldFont);
        nameField.setFont(fieldFont);
        courseField.setFont(fieldFont);

        // DateTime Formatter for "h:mm a"
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");

        // Auto fill Time In
        timeInField.setText(LocalDateTime.now().format(timeFormatter));

        // Add form components
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(courseLabel);
        formPanel.add(courseField);
        formPanel.add(timeInLabel);
        formPanel.add(timeInField);

        // Signature panel
        JPanel signaturePanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                for (int i = 1; i < points.size(); i++) {
                    Point p1 = points.get(i - 1);
                    Point p2 = points.get(i);
                    if (p1 != null && p2 != null) {
                        g.drawLine(p1.x, p1.y, p2.x, p2.y);
                    }
                }
            }
        };
        signaturePanel.setPreferredSize(new Dimension(400, 120));
        signaturePanel.setBackground(Color.WHITE);
        signaturePanel.setBorder(BorderFactory.createTitledBorder("Draw E-Signature"));

        // Mouse listeners
        signaturePanel.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) { points.add(null); }
        });
        signaturePanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) { points.add(e.getPoint()); signaturePanel.repaint(); }
        });

        // Attendance list
        DefaultListModel<String> attendanceListModel = new DefaultListModel<>();
        JList<String> attendanceList = new JList<>(attendanceListModel);
        attendanceList.setBorder(BorderFactory.createTitledBorder("Attendance Checklist"));
        attendanceList.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        JScrollPane scrollPane = new JScrollPane(attendanceList);
        scrollPane.setPreferredSize(new Dimension(200, 200));

        // Buttons: Submit & Clear
        JButton submitButton = new JButton("Submit Attendance");
        JButton clearButton = new JButton("Clear Signature");

        // Submit button action
        submitButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String course = courseField.getText().trim();
            String timeIn = timeInField.getText().trim();

            if(name.isEmpty() || course.isEmpty() || points.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please fill all fields and draw your signature!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                // Add name to checklist
                attendanceListModel.addElement(name + " - " + course + " - " + timeIn);
                // Clear fields for next student
                nameField.setText("");
                courseField.setText("");
                timeInField.setText(LocalDateTime.now().format(timeFormatter));
                points.clear();
                signaturePanel.repaint();
            }
        });

        // Clear button action
        clearButton.addActionListener(e -> {
            points.clear();
            signaturePanel.repaint();
        });

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        // Assemble main panel
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(signaturePanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(scrollPane, BorderLayout.EAST);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}