/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.woot;

import jbenchmarker.core.Operation;
import jbenchmarker.trace.TraceOperation;
import jbenchmarker.trace.TraceOperation.OpType;

/**
 *
 * @author urso
 */
public class WootOperation extends Operation {
    private WootIdentifier id;
    private WootIdentifier ip;   // previous
    private WootIdentifier in;   // next
    
    private char content;
    
    
    public WootOperation(TraceOperation o) {
        super(o);
    }

    /**
     * Constructor for insert operation
     * @param o a trace insert
     * @param id identifier to insert
     * @param ip identifier of previous element
     * @param in identifier of next element
     * @param content content of element
     */
    public WootOperation(TraceOperation o, WootIdentifier id, WootIdentifier ip, WootIdentifier in, char content) {
        super(o);
        this.id = id;
        this.ip = ip;
        this.in = in;
        this.content = content;
    }

    /**
     * Constructore for delete operation
     * @param o a trace delete
     * @param id identifier to delete
     */
    public WootOperation(TraceOperation o, WootIdentifier id) {
        super(o);
        this.id = id;
    }


    public OpType getType() {
        return this.getOriginalOp().getType();
    }

    public WootIdentifier getId() {
        return id;
    }

    public WootIdentifier getIn() {
        return in;
    }

    public WootIdentifier getIp() {
        return ip;
    }

    public char getContent() {
        return content;
    }

    @Override
    public Operation clone() {
        return new WootOperation(this.getOriginalOp(), id.clone(), ip.clone(), in.clone(), content);
    }
}
