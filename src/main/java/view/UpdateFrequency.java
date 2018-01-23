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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import administrator.Administrator;

public class UpdateFrequency extends JFrame{
	private Administrator administrator;
	private JPanel jContentPane = null;
	private JLabel l1;
	private JTextArea t1;
	private JButton buttonNewFrequency;
	
	public UpdateFrequency(Administrator administrator){
		this.setAdministrator(administrator);
        this.setContentPane(getContent());
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
            panel.setBounds(5, 11, 250, 140);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            jContentPane.add(panel);
            l1 = new JLabel("New Frequency:");
            panel.add(l1);
            t1 = new JTextArea();
            t1.setMaximumSize(new Dimension(200,23));
            panel.add(t1);
            buttonNewFrequency = new JButton("Update");
            buttonNewFrequency.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					double frequency = Double.parseDouble(t1.getText());
					administrator.updateFrequency(frequency);
					JOptionPane.showMessageDialog(null, "Frequency updated to: " + frequency);
				}
			});
            panel.add(buttonNewFrequency);
        
        }
        return jContentPane;
	}
}
