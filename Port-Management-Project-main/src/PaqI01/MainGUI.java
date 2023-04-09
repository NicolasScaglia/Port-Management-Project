package PaqI01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class MainGUI extends JFrame{
    static int selectedHub;
    private JPanel MainFrame;
    private JLabel idNumber;
    private JTextField tidNumber;
    private JLabel weight;
    private JTextField tweight;
    private JLabel desc;
    private JTextArea tdesc;
    private JLabel scompany;
    private JTextField tscompany;
    private JTextField trcompany;
    private JLabel rcompany;
    private JButton pbutton;
    private JButton cbutton;
    private JButton dbutton;
    private JButton nbutton;
    private JLabel op;
    private JTextField bcolumn;
    private JTextArea sdescription;
    private JComboBox countryoforigin;
    private JLabel logo;
    private JTextArea ilogo;
    private JLabel country;
    private JLabel priority;
    private JRadioButton p1;
    private JRadioButton p2;
    private JRadioButton p3;
    private JLabel state;
    private JTextArea hub;
    private JLabel inspection;
    private JCheckBox confirminspection;
    private JTextField countrynumber;
    private JComboBox ncountry;
    private JRadioButton buttonhub1;
    private JRadioButton buttonhub2;
    private JRadioButton buttonhub3;
    private JLabel idnumber;

    public MainGUI() {
        setContentPane(MainFrame);
        setTitle("Welcome");
        setSize(1340,740);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        //Initialization of the components of the Port
        Hub hub1 = new Hub();
        Hub hub2 = new Hub();
        Hub hub3 = new Hub();
        Port mainPort = new Port(hub1, hub2, hub3);
        Container actualContainer = new Container();
        //Printing by default the Hub 1
        buttonhub1.setSelected(true);
        hub.setText(mainPort.completePort[0].HubToString());

        pbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Checking which hub is selected
                if(buttonhub1.isSelected()){
                    selectedHub = 0;
                } else if (buttonhub2.isSelected()) {
                    selectedHub = 1;
                }else{
                    selectedHub = 2;
                }
                //Saving all the information in the Container we are working with right now
                actualContainer.setID(Integer.parseInt(tidNumber.getText()));
                actualContainer.setWeight(Integer.parseInt((tweight.getText())));
                actualContainer.setCountryOfOrigin(Objects.requireNonNull(countryoforigin.getSelectedItem()).toString());
                actualContainer.setReceiverCompany(trcompany.getText());
                actualContainer.setSenderCompany(tscompany.getText());
                actualContainer.setContentDescription(tdesc.getText());
                if(p1.isSelected()){
                    actualContainer.priorityLevel = 1;
                }
                if(p2.isSelected()){
                    actualContainer.priorityLevel = 2;
                }
                if(p3.isSelected()){
                    actualContainer.priorityLevel = 3;
                }
                actualContainer.setInspected(confirminspection.isSelected());
                mainPort.checkAvailable(actualContainer);
                hub.setText(mainPort.completePort[selectedHub].HubToString());
            }
        });
        cbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buttonhub1.isSelected()){
                    selectedHub = 0;
                } else if (buttonhub2.isSelected()) {
                    selectedHub = 1;
                }else{
                    selectedHub = 2;
                }
                mainPort.completePort[selectedHub].removeContainer(Integer.parseInt(bcolumn.getText()));
                hub.setText(mainPort.completePort[selectedHub].HubToString());
            }
        });
        dbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buttonhub1.isSelected()){
                    selectedHub = 0;
                } else if (buttonhub2.isSelected()) {
                    selectedHub = 1;
                }else{
                    selectedHub = 2;
                }
                String foundContainer;
                foundContainer = mainPort.completePort[selectedHub].searchContainer(Integer.parseInt(tidNumber.getText()));
                sdescription.setText(foundContainer);
            }
        });
        nbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = mainPort.containerCount(Objects.requireNonNull(ncountry.getSelectedItem()).toString());
                countrynumber.setText(String.valueOf(count));
            }
        });
        buttonhub1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buttonhub1.isSelected()){
                    hub.setText(mainPort.completePort[0].HubToString());
                }
            }
        });
        buttonhub2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buttonhub2.isSelected()){
                    hub.setText(mainPort.completePort[1].HubToString());
                }
            }
        });

        buttonhub3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buttonhub3.isSelected()){
                    hub.setText(mainPort.completePort[2].HubToString());
                }
            }
        });
    }

    public static void main(String[] args) {
        MainGUI myGui = new MainGUI();

    }
}
