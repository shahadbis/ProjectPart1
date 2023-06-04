/*
Name: Shahad Abdulaziz Bin Salman
ID: 2105902
Section: B0B 
 */
package PhoneNetworkApp;

import algorithmtwo.Graph;
import algorithmtwo.MHPrimAlg;
import algorithmtwo.KruskalAlg;
import java.io.FileNotFoundException;
import java.util.Scanner;

//------------------------------ Main Class -------------------------------
public class PhoneNWDesignApp {

    public static void main(String[] args) throws FileNotFoundException {
        // Scanner to read from user
        Scanner sc = new Scanner(System.in);

        // Voiw mune to the user to choise one of the requirements
        int userChoise = mune(sc);

        // Declearing data
        boolean isInvalid = false;

        // Create graph object
        Graph mst = new Graph();

        // Starting do-while loop to check the user's choise 
        do {
            //----------------------------------------------
            // First requirement reading data from file and calculate the cost
            if (userChoise == 1) {

                // Use readGraphFromFile method from Graph class
                mst.readGraphFromFile("inputFile.txt");

                // Use prim and krakal algoriths to find cost
                KruskalAlg kruskal = new KruskalAlg(mst) 
                kruskal.displayResultingMST(userChoise);
                
                System.out.println("\n-------------------------------------------------\n");
                
                MHPrimAlg prim = new MHPrimAlg(mst);
                prim.displayResultingMST(userChoise);


            }//----------------------------------------------
            // Second requirement generating random data and calculate the cost and time that algoriths take 
            else if (userChoise == 2) {

                // n = No.vertices, m = No.edges
                System.out.println("\nEnter NO.offices in campany (n): ");
                int n = sc.nextInt();
                System.out.println("\nEnter NO.phone lines in campany (m): ");
                int m = sc.nextInt();

                // Use makeGraph method from Graph class
                mst.make_Graph(n, m);

                //--------------- Kruskal algo------------------
                System.out.println("\nKruskal's Algorithm :");
                KruskalAlg kruskal = new KruskalAlg(mst) 
                kruskal.displayResultingMST(userChoise);

                System.out.println("\n-------------------------------------------------\n");

                //--------------- Prim algo------------------
                System.out.println("Prim's Algorithm :");
                MHPrimAlg prim = new MHPrimAlg(mst);
                prim.displayResultingMST(userChoise);

                break;

            }//----------------------------------------------
            // Invalid input user should choose another choise  
            else {
                System.out.println("\n!!! Invalid input, choose again !!!\n");
                choise = mune(sc);
                isInvalid = true;
            }
        } while (isInvalid);
    }

    //---------------------------- mune Method to display mune to the user -------------------------
    public static int mune(Scanner sc) {
        System.out.println("-------------------------------------------------");
        System.out.println("\tWelcome in Phone Lines System!");
        System.out.println("-------------------------------------------------");
        System.out.println("Choose wich Requirement want to display:");
        System.out.println("1. Compute the minimum spanning tree (data are taken from a file)");
        System.out.println("2. Compute the minimum spanning tree (random data)");
        System.out.println("\nYour choise:");

        return sc.nextInt();
    }
}
