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

import jbenchmarker.core.Document;
import jbenchmarker.core.Operation;

import java.lang.Integer;
import java.util.*;
import java.util.ArrayList;
import java.util.Random;
import jbenchmarker.trace.TraceOperation;

/**
 *
 * @author mehdi
 */
public class LogootDocument  extends Document
{
    private RangeList<LogootIdentifier> idTable;
    private RangeList<Character> document;

    public LogootDocument(long max) 
    {
        super();
        document = new RangeList<Character>();
        idTable = new RangeList<LogootIdentifier>();

        LogootIdentifier Begin = new LogootIdentifier(1), End = new LogootIdentifier(1);
        Begin.addComponent( new Component(0, -1, -1) );
        End.addComponent( new Component(max, -1, -1) );

        idTable.add(Begin); document.add(' ');
        idTable.add(End); document.add(' ');
    }
    
    @Override
    public String view() {
        StringBuilder s = new StringBuilder();
        for (char c : document)
            s.append(c);
        return s.substring(1, s.length()-1);
    }

    int dicho(LogootIdentifier idToSearch) {
        int startIndex = 0, endIndex = idTable.size()-1, middleIndex;
        do {
            middleIndex = startIndex + (endIndex - startIndex) / 2;
            int c = idTable.get(middleIndex).compareTo(idToSearch);
            if (c == 0) {
                return middleIndex;
            } else if (c < 0) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        } while (startIndex < endIndex);
        return (idTable.get(startIndex).compareTo(idToSearch) < 0) ? 
                startIndex + 1 : startIndex;
    }
    
    
    @Override
    public void applyLocal(Operation op) {
        LogootOperation lg = (LogootOperation) op;
        LogootIdentifier idToSearch = lg.getIdentifiant();
        int pos = dicho(idToSearch);
        //Insertion et Delete
        if (lg.getType() == TraceOperation.OpType.ins) {
            idTable.add(pos, idToSearch);
            document.add(pos, lg.getContent());
        } else if (idTable.get(pos).equals(idToSearch)) {
            idTable.remove(pos);
            document.remove(pos);
        }        
//        // DEBUG
//        for (int i = 0; i < idTable.size(); i++)  
//            for (int j = 0; j < idTable.size(); j++)  
//                if (i!=j && idTable.get(i).equals(idTable.get(j)))
//                    System.err.println("BUG");                           
    }   
    
     public RangeList<LogootIdentifier> getIdTable() {
        return idTable;
    }

    public RangeList<Character> getDocument() {
        return document;
    }
}