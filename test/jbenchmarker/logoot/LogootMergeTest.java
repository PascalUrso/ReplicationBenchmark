/**
 *   This file is part of ReplicationBenchmark.
 *
 *   ReplicationBenchmark is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   ReplicationBenchmark is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with ReplicationBenchmark.  If not, see <http://www.gnu.org/licenses/>.
 *
 **/

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.logoot;
import java.math.BigInteger;
import jbenchmarker.core.Operation;
import jbenchmarker.trace.TraceOperation;
import java.util.ArrayList;
import java.util.List;



import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import jbenchmarker.trace.IncorrectTrace;

/**
 *
 * @author mehdi
 */
public class LogootMergeTest 
{
      
         // helpers
    TraceOperation insert(int p, String s) {
        return TraceOperation.insert(1, p, s, null); //Replica , position , content , VH
    }
    TraceOperation delete(int p, int o) {
         return TraceOperation.delete(1, p, o, null);//Replica , position , offset , VH
    }
    
//    @Test
//    public void testgenerateLineIdentifiersCas1()
//    {
//         System.out.println("Test LogootMerge ...");
//          
//       LogootMerge LM = new LogootMerge(new LogootDocument(), 1);
//       LogootDocument lg = (LogootDocument) (LM.getDoc());
//       
//       LogootIdentifier P = new LogootIdentifier();
//       LogootIdentifier Q = new LogootIdentifier();
//       LogootIdentifier R = new LogootIdentifier();
//         
//       Component c1 = new Component(BigInteger.valueOf(100),2,105);
//       Component c2 = new Component(BigInteger.valueOf(980),3,107);
//         
//       Component c4 = new Component(BigInteger.valueOf(100),4,150);
//       Component c5 = new Component(BigInteger.valueOf(990),5,152);
//         
//       P.addComponent(c1); P.addComponent(c2);
//       Q.addComponent(c4); Q.addComponent(c5);
//       
//       ArrayList<LogootIdentifier> patch = LM.generateLineIdentifiers(P, Q, 100);
//       
//        assertEquals(100, patch.size());
//        
//        for(int i=0; i<patch.size()-1;i++)
//        {
//            assertEquals(false, patch.get(i).isLessThan(P));
//            assertEquals(true, P.isLessThan(patch.get(i)));
//            
//            assertEquals(true, patch.get(i).isLessThan(patch.get(i+1)));
//            assertEquals(false, patch.get(i+1).isLessThan(patch.get(i)));
//            
//            assertEquals(true, patch.get(i).isLessThan(Q));
//            assertEquals(false, Q.isLessThan(patch.get(i)));
//        }
//    }
//    
//    @Test
//    public void testgenerateLineIdentifiersCas2()
//    {
//       //Boucle infinie        
//       LogootMerge LM = new LogootMerge(new LogootDocument(), 1);
//       LogootDocument lg = (LogootDocument) (LM.getDoc());
//       
//       LogootIdentifier P = new LogootIdentifier();
//       LogootIdentifier Q = new LogootIdentifier();
//         
//       Component c1 = new Component(BigInteger.valueOf(20),4,50); 
//       Component c2 = new Component(BigInteger.valueOf(30),4,60);
//       Component c3 = new Component(BigInteger.valueOf(40),4,70);
//       
//       Component c4 = new Component(BigInteger.valueOf(20),6,60);
//       Component c5 = new Component(BigInteger.valueOf(30),6,60);
//       Component c6 = new Component(BigInteger.valueOf(40),6,60);
//         
//       P.addComponent(c1); P.addComponent(c2); P.addComponent(c3);
//       Q.addComponent(c4); Q.addComponent(c5); Q.addComponent(c6);
//
//        ArrayList<LogootIdentifier> patch = LM.generateLineIdentifiers(P, Q, 100);
//        
//        assertEquals(100, patch.size());
//        
//        for(int i=0; i<patch.size()-1;i++)
//        {
//            assertEquals(false, patch.get(i).isLessThan(P));
//            assertEquals(true, P.isLessThan(patch.get(i)));
//            
//            assertEquals(true, patch.get(i).isLessThan(patch.get(i+1)));
//            assertEquals(false, patch.get(i+1).isLessThan(patch.get(i)));
//            
//            assertEquals(true, patch.get(i).isLessThan(Q));
//            assertEquals(false, Q.isLessThan(patch.get(i)));
//        }
//    }
//  
//    
//    
//     @Test
//    public void testgenerateLineIdentifiersCas3()
//    {
//       //Boucle infinie        
//       LogootMerge LM = new LogootMerge(new LogootDocument(), 1);
//       LogootDocument lg = (LogootDocument) (LM.getDoc());
//       
//       LogootIdentifier P = new LogootIdentifier();
//       LogootIdentifier Q = new LogootIdentifier();
//         
//       Component c1 = new Component(BigInteger.valueOf(20),4,50); 
//       Component c2 = new Component(BigInteger.valueOf(10),6,60);
//       
//       Component c4 = new Component(BigInteger.valueOf(20),6,60);
//       Component c5 = new Component(BigInteger.valueOf(30),4,60);
//       Component c6 = new Component(BigInteger.valueOf(40),4,70);
//       
//       P.addComponent(c1); P.addComponent(c2);
//       Q.addComponent(c4); Q.addComponent(c5); Q.addComponent(c6);
//
//        ArrayList<LogootIdentifier> patch = LM.generateLineIdentifiers(P, Q, 100);
//        
//        assertEquals(100, patch.size());
//        
//        for(int i=0; i<patch.size()-1;i++)
//        {
//            assertEquals(false, patch.get(i).isLessThan(P));
//            assertEquals(true, P.isLessThan(patch.get(i)));
//            
//            assertEquals(true, patch.get(i).isLessThan(patch.get(i+1)));
//            assertEquals(false, patch.get(i+1).isLessThan(patch.get(i)));
//            
//            assertEquals(true, patch.get(i).isLessThan(Q));
//            assertEquals(false, Q.isLessThan(patch.get(i)));
//        }
//
//    }
//    
    @Test
    public void testgenerateLocal()
    { 
        LogootMerge LM = new LogootMerge(new LogootDocument(Long.MAX_VALUE), 1, 64, new BoundaryStrategy(1000000000)); 
        LogootDocument lg = (LogootDocument) (LM.getDoc());
        
        List<Operation> a = LM.generateLocal(insert(0, "a"));  //a
        assertEquals(1, a.size());
        assertEquals("a", LM.getDoc().view());


        a = LM.generateLocal(insert(0, "gf")); //gfa
        assertEquals(2, a.size());
        assertEquals("gfa", LM.getDoc().view());

        a = LM.generateLocal(delete(0, 1));//gf
        assertEquals(1, a.size());
        assertEquals("fa", LM.getDoc().view());

        a = LM.generateLocal(insert(1, "EKL"));//fEKLa
        assertEquals(3, a.size());
        assertEquals("fEKLa", LM.getDoc().view());


        a = LM.generateLocal(delete(1, 3));//La
        assertEquals("fa", LM.getDoc().view());
    }

//
//    @Test(expected=IndexOutOfBoundsException.class)
//    public void testIns() throws IncorrectTrace
//    {
//          LogootMerge LM = new LogootMerge(new LogootDocument(), 1);
//          LM.generateLocal(insert(10,"a"));
//          fail("Out of bound insert not detected.");    
//    }
//
//    @Test(expected=java.lang.AssertionError.class) //contrairement à IndexOutOfBoundsException
//    public void testDel() throws IncorrectTrace
//    {
//        LogootMerge LM = new LogootMerge(new LogootDocument(), 1);
//        LM.generateLocal(delete(0,1));
//        fail("Out of bound delete not detected."); 
//    }
//    

}
