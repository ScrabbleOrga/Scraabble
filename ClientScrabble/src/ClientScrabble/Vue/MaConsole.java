package ClientScrabble.vue; 
/**
   An easy interface to read numbers and strings from
   standard input

   @version 1.10 10 Mar 1997
   @author Cay Horstmann
*/

public class MaConsole
{  /**
      print a prompt on the console but don't print a newline

      @param prompt the prompt string to display
    */

   public static void printPrompt(String prompt)
   {  System.out.print(prompt + " ");
      System.out.flush();
   }

   /**
      read a string from the console. The string is
      terminated by a newline

      @return the input string (without the newline)
    */

   public static String readLine()
   {  int ch;
      String r = "";
      boolean done = false;
      while (!done)
      {  try
         {  ch = System.in.read();
            if (ch < 0 || (char)ch == '\n')
               done = true;
            else if ((char)ch != '\r') // weird--it used to do \r\n translation
               r = r + (char) ch;
         }
         catch(java.io.IOException e)
         {  done = true;
         }
      }
      return r;
   }
 

   /**
      read a string from the console. The string is
      terminated by a newline

      @param prompt the prompt string to display
      @return the input string (without the newline)
    */

   public static String readLine(String prompt)
   {  printPrompt(prompt);
      return readLine();
   }


}
