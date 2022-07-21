package csen1002.main.task7;

import java.util.Hashtable;
import java.util.Stack;

/**
 * Write your info here
 * 
 * @name Samar Shokry
 * @id 43-1746
 * @labNumber 11
 */
public class LL1CFG {
	/**
	 * LL1 CFG constructor
	 * 
	 * @param description is the string describing an LL(1) CFG, first, and follow as represented in the task description.
	 */
	public String[] variableRules;
	public Hashtable<String, String> firsts;
	public Hashtable<Character, String> follows;
	public Hashtable<String,String> parsingTable;
	
	public LL1CFG(String description) {
		variableRules=description.split("#")[0].split(";");
		
		String[] allFirsts=description.split("#")[1].split(";");
		String[] allFollows=description.split("#")[2].split(";");
		
		firsts= new Hashtable<String, String>();
		follows= new Hashtable<Character, String>();
		parsingTable=new Hashtable<String, String>();
		
		for(int i=0;i<variableRules.length;i++) {
			String[] split1=variableRules[i].split(",");
			String[] split2= allFirsts[i].split(",");
			for(int j=1;j<split1.length;j++) {
				firsts.put(split1[j], split2[j]);	
			}	
		}
		for(int i=0;i<allFollows.length;i++) {
			char variable=allFollows[i].split(",")[0].charAt(0);
			follows.put(variable,allFollows[i].split(",")[1]);
		}
//	System.out.println(firsts);
//	System.out.println(follows);
	//PARSING TABLE
	for(int i=0;i<variableRules.length;i++) {
		String[] split1=variableRules[i].split(",");
		for(int j=1;j<split1.length;j++) {
			String f=firsts.get(split1[j]);
			for(int k=0;k<f.length();k++) {
				char f1=f.charAt(k);
				if(f1=='e') {
					String temp=follows.get(split1[0].charAt(0));
					for(int z=0;z<temp.length();z++) {
						String ke=split1[0]+temp.charAt(z);
						parsingTable.put(ke,split1[j]);
					}

				}
				else {
					String ke=split1[0]+f1;
					parsingTable.put(ke,split1[j]);	
				}
			}
		
		}	
	}
//	System.out.println(parsingTable);

	
	
	}
	/**
	 * Returns A string encoding a derivation is a comma-separated sequence of sentential forms each representing a step in the derivation..
	 * 
	 * @param input is the string to be parsed by the LL(1) CFG.
	 * @return returns a string encoding a left-most derivation.
	 */
	public static String GenerateDerivation(String output,Character current,String value2Parse) {
		String[] outputSplit=output.split(",");
		String lastDerivation=outputSplit[outputSplit.length-1];
		String result="";
		boolean unChanged=true;
		for(int i=0;i<lastDerivation.length();i++) {
			if(lastDerivation.charAt(i)==current && unChanged) {
				if(value2Parse.equals("e")) {
					result+="";
				}
				else {
				result+=value2Parse;
				}
				unChanged=false;
			}
			else {
				result+=lastDerivation.charAt(i);
			}
		}
		return result;
	}
	public String parse(String input) {
		input=input+"$";
		Stack<Character> stack = new Stack<Character>();
		stack.push('$');
		stack.push('S');
		String output="S,";
		boolean der=true;
		int i=0;
		while(!stack.isEmpty()&& der) {
			char current=stack.peek();
			if(Character.isUpperCase(current)) {
				String lookup=current+Character.toString(input.charAt(i));
				String value2Parse=parsingTable.get(lookup);
				if(value2Parse!=null) {
					if(value2Parse.equals("e")) {
						// just remove the character from stack & do nothing
						stack.pop();
						output+=GenerateDerivation(output,current,value2Parse)+",";
						
					}
					else {
						//push the rule backwards & generate corresponding derivation
						stack.pop();
						for(int j=value2Parse.length()-1;j>=0;j--) {
							stack.push(value2Parse.charAt(j));
						}
						output+=GenerateDerivation(output,current,value2Parse)+",";
					}
							
				}
				else {
					der=false;
					break;
				}
			}
			else {
				if(input.charAt(i)==current) {
					stack.pop();
					i++;
				}
				else {
					der=false;
					break;
				}
			}
			
		}
		if(!der) {
			output+="ERROR";
			return output;
		}
		return output.substring(0,output.length()-1);
	}
	public static void main(String[] args) {
		LL1CFG ll1cfg1 = new LL1CFG("S,iST,e;T,cS,a#S,i,e;T,c,a#S,ca$;T,ca$");
		 ll1cfg1.parse("iia");
		
	
				
	}

}
