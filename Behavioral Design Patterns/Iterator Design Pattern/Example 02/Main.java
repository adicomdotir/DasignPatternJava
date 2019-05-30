public class Main {
	public static void main(String[] args) {
		Iterator iterator = new BooksCollection().createIterator();
		while (iterator.hasNext() ){
			System.out.println(iterator.next());
		}
	}
}

interface Iterator{
	public boolean hasNext();
	public Object next();
}

interface Container{
	public Iterator createIterator();
}

class BooksCollection implements Container{
	private String m_titles[] = {"test0","test1","test2","test3","test4"};

	public Iterator createIterator(){
		BookIterator result = new BookIterator();
		return result;
	}
	
	private class BookIterator implements Iterator{
		private int m_position;

		public boolean hasNext(){
			if (m_position < m_titles.length)
				return true;
			else
				return false;
		}
		public Object next(){
			if (this.hasNext())
				return m_titles[m_position++];
			else
				return null;
		}
	}
}