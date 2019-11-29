package sample;
import java.util.*;
import java.io.*;
public class words {
	public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  String S=sc.nextLine();
  
  ArrayList<String> a= new ArrayList<>();
  a=tokenizer(a,S);
  for(int i=0;i<a.size();i++) {
	  System.out.println(a.get(i));
  }

  
}
	/*tokenizer function splits the words by space and the words enclosed 
	within quotes are considered to be one entity*/
	public static ArrayList<String> tokenizer(ArrayList<String> a,String S){
		int flag=0;
		  String wd="";
		  for(int i=0;i<S.length();i++) {
			  char quote='"';
			  
			  if(S.charAt(i)!=' ' && flag==0 && S.charAt(i)!='"') {
				  wd+=S.charAt(i);
				  continue;
		         }
			  if(S.charAt(i)=='"') {
				  flag++;
				  
				  wd+=S.charAt(i);
				  if(flag==2) {
					  a.add(wd);
					  wd="";
					  i=i+1;
					  flag=0;
				  }  
			  }
			  else if(flag!=0) {
				  wd+=S.charAt(i);
			  }
			  else {
				  a.add(wd);
				  wd="";
			  }
		   }
		  return a;
	}

}
/*
input:
xyz abc mnp "asdf dfaa asdf" asd "fdas asdsdafF"

output:
xyz
abc
mnp
"asdf dfaa asdf"
asd
"fdas asdsdafF"
*/