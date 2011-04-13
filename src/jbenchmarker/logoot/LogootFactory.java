/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.logoot;

import jbenchmarker.core.MergeAlgorithm;
import jbenchmarker.core.ReplicaFactory;

/**
 *
 * @author urso
 */
public class LogootFactory extends ReplicaFactory {
    @Override
    public MergeAlgorithm createReplica(int r) {
        return new LogootMerge(new LogootDocument(Long.MAX_VALUE), r, 64, new BoundaryStrategy(1000000000));
    }
}