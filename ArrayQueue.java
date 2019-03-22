
public class ArrayQueue<T> implements Queue{

	static final int defaultsize = 100;

    Object a[];
    int head;
    int tail;
    int size;
    
	public ArrayQueue() {
		a = new Object[defaultsize];
        head = 0;
        tail = 0;
        size = defaultsize;
	}

	 ArrayQueue(int maxsize)  {
	        a = new Object[maxsize];
	        head = 0;
	        tail = 0;
	        size = maxsize;
	    }
	 
	@Override
	public T dequeue() {
		if(head == tail) 
			return null;
		Object temp = a[head];
		head = (head + 1) % size;
		
		return (T) temp;
	}

	@Override
	public void enqueue(Object item) {
		if((head + 1) % size == tail) 
			grow_array();
		a[tail++] = item;
		tail = tail % size;
	}

	protected void grow_array() {
		Object[] temp = new Object[size * 2];
		for(int i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	@Override
	public boolean empty() {
		return head == tail;
	}

}
