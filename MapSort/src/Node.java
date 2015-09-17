
/* object stored in hashmap
 * stores a key and value
 * that can be returned
 */
public class Node {
	private String key;
	private int value;
	
	public Node(String k, int v) {
		this.key = k;
		this.value = v;
	}

	public int getValue() {
		return this.value;
	}
	
	public String getKey() {
		return this.key;
	}
}
