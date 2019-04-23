package compare;

import com.herbtea.study.datastructure.ArrayList.ArrayList;
import com.herbtea.study.datastructure.LinkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.addLast(10);
        a.addLast(20);
        a.addLast(30);
        ArrayList.ListIterator ai = a.listIterator();
        while (ai.hasNext()){
            if((int)ai.next() == 20) {
                ai.add(25);
            }
        }

        LinkedList l = new LinkedList();
        l.addLast(10);
        l.addLast(20);
        l.addLast(30);
        l.addFirst(5);
        LinkedList.ListIterator li = l.listIterator();
        while (li.hasNext()){
            if((int)li.next() == 20) {
                li.add(25);
            }
        }
    }
}
