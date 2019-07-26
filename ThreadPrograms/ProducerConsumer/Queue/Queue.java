package ProducerConsumer.Queue;                                                       

// CLASSPATH = "C:\Program Files (x86)\Java\jdk1.6.0_02\bin\ThreadPrograms";

public class Queue extends Thread{                                                           // Properties Of Thread class is Inherited by Parent class(i.e. Queue) 
	
	public int N = 0;                                                                        // Initially, Starting Index Of Element in the Infinite Queue is set to be "ZERO" 
	boolean Available = false;                                                               // Declaring Flag for Availability of Elements in the Infinite Queue as "false" 
	public synchronized int get(){                                                           // Allowing Consumer to Consume the Element when Producer is Sleeping
		
		while(Available == false){                                                           // Executing the While-Loop if Element not found in the Infinite Queue     
			
			try{
				
				wait();                                                         // Tells the Consumer to give up its lock & went to sleep until Producer calls notify() 
				
			}catch(Exception e){

                e.printQueueTrace();                                            // Helps the programmer to understand where the actual problem occurred in the Consumer Thread 

            }

        }

        System.out.println("Consumer : " + N++);
        Available = false;                                                                   // Set Flag for Availability of Elements in the Infinite Queue as "false"
        notify();                                                                            // Notify the Producer for Producing the Element for Consumption  
        return N;                                                                            // RETURNS the Index Of the Consumed Element from the Infinite Queue 

    } 		
	
	public synchronized void put(int N){                                                     // Allowing Producer to Produce the Element when Consumer is Sleeping
		
		this.N = N;                                                                          // Pointing to that Index which the Consumer wants to Consume
		while(Available == true){                                                            // Executing the While-Loop if Element found in the Infinite Queue
			
			try{
				
				wait();                                                         // Tells the Producer to give up its lock & went to sleep until Consumer calls notify() 
				
			}catch(Exception e){

                e.printQueueTrace();                                            // Helps the programmer to understand where the actual problem occurred in the Producer Thread

            }

        }

        System.out.println("Producer : " + N++);
        Available = true;                                                                    // Set Flag for Availability of Elements in the Infinite Queue as "true"
        notify();                                                                            // Notify the Consumer for Consuming the Element for next Production

    }

}	