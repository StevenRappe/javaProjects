import java.util.UUID;


// produces UUID's and puts them in the blocking queue
public class Producer implements Runnable {
	private UUID randNum;	
	
	public Producer() {
		
	}
	
	public void run() {
		int j=0;
		for (int i=0; i<20000; i++) {
			
			try {
				randNum = UUID.randomUUID();
				ThreadedBlockingQueue.queue.put(randNum);	
				Thread.sleep(1);
				j++;
				if (j==999) {
					System.out.println("1000 UUID's produced");
					j=0;
				}
			}
			catch (InterruptedException e) {
				System.out.println("Producer exception caught");
				e.printStackTrace();
			}
		}
	}
}
