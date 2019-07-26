package DiningPhilosophers.Philosopher;

// CLASSPATH = "C:\Program Files (x86)\Java\jdk1.6.0_02\bin\ThreadPrograms";

public class Philosopher extends Exception implements Runnable{                            // Inheriting Properties of Exception class & Implementing Properties of Runnable class
	
	private Object LeftFork = new Object();                                                // Creating Private Object of Object-class -> LeftFork  
	private Object RightFork = new Object();                                               // Creating Private Object of Object-class -> RightFork
	
	public Philosopher(Object LeftFork, Object RightFork){                                 // Defining Constructor(i.e. Philosopher) with Objects LeftFork & RightFork as an Argument
		
		this.LeftFork = LeftFork;                                                          // Refering to the LeftFork of Philosopher class & Philosopher is being Invoked 
		this.RightFork = RightFork;                                                        // Refering to the RightFork of Philosopher class & Philosopher is being Invoked
		
	}

    private void doAction(String action) throws InterruptedException{             // Defining doAction() method with String as an Argument & throws Exception as InterruptedException
		
		System.out.println(Thread.currentThread().getName() + " " + action);
		Thread.sleep(((int) (Math.random() * 100)));                              // Philosopher Thinking time : t = Generating Random Number of Integers with the Shieft of 100 msec 
		
	}	
		
	public void run(){                                                                       // Defining run() method for Execution of Philosopher Thread
		
		try{
			
			while(true){
				
				doAction(System.nanoTime() + ": Thinking");                                // Calling doAction() method in Nano secs. with String Message = "Thinking"  
				synchronized(LeftFork){
					
					doAction(System.nanoTime() + ": Picked up Left Fork");                 // Calling doAction() method in Nano secs. with String Message = "Picked up Left Fork"
					synchronized(RightFork){
						
						doAction(System.nanoTime() + ": Picked up Right Fork - Eating");   // Calling doAction() in Nano secs. with String Message = "Picked up Right Fork - Eating" 
						doAction(System.nanoTime() + ": Put down Right Fork");             // Calling doAction() in Nano secs. with String Message = "Put down Right Fork"
						
					}

					doAction(System.nanoTime() + ": Put down Left Fork. Back to Thinking"); // Calling doAction() in Nano secs. with Message = "Put down Left Fork, Back to Thinking"
					
				}

			}

		}catch(InterruptedException ie){

		    Thread.currentThread().interrupt();                                   // Calling the interrupt() method of the Philosopher Thread if InterruptedException is Encountered
			return;
			
		}

	}

}	