class TypeWriter extends Exception{                                 // Properties of parent class(i.e. Exception) is inherited by current class(i.e. TypeWriter)
	
	static void DelayEffect(String str){                            // Function for generating Delay in time is Defined 
		
		try{
			
			for(int i=0; i<str.length(); i++){                      // Delay Loop is created with [Total No. of iterations = Length of String] & is increamented after each iteration

                System.out.println(str.charAt(i));                  // Displaying each Character of String 
                Thread.sleep(1000);                                 // Delay time t = 1000 msec. occures after each Character of String

			}
			
        }catch(Exception e){                                        // Exception occures when any special symbol or Numeric value is Encountered

            e.printStackTrace();                                    // Helps the current class(i.e. TypeWriter) where the actual problem occurred

        }

    }

    public static void main(String args[]){                         

        String Typing = args[0];                                    // Assigning user's first argument(i.e. args[0]) to the given String

        DelayEffect(Typing);                                        // Calling Delay Function with String as an Argument

    }

}	