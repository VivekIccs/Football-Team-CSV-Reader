/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.control;
import uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.model.*;
import javax.swing.*;
import java.awt.*;
import uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.gui.*;
import uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.model.utils.DataFiles;


/**
 *
 * @author Anas Adurker
 */
public class MainGUI  extends JFrame{
    public MainGUI() {    
    }
    public static void main(String[] args){
        MainModel.setFootballTeams(DataFiles.readFootballTeams("football_A2.csv"));
        MainModel.sortFootballTeamsByTeamName();
        ModuleWindow mainWindow = new ModuleWindow();
    }    
 
}
