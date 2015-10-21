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
        
        DPDTest t = new DPDTest();
        ClientRetailAddress cra = new ClientRetailAddress();
        cra.setClientRetailAddressCity("Астрахань");
        cra.setClientRetailAddressId(1);
        cra.setClientRetailAddressStreet("Улица Каменноярская");
        cra.setClientRetailAddressHouseNumber("33");
        cra.setClientRetailAddressApartment("1");
        
        DpdClientAddressStatus dpdStatus = t.createDPDAddress(cra);
        
        System.out.println("createAddress");
        System.out.println("---------------");
        System.out.println("address status:");
        System.out.println("code: " + dpdStatus.getCode());
        System.out.println("status: " + dpdStatus.getStatus());
        System.out.println("errorMessage: " + dpdStatus.getErrorMessage());
        System.out.println("---------------");
        
        if(dpdStatus.getCode().equals("1")){
            dpdStatus = t.updateDPDAddress(cra);
            System.out.println("updateAddress");
            System.out.println("address status:");
            System.out.println("code: " + dpdStatus.getCode());
            System.out.println("status: " + dpdStatus.getStatus());
            System.out.println("errorMessage: " + dpdStatus.getErrorMessage());
            System.out.println("---------------");            
        }
//        t.makeExcelFromAdressList();
        
        
    }
       
}
