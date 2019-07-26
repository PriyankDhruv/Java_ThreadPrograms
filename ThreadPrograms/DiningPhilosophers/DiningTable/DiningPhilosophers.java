package DiningPhilosophers.DiningTable;

// CLASSPATH = "C:\Program Files (x86)\Java\jdk1.6.0_02\bin\ThreadPrograms";

import DiningPhilosophers.Philosopher.*;                                       // Importing Philosopher.class in the Sub-Directory "Philosopher" & Parent-Directory "Diningphilosopher"

public class Diningphilosopher extends Exception{                                           // Properties of Exception class is Inherited by current class(i.e. Diningphilosopher)
	
	public static void main(String args[]) throws Exception{                                 // Defining main() method with String as an Argument & throws Exception 
		
		Philosopher philosopher[] = new Philosopher[5];                                     // Creating Array of Objects(i.e. philosopher[]) of Philosopher class of SIZE = 5
		Object Forks[] = new Object[philosopher.length];                                    // Creating Array of Objects(i.e. Forks[]) of Object class of SIZE = philosopher.length  
		
		for(int i=0; i<Forks.length; i++){                                                   // Executing for-Loop from i = 0 to i = Forks.length - 1 
			
			Forks[i] = new Object();                                                         // Creating new Object of Object-class for Each Object in Array of Forks(i.e. Forks[]) 
			
		}
		
		for(int i=0; i<philosopher.length; i++){                                            // Executing for-Loop from i = 0 to i = philosopher.length - 1
			
			Object LeftFork = Forks[i];                                                      // Assigning Each Forks(in Forks[]) to Each philosopher(in philosopher[]) as LeftFork
			Object RightFork = Forks[(i + 1) % Forks.length];                           // Assigning Remaining Forks(in Forks[]) to Each philosopher(in philosopher[]) as RightFork
			
			philosopher[i] = new Philosopher(LeftFork, RightFork); 
			                                       // Creating new Philosopher with LeftFork & RightFork as an Argument for Each Object in Array of philosopher(i.e. philosopher[])
			
			Thread t = new Thread(philosopher[i], "Philosopher " + (i + 1));                
			                                   // Creating Thread Object for the current class(i.e. Philosopher) with Array of philosopher(i.e. philosopher[]) as one of the Argument 
			t.start();                                                                       // Calling start() method of Philosopher Thread 
			
		}

	}

}	
		