package ui;

import javax.swing.*;
import java.awt.*;
import dao.UserDAO;
import model.User;

public class RegisterFrame extends JFrame {
    private JTextField nameField, usernameField;
    private JPasswordField passwordField;

    public RegisterFrame() {
        setTitle("Campus Classifieds - Register");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Register", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        nameField = new JTextField(15);
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        JButton registerBtn = new JButton("Register");

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(registerBtn);

        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        registerBtn.addActionListener(e -> {
            String name = nameField.getText();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            UserDAO userDAO = new UserDAO();
            boolean success = userDAO.register(new User(name, username, password));

            if (success) {
                JOptionPane.showMessageDialog(this, "Registration Successful!");
                new LoginFrame();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Username already exists!");
            }
        });

        setVisible(true);
    }
}
