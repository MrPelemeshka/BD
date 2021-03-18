import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginWindow extends JFrame {

    private JPanel contentPane;
    private JTextField loginField;
    private JPasswordField passwordField;
    public static JLabel errorLabel;
    private final Action loginButtonPressed = new SwingAction();
    private final Action registrationButtonPressed = new SwingAction1();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton registrationButton;
    int tryCount = 0;



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //ManagerWindow w = new ManagerWindow();
                    LoginWindow frame = new LoginWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public LoginWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        loginButton.setAction(loginButtonPressed);
        loginButton.setBorder(null);
        contentPane.add(loginButton);
        contentPane.setBackground(new Color(255,215,127));
        loginButton.setBackground(new Color(255,153,51));

        passwordField = new JPasswordField();
        sl_contentPane.putConstraint(SpringLayout.NORTH, loginButton, 22, SpringLayout.SOUTH, passwordField);
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
        sl_contentPane.putConstraint(SpringLayout.WEST, loginButton, 0, SpringLayout.WEST, lblNewLabel);
        sl_contentPane.putConstraint(SpringLayout.EAST, loginButton, -8, SpringLayout.EAST, lblNewLabel);
        sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 43, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 153, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, loginField);
        sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -160, SpringLayout.EAST, contentPane);
        contentPane.add(lblNewLabel);
        errorLabel = new JLabel("");
        sl_contentPane.putConstraint(SpringLayout.SOUTH, loginButton, -6, SpringLayout.NORTH, errorLabel);
        sl_contentPane.putConstraint(SpringLayout.NORTH, errorLabel, 192, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, errorLabel, 173, SpringLayout.WEST, contentPane);
        contentPane.add(errorLabel);

        JLabel lblNewLabel_1 = new JLabel("Пароль");
        sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, errorLabel);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -6, SpringLayout.NORTH, passwordField);
        contentPane.add(lblNewLabel_1);

        registrationButton = new JButton("Регистрация");
        sl_contentPane.putConstraint(SpringLayout.NORTH, registrationButton, 6, SpringLayout.SOUTH, errorLabel);
        sl_contentPane.putConstraint(SpringLayout.WEST, registrationButton, 0, SpringLayout.WEST, loginButton);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, registrationButton, -30, SpringLayout.SOUTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, registrationButton, 0, SpringLayout.EAST, loginButton);
        registrationButton.setBorder(null);
        registrationButton.setBackground(new Color(255, 153, 51));
        contentPane.add(registrationButton);
        registrationButton.setAction(registrationButtonPressed);
        this.setVisible(true);
    }

    // loginButtonAction
    class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "Войти");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }

        public void actionPerformed(ActionEvent e) {

            Connection connectionToDB = DataBase.getConnection();
            String sql = "SELECT * FROM "+'"'+"User"+'"'+" WHERE "+'"'+"Login"+'"'+"='" + loginField.getText() + "';";
            if (connectionToDB != null) {
                try {
                    Statement statement = connectionToDB.createStatement();
                    ResultSet rs = statement.executeQuery(sql);
                    rs.next();
                    String dbLogin = rs.getString(1);
                    String dbPassword = rs.getString(2);
                    String inpLogin = loginField.getText();
                    String inpPasword = passwordField.getText();
                    if (dbLogin.equals(inpLogin) && dbPassword.equals(inpPasword)){
                        String role = rs.getString("Role");
                        String name = rs.getString(4);
                        System.out.println(dbLogin+" "+dbPassword+'1'+role+'1'+name+"!");
                        UserInfo info = new UserInfo(role,name);
                        switch (role) {
                            case "Manager                                                                                                                                                                                                                                                        " -> {
                                System.out.println("!!!");
                                new ManagerWindow(info);
                                dispose();
                            }
                            case "Заказчик                                                                                                                                                                                                                                                        " -> {
                                new CustomerWindow(info);
                                dispose();
                            }
                            case "Director                                                                                                                                                                                                                                                        " -> {
                                new DirectorWindow(info);
                                dispose();
                            }
                        }
                    } else {
                        increaceCount();
                        errorLabel.setText("Неправильный логин/пароль");
                    }
                } catch (SQLException s) {
                    errorLabel.setText("Неправильный логин!@пароль");
                    increaceCount();
                }
            }
        }

        private void increaceCount(){
            tryCount++;
            if (tryCount == 5){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                tryCount = 0 ;
            }
        }

    }

    class SwingAction1 extends AbstractAction {
        public SwingAction1() {
            putValue(NAME, "Регистрация");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }

        public void actionPerformed(ActionEvent e) {
            new RegistrationWindow();
        }
    }

}
