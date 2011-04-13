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

package jbenchmarker.woot.wooth;

import jbenchmarker.trace.TraceOperation;
import jbenchmarker.woot.WootIdentifier;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author urso
 */
public class WootHDocumentTest {

   
//    WootHashNode a, b, c, d, e, f, g, h, x, z;


    public WootHDocumentTest() {
//        c = new WootHashNode(new WootIdentifier(1,1), 'c', true, instance.getFirst().getNext(), 1);
//        b = new WootHashNode(new WootIdentifier(1,2), 'b', false, c, 1);
//        a = new WootHashNode(new WootIdentifier(2,1), 'a', true, b, 1);
        
//        z = new WootHashNode(new WootIdentifier(1,3), 1, 'z', false);
//        a = new WootHashNode(new WootIdentifier(1,1), 1, 'a', true);
//        b = new WootHashNode(new WootIdentifier(2,1), 2, 'b', true);
//        c = new WootHashNode(new WootIdentifier(2,2), 3, 'c', false);
//        d = new WootHashNode(new WootIdentifier(3,1), 2, 'd', false);
//        e = new WootHashNode(new WootIdentifier(3,2), 3, 'e', false);
//        f = new WootHashNode(new WootIdentifier(3,3), 4, 'f', false);
//        g = new WootHashNode(new WootIdentifier(3,4), 3, 'g', true);
//        h = new WootHashNode(new WootIdentifier(4,1), 4, 'h', true);
//        x = new WootHashNode(new WootIdentifier(1,2), 1, 'x', true);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
 
    /**
     * Test of view method, of class WootHDocumentTest.
     */
    @Test(timeout=100)
    public void testView() {
        System.out.println("view");
        WootHashDocument instance = new WootHashDocument();

        assertEquals("", instance.view()); 
                
        WootHashNode c = new WootHashNode(new WootIdentifier(1,1), 'c', true, instance.getFirst().getNext(), 1);
        instance.getFirst().setNext(c);
        assertEquals("c", instance.view()); 
        
        WootHashNode b = new WootHashNode(new WootIdentifier(1,2), 'b', false, c, 1);
        instance.getFirst().setNext(b);
        assertEquals("c", instance.view()); 
        
        WootHashNode a = new WootHashNode(new WootIdentifier(2,1), 'a', true, b, 1);
        instance.getFirst().setNext(a);                
        assertEquals("ac", instance.view());          
    }


    /**
     * Test of getVisible method, of class WootHDocumentTest.
     */
    @Test(timeout=100)
    public void testGetVisible() {
        System.out.println("getVisible");
        WootHashDocument instance = new WootHashDocument();
       
        WootHashNode c = new WootHashNode(new WootIdentifier(1,1), 'c', true, instance.getFirst().getNext(), 1);
        instance.getFirst().setNext(c);
        assertEquals(c, instance.getVisible(0));
        
        WootHashNode b = new WootHashNode(new WootIdentifier(1,2), 'b', false, c, 1);
        instance.getFirst().setNext(b);
        assertEquals(c, instance.getVisible(0));
        
        WootHashNode a = new WootHashNode(new WootIdentifier(2,1), 'a', true, b, 1);
        instance.getFirst().setNext(a);
        assertEquals(a, instance.getVisible(0));
        assertEquals(c, instance.getVisible(1));
    }
    
    /**
     * Test of nextVisible method, of class WootHDocumentTest.
     */
    @Test(timeout=100)
    public void testNextVisible() {
        System.out.println("nextVisible");
        WootHashDocument instance = new WootHashDocument();
       
        WootHashNode c = new WootHashNode(new WootIdentifier(1,1), 'c', true, instance.getFirst().getNext(), 1);
        instance.getFirst().setNext(c);
        assertEquals(c, instance.nextVisible(instance.getFirst()));
        
        WootHashNode b = new WootHashNode(new WootIdentifier(1,2), 'b', false, c, 1);
        instance.getFirst().setNext(b);
        assertEquals(c, instance.nextVisible(instance.getFirst()));
        
        WootHashNode a = new WootHashNode(new WootIdentifier(2,1), 'a', true, b, 1);
        instance.getFirst().setNext(a);
        assertEquals(a, instance.nextVisible(instance.getFirst()));
        assertEquals(c, instance.nextVisible(a));
    }
    
    /**
     * Test of getVisible method, of class WootHDocumentTest.
     */
    @Test(timeout=100)
    public void testGetPrevious() {
        System.out.println("getPrevious");
        WootHashDocument instance = new WootHashDocument();
        assertEquals(instance.getFirst(), instance.getPrevious(0));
       
        WootHashNode c = new WootHashNode(new WootIdentifier(1,1), 'c', true, instance.getFirst().getNext(), 1);
        instance.getFirst().setNext(c);
        assertEquals(instance.getFirst(), instance.getPrevious(0));        
        assertEquals(c, instance.getPrevious(1));
        
        WootHashNode b = new WootHashNode(new WootIdentifier(1,2), 'b', false, c, 1);
        instance.getFirst().setNext(b);
        assertEquals(instance.getFirst(), instance.getPrevious(0));
        assertEquals(c, instance.getPrevious(1));
        
        WootHashNode a = new WootHashNode(new WootIdentifier(2,1), 'a', true, b, 1);
        instance.getFirst().setNext(a);
        assertEquals(instance.getFirst(), instance.getPrevious(0));
        assertEquals(a, instance.getPrevious(1));
        assertEquals(c, instance.getPrevious(2));
    }
    
    /**
     * Test of getVisible method, of class WootHDocumentTest.
     */
    @Test(timeout=100)
    public void testGetNext() {
        System.out.println("getNext");
        WootHashDocument instance = new WootHashDocument();
        WootHashNode CB = instance.getFirst(), CE = instance.getFirst().getNext();
        assertEquals(CE, instance.getNext(CB));
       
        WootHashNode c = new WootHashNode(new WootIdentifier(1,1), 'c', true, instance.getFirst().getNext(), 1);
        instance.getFirst().setNext(c);
        assertEquals(c, instance.getNext(CB));
        assertEquals(CE, instance.getNext(c));
        
        WootHashNode b = new WootHashNode(new WootIdentifier(1,2), 'b', false, c, 1);
        instance.getFirst().setNext(b);
        assertEquals(c, instance.getNext(CB));
        assertEquals(CE, instance.getNext(c));
        
        WootHashNode a = new WootHashNode(new WootIdentifier(2,1), 'a', true, b, 1);
        instance.getFirst().setNext(a);
        assertEquals(a, instance.getNext(CB));
        assertEquals(c, instance.getNext(a));
        assertEquals(CE, instance.getNext(c));
    }
    
    
    @Test(timeout=100)
    public void testApply() {
        System.out.println("applyLocal");
        WootHashDocument instance = new WootHashDocument();
        TraceOperation ins = TraceOperation.insert(0, 0, null, null),
                del = TraceOperation.delete(0, 0, 0, null);
        WootIdentifier a = new WootIdentifier(1,1), b = new WootIdentifier(1,2),
                c = new WootIdentifier(2,1), d = new WootIdentifier(2,2), 
                e = new WootIdentifier(3,1), f = new WootIdentifier(3,2),
                g = new WootIdentifier(0,1);
        
        
        instance.applyLocal(instance.insert(ins, a , WootIdentifier.IB, WootIdentifier.IE, 'a'));
        assertEquals("a", instance.view());
        
        instance.applyLocal(instance.insert(ins, b, a, WootIdentifier.IE, 'b'));
        assertEquals("ab", instance.view());

        instance.applyLocal(instance.insert(ins, c, WootIdentifier.IB, a, 'c'));
        assertEquals("cab", instance.view());

        instance.applyLocal(instance.delete(del, c));
        assertEquals("ab", instance.view());
        
        instance.applyLocal(instance.insert(ins, e, a, b, 'e'));
        assertEquals("aeb", instance.view());

        instance.applyLocal(instance.delete(del, e));
        assertEquals("ab", instance.view());
    
        instance.applyLocal(instance.insert(ins, d, a, b, 'd'));
        assertEquals("adb", instance.view());

        instance.applyLocal(instance.insert(ins, f, a, b, 'f'));
        assertTrue(f.compareTo(d) > 0);
        assertEquals("adfb", instance.view());
        
        instance.applyLocal(instance.insert(ins, g, a, b, 'g'));
        assertTrue(g.compareTo(d) < 0);
        assertEquals("agdfb", instance.view());    
    }
    
    @Test(timeout=100)
    public void wootPuzzle() {
        System.out.println("Woot Puzzle");
        TraceOperation ins = TraceOperation.insert(0, 0, null, null);
        WootHashDocument instance = new WootHashDocument();
        WootIdentifier a = new WootIdentifier(1,1), b = new WootIdentifier(3,1),
                c = new WootIdentifier(2,1);
        
        instance.applyLocal(instance.insert(ins, a, WootIdentifier.IB, WootIdentifier.IE, 'a'));
        instance.applyLocal(instance.insert(ins, b, WootIdentifier.IB, a, 'b'));
        instance.applyLocal(instance.insert(ins, c, WootIdentifier.IB, WootIdentifier.IE, 'c'));
        assertTrue(c.compareTo(a) > 0);
        assertTrue(c.compareTo(b) < 0);
        assertEquals("bac", instance.view());
    }
}