/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.woot.wooth;

import jbenchmarker.woot.WootIdentifier;
import jbenchmarker.woot.WootNode;

/**
 *
 * @author urso
 */
public class WootHashNode extends WootNode {
    private WootHashNode next;
    private int degree;

    public WootHashNode(WootIdentifier id, char content, boolean visible, WootHashNode next, int degree) {
        super(id, content, visible);
        this.next = next;
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

    WootHashNode getNext() {
        return next;
    }

    void setNext(WootHashNode next) {
        this.next = next;
    }
}
