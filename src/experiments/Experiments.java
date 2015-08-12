/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package experiments;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import experiments.DPDTest;

/**
 *
 * @author dimasik
 */




public class Experiments {
    
    public static void main(String[] args) {
        DPDTest.run();
    }
    


    /**
     * @param args the command line arguments
     */
    public static void main2(String[] args) {
        // TODO code application logic here
//        Cat myCat= new Cat();
//        Animal myAnimal = myCat;
//        myCat.sayA();
//        myAnimal.say();
        List<Map<String,Object>> a = new ArrayList<Map<String,Object>>();
//        String c = null;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("1",null);
        a.add(null);
        a.add(map);
        
//        for (Map a1 : a) {
//            if(a1!=null && !a1.equals("") && !a1.equals("sdfs")){
//                System.out.println(a1);
//            }
//        }
        
        MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
        
        BigDecimal axz = new BigDecimal(0, MathContext.DECIMAL64);
        BigDecimal b = new BigDecimal(131161.2, MathContext.DECIMAL64);
        BigDecimal c = new BigDecimal(51, MathContext.DECIMAL64);
                
        axz = b.divide(c, 4, RoundingMode.HALF_UP);
//        BigDecimal axze = new BigDecimal(1).multiply(new BigDecimal(12334));
        System.out.println(axz);
//        System.out.println(a.get(0).equals(null));
        System.out.println(Math.abs(-1));
        
//        Integer i = 1025;
//        double asd = (double)i/30;
//        System.out.println(Integer.MAX_VALUE);
        
        
        BigDecimal bd = new BigDecimal(100);
        
        
        boolean cond = true;
 int i = 0;
System.out.print(cond ? 'X' : 0);
System.out.print(cond ? 'X' : i);
  

    }
    
}
