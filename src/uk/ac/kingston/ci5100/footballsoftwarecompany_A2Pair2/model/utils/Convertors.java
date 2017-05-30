/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.model.utils;

import java.util.ArrayList;
import uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.model.FootballTeam;

/**
 *
 * @author Anas Adurker
 */

public class Convertors {

    /**
     *
     * @param s
     * @param a
     * @return
     */
    public static String[] getStringAsArray(String s)
    {        
        return getStringAsArray(s," ");
    }

    public static String[] getStringAsArray(String s, String seperate)
    {
        String[] result = s.split(seperate);
        return result;
    }
    
    
    public static String getArrayAsString(String[] a)
    {
        String result = "";

        for(String f: a)
        {
            result += f + " ";
        }

        result = result.trim();
        return result;
    }
    
    /**
     *
     * @param array
     * @return
     */
    public static String footballTeamListToString(ArrayList<FootballTeam> array)
    {
        String result = "";
        for (FootballTeam one : array) {
            result = result + one.toString();
        }
        return result;
   }
    
    /**
     *
     * @param array
     * @return
     */
    public static String listToString(ArrayList array)
    {
        String result = "";
        for (Object one : array)
        {
            result = result + one.toString();
        }
        return result;
   }
}