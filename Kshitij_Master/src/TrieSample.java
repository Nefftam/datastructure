public class TrieSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie ts =  new Trie();
		ts.add("tr");
		ts.add("try");
		
		boolean found = ts.search("tr");
		System.out.println("String found " + found);
		
		//ts.remove("trie");
		
	}

}

class N3
{
	boolean isLeaf;
	N3[] nodeArr = new N3[26];
}

class Trie
{
	N3 node;
	Trie()
	{
		node = new N3();
	}
	
	public boolean search(String str) 
	{
		N3 temp = node;
		str = str.toLowerCase();
		for(int i=0 ; i<str.length(); i++)
		{
			char c = str.charAt(i);
			int index = c - 'a';
			if(temp.nodeArr[index] == null)
			{
				System.out.println("Element not found");
				return false;
			}
			temp = temp.nodeArr[index];
		}
		if(temp.isLeaf)
		{
			return true;
		}
		return false;
	}

	public void add(String str)
	{
		str = str.toLowerCase();
		int index =0;
		N3 temp = node;
		for(int i=0 ; i<str.length(); i++)
		{
			char c = str.charAt(i);
			index = c - 'a';
			if(temp.nodeArr[index] == null)
			{
				temp.nodeArr[index] = new N3();
			}
			temp = temp.nodeArr[index];
		}
		temp.isLeaf = true;
	}
}
