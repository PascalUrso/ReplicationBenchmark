/**
 *   This file is part of ReplicationBenchmark.
 *
 *   ReplicationBenchmark is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   ReplicationBenchmark is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with ReplicationBenchmark.  If not, see <http://www.gnu.org/licenses/>.
 *
 **/

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
