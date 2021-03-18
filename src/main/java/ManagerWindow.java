import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManagerWindow extends JFrame {

    private JPanel contentPane;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final Action action = new SwingAction();
    private UserInfo userInfo;
    public ManagerWindow(UserInfo info){
        this.userInfo = info;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setLocation(screenSize.width / 2 - this.getSize().width / 2,
                screenSize.height / 2 - this.getSize().height / 2);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(new Color(255, 215, 127));
        SpringLayout sl_contentPane = new SpringLayout();
        contentPane.setLayout(sl_contentPane);

        JButton viewOrdersWindow = new JButton("Список заказов");
        viewOrdersWindow.setFont(new Font("Tahoma", Font.PLAIN, 15));
        sl_contentPane.putConstraint(SpringLayout.SOUTH, viewOrdersWindow, 73, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, viewOrdersWindow, 198, SpringLayout.WEST, contentPane);
        viewOrdersWindow.setAction(action);
        sl_contentPane.putConstraint(SpringLayout.NORTH, viewOrdersWindow, 27, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, viewOrdersWindow, 42, SpringLayout.WEST, contentPane);
        contentPane.add(viewOrdersWindow);
        this.setVisible(true);
    }

    private class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "Создать заказ");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }
        public void actionPerformed(ActionEvent e) {
            new NewOrderWindow(userInfo);
        }
    }
}
