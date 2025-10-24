package ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import dao.ProductDAO;
import model.Product;
import model.User;

public class ProductListFrame extends JFrame {
    private User currentUser;

    public ProductListFrame(User user) {
        this.currentUser = user;

        setTitle("Campus Classifieds - Products");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Available Products", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        // Get products (from mock data or DAO)
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getAllProducts();

        // Show product list
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Product p : products) {
            listModel.addElement(p.getId() + ". " + p.getName() + " - ₹" + p.getPrice());
        }

        JList<String> productList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(productList);
        add(scrollPane, BorderLayout.CENTER);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(e -> {
            new HomeFrame(currentUser);
            dispose();
        });
        add(backBtn, BorderLayout.SOUTH);

        setVisible(true);
    }
}
