/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Anas Adurker
 */
public class MainModel {
    private static ArrayList<FootballTeam> footballTeams = new ArrayList<>();
    
    public static String[] footballTeamsFileHeader;
    
    public static FootballTeam getFootballTeamFromTeamName(String targetTeamName)
    {
        for (FootballTeam a : footballTeams)
        {
            if (a != null)
            {
                if (a.getTeamName().equals(targetTeamName)) return a;
            }
        }
        return null;
    }
    public static ArrayList<FootballTeam> getFootballTeams()
    {
        return footballTeams;
    }

    /**
     *
     * @param footballTeams
     */
    public static void setFootballTeams(ArrayList<FootballTeam> footballTeams)
    {
        MainModel.footballTeams = footballTeams;
    }
    
    public static String[] getFootballTeamsFileHeader()
    {
        return footballTeamsFileHeader;
    }

    public static void setFootballTeamsFileHeader(String[] footballTeamsFileHeader)
    {
        MainModel.footballTeamsFileHeader = footballTeamsFileHeader;
    }
      public static void sortFootballTeamsByTeamName(){
          Collections.sort(footballTeams, new FootballTeamNameCompare()); 
       }
        public static void sortFootballTeamsByLeague(){
          Collections.sort(footballTeams, new FootballTeamLeagueCompare()); 
       }
}
