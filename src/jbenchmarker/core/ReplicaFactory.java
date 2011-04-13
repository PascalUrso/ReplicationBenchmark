/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.core;

/**
 * Abstract factory to create replicas
 * @author urso
 */
public abstract class ReplicaFactory {
    public abstract MergeAlgorithm createReplica(int r);
}
