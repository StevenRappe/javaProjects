import java.util.UUID;


// takes elements from the blocking queue and records maximum string
public class Consumer implements Runnable {
	private UUID max, current;
	
	public Consumer () {
		
	}
	
	public void run () {
		int j=0;
		for (int i=0; i<20000; i++) {
			try {
				current = ThreadedBlockingQueue.queue.take();
				if (i == 0) {
					max = current;
				}
				if (current.toString().compareTo(max.toString()) > 0) {
					max = current;
				}
				Thread.sleep(1);
				j++;
				if (j==999) {
					System.out.println("1000 UUID's consumed");
					j=0;
				}
			}
			catch (InterruptedException e) {
				System.out.println("Consumer exception caught");
				e.printStackTrace();
			}
		}
		System.out.println("Max string: " + max);
	}
}
