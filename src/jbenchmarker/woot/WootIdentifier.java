/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.woot;

/**
 *
 * @author urso
 */
public class WootIdentifier implements Comparable<WootIdentifier> {
    public static final WootIdentifier IB = new WootIdentifier(-1,0);
    public static final WootIdentifier IE = new WootIdentifier(-1,1);;

    public WootIdentifier(int replica, int clock) {
        this.replica = replica;
        this.clock = clock;
    }
    
    private int replica;
    private int clock;

    public int getClock() {
        return clock;
    }

    public int getReplica() {
        return replica;
    }


    @Override
    public int compareTo(WootIdentifier t) {
        if (this.replica == t.replica) 
            return this.clock - t.clock;
        else 
            return this.replica - t.replica;
    }
    
    public WootIdentifier clone() {
        return new WootIdentifier(replica,clock);
    }
}
