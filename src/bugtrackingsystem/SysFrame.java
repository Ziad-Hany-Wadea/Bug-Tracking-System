package bugtrackingsystem;

import bugtrackingsystem.forms.Form;
import database.DataBaseConnection;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Statement;
import javax.swing.JFrame;

public abstract class SysFrame extends JFrame implements Form {

    protected final Statement statement;
    protected final Color black, orange, white;
    protected final Font font_18, font_20, font_24;
    protected final int MYWIDTH, MYHEIGHT;

    public SysFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bug Tracking System");
        this.setResizable(false);
        this.setLocation(0, 0);

        this.MYWIDTH = 700;
        this.MYHEIGHT = 400;
        this.statement = new DataBaseConnection().setStatement();

        this.black = new Color(0x000000);
        this.orange = new Color(0xFF6600);
        this.white = new Color(0xFFFFFF);

        this.font_18 = new Font("Tahoma", Font.BOLD, 12);
        this.font_20 = new Font("Tahoma", Font.BOLD, 14);
        this.font_24 = new Font("Tahoma", Font.BOLD, 18);

    }

    public void showing() {
        properties();
        setFonts();
        setBounds();
        setColors();
        setOtherProperties();
        setLocation(MYWIDTH/2, MYHEIGHT/2);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void properties() {

    }

    @Override
    public void setBounds() {

    }

    @Override
    public void setFonts() {

    }

    @Override
    public void setColors() {

    }

    @Override
    public void setOtherProperties() {

    }

    @Override
    public void confirm(ActionEvent eve) {

    }

}
