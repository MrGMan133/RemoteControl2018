package view;

import administrator.Administrator;
import model.Remote;

import javax.swing.*;
import javax.swing.JList;
import java.awt.Container;
import javax.swing.JScrollPane;

public class ViewRemotes extends JFrame{
    private JPanel jContentPane = null;
    private Administrator administrator;
    private JList<String> remoteList;
    private JScrollPane scrollPanel;
    public ViewRemotes(Administrator administrator){
        this.setAdministrator(administrator);
        this.setContentPane(getContent());
        this.remoteList = new JList<>(administrator.getRemoteInfo().toArray(new String[0]));
        setTitle("Remote Manager");
        this.setSize(300, 200);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	private Container getContent() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            JPanel panel = new JPanel();
            scrollPanel = new JScrollPane(remoteList);
            panel.setBounds(5, 11, 250, 140);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            jContentPane.add(panel);
            panel.add(scrollPanel);
        }
        return jContentPane;
    }
}
