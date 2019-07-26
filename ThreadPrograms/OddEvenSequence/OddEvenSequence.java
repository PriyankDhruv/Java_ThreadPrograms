import java.util.Scanner;                                                            // Importing Scanner from util directory in java 

class OddEvenSequence extends Thread{                                                // Properties of parent class(i.e. Thread) is inherited by current class(i.e. OddEvenSequence)
	
	boolean Odd;
	int count = 1;                                                                   // Set Counter to initial state(i.e. ONE)
	
    static{                                                                          // The static block is first executed as soon as the class is loaded before the main()
		
		System.out.println("Enter the Extension of the Sequence : ");
		
    }	
	
	Scanner Input = new Scanner(System.in);                                          // Taking Argument from user via System
	int MAX = Input.nextInt();
	
	public void OddBuffer(){                                                         // Defining OddBuffer() for identifying Odd Numbers

        synchronized(this){                                                          // Provides mutually exclusive access to print Even Sequence with thread t1(for EvenBuffer)

            while(count < MAX){                                                      // Executing the Loop until Counter reaches to maximum value of Sequence Extension

                System.out.println("Checking Odd Loop..");	

                while(!Odd){                                                         // Executing the Loop until the given Number is Odd

                    try{

                        System.out.println("Odd Waiting : " + count);
						
						Thread.sleep(2000);                                          // Thread Delay(i.e. Sleeping) time for OddBuffer is t = 2000 msec.
                        wait();                                                      // Tells the Thread t2 to give up the lock & go to sleep until t1 Thread gets Executed
						
                        System.out.println("Notified Odd : " + count);

                    }catch(InterruptedException e1){                    // InterruptedException occures only when one thread is sleeping or waiting & another thread interrupts it 

                        e1.printStackTrace();                                        // Helps the current class(i.e. OddEvenSequence) where the actual problem occurred    

                    }

                }

                System.out.println("Odd Thread : " + count);
                count++;                                                             // Increament the Counter
                Odd = false;                                                         // Set Odd to false when any Odd integer is not Encountered in the Sequence
                notify();                                                            // Wake up the Thread t1 of Even Sequence for Execution of EvenBuffer 

            }

        }

    }		
		
	public void EvenBuffer(){                                                        // Defining EvenBuffer() for identifying Even Numbers
		
		try{
			
			Thread.sleep(2000);                                                      // Thread Delay(i.e. Sleeping) time for EvenBuffer is t = 2000 msec.
			
		}catch(InterruptedException ie){                                // InterruptedException occures only when one thread is sleeping or waiting & another thread interrupts it 

            ie.printStackTrace();                                                    // Helps the current class(i.e. OddEvenSequence) where the actual problem occurred

        }			
		
		synchronized(this){                                                           // Provides mutually exclusive access to print Even Sequence with thread t2(for OddBuffer)
			
			while(count < MAX){                                                       // Executing the Loop until Counter reaches to maximum value of Sequence Extension
				
				System.out.println("Checking Even Loop..");
				
				while(Odd){                                                          // Executing the Loop until the given Number is not Odd
					
					try{
						
						System.out.println("Even Waiting : " + count);
						wait();                                                      // Tells the Thread t1 to give up the lock & go to sleep until t2 Thread gets Executed 
						System.out.println("Notified Even : " + count);
						
					}catch(InterruptedException e2){                    // InterruptedException occures only when one thread is sleeping or waiting & another thread interrupts it 

                        e2.printStackTrace();                                         // Helps the current class(i.e. OddEvenSequence) where the actual problem occurred 

                    }						
					
				}

                System.out.println("Even Thread : " + count);                        
                count++;                                                             // Increament the Counter
                Odd = true;                                                          // Set Odd to true when any Odd integer is Encountered in the Sequence
                notify();                                                            // Wake up the Thread t2 of Odd Sequence for Execution of OddBuffer 

            }

        }			
		
	}
	
	public static void main(String args[]){
		
		final OddEvenSequence OES = new OddEvenSequence();                           // Creating Object of OddEvenSequence class for the final time(i.e. Only Once)
		OES.Odd = true;                                                              // Initially, Set Odd to true  
		
		Thread t1 = new Thread(new Runnable(){                                       // Creating Thread t1 for Even Sequence in Runnable State
			
			public void run(){                                                       // Defining run() method for Executing Even Sequence
				
				OES.EvenBuffer();                                                    // Calling EvenBuffer() using final Object of OddEvenSequence class
				
			}

        });

        Thread t2 = new Thread(new Runnable(){                                       // Creating Thread t2 for Odd Sequence in Runnable State

            public void run(){                                                       // Defining run() method for Executing Odd Sequence

                OES.OddBuffer();                                                     // Calling OddBuffer() using final Object of OddEvenSequence class

            } 				
			
		});	
		
		t1.start();                                                                  // Calling start() method of Thread t1
		t2.start();                                                                  // Calling start() method of Thread t2
		
		try{
			
			t1.join();                                                               // Main Thread will stop Execution at this point & wait for Thread t1 to complete                                                                
			t2.join();                                                               // Main Thread will stop Execution at this point & wait for Thread t2 to complete
			
		}catch(InterruptedException e3){                                // InterruptedException occures only when one thread is sleeping or waiting & another thread interrupts it 

            e3.printStackTrace();                                                     // Helps the current class(i.e. OddEvenSequence) where the actual problem occurred   

        }

    }

}	