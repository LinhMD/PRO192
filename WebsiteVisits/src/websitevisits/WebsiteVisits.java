/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websitevisits;

/**
 *
 * @author USER
 */
public class WebsiteVisits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String temp = InputValidation.getString("Input File name\n", "File name must not empty");
//        FileDAO.ReadFile(temp);
        LogAnalyzer obj = new LogAnalyzer();
        System.out.println("count visits per id");
        System.out.println(obj.countVisitsPerIP(temp));
        System.out.println("most number visits by id");
        System.out.println(obj.mostNumberVisitsByIP(obj.countVisitsPerIP(temp)));
        System.out.println("ip most visit");
        System.out.println(obj.iPsMostVisits(obj.countVisitsPerIP(temp)));
        System.out.println("ip for days");
        System.out.println(obj.iPsForDays(temp));
        System.out.println("day with most ip visits");
        System.out.println(obj.dayWithMostIPVisits(obj.iPsForDays(temp)));
        String date = InputValidation.getString("input date", "date must not empty");
        System.out.println(obj.iPsWithMostVisitsOnDay(obj.iPsForDays(temp), date));
        
    }
    
}
