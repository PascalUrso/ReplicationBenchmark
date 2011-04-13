package jbenchmarker.rga;

import jbenchmarker.core.VectorClock; 
/**
*
* @author Roh
*/
public class RGAS4Vector implements Comparable<RGAS4Vector> {
	public static final int AFTER 	= 1;
	public static final int EQUAL 	= 0;
	public static final int BEFORE	= -1;
	
	
	private int ssn;
	private int sid;
	private int sum;
	private int seq;
	
	public RGAS4Vector(int ssn, int sid, VectorClock vc){
		this.ssn		= ssn;	
		this.sid 		= sid;
		this.sum 	= vc.getSum();
		this.seq		= vc.getSafe(sid);
	}
	
	public RGAS4Vector(int sid, VectorClock vc){
		this(0, sid, vc);
	}
	@Override 
	public String toString(){
		return "["+ssn+","+sid+","+sum+"]";
	}
	
	@Override 
	public int compareTo(RGAS4Vector s4v) {
		// TODO Auto-generated method stub
		if(this.ssn > s4v.ssn) return  AFTER;
		else if (this.ssn < s4v.ssn) return BEFORE;
		else { // this.ssn==s4v.ssn
			if(this.sum > s4v.sum) return AFTER;
			else if(this.sum < s4v.ssn) return BEFORE;
			else { // this.sum == s4v.sum
				if(this.sid > s4v.sid) return AFTER;
				else if(this.sid < s4v.sid) return BEFORE;
				else return EQUAL;
			}
		}
	}

    public RGAS4Vector(int ssn, int sid, int sum, int seq) {
        this.ssn = ssn;
        this.sid = sid;
        this.sum = sum;
        this.seq = seq;
    }

    public RGAS4Vector clone() {
        return new RGAS4Vector(ssn, sid, sum, seq);
    }
}
