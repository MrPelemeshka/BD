
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationWindow extends JFrame {

    private JPanel contentPane;
    private JTextField loginField;
    private JPasswordField passwordField;
    public static JLabel errorLabel;
    private final Action loginButtonPressed = new SwingAction();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JLabel lblNewLabel_2;
    private JTextField nameField;

    public RegistrationWindow() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(450, 300);
        this.setLocation(screenSize.width / 2 - this.getSize().width / 2,
                screenSize.height / 2 - this.getSize().height / 2);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        SpringLayout sl_contentPane = new SpringLayout();
        contentPane.setLayout(sl_contentPane);

        loginField = new JTextField();
        loginField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == e.VK_ENTER) {
                    passwordField.requestFocus();
                }
            }
        });
        sl_contentPane.putConstraint(SpringLayout.NORTH, loginField, 63, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, loginField, 114, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, loginField, -147, SpringLayout.EAST, contentPane);
        contentPane.add(loginField);
        loginField.setColumns(10);

        JButton loginButton = new JButton("Login");
        sl_contentPane.putConstraint(SpringLayout.WEST, loginButton, 128, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, loginButton, -10, SpringLayout.SOUTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, loginButton, -144, SpringLayout.EAST, contentPane);
        loginButton.setAction(loginButtonPressed);
        loginButton.setBorder(null);
        contentPane.add(loginButton);
        contentPane.setBackground(new Color(255, 215, 127));
        loginButton.setBackground(new Color(255, 153, 51));

        passwordField = new JPasswordField();
        sl_contentPane.putConstraint(SpringLayout.NORTH, loginButton, 77, SpringLayout.SOUTH, passwordField);
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == e.VK_ENTER) {
                    loginButton.doClick();
                }
            }
        });
        sl_contentPane.putConstraint(SpringLayout.SOUTH, loginField, -22, SpringLayout.NORTH, passwordField);
        sl_contentPane.putConstraint(SpringLayout.NORTH, passwordField, 108, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, passwordField, 133, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, passwordField, 114, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, passwordField, -147, SpringLayout.EAST, contentPane);
        contentPane.add(passwordField);

        JLabel lblNewLabel = new JLabel("Логин");
        sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 43, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 176, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, loginField);
        sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -137, SpringLayout.EAST, contentPane);
        contentPane.add(lblNewLabel);
        errorLabel = new JLabel("");
        sl_contentPane.putConstraint(SpringLayout.NORTH, errorLabel, 192, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, errorLabel, 173, SpringLayout.WEST, contentPane);
        contentPane.add(errorLabel);

        JLabel lblNewLabel_1 = new JLabel("Пароль");
        sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, errorLabel);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -6, SpringLayout.NORTH, passwordField);
        contentPane.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("Регистрация");
        sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 10, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 153, SpringLayout.WEST, contentPane);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(lblNewLabel_2);

        nameField = new JTextField();
        sl_contentPane.putConstraint(SpringLayout.WEST, nameField, 54, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, nameField, -15, SpringLayout.NORTH, errorLabel);
        sl_contentPane.putConstraint(SpringLayout.EAST, nameField, 354, SpringLayout.WEST, contentPane);
        contentPane.add(nameField);
        nameField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("ФИО");
        sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, passwordField);
        sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, errorLabel);
        contentPane.add(lblNewLabel_3);

        this.setVisible(true);
    }

    // RegButtonAction
    class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "Зарегистрироваться");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }

        public void actionPerformed(ActionEvent e) {
            Connection connectionToDB = DataBase.getConnection();
            boolean isCorrect = true;

            if (passwordField.getPassword().length < 5 | passwordField.getPassword().length > 20 ) isCorrect = false;
            if (String.valueOf(passwordField.getPassword()).contains(loginField.getText())) isCorrect = false;

            boolean containsUppercase = false;
            for(char c : passwordField.getPassword()){
                if (Character.isUpperCase(c)) containsUppercase = true;
            }
            if (!containsUppercase) isCorrect = false;

            boolean containsLowercase = false;
            for(char c : passwordField.getPassword()){
                if (Character.isLowerCase(c)) containsLowercase = true;
            }
            if (!containsLowercase) isCorrect = false;


            boolean error=true;
            if (connectionToDB != null && isCorrect) {
                try {
                    Statement statement = connectionToDB.createStatement();
                    String userName = null;
                    if (!nameField.getText().equals("")) userName = nameField.getText();
                    String sql = String.format("INSERT INTO "+'"'+"User"+'"'+"(\n" +
                            "\t"+'"'+"Login"+'"'+", "+'"'+"Password"+'"'+", "+'"'+"Role"+'"'+", "+'"'+"Name"+'"'+")\n" +
                            "\tVALUES ('%s', '%s', 'Заказчик', '%s')",
                            loginField.getText(), String.valueOf(passwordField.getPassword()), userName);
                    System.out.println(sql);
                    statement.executeUpdate(sql);
                } catch (SQLException s) {
                    error=false;
                    errorLabel.setText("Ошибка при регистрации");
                }
                if(error)errorLabel.setText("Успешно! Закройте окно регистрации");

            }
            else errorLabel.setText("Некорректный ввод");
        }
    }
}

