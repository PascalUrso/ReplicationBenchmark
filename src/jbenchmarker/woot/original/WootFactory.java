/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.woot.original;

import jbenchmarker.core.MergeAlgorithm;
import jbenchmarker.core.ReplicaFactory;
import jbenchmarker.woot.WootMerge;

/**
 *
 * @author urso
 */
public class WootFactory extends ReplicaFactory {
    @Override
    public MergeAlgorithm createReplica(int r) {
        return new WootMerge(new WootOriginalDocument(), r);
    }
}
