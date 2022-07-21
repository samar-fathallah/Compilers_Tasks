package csen1002.main.task6;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * Write your info here
 * 
 * @name Samar Shokry
 * @id 43-1746
 * @labNumber 11
 */

public class FFCFG {

	/**
	 * Constructs a CFG for which the First and Follow are to be computed
	 * 
	 * @param description A string representation of a CFG as specified in the task
	 *                    description
	 */
	public String[] variables;
	public Hashtable<Character, String> firsts;
	public Hashtable<Character, String> follows;
	public String input;
	public FFCFG(String description) {
		// TODO Auto-generated constructor stub
		variables=description.split(";");
		firsts= new Hashtable<Character, String>();
		follows= new Hashtable<Character, String>();
		for(int i=0;i<description.length();i++) {
			if(description.charAt(i)!=';'  && description.charAt(i)!=',') {
				if(Character.isLowerCase(description.charAt(i)) ){
					firsts.put(description.charAt(i),Character.toString(description.charAt(i)));
				}
				else {
					firsts.put(description.charAt(i),"");
				}
			}	
		
		}
		input=description;
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i)!=';'  && input.charAt(i)!=',') {
				if(!Character.isLowerCase(input.charAt(i)) ){
					if(input.charAt(i)=='S') {
						follows.put(input.charAt(i),"$");
					}
					else {
						follows.put(input.charAt(i),"");
					}

				}
			}	
		
		}		
	}
	public void PrintArray(String[] array){
		 for (String element: array) {
	            System.out.println(element+" ;");
	        } 
	}
	/**
	 * Calculates the First of each variable in the CFG.
	 * 
	 * @return A string representation of the First of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String toBeAdded(String currentFirst,String addFirsts) {
		String res="";
		for(int i=0;i<addFirsts.length();i++) {
			if(!currentFirst.contains(Character.toString(addFirsts.charAt(i))) && addFirsts.charAt(i)!='e') {
				res+=addFirsts.charAt(i);
			}
		}
		return res;
	}

	public boolean checkForEpsilon(String curr) {
		int c=0;
		if(curr.length()==1 && curr.charAt(0)=='e') {
			return true;
		}
		for(int i=0;i<curr.length();i++) {
			String currFirst=firsts.get(curr.charAt(i));
			if(!currFirst.isEmpty()) {
				if(currFirst.contains("e")) {
					c++;
				}
			}
		}
		if(c==curr.length()) {
			return true;
		}
		return false;
	}
	   public static String sortString(String inputString)
	    {
	        char tempArray[] = inputString.toCharArray();
	        Arrays.sort(tempArray);
	        return new String(tempArray);
	    }
	public String first() {
		// TODO Auto-generated method stub
		boolean change=true;
		while(change) {
			change=false;
			for(int i=0;i<variables.length;i++) {
				char currentVariable=variables[i].charAt(0);
				String[] righthand=variables[i].split(",");
				for(int j=1;j<righthand.length;j++) {
						for(int k=0;k<righthand[j].length();k++) {
							//check to add epsilon
							if(checkForEpsilon(righthand[j])) {
								String currentFirst=firsts.get(currentVariable);
								if(!currentFirst.contains("e")) {
									currentFirst+="e";
									firsts.put(currentVariable,sortString(currentFirst));
									change=true;
								}
								
							}
							//check to add first of variables or terminals
							//check if epsilon in all variables leading to righthand[k]
							String check=righthand[j].substring(0,k);
								if(checkForEpsilon(check)) {
										String toAdd=firsts.get(righthand[j].charAt(k));
										String addTo=firsts.get(currentVariable);
										String addIt=toBeAdded(addTo,toAdd);
										if(addIt.length()>0) {
												String currentFirst=firsts.get(currentVariable);
												currentFirst+=addIt;
												firsts.put(currentVariable,sortString(currentFirst));
												change=true;	
												}
										
								}	
						}
					}
						
				}	
		}
		String result="";	
		for(int i=0;i<variables.length;i++) {
			char curr=variables[i].charAt(0);
			result+=curr+","+firsts.get(curr)+";";
		}
		result=result.substring(0,result.length()-1);
		return result;
	}

	/**
	 * Calculates the Follow of each variable in the CFG.
	 * 
	 * @return A string representation of the Follow of each variable in the CFG,
	 *         formatted as specified in the task description.
	 */
	public String follow() {
		// TODO Auto-generated method stub
		String first=this.first();
		boolean change=true;
		while(change) {
			change=false;
			for(int i=0;i<variables.length;i++) {
				String[] righthand=variables[i].split(",");
				for(int j=1;j<righthand.length;j++) {
					for(int k=0;k<righthand[j].length();k++) {
						char B=righthand[j].charAt(k);
						if(Character.isUpperCase(B)) {
							String followB=follows.get(B);
							//last symbol then just add to its follow the follow of the mother variable
							if(k==righthand[j].length()-1) {
								char A=righthand[0].charAt(0);
								String followA=follows.get(A);
								followB=follows.get(B);
								String addIt=toBeAdded(followB,followA);
								if(addIt.length()>0) {
										String currentFollow=follows.get(B);
										currentFollow+=addIt;
										follows.put(B,sortString(currentFollow));
										change=true;	
										}	
							}
							else {
								char alpha=righthand[j].charAt(k+1);
								String alphaFirst=firsts.get(alpha);
								String addIt1=toBeAdded(followB,alphaFirst);
								if(addIt1.length()>0) {
										String currentFollow=follows.get(B);
										currentFollow+=addIt1;
										follows.put(B,sortString(currentFollow));
										change=true;	
										}	
								if(alphaFirst.contains("e")) {
									if((k+1)==righthand[j].length()-1) {
									char A=righthand[0].charAt(0);
									followB=follows.get(B);
									String followA=follows.get(A);
									String addIt=toBeAdded(followB,followA);
									if(addIt.length()>0) {
											String currentFollow=follows.get(B);
											currentFollow+=addIt;
											follows.put(B,sortString(currentFollow));
											change=true;	
											}	
									}
									else{
										char A=righthand[j].charAt(k+2);
										String followA=firsts.get(A);
										followB=follows.get(B);
										String addIt=toBeAdded(followB,followA);
										if(addIt.length()>0) {
												String currentFollow=follows.get(B);
												currentFollow+=addIt;
												follows.put(B,sortString(currentFollow));
												change=true;	
												}	
									}
								}
								
							}
							}
					
						}
					}
						}
				
					}
		String result="";	
		for(int i=0;i<variables.length;i++) {
			char curr=variables[i].charAt(0);
			char c=follows.get(curr).charAt(0);
			if(c !='$') {
				result+=curr+","+follows.get(curr)+";";
			}
			else {
				result+=curr+","+follows.get(curr).substring(1,follows.get(curr).length())+"$"+";";
			}
		}
		result=result.substring(0,result.length()-1);	
		return result;
	}
	public static void main(String[] args) {
		FFCFG cfg = new FFCFG("S,u,aYSV;Y,V,sYzSS,t;V,EuEu,uV,t,E;W,z,zE;X,bE,E,SuWV,tV;E,SaXt,tV,e");
		cfg.follow();
				
	}

}
