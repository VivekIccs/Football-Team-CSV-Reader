/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.model.*;

/**
 *
 * @author Anas Adurker
 */
public class MainTextOutput {

    
    public MainTextOutput(){
    }
    
    public static void main(String args[])throws IOException{
        try{
        
        
        FileReader fr = new FileReader("football_A2.csv");
        BufferedReader br = new BufferedReader(fr);
        ArrayList<FootballTeam> FootballTeams;          
        FootballTeams = new ArrayList <>();
        String str;
        
        //Coference League 1
            int coachesC1 = 0;
            int coachesC1Pt = 0;
            int coachesC1Ft = 0;
            
            //Conference League 2
            int coachesC2 = 0;
            int coachesC2Pt = 0;
            int coachesC2Ft = 0;
            
            //National League 1
            int coachesN1 = 0;
            int coachesN1Pt = 0;
            int coachesN1Ft = 0;
            
            //National League 2
            int coachesN2 = 0;
            int coachesN2Pt = 0;
            int coachesN2Ft = 0;

        while ((str=br.readLine())!=null) {
            String[] teamInfo;
            String[] coaches;
            int coachesLength;
            
            /*
            //ERROR FOUND
            // coaches = str.split(":")
            //Output value:
            //teamInfo[0] + teamInfo[1]
            */
                
            /*
            // ERROR FIX:
            //coaches = teamInfo[1].split(":");
            //Declared as an array in main
            // used Split to seperate into Array elements
            */
            
            teamInfo = str.split(",");
            coaches = teamInfo[1].split(":");
            coachesLength = coaches.length;
            
            
                                 
                try{  
                    FootballTeams.add(new FootballTeam(teamInfo[0], teamInfo[1],teamInfo[2], Integer.valueOf(teamInfo[3]), Boolean.parseBoolean(teamInfo[4])));

                    String teamCoachesStr;
                    teamCoachesStr = (str+","+coachesLength+" coaches");
                    out.println(teamCoachesStr);
                    
                    //out.println(coaches[0]);
                    //out.println("Coaches:"+coachesLength);
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
            }
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
                String Conference = ("\n"+"Conference League Coaches");
                Conference =( Conference + "\n" + "Conference League: "+ coachesCTotal+" (Fulltime: "+ coachesCFtTotal +" | Part time: "+ coachesCPtTotal+")");
                Conference =( Conference + "\n" +"Conference League 1: "+ coachesC1 +" (Fulltime: "+ coachesC1Ft +" | Part time: "+ coachesC1Pt+")");
                Conference =( Conference + "\n" +"Conference League 2: "+ coachesC2 +" (Fulltime: "+ coachesC2Ft +" | Part time: "+ coachesC2Pt+")");
                out.println (Conference);
                
                out.println("\n");
                //National String Builder
                String National = ("National League Coaches");
                National =( National + "\n"+ "National League: "+ coachesNTotal +" (Fulltime: "+ coachesNFtTotal +" | Part time: "+ coachesNPtTotal+")");
                National =( National + "\n"+"National League 1: "+ coachesN1 +" (Fulltime: "+ coachesN1Ft +" | Part time: "+ coachesN1Pt+")");
                National =( National + "\n"+"National League 2: "+ coachesN2 +" (Fulltime: "+ coachesN2Ft +" | Part time: "+ coachesN2Pt+")"+"\n");
                out.println(National);
                
                String Total = ("Total Coaches: "+ coachesTotal+" (Fulltime: "+ coachesFtTotal +" | Part time: "+ coachesPtTotal+")");
                out.println(Total);
        }
        
        catch (FileNotFoundException e){
            out.println("File not found");
        }
        
                  
    }
}
            

