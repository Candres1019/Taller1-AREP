package edu.escuelaing.arep;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        LinkedListImp linkedListImp = new LinkedListImp();
        linkedListImp.addLast(4.5);
        linkedListImp.addLast(6.0);
        linkedListImp.addLast(3.9);
        linkedListImp.addLast(1.9);
        linkedListImp.addLast(9.3);

        linkedListImp.add(4, 14.5);

        String printStr = linkedListImp.linkedListToString();
        System.out.println(printStr);
    }
}
