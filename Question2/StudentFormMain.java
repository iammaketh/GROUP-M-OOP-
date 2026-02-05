/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package groupm.studentformmain;


import javax.swing.*;
import java.awt.*;

public class StudentFormMain extends JFrame {

    JTextField txtFirst, txtLast, txtEmail, txtEmail2;
    JPasswordField txtPass, txtPass2;
    JRadioButton male, female;
    JComboBox<String> day, month, year, dept;
    JTextArea output;
    JButton submit;

    public StudentFormMain() {
        setTitle("Student Registration");
        setSize(500, 550);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // First Name
        addLabel("First Name", 20, 20);
        txtFirst = addTextField(120, 20);

        // Last Name
        addLabel("Last Name", 20, 60);
        txtLast = addTextField(120, 60);

        // Email
        addLabel("Email", 20, 100);
        txtEmail = addTextField(120, 100);

        // Confirm Email
        addLabel("Confirm Email", 20, 140);
        txtEmail2 = addTextField(120, 140);

        // Password
        addLabel("Password", 20, 180);
        txtPass = addPassword(120, 180);

        // Confirm Password
        addLabel("Confirm Password", 20, 220);
        txtPass2 = addPassword(120, 220);

        // Gender
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setBounds(120, 260, 70, 25);
        female.setBounds(200, 260, 80, 25);
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        add(male);
        add(female);

        // DOB Labels
        addLabel("DOB (Day/Month/Year)", 20, 300);

        // Day/Month/Year ComboBoxes
        day = new JComboBox<>();
        month = new JComboBox<>();
        year = new JComboBox<>();

        for (int i = 1; i <= 31; i++) day.addItem("" + i);
        for (int i = 1; i <= 12; i++) month.addItem("" + i);
        for (int i = 1960; i <= 2010; i++) year.addItem("" + i);

        day.setBounds(170, 300, 60, 25);
        month.setBounds(240, 300, 70, 25);
        year.setBounds(320, 300, 80, 25);

        add(day);
        add(month);
        add(year);

        // Department
        addLabel("Department", 20, 340);
        dept = new JComboBox<>(new String[]{"Select", "CSE", "Civil", "Electrical", "Mechanical"});
        dept.setBounds(120, 340, 150, 25);
        add(dept);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(120, 380, 100, 30);
        add(submit);

        // Output Area
        output = new JTextArea();
        output.setBounds(20, 420, 440, 80);
        output.setEditable(false);
        add(output);

        // Button Action
        submit.addActionListener(e -> handleSubmit());

        setVisible(true);
    }

    // Helper methods
    private void addLabel(String text, int x, int y) {
        JLabel l = new JLabel(text);
        l.setBounds(x, y, 150, 25);
        add(l);
    }

    private JTextField addTextField(int x, int y) {
        JTextField t = new JTextField();
        t.setBounds(x, y, 200, 25);
        add(t);
        return t;
    }

    private JPasswordField addPassword(int x, int y) {
        JPasswordField p = new JPasswordField();
        p.setBounds(x, y, 200, 25);
        add(p);
        return p;
    }

    private void handleSubmit() {
        String fn = txtFirst.getText().trim();
        String ln = txtLast.getText().trim();
        String em1 = txtEmail.getText().trim();
        String em2 = txtEmail2.getText().trim();
        String p1 = new String(txtPass.getPassword());
        String p2 = new String(txtPass2.getPassword());

        if (fn.isEmpty() || ln.isEmpty()) { show("Name is required"); return; }
        if (!em1.equals(em2)) { show("Emails do not match"); return; }
        if (p1.length() < 8 || !p1.matches(".*\\d.*")) { show("Password must be 8+ chars with numbers"); return; }
        if (!p1.equals(p2)) { show("Passwords do not match"); return; }
        if (!male.isSelected() && !female.isSelected()) { show("Select Gender"); return; }
        if (dept.getSelectedIndex() == 0) { show("Select Department"); return; }

        String gender = male.isSelected() ? "M" : "F";
        String dob = day.getSelectedItem() + "/" + month.getSelectedItem() + "/" + year.getSelectedItem();

        String record = String.format("%s %s | %s | %s | %s", fn, ln, gender, dept.getSelectedItem(), dob);
        output.setText(record);
        JOptionPane.showMessageDialog(this, "Record Submitted!");
    }

    private void show(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentFormMain::new);
    }
}
