/* I wrote the program based on what I learned in class, but for some reason, it compiles without a problem, but nothing happens when I run it. It seems that there might be an 
 * incompatibility between the code written and OSX because I remember that to open a program in Windows, you write the name of the program in command prompt. In OSX a program has to
 * be opened through the command "open -a application.app" which is completely different and may be the cause of the program
 * I had help from the site http://stackoverflow.com/questions/5488072/reading-in-from-system-in-java and I found exitValue() from http://stackoverflow.com/questions/4842712/process-exitvalue-in-java*/
import java.util.Scanner;



public class Shell {
    
			 static String shell;
           public static void main(String[] args) throws Throwable 
           {
        	   System.out.println("Running Shell");
           // create a new list of arguments for process
               
               Scanner my_scanner = new Scanner(System.in);
               String my_string = my_scanner.next();
               if (my_string.endsWith("&")) { // Used to eliminate the '&' from the program
   				shell = my_string.substring(0, my_string.length() - 1);
   			}
           // create the process builder
               ProcessBuilder pb = new ProcessBuilder(shell);
           Process p =  pb.start(); 
          if (my_string.endsWith("&")) 
          {
				pb.start();
			} else {
				p = pb.start();
				p.waitFor();
				System.out.println(p.exitValue());
			}


           }
}