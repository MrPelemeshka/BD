import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DirectorWindow extends JFrame {

    private JPanel contentPane;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JTable instrumentsTable;
    private DefaultTableModel instrumentsTableModel;
    private UserInfo userInfo;

    public DirectorWindow(UserInfo info){
        this.userInfo = info;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setLocation(screenSize.width / 2 - this.getSize().width / 2,
                screenSize.height / 2 - this.getSize().height / 2);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        SpringLayout sl_contentPane = new SpringLayout();
        contentPane.setLayout(sl_contentPane);
        contentPane.setBackground(new Color(255, 215, 127));

        instrumentsTableModel = new DefaultTableModel();
        instrumentsTable = new JTable(instrumentsTableModel);
        String[] instrumentsTableHeaders = new String[] {"Наименование", "Тип инструмента", "Возраст(мес.)","Количество"};
        instrumentsTableModel.setColumnIdentifiers(instrumentsTableHeaders);
        sl_contentPane.putConstraint(SpringLayout.NORTH, instrumentsTable, 39, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, instrumentsTable, 48, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.SOUTH, instrumentsTable, 314, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, instrumentsTable, 525, SpringLayout.WEST, contentPane);
        contentPane.add(instrumentsTable);
        instrumentsTable.setBackground(new Color(225,221,215));

    }
}
