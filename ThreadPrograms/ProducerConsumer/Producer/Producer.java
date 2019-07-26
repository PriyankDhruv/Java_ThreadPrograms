package ProducerConsumer.Producer;

// CLASSPATH = "C:\Program Files (x86)\Java\jdk1.6.0_02\bin\ThreadPrograms";
import ProducerConsumer.Queue.*;                                                       // Importing Queue-class in the Sub-Directory "Queue" & Parent-Directory "ProducerConsumer"

public class Producer implements Runnable{                                     // Implementation of the Properties of Parent class(i.e. Runnable) in the current class(i.e. Producer) 
	
	public int N = 0;                                                                        // Initially, Starting Index Of Element in the Infinite Queue is set to be 'ZERO' 
	Queue q;                                                                                 // Declaring Object of Previous class(i.e. Queue) 
	public Producer(Queue q){                                                                // Defining Constructor(i.e. Producer) with Object of class(i.e. q) as an Argument
		
		this.q = q;                                                                          // Refering to the Object of Queue-class(i.e. q) & Producer is being Invoked
		Thread t = new Thread(this);                                                         // Creating Thread Object for Producer class
		t.start();                                                                           // Calling start() method of Producer Thread 
		
	}

    public void run(){                                                                       // Defining run() method for Execution of Producer Thread 
		
        int p = 0;                                                                           // Default initialization of Data-Types while Defining any method of current class
        while(true){
				
            q.put(q.N++);                                                                  // Calling put() method of Queue class with Increamented Index Of Element as an Argument
            try{

                Thread.sleep(2000);                                                          // Producer's Sleeping time : t = 2000 msec

            }catch(Exception e){

                e.printStackTrace();                                             // Helps the programmer to understand where the actual problem occurred while Producing the Element

            }

        }

    }

}	