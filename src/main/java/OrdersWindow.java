import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class OrdersWindow extends JFrame {
    private JPanel contentPane;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public OrdersWindow(){
        this.setSize(1000, 800);
        this.setLocation(screenSize.width / 2 - this.getSize().width / 2,
                screenSize.height / 2 - this.getSize().height / 2);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(new Color(255, 215, 127));
        SpringLayout sl_contentPane = new SpringLayout();
        contentPane.setLayout(sl_contentPane);
        this.setVisible(true);
    }
}
