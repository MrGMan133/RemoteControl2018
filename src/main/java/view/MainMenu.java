package view;

import administrator.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private Administrator administrator;
    private JPanel jContentPane = null;
    public MainMenu(){
        administrator = new Administrator();
        this.setContentPane(getContent());
        setTitle("Remote Manager");
        this.setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
            JLabel label1 = new JLabel("1. Create Remotes");
            panel.add(label1);
            JLabel label2 = new JLabel("2. View Remotes");
            panel.add(label2);
            JLabel label3 = new JLabel("3. Enable Remote");
            panel.add(label3);
            JLabel label4 = new JLabel("4. Disable Remote");
            panel.add(label4);
            JLabel label5 = new JLabel("5. Open Gate");
            panel.add(label5);
            JTextField t1 = new JTextField();
            t1.setMaximumSize(new Dimension(200,23));
            panel.add(t1);
            JButton buttonOK = new JButton("Go");
            buttonOK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int choice = Integer.parseInt(t1.getText());
                    chosenMenu(choice);
                }
            });
            panel.add(buttonOK);
        }
        return jContentPane;
    }
    public void chosenMenu(int choice){
        switch (choice){
            case 1:
                administrator.createRemotes();
                new CreateRemotes(administrator).setVisible(true);
        }
    }
}
