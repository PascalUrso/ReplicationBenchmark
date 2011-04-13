/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author urso
 */
public abstract class Document {
    

    public Document() {
    }
    
    /* 
     * View of the document (without metadata)
     */
    abstract public String view();
    
    /**
     * Applies an operation
     */ 
    public void apply(Operation op) {
        applyLocal(op);
    }
    
    abstract protected void applyLocal(Operation op);
}
