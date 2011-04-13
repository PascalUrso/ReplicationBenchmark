package jbenchmarker.rga;

/**
*
* @author Roh
*/ 
public class RGANode {
	private RGAS4Vector 	key;
	//private RGAS4Vector 	pre; 		//unnecessary because of no update. 
	private boolean 			visible;
	private char 				content;
	private RGANode		next;
	
	public RGANode(){
		this.key 	= null;
		this.next 	= null;		
		this.visible = true;
	}
	public RGANode(RGAS4Vector s4v, char c){
		this.key 		= s4v;
		this.content 	= c;
		this.visible		= true;
		this.next		= null;
	}
	
	public RGAS4Vector getKey(){
		return key;
	}
	
	public char getContent(){
		return content;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	public void makeTombstone(){
		visible = false;
	}
	
	public void setNext(RGANode nd){
		this.next = nd;
	}
	
	public RGANode getNext(){
		return next;
	}
	
	public RGANode getNextVisible(){
		RGANode node = next;
		while(node != null && !node.isVisible()) node = node.getNext();
		return node;
	}
}
