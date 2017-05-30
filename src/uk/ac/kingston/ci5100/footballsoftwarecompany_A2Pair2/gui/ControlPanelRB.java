/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Anas Adurker
 */
public class ControlPanelRB extends JPanel{
    String[] sortOptions = {"TeamName", "League"};
    private EventListener eventHandler;
    private JButton refreshView = new JButton("Refresh");
    private JButton quitProgram = new JButton("Quit");
    private ButtonGroup sortButtons = new ButtonGroup();
    private JRadioButton sortByTeamName = new JRadioButton("Sort by Team Name");
    private JRadioButton sortByLeague = new JRadioButton("Sort by League");

    public ControlPanelRB(EventListener eventHandler ) {
        this.eventHandler = eventHandler;
        this.setLayout(new FlowLayout());
         // this line associates a command string with the button
         // so the evenet handler can find out which button has 
         // been pressed
         refreshView.setActionCommand("Refresh");
         sortByTeamName.setActionCommand("SortByTeamName");
         sortByLeague.setActionCommand("SortByLague");
         quitProgram.setActionCommand("Quit");
         // associate the event handler with the button
         // since a button is expecting an action listener then 
         // need to cast it
        refreshView.addActionListener((ActionListener)eventHandler);
        sortByTeamName.addActionListener((ActionListener)eventHandler);
        sortByLeague.addActionListener((ActionListener)eventHandler);
        quitProgram.addActionListener((ActionListener)eventHandler);
        this.add(refreshView);
        // group the buttons to take care of 'radio' behaviour
        sortButtons.add(sortByTeamName);
        sortButtons.add(sortByLeague);
        this.add(sortByTeamName);
        this.add(sortByLeague);
        this.add(quitProgram);
       
    }
    
}
