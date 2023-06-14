/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bugtrackingsystem.modules;
import bugtrackingsystem.forms.DefineBug;
import bugtrackingsystem.forms.Login;
import bugtrackingsystem.forms.UpdateBugStatus;
import bugtrackingsystem.tables.Bugs;
import bugtrackingsystem.tables.DevPerformance;
import bugtrackingsystem.tables.TesterPerformance;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author ziadh
 */
public class ProjectManager  extends ModulesTemplate implements ActionListener  {
    public ProjectManager (int ProjectManagerID) {
        this.user_id = ProjectManagerID;

        

        this.panel.add(viewBugs);
        this.panel.add(viewDevPerf);
        this.panel.add(viewTesPerf);
        this.panel.add(updateStatus);
        
        this.viewBugs.addActionListener(this);
        this.viewDevPerf.addActionListener(this);
        this.viewTesPerf.addActionListener(this);
        this.updateStatus.addActionListener(this);
        this.logout.addActionListener(this);

        setTitle("ProjectManager");

        super.showing();
    }
    
    @Override
    public void setBounds() {
        this.title.setBounds(30, 10, 400, 50);
        this.viewBugs.setBounds(280, 140, 200, 30);
        this.viewDevPerf.setBounds(280, 180, 200, 30);
        this.viewTesPerf.setBounds(280, 220, 200, 30);
        this.updateStatus.setBounds(280, 260, 200, 30);
        this.logout.setBounds(280, 330, 200, 30);
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
        if (eve.getSource() == this.viewDevPerf) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new DevPerformance(user_id).setVisible(true);
                }
            });
            this.dispose();
        }
        if (eve.getSource() == this.viewTesPerf) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new TesterPerformance(user_id).setVisible(true);
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

