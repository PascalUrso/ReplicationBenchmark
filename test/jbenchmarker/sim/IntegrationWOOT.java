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
package jbenchmarker.sim;

import jbenchmarker.woot.wooto.WootOFactory;
import jbenchmarker.woot.original.WootFactory;
import org.junit.Ignore;
import java.util.Iterator;
import jbenchmarker.core.MergeAlgorithm;
import jbenchmarker.trace.TraceGenerator;
import jbenchmarker.trace.TraceOperation;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author urso
 */
public class IntegrationWOOT {

    /**
     * Test of run method, WOOT class CausalDispatcher; exemple.xml.
     */
    @Test
    public void testWootExempleRun() throws Exception {
        System.out.println("Integration test with causal + WOOT");
        Iterator<TraceOperation> trace = TraceGenerator.traceFromXML("../../traces/xml/exemple.xml", 1, 100);
        CausalDispatcher cd = new CausalDispatcher(new WootFactory());

        cd.run(trace);
        String r = "Salut Monsieurjour MehdiFin";
        assertEquals(r, cd.getReplicas().get(0).getDoc().view());
        assertEquals(r, cd.getReplicas().get(2).getDoc().view());
        assertEquals(r, cd.getReplicas().get(4).getDoc().view());
    }
    
    /**
     * Test of run method on WOOT , of class CausalDispatcher; whole traces
     */
    @Ignore // Too long -- Passes on revision 96 -- 1800s
    @Test
    public void testWootG1Run() throws Exception {
        Iterator<TraceOperation> trace = TraceGenerator.traceFromXML("../../traces/xml/G1.xml", 1, 2000);         
        CausalDispatcher cd = new CausalDispatcher(new WootFactory());

        cd.run(trace);
        String r = cd.getReplicas().get(0).getDoc().view();
        for (MergeAlgorithm m : cd.getReplicas().values()) {
            assertEquals(r, m.getDoc().view());
        }
    }
    
    @Ignore // Too long -- Passess on revision 98 -- 9500s !
    @Test
    public void testWootG2Run() throws Exception {
        Iterator<TraceOperation> trace = TraceGenerator.traceFromXML("../../traces/xml/G2.xml", 1);
        CausalDispatcher cd = new CausalDispatcher(new WootFactory());

        cd.run(trace);
        String r = cd.getReplicas().get(0).getDoc().view();
        for (MergeAlgorithm m : cd.getReplicas().values()) {
            assertEquals(r, m.getDoc().view());
        }
    }

    @Ignore // Too long -- G3 pass on revision 86 -- 100s
    @Test
    public void testWootG3Run() throws Exception {
        Iterator<TraceOperation> trace = TraceGenerator.traceFromXML("../../traces/xml/G3.xml", 1);         
        CausalDispatcher cd = new CausalDispatcher(new WootFactory());
        
        cd.run(trace);  
        String r = cd.getReplicas().get(0).getDoc().view();
        for (MergeAlgorithm m : cd.getReplicas().values())
            assertEquals(r, m.getDoc().view());
    }

    /**
     * Test of run method on WOOTO, CausalDispatcher; whole traces
     */
     @Ignore // (Only) 11 s 
    @Test
    public void testWootOG1Run() throws Exception {        
        System.out.println("Integration test with causal + WOOTO");
        Iterator<TraceOperation> trace = TraceGenerator.traceFromXML("../../traces/xml/G1.xml", 1);         
        CausalDispatcher cd = new CausalDispatcher(new WootOFactory());

        cd.run(trace);
        String r = cd.getReplicas().get(0).getDoc().view();
        for (MergeAlgorithm m : cd.getReplicas().values()) {
            assertEquals(r, m.getDoc().view());
        }
    }
        
    /**
     * Test of run method, of class CausalDispatcher; WOOTO tail lines of G1.xml 
     */
    
    @Test
    public void testWootOG1RunSubset() throws Exception {
        Iterator<TraceOperation> trace = TraceGenerator.traceFromXML("../../traces/xml/G1.xml", 1, 2000);
        CausalDispatcher cd = new CausalDispatcher(new WootOFactory());

        cd.run(trace);
        String r = cd.getReplicas().get(0).getDoc().view();
        for (MergeAlgorithm m : cd.getReplicas().values()) {
            assertEquals(r, m.getDoc().view());
        }
    }


}
