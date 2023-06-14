package bugtrackingsystem.forms;

import bugtrackingsystem.SysFrame;
import bugtrackingsystem.modules.Admin;
import bugtrackingsystem.modules.Developer;
import bugtrackingsystem.modules.ProjectManager;
import bugtrackingsystem.modules.Tester;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Login extends SysFrame implements ActionListener {

    private final JPanel page, panel1;
    private final JLabel idLabel, passLabel;
    private final JTextField idField;
    private final JPasswordField passField;
    private final JButton login;

    public Login() {
        page = new JPanel();
        panel1 = new JPanel();
        login = new JButton("Login");
        idLabel = new JLabel("ID: ");
        passLabel = new JLabel("Password: ");
        idField = new JTextField();
        passField = new JPasswordField();
        setTitle("Login");
        this.add(page);

        super.showing();
    }

    @Override
    public void properties() {
        page.setLayout(null);
        this.page.setPreferredSize(new Dimension(this.MYWIDTH, this.MYHEIGHT));

        this.panel1.setLayout(null);

        login.addActionListener(this);

        panel1.add(idLabel);
        panel1.add(idField);
        panel1.add(passLabel);
        panel1.add(passField);
        panel1.add(login);

        page.add(panel1, 0);
    }

    @Override
    public void setBounds() {
        panel1.setBounds(0, 0, MYWIDTH, MYHEIGHT);

        idLabel.setBounds(190, 120, 90, 35);
        passLabel.setBounds(190, 180, 90, 35);
        idField.setBounds(280, 120, 200, 25);
        passField.setBounds(280, 180, 200, 25);

        login.setBounds(330, 230, 100, 25);
    }

    @Override
    public void setFonts() {
        idLabel.setFont(this.font_20);
        passLabel.setFont(this.font_20);
        idField.setFont(this.font_20);
        passField.setFont(this.font_20);
        login.setFont(this.font_24);
    }

    @Override
    public void setColors() {
        panel1.setBackground(Color.black);

        idLabel.setForeground(Color.white);
        passLabel.setForeground(Color.white);
        idField.setForeground(Color.black);
        passField.setForeground(Color.black);
        login.setForeground(Color.white);

        idField.setBackground(Color.white);
        passField.setBackground(Color.white);
        login.setBackground(this.orange);

    }

    @Override
    public void confirm(ActionEvent eve) {
        if (eve.getSource() == login) {

            String idStr = this.idField.getText().trim();
            String pass = this.passField.getText().trim();
            try {
                if (!idStr.equals("") && !pass.equals("")) {
                    int id_ = Integer.parseInt(this.idField.getText().trim());
                    String sql = "SELECT * FROM Users WHERE ID = " + id_;

                    ResultSet rs = this.statement.executeQuery(sql);
                    while (rs.next()) {
                        if (rs.getString(3).equals(pass)) {
                            switch (rs.getString(4)) {
                                case "admin" -> {
                                    Admin admin = new Admin(id_);
                                    this.dispose();
                                }

                                case "pm" -> {
                                    java.awt.EventQueue.invokeLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            new ProjectManager(id_).setVisible(true);
                                        }
                                    });
                                    this.dispose();
                                }

                                case "developer" -> {
                                    java.awt.EventQueue.invokeLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            new Developer(id_).setVisible(true);
                                        }
                                    });
                                    this.dispose();
                                }

                                case "tester" -> {
                                    java.awt.EventQueue.invokeLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            new Tester(id_).setVisible(true);
                                        }
                                    });
                                    this.dispose();
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Password is not correct", "Login failed", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Fill the login form", "Login failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException | java.lang.NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "User not found", "Login failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.confirm(e);
    }

}
