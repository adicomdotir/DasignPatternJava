package ir.javacup.thread;

public class Resource {

	private boolean available = false;
	private int content;
	
	public synchronized int get() throws InterruptedException {
		while (available == false) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		available = false;
		notify();
		return content;
	}
	
	public synchronized void set(int value) throws InterruptedException {
		while (available == true) {
			try {
				wait();
			} catch (InterruptedException e) { } 
      	}
		content = value;
		available = true;
		notify();
	}
	
}
