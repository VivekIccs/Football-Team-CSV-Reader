/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.model.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.model.FootballTeam;

/**
 *
 * @author Anas Adurker
 */
public class DataFiles {
    
    private static ArrayList<String> readTextFile(String csvFile) throws IOException
    {
        
        ArrayList<String> result = new ArrayList<>();
        BufferedReader infile = null;
        infile = new BufferedReader(new FileReader(csvFile));
        while (infile.ready())
        {
            String nextline = infile.readLine();
            nextline = nextline.trim();
            result.add(nextline);
        }
        infile.close();
        return result;
    }


    public static ArrayList<FootballTeam> readFootballTeams(String file)
    {
        ArrayList<FootballTeam> results = new ArrayList<>();
        try
        {
            ArrayList<String> teamsFileAsStrings = readTextFile(file);
            String remove;
            remove = teamsFileAsStrings.remove(0);
            
            for (String oneLine : teamsFileAsStrings)
            {
                FootballTeam oneTeam;
                oneTeam = new FootballTeam(oneLine);
                results.add(oneTeam);
            }
            

        }
        catch (IOException ioex)
        {
            System.out.println("Failed to read the file " + file);
        }
        
        return results;
    }
}
