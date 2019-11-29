package sample;
import java.util.*;
public class Treesample {
       public static void main(String args[]) {
    	   Scanner sc=new Scanner(System.in);
    	   int n=sc.nextInt();
    	   ArrayList<String> a=new ArrayList<>();
    	   
    	   for(int i=0;i<n;i++) {
    		   a.add(sc.next());
    	   }
    	   
    	   checkTreeViability(a,n);
    	   
    	   
       }
       //checks if the tree is viable or not
       public static void checkTreeViability(ArrayList<String> a,int n) {
    	   if(!a.contains("-")) {//base condition
    	       System.out.println("0");
    	   }
    	   else
    	   {   
    		   a.remove("-");
    		   for(int i=0;i<n-1;i++) {
    			   boolean ans=find(a.get(i),a);
    			   if(ans==false) {
    				   System.out.println("0");//if not viable
    				   return;
    			   }
    		   }
    		   System.out.println("1");//if viable
    		   
    	   }
       }
       //checks if the node can be present in the tree
       public static boolean find(String str,ArrayList<String> a) {
    	   for(int i=0;i<str.length();i++) {
    		   if(!a.contains(str.substring(0,i+1))) {
    			   return false;
    		   }
    	   }
    	   return true;
       }
}
/*
input 1
6
LR
-
R
LL
RL
L
output 1
1

input 2
3
LR
-
R
output 2
0
 */
