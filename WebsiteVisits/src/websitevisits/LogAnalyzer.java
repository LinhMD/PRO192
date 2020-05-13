/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websitevisits;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author USER
 */
public class LogAnalyzer {
    private ArrayList<LogEntry> Log;
    public LogAnalyzer(){
        this.Log = new ArrayList<>();
    }
    public HashMap<String,Integer> countVisitsPerIP(String fileName){
        this.Log = FileDAO.ReadFile(fileName);
        HashMap<String, Integer> map = new HashMap<>();
        Log.forEach((log) -> {
            boolean check = true;
            Set<String> key = map.keySet();
            for (String string : key) {
                if(string.equals(log.getIpAddress()))
                    check = false;
            }
            if (check) 
                map.put(log.getIpAddress(), this.countVisits(log.getIpAddress()));
        });
        return map;
    }
    public int countVisits(String IpAdress){
        int count = 0;
        count = Log.stream().filter((log) -> (log.getIpAddress().equals(IpAdress))).map((_item) -> 1).reduce(count, Integer::sum);
        return count;
    }
    public int mostNumberVisitsByIP(HashMap<String, Integer> map){
        Collection<Integer> list = map.values();
        int max = 0;
        for (Integer integer : list) {
            if (max < integer)
                max = integer;
        }
        return max;
    }
    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> map){
        int max = this.mostNumberVisitsByIP(map);
        ArrayList<String> List = new ArrayList<>();
        Set<String> s = map.keySet();
        s.stream().filter((key) -> (map.get(key) == max)).forEachOrdered((key) -> {
            List.add(key);
        });
        return List;
    }
    public HashMap<String, ArrayList<String>> iPsForDays(String fileName){
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        this.Log = FileDAO.ReadFile(fileName);
        Log.forEach((log1) -> {
            Set<String> key = map.keySet();
            boolean check = true;
            for (String string : key) {
                if(string.equals(log1.getAccessTime()))
                    check = false;
            }
            if (check) {
                ArrayList<String> IpAdress = new ArrayList<>();
                Log.stream().filter((log2) -> (log1.getAccessTime().equals(log2.getAccessTime()))).forEachOrdered((log2) -> {
                    IpAdress.add(log2.getIpAddress());
                });
                map.put(log1.getAccessTime(), IpAdress);
            }
        });
        return map;
    }
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map){
        String maxS = "nah";
        int max = 0;
        Set<String> Key = map.keySet();
        for (String key : Key) {
            ArrayList<String> temp = map.get(key);
            if(temp.size() > max){
                maxS = key;
                max = temp.size();
            }
        }
        return maxS;
    }
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> list, String date){
        Set<String> keys = list.keySet();
        ArrayList<String> result = new ArrayList();
        if(!list.containsKey(date)) return null;
        for (String key : keys) {
            if(key.equalsIgnoreCase(date)){
                HashMap<String, Integer> most = new HashMap();
                ArrayList<String> ips = list.get(key);
                ips.forEach((ip) -> {
                    if(most.containsKey(ip)){
                        int count = most.get(ip);
                        most.put(ip, ++count);
                    }else{
                        most.put(ip, 1);
                    }
                });
                result = this.iPsMostVisits(most);
            }
        }
        return result;
    }
}
