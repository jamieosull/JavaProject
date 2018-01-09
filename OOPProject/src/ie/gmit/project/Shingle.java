/**
 * 
 */
package ie.gmit.project;

import java.util.Comparator;

/**
 * @author jamieosullivan
 *
 */


@SuppressWarnings("rawtypes")
public class Shingle implements Comparator {
	private int doc0;
	private int doc1;
	private int hashCode;


	/**
	 * @param doc0
	 * @param doc1
	 * @param hashCode
	 */
	public Shingle(int doc0, int doc1, int hashCode) {
		super();
		this.doc0 = doc0;
		this.doc1 = doc1;
		this.hashCode = hashCode;
	}

	/**
	 * @return the doc0
	 */
	public int getDoc0() {
		return doc0;
	}

	/**
	 * @param doc0 the doc0 to set
	 */
	public void setDoc0(int doc0) {
		this.doc0 = doc0;
	}

	/**
	 * @return the doc1
	 */
	public int getDoc1() {
		return doc1;
	}

	/**
	 * @param doc1 the doc1 to set
	 */
	public void setDoc1(int doc1) {
		this.doc1 = doc1;
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
		return "Shingle [doc0=" + doc0 + ", doc1=" + doc1 + ", hashCode=" + hashCode + "]";
	}

	@Override
	public int compare(Object o1, Object o2) {
		return 0;
	}

	

	
	
	
	
}
