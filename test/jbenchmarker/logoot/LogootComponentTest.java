/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.logoot;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mehdi
 */
public class LogootComponentTest {
  
    @Test
    public void testEquals() {
        assertEquals(new Component(4,5,99999), new Component(4,5,99999));
    }
    
//   @Test
//    public void testComponent() 
//    {
//        System.out.println("Test Component ...");
//         
//        //Creation
//        Component c1 = new Component(BigInteger.valueOf(20),4,50);        
//        assertEquals(BigInteger.valueOf(20),c1.getDigit());
//        assertEquals(4,c1.getPeerID());
//        assertEquals(50,c1.getClock());
//
//    }
//   
//   @Test
//    public void testSet() 
//    {
//         Component c1 = new Component(BigInteger.valueOf(20),4,50);
//
//         c1.setDigit(BigInteger.valueOf(20)); c1.setPeerID(5); c1.setClock(60);
//         assertEquals(BigInteger.valueOf(20),c1.getDigit());
//         assertEquals(5,c1.getPeerID());
//         assertEquals(60,c1.getClock());
//    }
//   
//   
//   @Test
//    public void testEqualsTo() 
//    {
//        Component c1 = new Component(BigInteger.valueOf(20),4,50);
//        Component c2 = new Component(BigInteger.valueOf(20),4,50);
//
//        assertEquals(true,c1.equalsTo(c2)); 
//    }
//   
//   @Test
//    public void testIsLessThan() 
//    {
//        Component c1 = new Component(BigInteger.valueOf(20),4,50);
//
//        Component c2 = new Component(BigInteger.valueOf(20),6,50);
//        assertEquals(true,c1.isLessThan(c2));
//        
//    }
}
