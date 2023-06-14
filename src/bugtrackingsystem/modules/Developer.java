/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bugtrackingsystem.modules;
import bugtrackingsystem.forms.Login;
import bugtrackingsystem.forms.UpdateBugStatus;
import bugtrackingsystem.tables.Bugs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author ziadh
 */
public class Developer extends ModulesTemplate implements ActionListener  {
    public Developer (int developerID) {
        this.user_id = developerID;

        

        this.panel.add(viewBugs);
        this.panel.add(updateStatus);

        this.viewBugs.addActionListener(this);
        this.updateStatus.addActionListener(this);
        this.logout.addActionListener(this);

        setTitle("Developer");

        super.showing();
    }
    
    @Override
    public void setBounds() {
        this.title.setBounds(30, 10, 400, 50);
        this.viewBugs.setBounds(280, 160, 140, 30);
        this.updateStatus.setBounds(280, 200, 140, 30);
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
        if (eve.getSource() == this.updateStatus) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new UpdateBugStatus(user_id).setVisible(true);
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

