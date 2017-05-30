/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.model.FootballTeam;
import uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.model.utils.Convertors;

/**
 *
 * @author Anas Adurker
 */

public class ViewPanel extends JPanel {
 
    private JTextArea modelDetails = new JTextArea();
    private ArrayList model;
    
    public ViewPanel( ArrayList model) {
        this.model=model;
        this.setLayout(new BorderLayout());
        JScrollPane jsp = new JScrollPane(modelDetails);
        this.add(jsp, BorderLayout.CENTER);
        this.update();
    }
    public void update( ){
        modelDetails.setText("");
        modelDetails.append(Convertors.listToString(model));
        
    }
   
}
