/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import jbenchmarker.trace.IncorrectTrace;
import jbenchmarker.trace.TraceOperation;

/**
 *
 * @author urso
 */
public abstract class MergeAlgorithm {
    // Replica identifier
    private int replicaNb;
    
    // Supported Document
    private Document doc;
   
    // Local operations generated
    private List<TraceOperation> localHistory; 

    // All operations executed
    private List<Operation> history;
    
    // Local operations generated time map : size history  -> exec time
    private TreeMap<Integer, Long> localExecTime;
    
    // All operations executed   
    private List<Long> execTime;
    
    /*
     * Constructor
     */
    public MergeAlgorithm(Document doc, int r) {
        this();
        this.replicaNb = r;
        this.doc = doc;
    }

    public MergeAlgorithm() {
        this.execTime = new ArrayList<Long>();
        this.localExecTime = new TreeMap<Integer, Long>();
        this.history = new ArrayList<Operation>();
        this.localHistory = new ArrayList<TraceOperation>();
    }

    /**
     * To be define by the concrete merge algorithm
     * Should call doc.apply
     */
    protected abstract void integrateLocal(Operation op) throws IncorrectTrace;
    
    /**
     * To be define by the concrete merge algorithm
     * Should call doc.apply
     */
    protected abstract List<Operation> generateLocal(TraceOperation opt) throws IncorrectTrace;
    
   
    
    /*
     * Integration of a remote operation
     * Adds operation in history and execution time
     */
    public void integrate(Operation op) throws IncorrectTrace {
        long startTime = System.nanoTime();
        history.add(op);
        integrateLocal(op); 
        execTime.add(System.nanoTime() - startTime);
    }
    
    /**
     *  Generation of a local trace operation, returns a patch of operation
     * Throws IncorrectTrace iff operation is not generable in the context.
     **/    
    public List<Operation> generate(TraceOperation opt) throws IncorrectTrace {
        localHistory.add(opt);
        long startTime = System.nanoTime();
        List<Operation> l = generateLocal(opt);
        long t = System.nanoTime() - startTime, oh = t/l.size();
        int i = history.size();
        localExecTime.put(i,t);
        for (Operation o : l) {
            execTime.add(oh);
            history.add(o);
            i++;
        }        
        return l;
    }

    public List<Long> getExecTime() {
        return execTime;
    }

    public List<Operation> getHistory() {
        return history;
    }

    public TreeMap<Integer, Long> getLocalExecTime() {
        return localExecTime;
    }

    public List<TraceOperation> getLocalHistory() {
        return localHistory;
    }
    
    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public void setReplicaNb(int replicaNb) {
        this.replicaNb = replicaNb;
    }

    public int getReplicaNb() {
        return replicaNb;
    }

    public void reset() {
        this.execTime.clear();
        this.localExecTime.clear();
        this.history.clear();
        this.localHistory.clear();       
    }
}
