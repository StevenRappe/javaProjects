Project: TheadExecution

Description:
	Creates a linkedBlockingQueue that producer fills with UUIDs. Consumer then
	removes these UUIDs from the queue and records the maximum lexicographically 
	valued UUID by converting it into a string.
	
Files:
	Consumer: Takes elements from the queue and records the maximum valued string.
	Producer: Creates UUIDs and adds them to the queue.
	ThreadedBlockingQueue: Holds the main method for the program, executes threads
		concurrently.
	
Execution:
	Run file "ThreadedBlockingQueue". Program is automated and runs independently.
