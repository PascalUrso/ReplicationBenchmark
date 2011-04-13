/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;
import jbenchmarker.core.MergeAlgorithm;
import jbenchmarker.core.ReplicaFactory;
import jbenchmarker.sim.CausalDispatcher;
import jbenchmarker.trace.TraceGenerator;
import jbenchmarker.trace.TraceOperation;

/**
 *
 * @author urso
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        if (args.length != 2) System.exit(1);
        
            ReplicaFactory rf = (ReplicaFactory) Class.forName(args[0]).newInstance();

            Iterator<TraceOperation> trace = TraceGenerator.traceFromXML(args[1], 1); 
            CausalDispatcher cd = new CausalDispatcher(rf);

            long st = System.currentTimeMillis();
            cd.run(trace);
            long ft = System.currentTimeMillis();

            // Name of result file is "[package.]Name[Factory]-trace[.xml].res"
            int i = args[1].lastIndexOf('/'), j = args[1].lastIndexOf('.'), 
                    k = args[0].lastIndexOf('.'), l = args[0].lastIndexOf("Factory");
            if (i==-1) i = args[1].lastIndexOf('\\');
            String fileName = args[0].substring(k+1, l) + "-" + args[1].substring(i+1, j);

            MergeAlgorithm R0 = cd.getReplicas().get(0);

            System.out.println("---------------------------------------------\nTotal time : " + (ft-st)/1000.0 + " s");
            System.out.println("---------------------------------------------\n");        
            System.out.flush();
            System.out.println(R0.getDoc().view());


            BufferedWriter out = new BufferedWriter(new FileWriter(fileName+"-remote.res"));        
            for (int o = 0; o < R0.getHistory().size(); ++o) {
                long s = 0;
                for (MergeAlgorithm m : cd.getReplicas().values()) {
                    out.append(m.getExecTime().get(o) + "\t");                        
                    s = s + m.getExecTime().get(o);
                }
                out.append(s + "\n");
            }
            out.close();

            out = new BufferedWriter(new FileWriter(fileName+"-local.res"));
            TreeMap<Integer, Long> let = (TreeMap<Integer, Long>) R0.getLocalExecTime().clone();
            for (MergeAlgorithm m : cd.getReplicas().values()) {
                let.putAll(m.getLocalExecTime());
            }
            for (Entry<Integer, Long> e : let.entrySet()) {
                out.append(e.getKey() + "\t" + e.getValue() + '\n');                        
            }
            out.close();

            out = new BufferedWriter(new FileWriter(fileName+"-mem.res"));
            for (long e : cd.getMemUsed()) {
                out.append(e + "\n");                        
            }
            out.close();
        }
}
