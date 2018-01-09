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
	private int docId;
	private int hashCode;
	/**
	 * @param docId
	 * @param hashCode
	 */
	
	public Shingle() {
		super();
	}
	
	
	public Shingle(int docId, int hashCode) {
		super();
		this.docId = docId;
		this.hashCode = hashCode;
	}
	/**
	 * @return the docId
	 */
	public int getDocId() {
		return docId;
	}
	/**
	 * @param docId the docId to set
	 */
	public void setDocId(int docId) {
		this.docId = docId;
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
		return "Shingle [docId=" + docId + ", hashCode=" + hashCode + "]";
	}


	@Override
	public int compare(Object arg0, Object arg1) {
		return 0;
	}
	
	
	
	
}
