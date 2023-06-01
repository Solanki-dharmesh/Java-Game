import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class hangman{

  
    public static void main(String[] args) throws FileNotFoundException  {

        Scanner keyboard=new Scanner(System.in);
         System.out.println("1 or 2 Players?");
         String player=keyboard.nextLine();
         String word;
         if(player.equals("1")){
            Scanner s=new Scanner(new File("C:/Users/91951/PROJECTS/html/project/hangman/words.txt"));
        List<String> words=new ArrayList<>();
         while (s.hasNext()) {
            words.add(s.nextLine());
         } 
         Random r=new Random();
          word=words.get((r.nextInt(words.size())));
         }else{
            System.out.println("player please enter your word..");
            word=keyboard.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Ready for player 2! Good Luck");
         }
        
        //  System.out.println(word);

         List<Character> playerGuesses=new ArrayList<>();
         ShowState(word, playerGuesses);
        int wrongcount=0;
       while (true) {
                PrintHangman(wrongcount);
                if(wrongcount>=6){
                    System.out.println("Oops! You Loose (┬┬_┬┬)");
                    System.out.println("The word was:"+word);
                    break;
                }
                
             
        ShowState(word, playerGuesses);
       if(! getPlayerGuess(keyboard, word, playerGuesses)){
        wrongcount++;
       }
        if(  ShowState(word, playerGuesses)){
            System.out.println("you win");
            break;
        }
        System.out.println("please enter your guess for word:");
       if( keyboard.nextLine().equals(word)){
        System.out.println("you win");        
            break;
       }else{
        System.out.println("Nope! try again...");
       }

       }

       
        
    }

    private static void PrintHangman(int wrongcount) {
        System.out.println( " --------");
        System.out.println(" |       |");
        if(wrongcount>=1){
            System.out.println(" O");
        }
        if(wrongcount>=2){
            System.out.print("\\ ");
            if(wrongcount>=3){
                System.out.println("/");
            }else{
                System.out.println("");
            }
        }
        if(wrongcount>=4){
            System.out.println(" |");
        }
        if(wrongcount>=5){
            System.out.print("/ ");
            if(wrongcount>=6){
                System.out.println("\\");
            }else{
                System.out.println("");
            }
        }
    }

    private static boolean getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
        System.out.println("Plese enter the letter:");
         String letterGuess=keyboard.nextLine();
         playerGuesses.add(letterGuess.charAt(0));
            return word.contains(letterGuess);
    }

    private static boolean ShowState(String word,List<Character> playerGuesses){
        int correntcount= 0;  
        for (int i = 0; i < word.length(); i++) {
           if(playerGuesses.contains(word.charAt(i))){
               System.out.print(word.charAt(i));
               correntcount++;
           }else{
               System.out.print("-");
           }
        }
        System.out.println();
        return (word.length()==correntcount);
   }
}