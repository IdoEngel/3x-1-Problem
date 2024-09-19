import java.lang.NullPointerException;
import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;

public class CasheSaves {
    private final long res;
    private final long input;
    protected CasheSaves next;

    private static CasheSaves head = null;

    public CasheSaves(long res, long input) {
        this.res = res;
        this.input = input;
        this.next = null;
    }
    public CasheSaves() {
        this.res = 0;
        this.input = 0;
        this.next = null;
    }

    public CasheSaves getHead() {return CasheSaves.head; }
    public long  getRes() {return res; }
    public long getInput() {return input; }
    public CasheSaves getNext() {return next; }

    @Override
    public String toString() {
        String ret;
        if (next != null) {
            ret = "CasheSaves{" +
                    "res=" + res +
                    ", input=" + input +
                    ", next={ res=" + next.res +
                    ", input=" + next.input +
                    "}}";
        }
        else {
            ret = "CasheSaves{" +
                    "res=" + res +
                    ", input=" + input +
                    ", next=null" +
                    '}';
        }
        return ret;
    }

    /**
     * Create a node at the end of the lined list
     * @param res the last result of the culc
     * @param input the first input that led to the res
     * @return the new node not in the linked list, as a stand-alone var*/
    public CasheSaves create(long res, long input){
        CasheSaves ret;

        if(CasheSaves.head == null){ // create the head
            CasheSaves.head = new CasheSaves(res, input);
            ret = CasheSaves.head;
        }
        else{ // there is a head
            CasheSaves curr = CasheSaves.head;

            while(curr.next != null){  // find the last ele
                curr = curr.next;
            }

            curr.next = new CasheSaves(res, input);
            ret = curr.next;
        }
        return ret;
    }

    /**
     * check & return the len of the linked list - starting with head
     * @return the len of the linked list
     * @throws NullPointerException if head is null
     */
    public int len()
        throws NullPointerException {
        int counter = 0;
        CasheSaves curr = CasheSaves.head;

        if (CasheSaves.head == null){ // if there is no head prt
            throw new NullPointerException("head ptr is null");
        }

        while (curr != null){  // checks the len of the linked list
            counter++;
            curr = curr.next;
        }
        return counter;
    }

    /**
     * Delete element by index
     * @param index the index to delete
     * @return the deleted node
     * @throws IndexOutOfBoundsException if index greater than the len of the list
     */
    public CasheSaves del(int index)
        throws IndexOutOfBoundsException{

        CasheSaves curr = CasheSaves.head;
        CasheSaves ret = null;
        if (index+1 > CasheSaves.head.len()){  // throw eception if index is out of range
            throw new IndexOutOfBoundsException(String.format("Len of linked list is shorter then the given index(%d)", index));
        }

        int i;
        for (i=0; i < index; i++){ // go to the element before the one to del
            curr = curr.next;
        }
        ret = curr.next;

        // check if del is the last:
        if (index == CasheSaves.head.len()-1){  // -1, for index fix
            curr.next = null;
        }
        else if (index == 0){ // if del the first
            ret = CasheSaves.head;
            CasheSaves.head = CasheSaves.head.next;
        }
        else{ // the del is somewhere in the middle
            curr.next = curr.next.next;
        }

        return ret;
    }

    /**
     * Return the index of node with the same input
     * @param input the input to look for
     * @return the index of the
     * @throws NullPointerException if head ptr is null
     */
    public int findIndex(int input)
        throws NullPointerException {
        int index = 0;
        CasheSaves curr = CasheSaves.head;

        while (curr != null) {
            if (curr.input == input){
                break;
            }
            index++;
            curr = curr.next;
        }

        return index;
    }

    /**
     * Search for an element wiht the same input, return its res
     * @param input the input to search in the linked list
     * @return the res of the found element
     * @throws NullPointerException if the head ptr is null
     * @throws NoSuchElementException if the element in the given input havnt found
     */
    public long search(long input)
            throws NullPointerException, NoSuchElementException {
        long ret = -1;
        boolean found = false;
        CasheSaves curr = CasheSaves.head;

        if (CasheSaves.head == null){ //return if there is no data
            throw new NullPointerException("head ptr is null");
        }
        // else: there is a head ptr

        while (curr != null) {  // find the ele, and update the vars
            if(curr.input == input){
                ret = curr.res;
                found = true;
            }
            curr = curr.next;
        }
        if (!found){
            throw new NoSuchElementException(String.format("There is no element with the input %d", input));
        }
        return ret;
    }

    /**
     * checks if the input exits, if not - search will raise an error - meaning not exist
     * @param input the input to search
     * @return is the input allready loged?
     */
    public boolean exist(long input){
        try{
            search(input);
            return true;
        }
        catch (NoSuchElementException | NullPointerException e){
            return false;
        }
    }

}
