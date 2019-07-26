package ProducerConsumer.Operator;

// CLASSPATH = "C:\Program Files (x86)\Java\jdk1.6.0_02\bin\ThreadPrograms";
import ProducerConsumer.Queue.*;                                                     // Importing Queue-class in the Sub-Directory "Queue" & Parent-Directory "ProducerConsumer"
import ProducerConsumer.Producer.*;                                                  // Importing Producer.class in the Sub-Directory "Producer" & Parent-Directory "ProducerConsumer"
import ProducerConsumer.Consumer.*;                                                  // Importing Consumer.class in the Sub-Directory "Consumer" & Parent-Directory "ProducerConsumer"

public class ProducerConsumer{
	
	public static void main(String args[]){                                                  // Defining main() method with Array Of String Variables(i.e. args[]) as an Argument
		
		Queue q = new Queue();                                                               // Defining Object Of Queue class
		q.N = 0;                                                                             // Initializing the Index Of Queue-Elements to be fill in the Infinite Queue from "ZERO"
				
		Producer P = new Producer(q);                                                // Defining Object Of Producer class(i.e. P) with Object Of Queue class(i.e. q) as an Argument
		Consumer C = new Consumer(q);                                                // Defining Object Of Consumer class(i.e. C) with Object Of Queue class(i.e. q) as an Argument  
		
	}

}	