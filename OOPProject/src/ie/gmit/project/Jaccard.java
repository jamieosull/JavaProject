/**
 * 
 */
package ie.gmit.project;

import java.util.List;

import javax.swing.text.Document;

/**
 * @author jamieosullivan
 *
 */
public interface Jaccard {
	
	public List<Shingle> createShingles(Document document, int id);
	public List<Integer> createHashCodes(Document document);
	public double jaccardSimilarity(Integer[] a, Integer[] b);
	public void minHash(List<Shingle> Shingles, List<Shingle> Shingles2);

}
