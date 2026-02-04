//A program to play the Wythoff's Game
import java.util.Scanner;
public class LastBiscuit
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //Declaring the Initial number of biscuits in both barrels as constants
        final int BIS_BARRELONE = 6;
        final int BIS_BARRELTWO = 8;
        //Creating variables of the declared constants to make the code easier
        int xbl = BIS_BARRELONE;
        int ybl = BIS_BARRELTWO;
        System.out.println("Biscuits Left - Barrel 1: " + xbl);
        System.out.println("Biscuits Left - Barrel 2: " + ybl);
        int player=0; //To know which Player's turn it is
        //counter variables to count the number of "skip" used by both players
        int pskip1=0;
        int pskip2=0;
        //The loop runs until both the barrels becomes empty and then Game is "OVER"
        while (xbl!=0 || ybl!=0)
        {
            player=player+1;
            if (player%2!=0)
            {
                System.out.println("Player Turn: 1");
            }
            else
            {
                System.out.println("Player Turn: 2");
            }
            int bis;
            //A variable to run the Game written inside the loop
            boolean isValid = false;
            while (!isValid)//The Game works until the condition becomes True
            {
             //The player chooses a barrel to pick Biscuits
             System.out.print("Choose a barrel: barrel1 (one), barrel2 (two), or both (both), "
                     + "or skip turn (skip)? ");
                String barrel = sc.nextLine();
                if (barrel.equals("one"))
                {
                    System.out.print("How many biscuits are you taking? ");
                    while (!sc.hasNextInt())//checking if the input is Integer or not
                    {
                        System.out.print("Please input an integer: ");
                        sc.nextLine();
                    }
                    //Biscuits are picked from Barrel 1
                    bis = sc.nextInt();
                    sc.nextLine();
                    if (bis<1 || bis>xbl)
                    {
                        System.out.println("Sorry, that's not a legal number of biscuits "
                                +"for that/those barrel(s)");
                        isValid = false;
                    }
                    else
                    {
                        //Finding the number of biscuits left in Barrel 1
                        xbl = xbl - bis;
                        isValid = true;
                    }
                }
                else if (barrel.equals("two"))
                {
                    System.out.print("How many biscuits are you taking? ");
                    while (!sc.hasNextInt())//checking if the input is Integer or not
                    {
                        System.out.print("Please input an integer: ");
                        sc.nextLine();
                    }
                    //Biscuits are picked from Barrel 2
                    bis = sc.nextInt();
                    sc.nextLine();
                    if (bis<1 || bis>ybl)
                    {
                        System.out.println("Sorry, that's not a legal number of biscuits "
                                +"for that/those barrel(s)");
                        isValid = false;
                    }
                    else
                    {
                        //Finding the number of biscuits left in Barrel 2
                        ybl = ybl - bis;
                        isValid = true;
                    }
                }
                else if (barrel.equalsIgnoreCase("both"))
                {
                    System.out.print("How many biscuits are you taking? ");
                    while (!sc.hasNextInt())//checking if the input is Integer or not
                    {
                        System.out.print("Please input an integer: ");
                        sc.nextLine();
                    }
                    //Biscuits are picked from both the Barrels
                    bis = sc.nextInt();
                    sc.nextLine();
                    if (bis<1 || bis>xbl || bis>ybl)
                    {
                        System.out.println("Sorry, that's not a legal number of biscuits "
                                +"for that/those barrel(s)");
                        isValid = false;
                    }
                    else
                    {
                        //Finding the number of biscuits left in both Barrels
                        xbl = xbl - bis;
                        ybl = ybl - bis;
                        isValid = true;
                    }
                }
                //Player 1 skips
                else if (barrel.equalsIgnoreCase("skip") && (player%2!=0))
                {
                    if (pskip1>=1 && player%2!=0)
                    {
                        System.out.println("Sorry you've used your skip.");
                        isValid = false;
                    }
                    else
                    {
                        isValid = true;
                    }
                        pskip1 = pskip1 + 1; // counting the number of skips for Player 1
                }
                //Player 2 skips
                else if (barrel.equalsIgnoreCase("skip") && (player%2==0))
                {
                    if (pskip2>=1 && player%2==0)
                    {
                        System.out.println("Sorry you've used your skip.");
                        isValid = false;
                    }
                    else
                    {
                        isValid = true;
                    }
                      pskip2 = pskip2 + 1; // counting the number of skips for Player 2
                }
                else
                {
                    isValid = false;
                }
            }
                System.out.println("Biscuits Left - Barrel 1: " + xbl);
                System.out.println("Biscuits Left - Barrel 2: " + ybl);
                //Declaring the winner of Wythoff's Game
                // decided on the basis of 'who took the Last Biscuit'
                if ((ybl == 0) && (xbl == 0))
                {
                    if (player%2!=0)
                    {
                        System.out.println("Winner is player 1");
                    }
                    else
                    {
                        System.out.println("Winner is player 2");
                    }
                }
                //exiting the loop
                isValid=true;
            }
        }
    }

