/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.model;

import uk.ac.kingston.ci5100.footballsoftwarecompany_A2Pair2.model.utils.Convertors;


/**
 *
 * @author Anas Adurker
 */
public class FootballTeam {

    FootballTeam() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public FootballTeam(String teamName, String coachName, String league, int division, boolean fulltime){
        this.teamName = teamName;
        this.coachName= coachName;
        this.league = league;
        this.division = division;
        this.fulltime = fulltime;
    }
    public FootballTeam(String csvString){
        String[] attributes = Convertors.getStringAsArray(csvString,",");
        this.teamName = attributes[0];
        this.coachName = attributes[1];
        this.league = attributes[2];
        this.division = Integer.valueOf(attributes[3]);

        String fulltimeString = attributes[4];
        if (fulltimeString.startsWith("Y".toLowerCase()))
        {
            this.fulltime = true;
        }
        else if (fulltimeString.startsWith("n".toLowerCase()))
        {
            this.fulltime = false;
        }
    }
  /*{
      String[] attributes = Convertors.getStringAsArray(csvString,",");
      
      this.id = attributes[0];
      this.givenNames = Convertors.getStringAsArray(attributes[1]);
      this.familyNames = Convertors.getStringAsArray(attributes[2]);
      this.gender = attributes[3];

      String fulltimeString = attributes[4];
      if (fulltimeString.equals("yes"))
      {
        this.fulltime = true;
      }
      else
      {
          this.fulltime = false;
      }
  }*/

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     *
     * @return
     */
    public String getCoachName(){
        return coachName;
    }
    
    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }
    
    /**
     *
     * @return
     */

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }
    
    /**
     *
     * @return
     */

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }
    
    /**
     *
     * @return
     */

    public Boolean getFulltime() {
        //.startsWith("y".toLowerCase())
        return fulltime;
    }

    /**
     *
     * @param ft
     */
    public void setFulltime(boolean ft) {
        if (this.getFulltime().toString().startsWith("Y".toLowerCase())){
            this.fulltime = true;
        }
       if (this.getFulltime().toString().startsWith("N".toLowerCase())){
        this.fulltime = false;    
       }
           
    }
    
    /**
     *
     * @return
     */
    
    /**
     *
     * @param teamName
     * @param coachName
     * @param league
     * @param division
     * @param fulltime
     */
    
    private String teamName;
    private String coachName;
    private String league;
    private int division;
    private boolean fulltime;
    /*private String[] getStringasArray(String t)
    {
    String[] teamname = t.split(":");
    return teamname;
    }
    */
   @Override
    public String toString()
    {
        return teamName + "\t" + coachName + "\t" 
                + league + "\t" + division + "\t" 
                + fulltime + "\t" + "\n";
    }

    
}
    
    
     
    


