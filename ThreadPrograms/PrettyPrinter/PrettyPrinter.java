class Printer extends Thread{                                       // Properties of the Thread class is Inherited by the Printer class  
	
	synchronized public void Print(String msg){                     // Defining the Overloaded Function i.e. Print() with String as Argument
		
		System.out.println("{");                     
		
		try{
			
			Thread.sleep(2000);                                     // Delay time of Thread Execution is t = 2000 sec.
			
		}catch(Exception e){

            e.printStackTrace();                                    // Helps the current class i.e. USER where the actual problem occurred

        }

        System.out.println(msg);                                    // Prints the message given by the USER
        System.out.println("}");

    }

}	

class User extends Thread{                                          // Properties of the Thread class is Inherited by the User class
	
	Printer P;                                                      // Declaring Object of the Printer class
	String PrintContent;
	User(String PrintContent, Printer P){                           // Constructor of User class is Defined
		
		this.P = P;                                                 // Reference made to the Object of the Printer class 
		this.PrintContent = PrintContent;                           // Reference made to the String of the User class
		Thread t = new Thread(this);                                // Object of Thread is created with Reference to the current class i.e. User class
	
    }

    public void run(){                                              // Run method for Thread Execution is Defined

        P.Print(PrintContent);                                      // Calling Overloaded method of the Printer class using Object of the Printer

    }
	
}

class PrettyPrinter{

    public static void main(String args[]){

        try{

            Printer P = new Printer();                              // Creating Object of the Printer class for Constructor initialization 

            User U1 = new User("Hope",P);                           // Creating 1st Object of the User class with user's Input & Object of Printer as Arguments
            U1.start();                                                // Calling start() method of Thread using 1st Object of the User class 
            U1.join();                                                    // U1 Thread waits for the main Thread to execute  

            User U2 = new User("Never",P);                           // Creating 2nd Object of the User class with user's Input & Object of Printer as Arguments 
            U2.start();                                                 // Calling start() method of Thread using 2nd Object of the User class 
            U2.join();                                                     // U2 Thread waits for the U1 Thread to execute 

            User U3 = new User("Dies",P);                            // Creating 3rd Object of the User class with user's Input & Object of Printer as Arguments
            U3.start();                                                 // Calling start() method of Thread using 3rd Object of the User class 
            U3.join();                                                     // U3 Thread waits for the U2 Thread to execute

        }catch(Exception e){ 			
		
		    e.printStackTrace();                                    // Helps the current class i.e. PrettyPrinter where the actual problem occurred
			
		}

    }

}	