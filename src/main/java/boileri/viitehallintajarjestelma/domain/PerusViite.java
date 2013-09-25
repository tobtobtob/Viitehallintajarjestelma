/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.domain;

import java.util.ArrayList;

/**
 *
 * @author Outt
 */
public class PerusViite extends Viite{
    private String a;
    private String b;
    private String c;
    private String d;
    
    public PerusViite(ArrayList<String> A) {
        this.a = A.get(0);
        this.b = A.get(1);
        this.c = A.get(2);
        this.d = A.get(3);             
    }
    
    @Override
    public String toString() {
        String x = "Aaa:"+a+"\nBee"+b+"\nCee"+c+"\nDee"+d;
        return x;
    }
    
}
