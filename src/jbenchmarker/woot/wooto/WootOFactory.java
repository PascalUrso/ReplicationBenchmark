/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.woot.wooto;

import jbenchmarker.core.MergeAlgorithm;
import jbenchmarker.core.ReplicaFactory;
import jbenchmarker.woot.WootMerge;
/**
 *
 * @author urso
 */
public class WootOFactory extends ReplicaFactory {
    @Override
    public MergeAlgorithm createReplica(int r) {
        return new WootMerge(new WootOptimizedDocument(), r);
    }
}
