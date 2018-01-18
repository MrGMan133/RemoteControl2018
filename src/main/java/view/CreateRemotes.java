package view;

import administrator.Administrator;
import model.Remote;

import javax.swing.*;
import javax.swing.JList;
import java.awt.Container;
import javax.swing.JScrollPane;

public class CreateRemotes extends JFrame{
    private JPanel jContentPane = null;
    private Administrator administrator;
    private JList remoteList;
    public CreateRemotes(Administrator administrator){
        this.administrator = administrator;
        this.setContentPane(getContent());
        this.remoteList = new JList(administrator.getRemoteInfo().toArray());
        setTitle("Remote Manager");
        this.setSize(300, 200);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    private Container getContent() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);

            JPanel panel = new JPanel();

            panel.setBounds(5, 11, 250, 140);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            jContentPane.add(panel);
            panel.add(new JScrollPane(remoteList));
        }
        return jContentPane;
    }
}
