package sample.dummy;

import sample.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by stepan on 6/23/2017.
 */
public class DummyMessages {

    public static String userID = "my_name@company.com";
    public static List<Message> initialMessages;


    public static void populate(){
        initialMessages = new ArrayList<>();

        for(int i = 0; i < 12 ; i++){
            System.out.println("i is: " + i);


            Date sentDate = new Date(System.currentTimeMillis() - timeSinceSent[i] * 3600000L);

            List<String> recipientIDs = new ArrayList<>();
            recipientIDs.add(userID);
            if(i%2 == 0 ){
                recipientIDs.add(sendersIDs[5* i % 12]);
            }
            if(i%3 == 0 ){
                recipientIDs.add(sendersIDs[(7* i) % 12]);
            }

      Message m = new Message(msgIDs[i], msgParentIDs[i], sendersIDs[i], recipientIDs, msgTitle[i],  msgBody[i], sentDate, i < 4 , i % 4 == 0, i%7 == 2);

            initialMessages.add(m);
            System.out.println(m.toString() + "\n\n");
        }

    }


    public static Message getMessageByID(Long id){
        boolean messageFound = false;
        for(Message m : initialMessages){
            if(m.getMessageID()== id){
                return m;
            }
        }
        return null;
    }


    public static String[] sendersIDs = new String[]{"a@aa.com", "b@bb.com", "c@cc.com", "d@aa.com", "er@bb.com", "f.g@cc.com", "my_name@company.com", "klm@bb.com", "nop@cc.com", "qwe1@aa.com", "fgh544@bb.com", "xxx@cc.com"};

    public static Long[] msgIDs = {       15L, 23L, 67L, 115L, 123L,  167L, 225L, 243L, 267L, 325L, 384L, 647L};
    public static Long[] msgParentIDs =  { -1L, -1L, -1L, -23L, -1L,    -1L, -115L, -1L, -1L, -1L, 15L, -1L};
    public static Long[] timeSinceSent = { 1801L, 1456L, 742L, 729L, 672L, 653L, 643L, 618L, 345L, 147L, 96L, 69L};

    public static  String[] msgTitle = new String[]{"Object o", "Integer i", "String s", "StringBuilder sb", "Thread th", "Collection c", "Double d", "Set s", "Map m", "Array a", "boolean b", "Comparable c"};
    public static  String[] msgBody = new String[]{"Class Object is the root of the class hierarchy. Every class has Object as a superclass. All objects, including arrays, implement the methods of this class.",
            "The Integer class wraps a value of the primitive type int in an object",
            "he Java language provides special support for the string concatenation operator ( + )",
            "The principal operations on a StringBuilder are the append and insert methods",
            "A thread is a thread of execution in a program. ",
            "A collection is an object that can hold references to other objects. ",
            "Class Double. The Double class wraps a value of the primitive type double in an object",
            "This class implements the Set interface, backed by a hash table (actually a HashMap instance). ",
            "A map cannot contain duplicate keys; each key can map to at most one value.",
            "Each ArrayList instance has a capacity. The capacity is the size of the array used to store the elements in the list. It is always at least as large as the list size.",
            "A Boolean value is one with two choices: true or false, yes or no, 1 or 0.",
            "Virtually all Java core classes that implement Comparable have natural orderings that are consistent with equals. One exception is java."};

}
