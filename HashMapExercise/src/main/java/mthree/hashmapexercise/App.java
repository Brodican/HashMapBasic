/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.hashmapexercise;

/**
 *
 * @author utkua
 */
public class App {
    
    public static void main(String[] args) {
        HashMapEx<String,String> hashy = new HashMapEx();
        String sj = "sj";
        String js = "js";
        hashy.putEntry(sj, js);
        hashy.putEntry("xx", "xs");
        hashy.putEntry("xe", "xz");
        hashy.putEntry("mm", "ml");
        hashy.putEntry("md", "mo");
        hashy.putEntry("ms", "mr");
        hashy.putEntry("mq", "mnd");
        hashy.putEntry("mp", "ssc");
        String got = hashy.getEntry(sj).getValue();
        
        System.out.println("got: " + got);
    }
    
}
