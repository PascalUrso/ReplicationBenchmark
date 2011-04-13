/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.sim;

import jbenchmarker.woot.wooth.WootHFactory;
import jbenchmarker.core.MergeAlgorithm;
import java.util.Iterator;
import jbenchmarker.trace.TraceGenerator;
import jbenchmarker.trace.TraceOperation;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author urso
 */
public class IntegrationWOOTH {
    @Test
    public void testWootHExempleRun() throws Exception {
        System.out.println("Integration test with WootH");
        Iterator<TraceOperation> trace = TraceGenerator.traceFromXML("../../traces/xml/exemple.xml", 1);
        CausalDispatcher cd = new CausalDispatcher(new WootHFactory());

        cd.run(trace);
        String r = "Salut Monsieurjour MehdiFin";
        assertEquals(r, cd.getReplicas().get(0).getDoc().view());
        assertEquals(r, cd.getReplicas().get(2).getDoc().view());
        assertEquals(r, cd.getReplicas().get(4).getDoc().view());
    }
    
    // @Ignore
    @Test
    public void testWootHG1Run() throws Exception {
        Iterator<TraceOperation> trace = TraceGenerator.traceFromXML("../../traces/xml/G1.xml", 1);
        CausalDispatcher cd = new CausalDispatcher(new WootHFactory());

        cd.run(trace);
//        for (Object o : ((WootHDocument) cd.getReplicas().get(0).getDoc()).getIdTable())                      
//             System.out.println(o);
        String r = cd.getReplicas().get(0).getDoc().view();
        for (MergeAlgorithm m : cd.getReplicas().values()) {
            assertEquals(r, m.getDoc().view());
        }
    }
    
    @Test
    public void testWootHG2Run() throws Exception {
        Iterator<TraceOperation> trace = TraceGenerator.traceFromXML("../../traces/xml/G2.xml", 1);
        CausalDispatcher cd = new CausalDispatcher(new WootHFactory());

        cd.run(trace);
        String r = cd.getReplicas().get(0).getDoc().view();
        for (MergeAlgorithm m : cd.getReplicas().values()) {
            assertEquals(r, m.getDoc().view());
        }
    }
    
    @Test
    public void testWootHG3Run() throws Exception {
        Iterator<TraceOperation> trace = TraceGenerator.traceFromXML("../../traces/xml/G3.xml", 1);
        CausalDispatcher cd = new CausalDispatcher(new WootHFactory());

        cd.run(trace);
        String r = cd.getReplicas().get(0).getDoc().view();
        for (MergeAlgorithm m : cd.getReplicas().values()) {
            assertEquals(r, m.getDoc().view());
        }
    }
    
    @Test
    public void testWootHSerieRun() throws Exception {
        Iterator<TraceOperation> trace = TraceGenerator.traceFromXML("../../traces/xml/Serie.xml", 1);
        CausalDispatcher cd = new CausalDispatcher(new WootHFactory());

        cd.run(trace);
        String r = cd.getReplicas().get(0).getDoc().view();
        for (MergeAlgorithm m : cd.getReplicas().values()) {
            assertEquals(r, m.getDoc().view());
        }
    }
}
