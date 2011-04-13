/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jbenchmarker.logoot;

import java.util.ArrayList;

/**
 *
 * @author urso
 */
public interface LogootStrategy {


    /**
     * Generate N identifier between P and Q;
     */
    ArrayList<LogootIdentifier> generateLineIdentifiers(LogootMerge replica, LogootIdentifier P, LogootIdentifier Q, int N);
}
