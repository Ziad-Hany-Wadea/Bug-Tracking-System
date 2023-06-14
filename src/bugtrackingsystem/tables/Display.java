package bugtrackingsystem.tables;

import bugtrackingsystem.SysFrame;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class Display extends SysFrame {

    protected JPanel Panel;
    protected JScrollPane container;
    protected DefaultTableModel model;
    protected JTable table;
    protected JButton back;

    public Display() {
        this.model = new DefaultTableModel();
        this.table = new JTable(this.model);
        this.setSize(800, 500);

        this.container = new JScrollPane();
        this.Panel = new JPanel();

        this.back = new JButton("Back");
    }

    @Override
    public void properties() {
        this.container.setBounds(0, 0, 1520, 400);
        this.Panel.setBounds(0, 800, 1235, 150);
        this.Panel.setBackground(new Color(0x5595d5));

        this.Panel.setLayout(null);

        this.model.setRowCount(50);

        this.table.getTableHeader().setReorderingAllowed(false);

        this.table.setRowHeight(30);
        this.table.setAutoscrolls(true);
        this.table.setFocusable(false);
        this.table.setFillsViewportHeight(false);
        this.table.setFont(new Font("Arial", Font.PLAIN, 16));
        this.table.setFocusable(false);

        this.table.setGridColor(Color.CYAN);
        this.table.setBackground(this.white);
        this.table.setForeground(this.black);
        this.table.setDragEnabled(false);

        this.back.setBounds(35, 75, 75, 25);
        this.back.setFont(new Font("Arial", Font.PLAIN, 17));
        this.back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.back.setFocusable(false);
        this.back.setVerticalTextPosition(JButton.CENTER);
        this.back.setHorizontalTextPosition(JButton.RIGHT);
        this.back.setIconTextGap(15);
    }

}
