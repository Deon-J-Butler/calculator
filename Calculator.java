import java.util.Scanner; //import Scanner for user input
import java.io.*; //import Input/Output for export to docs

public class Calculator{
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("What is your name?");
        String name = input.nextLine();
        System.out.println("Hello, "+name+". I am Calculator.");
        
        String runProgram = "N";
        while(runProgram.equals("N") || runProgram.equals("n")){
            
            try{ //try to run the program, watch for exceptions
                System.out.print("Enter the first number >> ");
                double firstNum = input.nextDouble();
                System.out.print("Enter the second number >> ");
                double secondNum = input.nextDouble();
                System.out.print("Enter operator >> ");
                String operator = input.next();
                double answer = 0;
                
                switch (operator) {
                    case "+":
                        answer = MathOP2.mathAdd(firstNum, secondNum);
                        System.out.println("The sum of the numbers is "
                              +answer);
                        break;
                        
                    case "-":
                        answer = MathOP2.mathSub(firstNum, secondNum);
                        System.out.println("The difference of the two numbers is "
                              +answer);
                        break;
                        
                    case "*":
                        answer = MathOP2.mathMulti(firstNum, secondNum);
                        System.out.println("The product of the two numbers is "
                              +answer);
                        break;
                        
                    case "/":
                        if(secondNum == 0){
                           System.out.println("You cannot divide by zero.");
                        } else {
                           answer = MathOP2.mathDiv(firstNum, secondNum);
                           System.out.println("The quotient of the two numbers is "
                                 +answer);
                        }
                        break;
                        
                    default:
                        System.out.println("That operator is not supported on this system, sorry.");
                        break;                     
                }
                
                System.out.println("Do you want to save the results, Y/N? "); //user can save results
                String results = input.next();
                if(results.equals("Y") || results.equals("y")){
                    
                      try{ //IO classes that refer to files are ran in try block
                      FileWriter fwLog = new FileWriter("Math_Results.csv", true);
                      BufferedWriter bw = new BufferedWriter(fwLog);
                      bw.write(firstNum+" "+operator+" "+secondNum+" = "+answer);
                      bw.newLine();
                      System.out.println("Results saved!");
                      bw.close();
                      } catch (Exception e){ //if IO class raises an exception
                      e.getStackTrace();
                      }
                      
                      System.out.println("Do you want to review the result log, Y/N? "); //user can view results
                      String reviewLog = input.next();
                      if(reviewLog.equals("Y") || reviewLog.equals("y")){
                      
                         try{ //IO classes that refer to files are ran in try block
                         FileReader frLog = new FileReader("Math_Results.csv");
                         BufferedReader br = new BufferedReader(frLog);
                         int read = 0;
                         while((read = br.read())!=-1){
                           System.out.print((char)read);
                           }
                         br.close();
                         } catch (Exception e){ //if IO class raises an exception
                         e.getStackTrace();
                         }
                         System.out.println();
                      }
                    }
               
                
            } catch(Exception e){ //print feedback if user enters something other than a nextInt()
                System.out.println("There was an error, a character other than a numerical value was entered. ");
                input.next();
                
            } finally { //this block is always printed
                System.out.print("Do you want to exit, Y/N? "); //check if user wants to exit Calculator
                runProgram = input.next();
            }
        }
        if(!(runProgram.equals("N") || runProgram.equals("n"))){
            System.out.println("Thank you for using our system. Until next time, "+name+"."); //printed on program close
        }       
    }    
}
