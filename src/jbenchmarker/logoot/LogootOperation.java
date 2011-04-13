 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.logoot;

import java.util.ArrayList;
import jbenchmarker.core.Operation;
import jbenchmarker.trace.TraceOperation;
import jbenchmarker.trace.TraceOperation.OpType;

/**
 *
 * @author mehdi
 */
public class LogootOperation extends Operation
{

    private LogootIdentifier identif;
    
    private char content;

    private LogootOperation(TraceOperation o, LogootIdentifier identif, char content) {
        super(o);
        this.identif = identif;
        this.content = content;
    }
    
    public OpType getType() {
        return this.getOriginalOp().getType();
    }

    public LogootIdentifier getIdentifiant() {
        return identif;
    }
    
    public char getContent() {
        return content;
    }

    static LogootOperation insert(TraceOperation o, LogootIdentifier idf, char cont) {
        return new LogootOperation(o, idf, cont);
    }

    public static LogootOperation Delete(TraceOperation o, LogootIdentifier idf) {
        return new LogootOperation(o, idf, (char) 0);
    }

    // FIXME: shoud clone the operation and its parameters
    @Override
    public Operation clone() {
        return new LogootOperation(this.getOriginalOp(), this.identif.clone(), this.content);
    }

}
