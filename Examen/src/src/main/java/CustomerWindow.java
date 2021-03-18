package src.main.java;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class CustomerWindow extends JFrame {

    private final Action newOrderClick = new SwingAction();
    private final Action rejectOrderClick = new SwingAction1();
    private JPanel contentPane;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private UserInfo userInfo;
    public CustomerWindow(UserInfo info) {
        this.userInfo = info;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setLocation(screenSize.width / 2 - this.getSize().width / 2,
                screenSize.height / 2 - this.getSize().height / 2);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(new Color(255, 215, 127));
        SpringLayout sl_contentPane = new SpringLayout();
        contentPane.setLayout(sl_contentPane);

        JButton newOrderButton = new JButton("New button");
        sl_contentPane.putConstraint(SpringLayout.NORTH, newOrderButton, 10, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, newOrderButton, 4, SpringLayout.WEST, contentPane);
        contentPane.add(newOrderButton);
        newOrderButton.setAction(newOrderClick);
        newOrderButton.setBackground(new Color(255,153,51));

        JButton rejectOrderButton = new JButton("New button");
        sl_contentPane.putConstraint(SpringLayout.NORTH, rejectOrderButton, 6, SpringLayout.SOUTH, newOrderButton);
        sl_contentPane.putConstraint(SpringLayout.WEST, rejectOrderButton, 0, SpringLayout.WEST, newOrderButton);
        contentPane.add(rejectOrderButton);
        rejectOrderButton.setAction(rejectOrderClick);
        rejectOrderButton.setBackground(new Color(255,153,51));
        this.setVisible(true);
    }

    class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "Оформить заказ");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }

        public void actionPerformed(ActionEvent e) {
            new NewOrderWindow(userInfo);
        }
    }

    class SwingAction1 extends AbstractAction {
        public SwingAction1() {
            putValue(NAME, "Без имени");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }

        public void actionPerformed(ActionEvent e) {

        }
    }
}