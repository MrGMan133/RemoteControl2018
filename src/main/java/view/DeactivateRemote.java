package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import administrator.Administrator;

public class DeactivateRemote extends JFrame{
	private JPanel jContentPane = null;
	private Administrator administrator;
	private JList<String> remoteList;
	private JScrollPane scrollPanel;
	private JLabel l1;
	private JTextArea t1;
	private JButton buttonDeactivate;
	
	public DeactivateRemote(Administrator administrator){
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
            l1 = new JLabel("Remote ID:");
            panel.add(l1);
            t1 = new JTextArea();
            t1.setMaximumSize(new Dimension(200,23));
            panel.add(t1);
            buttonDeactivate = new JButton("Activate");
            buttonDeactivate.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int id = Integer.parseInt(t1.getText());
					
				}
			});
            panel.add(buttonDeactivate);
        }
        return jContentPane;
    }

}

