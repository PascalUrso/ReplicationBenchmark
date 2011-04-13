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
class RangeList<T> extends ArrayList<T> {

    void removeRangeOffset(int i, int offset) {
        removeRange(i,i+offset);
    }

}
