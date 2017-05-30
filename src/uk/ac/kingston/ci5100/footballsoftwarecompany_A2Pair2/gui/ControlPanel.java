/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.model.*;

/**
 *
 * @author Anas Adurker
 */
public class ControlPanel extends JPanel {
    
    String[] sortOptions = {"Team Name", "League"};
    private EventListener eventHandler;
    private JButton refreshView = new JButton("Refresh");
    private JButton quitProgram = new JButton("Quit");
    private JComboBox sortByList = new JComboBox(sortOptions);
    // 
  
    
    /** Creates a new instance of ControlPanel
     * @param eventHandler */
    public ControlPanel(EventListener eventHandler ) {
        this.eventHandler = eventHandler;
        this.setLayout(new FlowLayout());
        refreshView.setActionCommand("Refresh");
        sortByList.setActionCommand("SortByList");
        quitProgram.setActionCommand("Quit");
        refreshView.addActionListener((ActionListener)eventHandler);
        sortByList.addActionListener((ActionListener)eventHandler);
        quitProgram.addActionListener((ActionListener)eventHandler);
        this.add(refreshView);
        this.add(sortByList);
        this.add(quitProgram);
       
    }
    
 
}