package bugtrackingsystem.modules;

import bugtrackingsystem.SysFrame;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class ModulesTemplate extends SysFrame {

    protected JPanel panel;
    protected JLabel title;
    protected JButton logout, viewBugs, viewUsers, viewDevPerf, viewTesPerf, addUser, updateUser, updateStatus, deleteUser, defineBug;
    protected int user_id;

    public ModulesTemplate() {
        this.panel = new JPanel();
        this.title = new JLabel();
        this.viewBugs = new JButton("View Bugs");
        this.logout = new JButton("Logout");
        this.viewUsers = new JButton("View All Users");
        this.addUser = new JButton("Add User");
        this.updateUser = new JButton("Update User");
        this.deleteUser = new JButton("Delete User");
        this.updateStatus = new JButton("Update Status");
        this.viewDevPerf = new JButton("View Developer Performance");
        this.viewTesPerf = new JButton("View Tester Performance");
        this.defineBug = new JButton("Define Bug");
    }

    @Override
    public void properties() {
        this.panel.setPreferredSize(new Dimension(this.MYWIDTH, this.MYHEIGHT));
        this.panel.setLayout(null);

        String sql = "SELECT * FROM Users WHERE ID=" + this.user_id;

        try {
            ResultSet rs = this.statement.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                title.setText("Welcome, " + name);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        this.panel.add(this.title);
        this.panel.add(this.viewBugs);
        this.panel.add(this.logout);

        this.add(panel,0);
    }

    @Override
    public void setBounds() {

        this.title.setBounds(30, 10, 400, 50);

        this.viewBugs.setBounds(280, 80, 110, 30);
        this.logout.setBounds(280, 330, 110, 30);
    }

    @Override
    public void setFonts() {
        this.title.setFont(font_24);

        this.viewBugs.setFont(font_20);
        this.logout.setFont(font_24);
    }

    @Override
    public void setColors() {
        panel.setBackground(this.black);
        
        this.title.setForeground(this.white);

        this.viewBugs.setForeground(this.white);
        this.viewBugs.setBackground(this.orange);
        
        this.addUser.setForeground(this.white);
        this.addUser.setBackground(this.orange);
        
        this.updateUser.setForeground(this.white);
        this.updateUser.setBackground(this.orange);
        
        this.deleteUser.setForeground(this.white);
        this.deleteUser.setBackground(this.orange);
        
        this.viewUsers.setForeground(this.white);
        this.viewUsers.setBackground(this.orange);
        
        this.updateStatus.setForeground(this.white);
        this.updateStatus.setBackground(this.orange);
        
        this.defineBug.setForeground(this.white);
        this.defineBug.setBackground(this.orange);
        
        this.viewDevPerf.setForeground(this.white);
        this.viewDevPerf.setBackground(this.orange);

        this.viewTesPerf.setForeground(this.white);
        this.viewTesPerf.setBackground(this.orange);        
        
        this.logout.setForeground(this.white);
        this.logout.setBackground(this.orange);
    }
}
