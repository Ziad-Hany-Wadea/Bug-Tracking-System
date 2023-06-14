/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bugtrackingsystem.modules;

import bugtrackingsystem.forms.AddUser;
import bugtrackingsystem.forms.DeleteUser;
import bugtrackingsystem.forms.Login;
import bugtrackingsystem.forms.UpdateUser;
import bugtrackingsystem.tables.Bugs;
import bugtrackingsystem.tables.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends ModulesTemplate implements ActionListener {

    public Admin(int adminID) {
        this.user_id = adminID;

        this.panel.add(viewUsers);
        this.panel.add(addUser);
        this.panel.add(updateUser);
        this.panel.add(deleteUser);

        this.viewBugs.addActionListener(this);
        this.viewUsers.addActionListener(this);
        this.addUser.addActionListener(this);
        this.updateUser.addActionListener(this);
        this.deleteUser.addActionListener(this);
        this.logout.addActionListener(this);

        setTitle("Admin");

        super.showing();
    }

    @Override
    public void setBounds() {
        this.title.setBounds(30, 10, 400, 50);

        this.viewBugs.setBounds(280, 80, 140, 30);
        this.viewUsers.setBounds(280, 120, 140, 30);
        this.addUser.setBounds(280, 160, 140, 30);
        this.updateUser.setBounds(280, 200, 140, 30);
        this.deleteUser.setBounds(280, 240, 140, 30);
        this.logout.setBounds(280, 330, 140, 30);
    }

    @Override
    public void confirm(ActionEvent eve) {
        if (eve.getSource() == this.viewBugs) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Bugs(user_id).setVisible(true);
                }
            });
            this.dispose();
        }
        if (eve.getSource() == this.viewUsers) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Users(user_id).setVisible(true);
                }
            });
            this.dispose();
        }
        if (eve.getSource() == this.addUser) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new AddUser(user_id).setVisible(true);
                }
            });
            this.dispose();
        }
        if (eve.getSource() == this.deleteUser) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new DeleteUser(user_id).setVisible(true);
                }
            });
            this.dispose();
        }

        if (eve.getSource() == this.updateUser) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new UpdateUser(user_id).setVisible(true);
                }
            });
            this.dispose();
        }

        if (eve.getSource() == this.logout) {
            Login login = new Login();
            this.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        confirm(e);
    }

}
