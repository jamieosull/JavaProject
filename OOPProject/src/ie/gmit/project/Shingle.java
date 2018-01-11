/**
 * 
 */
package ie.gmit.project;

import java.util.Comparator;

/**
 * @author jamieosullivan
 *
 */

public class Shingle implements Comparator {
	private int docID;
	private int hashCode;
	/**
	 * @param docID
	 * @param hashCode
	 */
	public Shingle(int docID, int hashCode) {
		super();
		this.docID = docID;
		this.hashCode = hashCode;
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
	 * @return the hashCode
	 */
	public int getHashCode() {
		return hashCode;
	}
	/**
	 * @param hashCode the hashCode to set
	 */
	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Shingle [docID=" + docID + ", hashCode=" + hashCode + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
	// must override hashcode and equals
		@Override
		public boolean equals(Object arg0) {
			// TODO Auto-generated method stub
			return super.equals(arg0);
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}
		
		
		
		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return 0;
		}
		

}
