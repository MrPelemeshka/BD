import javax.swing.*;
import javax.swing.border.EmptyBorder;

import src.main.java.DataBase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewOrderWindow extends JFrame {
    private JPanel contentPane;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JList orderNameField;
    private JLabel lblNewLabel_1;
    private JSpinner customersList;
    private JLabel lblNewLabel_2;
    private JTextField orderDescriptionList;
    private JButton btnNewButton;
    private final Action action = new SwingAction();
    private UserInfo userInfo;
    private DefaultListModel listModel;

    public NewOrderWindow(UserInfo info){
        this.userInfo = info;
        this.setSize(1000, 800);
        this.setLocation(screenSize.width / 2 - this.getSize().width / 2,
                screenSize.height / 2 - this.getSize().height / 2);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(new Color(255, 215, 127));
        SpringLayout sl_contentPane = new SpringLayout();
        contentPane.setLayout(sl_contentPane);
        listModel = new DefaultListModel();
        orderNameField = new JList(listModel);
        sl_contentPane.putConstraint(SpringLayout.NORTH, orderNameField, 61, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, orderNameField, 151, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, orderNameField, 106, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, orderNameField, 379, SpringLayout.WEST, contentPane);
        contentPane.add(orderNameField);

        JLabel lblNewLabel = new JLabel("Наименование заказа");
        sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 192, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, orderNameField);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Выберите клиента");
        sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 42, SpringLayout.SOUTH, orderNameField);
        sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 208, SpringLayout.WEST, contentPane);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(lblNewLabel_1);

        customersList = new JSpinner();
        sl_contentPane.putConstraint(SpringLayout.NORTH, customersList, 18, SpringLayout.SOUTH, lblNewLabel_1);
        sl_contentPane.putConstraint(SpringLayout.WEST, customersList, 85, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, customersList, 214, SpringLayout.SOUTH, lblNewLabel_1);
        sl_contentPane.putConstraint(SpringLayout.EAST, customersList, 483, SpringLayout.WEST, contentPane);
        contentPane.add(customersList);

        lblNewLabel_2 = new JLabel("Описание изделия");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 23, SpringLayout.SOUTH, customersList);
        sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 243, SpringLayout.WEST, contentPane);
        contentPane.add(lblNewLabel_2);

        orderDescriptionList = new JTextField();
        sl_contentPane.putConstraint(SpringLayout.NORTH, orderDescriptionList, 21, SpringLayout.SOUTH, lblNewLabel_2);
        sl_contentPane.putConstraint(SpringLayout.WEST, orderDescriptionList, 95, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, orderDescriptionList, 128, SpringLayout.SOUTH, lblNewLabel_2);
        sl_contentPane.putConstraint(SpringLayout.EAST, orderDescriptionList, 0, SpringLayout.EAST, customersList);
        contentPane.add(orderDescriptionList);
        orderDescriptionList.setColumns(10);

        btnNewButton = new JButton("New button");
        btnNewButton.setAction(action);
        sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 27, SpringLayout.SOUTH, orderDescriptionList);
        sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, lblNewLabel_2);
        contentPane.add(btnNewButton);
        this.setVisible(true);
        try {
            initList();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void initList() throws SQLException {
        Statement statement = DataBase.getConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Products");
        int k = 0;
        while (rs.next()){
            listModel.add(k,rs.getString("Name"));
            k++;
        }
    }
    private class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "Разместить заказ");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }
        public void actionPerformed(ActionEvent e) {

        }
    }
}
