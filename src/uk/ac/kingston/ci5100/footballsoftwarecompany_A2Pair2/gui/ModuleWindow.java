/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.model.*;
import uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.control.*;
/**
 *
 * @author Anas Adurker
 */
public class ModuleWindow extends JFrame //implements Runnable
 {
    private JTabbedPane tabs = new JTabbedPane();
    private ViewPanel viewPanel = new ViewPanel(MainModel.getFootballTeams());
    private ControlPanel controlPanel = new ControlPanel(new ControlPanelEvent());
    public ModuleWindow( ) {
        super("Module Viewer");
        this.run();
    }

    public void run(){

        JPanel tabPanel = new JPanel(new BorderLayout());
        
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tabPanel.add(controlPanel, BorderLayout.SOUTH);
        tabPanel.add(viewPanel, BorderLayout.CENTER);
        tabs.addTab("Football Teams", tabPanel);
        
        /*
        // code for JTextArea Start
        */
        JTextArea myJTextArea;
        myJTextArea = new JTextArea ("Coaches");

        
try{
            FileReader fr = new FileReader("football_A2.csv");
            BufferedReader br = new BufferedReader(fr);
            ArrayList<FootballTeam> FootballTeams = new ArrayList <FootballTeam>();          
            String str;
            int coachesC1 = 0;
            int coachesC1Pt = 0;
            int coachesC1Ft = 0;
            int coachesC2 = 0;
            int coachesC2Pt = 0;
            int coachesC2Ft = 0;
            int coachesN1 = 0;
            int coachesN1Pt = 0;
            int coachesN1Ft = 0;
            int coachesN2 = 0;
            int coachesN2Pt = 0;
            int coachesN2Ft = 0;

            while ((str=br.readLine())!=null) {
                String[] teamInfo;
                String[] coaches;
                int s;

                teamInfo = str.split(",");
                coaches = teamInfo[1].split(":");
                              
                try{  
                    FootballTeams.add(new FootballTeam(teamInfo[0], teamInfo[1],teamInfo[2], Integer.valueOf(teamInfo[3]), Boolean.parseBoolean(teamInfo[4])));
                    
                    //out.println (str);
                    //out.println("Coaches:"+coaches.length+"\n");
                    //conference League
                    if(teamInfo[2].startsWith("c".toUpperCase())){
                        //out.println("Conference league");
                        if((Integer.valueOf(teamInfo[3]))== 1){
                            coachesC1 = coachesC1 + coaches.length;
                            if(teamInfo[4].startsWith("y".toLowerCase())){
                                coachesC1Ft = coachesC1Ft + coaches.length;
                                }
                            else if(teamInfo[4].startsWith("n".toLowerCase())){
                                   coachesC1Pt = coachesC1Pt + coaches.length;
                                }   
                            }
                        else if((Integer.valueOf(teamInfo[3]))== 2){
                            coachesC2 = coachesC2 + coaches.length;
                            if(teamInfo[4].startsWith("y".toLowerCase())){
                                coachesC2Ft = coachesC2Ft + coaches.length;
                                }
                            else if(teamInfo[4].startsWith("n".toLowerCase())){
                                   coachesC2Pt = coachesC2Pt + coaches.length;
                                } 
                            }
                           
                        }
                    
                    //National League
                    else if(teamInfo[2].startsWith("n".toUpperCase())){
                        //out.println("National league");
                        if((Integer.valueOf(teamInfo[3]))== 1){
                            coachesN1 = coachesN1 + coaches.length;
                            if(teamInfo[4].startsWith("y".toLowerCase())){
                                coachesN1Ft = coachesN1Ft + coaches.length;
                                }
                            else if(teamInfo[4].startsWith("n".toLowerCase())){
                                coachesN1Pt = coachesN1Pt + coaches.length;
                                } 
                            }
                        else if((Integer.valueOf(teamInfo[3]))== 2){
                            coachesN2 = coachesN2 + coaches.length;
                            if(teamInfo[4].startsWith("y".toLowerCase())){
                                coachesN2Ft = coachesN2Ft + coaches.length;
                                }
                            else if(teamInfo[4].startsWith("n".toLowerCase())){
                                   coachesN2Pt = coachesN2Pt + coaches.length;
                                } 
                           }
                        }
                    }
                
                    catch (NumberFormatException e){          
                    }
                
                try {
                myJTextArea.replaceRange("Football Teams",myJTextArea.getLineStartOffset(0),myJTextArea.getLineStartOffset(1)-1);
                } catch (BadLocationException ex) {
                    //Logger.getLogger(ModuleWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                myJTextArea.append(str+"Coaches :"+coaches.length+"\n");
                }
            //Total Coaches
                int coachesCTotal = coachesC1 + coachesC2;
                int coachesNTotal = coachesN1 + coachesN2;
                int coachesTotal = coachesCTotal + coachesNTotal;
                
                int coachesCFtTotal = coachesC1Ft + coachesC2Ft;
                int coachesCPtTotal = coachesC1Pt + coachesC2Pt;
                
                int coachesNFtTotal = coachesN1Ft + coachesN2Ft;
                int coachesNPtTotal = coachesN1Pt + coachesN2Pt;
                int coachesFtTotal = coachesNFtTotal + coachesCFtTotal;
                int coachesPtTotal = coachesNPtTotal + coachesCPtTotal;
                //Conference String Builder
                String Conference = ("Conference League Coaches");
                Conference =( Conference + "\n" + "Conference League: "+ coachesCTotal+" (Fulltime: "+ coachesCFtTotal +" | Part time: "+ coachesCPtTotal+")");
                Conference =( Conference + "\n" +"Conference League 1: "+ coachesC1 +" (Fulltime: "+ coachesC1Ft +" | Part time: "+ coachesC1Pt+")");
                Conference =( Conference + "\n" +"Conference League 2: "+ coachesC2 +" (Fulltime: "+ coachesC2Ft +" | Part time: "+ coachesC2Pt+")");
                //out.println (Conference);
                
                //out.println("\n");
                //National String Builder
                String National = ("National League Coaches");
                National =( National + "\n"+ "National League: "+ coachesNTotal +" (Fulltime: "+ coachesNFtTotal +" | Part time: "+ coachesNPtTotal+")");
                National =( National + "\n"+"National League 1: "+ coachesN1 +" (Fulltime: "+ coachesN1Ft +" | Part time: "+ coachesN1Pt+")");
                National =( National + "\n"+"National League 2: "+ coachesN2 +" (Fulltime: "+ coachesN2Ft +" | Part time: "+ coachesN2Pt+")"+"\n");
                //out.println(National);
                
                String Total = ("Total Coaches: "+ coachesTotal+" (Fulltime: "+ coachesFtTotal +" | Part time: "+ coachesPtTotal+")");
                //out.println(Total);
               myJTextArea.append("\n"+Conference+"\n\n"+National+"\n"+Total);
            }
        
        catch (FileNotFoundException ex)
        {
            out.println("ERROR FILE NOT FOUND");
        }
        catch (IOException ex)
        {
            /*    Logger.getLogger(InRead.class.getName()).log(Level.SEVERE, null, ex);*/
            out.println("ERROR IN FILE");
        }   
        tabs.addTab("Coaches", myJTextArea);
        /*
        // code for JTextArea End
        */
        this.add(tabs,BorderLayout.CENTER);
        
        this.setSize(800,400);
        this.pack();
        this.setVisible(true);
        
    }
  
 class ControlPanelEvent implements ActionListener {

    @Override
    public void actionPerformed( ActionEvent actionEvent){
        if ( actionEvent.getActionCommand() == "Refresh"){
            viewPanel.update();
        
            }
        else if (actionEvent.getActionCommand() == "SortByList"){
            JComboBox sortByList = (JComboBox)actionEvent.getSource();
            int selectedIndex = sortByList.getSelectedIndex();
            switch (selectedIndex){
                case 0:  MainModel.sortFootballTeamsByTeamName(); break;
                case 1:  MainModel.sortFootballTeamsByLeague(); break;
            }  
            viewPanel.update();
        }
       
         else if (actionEvent.getActionCommand() == "SortByTeamName"){
            MainModel.sortFootballTeamsByTeamName();
            viewPanel.update();
        }
         else if (actionEvent.getActionCommand() == "SortByLeague"){
            MainModel.sortFootballTeamsByLeague();
            viewPanel.update();
        }
        else if (actionEvent.getActionCommand() == "Quit"){
            System.exit(0);
        }
    } 
      
}
 
}
