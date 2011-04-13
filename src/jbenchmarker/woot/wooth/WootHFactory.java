/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.woot.wooth;

import jbenchmarker.core.MergeAlgorithm;
import jbenchmarker.core.ReplicaFactory;
/**
 *
 * @author urso
 */
public class WootHFactory extends ReplicaFactory {
    @Override
    public MergeAlgorithm createReplica(int r) {
        return new WootHashMerge(new WootHashDocument(), r);
    }
}
