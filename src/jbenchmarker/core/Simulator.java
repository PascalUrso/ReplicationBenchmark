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

package jbenchmarker.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jbenchmarker.trace.TraceOperation;

/**
 *
 * @author urso
 */
public abstract class Simulator {
    protected Map<Integer,MergeAlgorithm> replicas;

   // Local operations generated
    protected List<Long> memUsed; 
    
    private ReplicaFactory rf;
    
    /**
     * Constructor of a Simulator. Replicas and Document will be instaciated at run time.
     * @param rf the factory
     */
    public Simulator(ReplicaFactory rf) {
        this.replicas = new HashMap<Integer,MergeAlgorithm>();
        this.memUsed = new java.util.ArrayList<Long>();
        this.rf = rf;
    }

    public Map<Integer, MergeAlgorithm> getReplicas() {
        return replicas;
    }

    /*
     * Runs a trace of operations. Iterate trough trace and construct replica with documents while needed.
     */
    public abstract void run(Iterator<TraceOperation> trace) throws Exception;    
    
    /**
     * Instanciate a new replica with classes given at construction. 
     * Adds the crated replica to the map.
     */
    public MergeAlgorithm newReplica(int number) {
        MergeAlgorithm r = rf.createReplica(number);
        replicas.put(number, r);
        return r;
    }

    /**
     * Memory occupied by whole framework. One entry per traceoperation.
     */
    public List<Long> getMemUsed() {
        return memUsed;
    }
}
