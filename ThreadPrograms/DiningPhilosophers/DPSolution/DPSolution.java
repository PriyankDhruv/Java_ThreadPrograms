package DiningPhilosophers.DPSolution;

// CLASSPATH = "C:\Program Files (x86)\Java\jdk1.6.0_02\bin\ThreadPrograms";

import DiningPhilosophers.Philosopher.*;                                    // Importing philosopher.class in the Sub-Directory "philosopher" & Parent-Directory "Diningphilosopher"

public class DPSolution{                                                   
	
	public static void main(String args[]){                                                  // Defining main() method with String as an Argument
		
		final philosopher philosopher[] = new philosopher[5];              // Create & Declare Array of philosopher(i.e. philosopher[]) of philosopher class as FINAL with SIZE = 5 
		Object Forks[] = new Object[philosopher.length];                                    // Creating Array of Objects(i.e. Forks[]) of Object class of SIZE = philosopher.length
		
		for(int i=0; i<Forks.length; i++){                                                   // Executing for-Loop from i = 0 to i = Forks.length - 1
			
			Forks[i] = new Object();                                                         // Creating new Object of Object-class for Each Object in Array of Forks(i.e. Forks[])
			
		}
		
		for(int i=0; i<philosopher.length; i++){                                            // Executing for-Loop from i = 0 to i = philosopher.length - 1
			
			Object LeftFork = Forks[i];                                                      // Assigning Each Forks(in Forks[]) to Each philosopher(in philosopher[]) as LeftFork
			Object RightFork = Forks[(i + 1) % Forks.length];                           // Assigning Remaining Forks(in Forks[]) to Each philosopher(in philosopher[]) as RightFork
			
			if(i == philosopher.length - 1){                                                
				
				philosopher[i] = new philosopher(RightFork, LeftFork);                       // The Last philosopher picks up the RightFork first
				
			}else{
				
				philosopher[i] = new philosopher(LeftFork, RightFork);                       // Each philosopher picks up the LeftFork first 
				
			}

			Thread t = new Thread(philosopher[i], "philosopher " + (i + 1));
			                                   // Creating Thread Object for the current class(i.e. Philosopher) with Array of philosopher(i.e. philosopher[]) as one of the Argument 
			t.start();                                                                       // Calling start() method of Philosopher Thread
			
		}

	}

}	