/**
 * 
 */
package ie.gmit.project;

import java.util.*;

/**
 * @author Jamie O'Sullivan
 *
 */
public class Document {
	private int docID;
	private Set<Integer> shingles;
	/**
	 * @param docID
	 * @param shingles
	 */
	public Document(int docID, Set<Integer> shingles) {
		super();
		this.docID = docID;
		this.shingles = shingles;
	}
	/**
	 * @return the docID
	 */
	public int getDocID() {
		return docID;
	}
	/**
	 * @param docID the docID to set
	 */
	public void setDocID(int docID) {
		this.docID = docID;
	}
	/**
	 * @return the shingles
	 */
	public Set<Integer> getShingles() {
		return shingles;
	}
	/**
	 * @param shingles the shingles to set
	 */
	public void setShingles(Set<Integer> shingles) {
		this.shingles = shingles;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Document [docID=" + docID + ", shingles=" + shingles + "]";
	}
	
	

}
