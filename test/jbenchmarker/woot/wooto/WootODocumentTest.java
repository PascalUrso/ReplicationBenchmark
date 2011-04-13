/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.woot.wooto;

import jbenchmarker.woot.WootDocument;
import jbenchmarker.trace.TraceOperation;
import jbenchmarker.woot.WootOperation;
import jbenchmarker.woot.WootIdentifier;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author urso
 */
public class WootODocumentTest {

   
    WootOptimizedNode a, b, c, d, e, f, g, h, x, z;
    
    public WootODocumentTest() {
        z = new WootOptimizedNode(new WootIdentifier(1,3), 1, 'z', false);
        a = new WootOptimizedNode(new WootIdentifier(1,1), 1, 'a', true);
        b = new WootOptimizedNode(new WootIdentifier(2,1), 2, 'b', true);
        c = new WootOptimizedNode(new WootIdentifier(2,2), 3, 'c', false);
        d = new WootOptimizedNode(new WootIdentifier(3,1), 2, 'd', false);
        e = new WootOptimizedNode(new WootIdentifier(3,2), 3, 'e', false);
        f = new WootOptimizedNode(new WootIdentifier(3,3), 4, 'f', false);
        g = new WootOptimizedNode(new WootIdentifier(3,4), 3, 'g', true);
        h = new WootOptimizedNode(new WootIdentifier(4,1), 4, 'h', true);
        x = new WootOptimizedNode(new WootIdentifier(1,2), 1, 'x', true);
    }

    // helpers
    WootOperation ins(WootDocument r, WootOptimizedNode n, WootIdentifier cp, WootIdentifier cn) {
        return r.insert(TraceOperation.insert(0, 0, null, null), 
                n.getId(), cp, cn, n.getContent());
    }
    WootOperation del(WootDocument r, WootOptimizedNode n) {
        return r.delete(TraceOperation.delete(0, 0, 0, null), n.getId());
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
 
    /**
     * Test of view method, of class WootOptimizedDocument.
     */
    @Test
    public void testView() {
        System.out.println("view");
        WootOptimizedDocument instance = new WootOptimizedDocument();

        assertEquals("", instance.view());
        
        instance.getElements().add(1,a);
        assertEquals("a", instance.view());
    
        instance.getElements().add(2,b);
        assertEquals("ab", instance.view());        

        instance.getElements().add(3,c);
        assertEquals("ab", instance.view());      

        instance.getElements().add(0,d);
        assertEquals("ab", instance.view());      
    }


    /**
     * Test of getVisible method, of class WootOptimizedDocument.
     */
    @Test
    public void testGetVisible() {
        System.out.println("getVisible");
        WootOptimizedDocument instance = new WootOptimizedDocument();
        
        instance.getElements().add(1,z);
        instance.getElements().add(1,a);
        assertEquals(1, instance.getVisible(0));  // cause a < z
        
        instance.getElements().add(1,d);
        assertEquals(2, instance.getVisible(0));  

        instance.getElements().add(3,b);
        assertEquals(2, instance.getVisible(0));
        assertEquals(3, instance.getVisible(1));
        
        instance.getElements().add(3,e);
        assertEquals(2, instance.getVisible(0));
        assertEquals(4, instance.getVisible(1));
    }

    /**
     * Test of getVisible method, of class WootOptimizedDocument.
     */
    @Test
    public void testGetPrevious() {
        System.out.println("getPrevious");
        WootOptimizedDocument instance = new WootOptimizedDocument();
        assertEquals(0, instance.getPrevious(0));
        
        instance.getElements().add(1,z);
        assertEquals(0, instance.getPrevious(0));

        instance.getElements().add(1,a);
        assertEquals(0, instance.getPrevious(0));
        assertEquals(1, instance.getPrevious(1)); 

        instance.getElements().add(1,d);
        assertEquals(0, instance.getPrevious(0));
        assertEquals(2, instance.getPrevious(1)); 

        instance.getElements().add(3,b);
        assertEquals(2, instance.getPrevious(1)); 
        assertEquals(3, instance.getPrevious(2));                 
        
        instance.getElements().add(3,e);
        assertEquals(2, instance.getPrevious(1)); 
        assertEquals(4, instance.getPrevious(2));                
    }

    /**
     * Test of nextVisible method, of class WootOptimizedDocument.
     */
    @Test
    public void testNextVisible() {
        System.out.println("nextVisible");
        WootOptimizedDocument instance = new WootOptimizedDocument();

        instance.getElements().add(1,z);
        instance.getElements().add(1,a);
        assertEquals(1, instance.nextVisible(0));  // cause a < z
        
        instance.getElements().add(1,d);
        assertEquals(2, instance.nextVisible(0));  
        assertEquals(2, instance.nextVisible(1));  // cause a < z

        instance.getElements().add(3,b);
        assertEquals(2, instance.nextVisible(0));
        assertEquals(2, instance.nextVisible(1));
        assertEquals(3, instance.nextVisible(2));
        
        instance.getElements().add(3,e);
        assertEquals(2, instance.nextVisible(0));
        assertEquals(2, instance.nextVisible(1));
        assertEquals(4, instance.nextVisible(2));
        assertEquals(4, instance.nextVisible(3));
    }
    
    @Test
    public void testApply() {
        System.out.println("applyLocal");
        WootOptimizedDocument instance = new WootOptimizedDocument();
        
        instance.applyLocal(ins(instance,a, WootIdentifier.IB, WootIdentifier.IE));
        assertEquals("a", instance.view());
        
        instance.applyLocal(ins(instance,b, a.getId(), WootIdentifier.IE));
        assertEquals("ab", instance.view());

        instance.applyLocal(ins(instance,d, WootIdentifier.IB, a.getId()));
        assertEquals("dab", instance.view());

        instance.applyLocal(del(instance,d));
        assertEquals("ab", instance.view());
        
        instance.applyLocal(ins(instance,e, a.getId(), b.getId()));
        assertEquals("aeb", instance.view());

        instance.applyLocal(del(instance,e));
        assertEquals("ab", instance.view());
    
        instance.applyLocal(ins(instance,g, a.getId(), b.getId()));
        assertEquals("agb", instance.view());

        instance.applyLocal(ins(instance,h, g.getId(), b.getId()));
        assertEquals("aghb", instance.view());
    }
    
    @Test
    public void wootPuzzle() {
        System.out.println("Woot Puzzle");
        WootOptimizedDocument instance = new WootOptimizedDocument();
        
        instance.applyLocal(ins(instance,a, WootIdentifier.IB, WootIdentifier.IE));
        instance.applyLocal(ins(instance,d, WootIdentifier.IB, a.getId()));
        instance.applyLocal(ins(instance,x, WootIdentifier.IB, WootIdentifier.IE));
        assertTrue(x.getId().compareTo(a.getId()) > 0);
        assertTrue(x.getId().compareTo(d.getId()) < 0);
        assertEquals("dax", instance.view());
    }
}