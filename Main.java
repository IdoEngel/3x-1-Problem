import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // define base cases:
        CasheSaves head = new CasheSaves(1, 4);
        head.create(1, 2);

        twoTries(input, head);
        System.out.println("Enter the largest number: ");
        run(head, input.nextLong());
    }

    static void twoTries(Scanner input, CasheSaves head){
        long user;
        System.out.print("Enter the number of times to run: ");
        user = input.nextLong(); // get user input
        long ans = calc(user, user, head, 0); // get the final res
        head.create(ans, user); // add to cashe
        System.out.printf("%d => %d%n",user, ans); // print ans

        System.out.println("SECOND TRY:");
        System.out.print("Enter the number of times to run: ");
        user = input.nextLong(); // get user input
        ans = calc(user, user, head, 0); // get the final res
        head.create(ans, user); // add to cashe
        System.out.printf("%d => %d%n",user, ans); // print ans
    }

    /**
     * run in a for loop from 1 to the inserted value to see if there is a value that dont return 1
     *  if such number found - add it to the rem (remmember) linked list to pritn later
     * @param head head pointer to the chase saves
     * @param biggest the biggest number the loop will go
     */
    static void run(CasheSaves head, long biggest){
        long ans;
        CasheSaves rem = new CasheSaves(1, 2);
        for (int i =1; i <= biggest; i++){
            ans = calc(i, i, head, 0); // get the final res
            System.out.printf("%d => %d%n",i, ans); // print ans
            if (ans != 1){
                rem.create(ans, i);
            }
        }

        System.out.println("THE NUMBERS THAT WITH ANSWER THAT IS NOT 1: ");
        CasheSaves curr = rem;
        for (int i=0; i < rem.len() && curr.next != null; i++){
            System.out.printf("%d => %d", curr.getInput(), curr.getRes());
            curr = curr.next;
        }
    }

    /**
     * Culc the ans accurding to the rules of the 3x+1 math problem
     * @param start the start value - not changing
     * @param num the curr ans - apdating until getting the prodicted answer (1) or the counter getting to high
     * @param head head pointer to the linked list
     * @param counter number of recursions
     * @return the final value of the math problem
     */
    static long calc(long start,long num, CasheSaves head, long counter){
        long ret = 0;

        // base cases:
        if (head.exist(num)){  // found in the cashe
            if (head.search(num) == 1) // the final predicted ans
                ret = head.search(num);
            else{
                System.out.println("NOT using cashe");
                if (num % 2 == 0){ // is even
                    head.create(num / 2, num);
                    ret = calc(start,num / 2, head , ++counter);
                }
                else{ // odd
                    head.create(num*3+1, num);
                    ret = calc(start, num*3+1, head, ++counter);
                }
            }
            System.out.println("using cashe");
        }
        else if (counter == 9223372036854775806L){  // mutch calc done to be sure 1 not going to come
            System.out.println("NOT using cashe");
            head.create(num, start);
            ret = num;
        }
        else {  // none of the cases came true
            System.out.println("NOT using cashe");
            if (num % 2 == 0){ // is even
                head.create(num / 2, num);
                ret = calc(start,num / 2, head , ++counter);
            }
            else{ // odd
                head.create(num*3+1, num);
                ret = calc(start, num*3+1, head, ++counter);
            }
        }
        return ret;
    }

}