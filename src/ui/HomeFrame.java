package ui;

import javax.swing.*;
import java.awt.*;
import model.User;

public class HomeFrame extends JFrame {
    private User currentUser;

    public HomeFrame(User user) {
        this.currentUser = user;

        setTitle("Campus Classifieds - Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel welcome = new JLabel("Welcome, " + user.getName(), SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 20));
        add(welcome, BorderLayout.NORTH);

        JButton viewProductsBtn = new JButton("View Products");
        JButton logoutBtn = new JButton("Logout");

        JPanel panel = new JPanel();
        panel.add(viewProductsBtn);
        panel.add(logoutBtn);
        add(panel, BorderLayout.CENTER);

        // Open product list
        viewProductsBtn.addActionListener(e -> {
            new ProductListFrame(currentUser);
            dispose();
        });

        // Logout and go back to login page
        logoutBtn.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });

        setVisible(true);
    }
}
