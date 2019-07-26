package ProducerConsumer.Consumer;

// CLASSPATH = "C:\Program Files (x86)\Java\jdk1.6.0_02\bin\ThreadPrograms";
import ProducerConsumer.Queue.*;                                                       // Importing Queue-class in the Sub-Directory "Queue" & Parent-Directory "ProducerConsumer"
import ProducerConsumer.Producer.*;                                                // Importing Producer.class in the Sub-Directory "Producer" & Parent-Directory "ProducerConsumer"

public class Consumer implements Runnable{                                       // Implementation of the Properties of Parent class(i.e. Runnable) in the current class(i.e. Consumer)
	
    Queue q;                                                                                 // Declaring Object of Previous class(i.e. Queue)
	public Consumer(Queue q){                                                                // Defining Constructor(i.e. Consumer) with Object of class(i.e. q) as an Argument
		
		this.q = q;                                                                          // Refering to the Object of Queue-class(i.e. q) & Consumer is being Invoked
		Thread t = new Thread(this);                                                         // Creating Thread Object for Consumer class
		t.start();                                                                           // Calling start() method of Consumer Thread 
		
	}

    public void run(){                                                                       // Defining run() method for Execution of Consumer Thread
        
        while(true){
		
            q.get();	                                                                     // Calling get() method of Queue class using Object Of Queue(i.e. q)
            try{

                Thread.sleep(2000);                                                          // Consumer's Sleeping time : t = 2000 msec

            }catch(Exception e){

                e.printStackTrace();                                               // Helps the programmer to understand where the actual problem occurred while Consuming the Element

            }

        }

    }

}	