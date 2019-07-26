class CreateDeadLock extends Exception{                                                  // Properties of Exception class is Inherited by the current class(i.e. CreateDeadLock)
	
	public static CreateDeadLock Resrc1 = new CreateDeadLock();                          // 1st Object of current class(i.e. CreateDeadLock) is Created  
	public static CreateDeadLock Resrc2 = new CreateDeadLock();                          // 2nd Object of current class(i.e. CreateDeadLock) is Created

	public static class Thread1 extends Thread{                                          // Sub-class Thread1 is Created with Inherited Properties of Thread class 
		
		public void run(){                                                               // run() method of Thread1 is Defined for its Execution 
			
			synchronized(Resrc1){                                                        // Thread1 is Only allowed to Access the 1st Resource
				
				System.out.println("Thread 1 : Holding Resource 1...");
				try{
					
					Thread.sleep(2000);                                                  // Thread1 Sleeping time : t = 2000 msec.
					
				}catch(InterruptedException ie){}					                     // InterruptedException arises when Thread1 Sleeps more than its Sleeping time
				System.out.println("Thread 1 : Waiting for Resource 2...");
				
				synchronized(Resrc2){                                                    // Thread1 is Only allowed to Access the 2nd Resource
					
					System.out.println("Thread 1 : Holding Resource 1 & 2...");
                
				}
				
            }

 		}

	}

	public static class Thread2 extends Thread{                                          // Sub-class Thread2 is Created with Inherited Properties of Thread class 
		
		public void run(){                                                               // run() method of Thread2 is Defined for its Execution
			
			synchronized(Resrc2){                                                        // Thread2 is Only allowed to Access the 2nd Resource
				
				System.out.println("Thread 2 : Holding Resource 2...");
				try{
					
					Thread.sleep(2000);                                                  // Thread2 Sleeping time : t = 2000 msec.
				
				}catch(InterruptedException ie){}                                        // InterruptedException arises when Thread2 Sleeps more than its Sleeping time  
 			    System.out.println("Thread 2 : Waiting for Resource 1...");
				
				synchronized(Resrc1){                                                    // Thread2 is Only allowed to Access the 1st Resource
					
					System.out.println("Thread 2 : Holding Resource 1 & 2...");
					
				}	
					
		    }

		}

    }		

	public static void main(String args[]){
		
		Thread1 t1 = new Thread1();                                                      // Creating Object of Thread1 as t1
		Thread2 t2 = new Thread2();                                                      // Creating Object of Thread2 as t2
		
		t1.start();                                                                      // Calling start() method of Thread1 using t1
		t2.start();                                                                      // Calling start() method of Thread2 using t2
		
	}	
	
}	