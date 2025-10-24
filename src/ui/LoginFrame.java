package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import dao.UserDAO;
import model.User;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Campus Classifieds - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Login", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginBtn);
        panel.add(registerBtn);

        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        loginBtn.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            UserDAO userDAO = new UserDAO();
            User user = userDAO.login(username, password);

            if (user != null) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                new HomeFrame(user);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!");
            }
        });

        registerBtn.addActionListener(e -> {
            new RegisterFrame();
            dispose();
        });

        setVisible(true);
    }
}
