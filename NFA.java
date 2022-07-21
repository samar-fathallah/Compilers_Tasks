package csen1002.main.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Write your info here
 * 
 * @name Samar Shokry
 * @id 43-1746
 * @labNumber 11
 */
public class NFA{
	/**
	 * NFA constructor
	 * 
	 * @param description is the string describing a NFA
	 */
	public ArrayList<String> states; 
	public ArrayList<String> OneTransitions;
	public ArrayList<String> ZeroTransitions;
	public ArrayList<String> newAcceptStates;
	public String[] epsilonTransitions;

	public NFA(String description) {
		// TODO Write Your Code Here
		int NumberofStates= NumberofStates(description);
		epsilonTransitions=new String[NumberofStates];
		String[] InputSplit=description.split("#");
		String epsilonTrans=InputSplit[2];
		String oneTrans=InputSplit[1];
		String zeroTrans=InputSplit[0];
		String acceptStates1=InputSplit[3];
		String[] split1=epsilonTrans.split(";");
		for (int i=0;i<NumberofStates;i++) {
			String temp=i+",";
			for(int j=0;j<split1.length;j++) {
				String[] eps=split1[j].split(",");
				if(Integer.parseInt(eps[0])==i) {
					temp+=eps[1]+",";
				}
			}
			epsilonTransitions[i]=temp.substring(0,temp.length()-1);
		}
	//GET EPSILON TRANSITIONS
		for(int i=0;i<epsilonTransitions.length;i++) {
			String[] epsilon=epsilonTransitions[i].split(",");
			for(int j=0;j<epsilon.length;j++) {
				int current=Integer.parseInt(epsilon[j]);
				String currentEpsilons=epsilonTransitions[current];
				String[] epsilonSplit=currentEpsilons.split(",");
				for(int k=0;k<epsilonSplit.length;k++) {
					if(!(ContainValue(epsilon,epsilonSplit[k]))) {
						epsilonTransitions[i]+=","+epsilonSplit[k];
					}	
				}
				epsilon=epsilonTransitions[i].split(",");
			}
		}
//		PrintArray(epsilonTransitions);
		//GETT ONE AND ZERO TRANSITIONS
		boolean check1 = false;
		boolean check2 = false;
		states = new ArrayList<String>();
		OneTransitions=new ArrayList<String>();
		ZeroTransitions=new ArrayList<String>();
		String tempState = epsilonTransitions[0];
		states.add(tempState);
		while (!check1 && !check2) {
			for (int i = 0; i < states.size(); i++) {
						String zero = AllTrans(states.get(i), zeroTrans,epsilonTransitions);
						ZeroTransitions.add(zero);
				if (!IsPresent(states,zero) ) {
					check1 = false;
					states.add(zero);
				} else {
					check1 = true;
				}
				String one = AllTrans(states.get(i), oneTrans, epsilonTransitions);
			    OneTransitions.add(one);
				if (!IsPresent(states,one)) {
					check2 = false;
					states.add(one);
				} else {
					check2 = true;
				}	
			}
		}
//		PrintArrayList(OneTransitions);
//		System.out.println();
//		PrintArrayList(ZeroTransitions);
	   // GET ACCEPT STATES
		newAcceptStates = new ArrayList<String>();
		String[] AcceptSplit=acceptStates1.split(",");
		for (int i = 0; i < AcceptSplit.length; i++) {
			for (int j = 0; j < states.size(); j++) {
				if (states.get(j).contains("" + AcceptSplit[i])) {
					newAcceptStates.add(states.get(j));
				}
			}
		}
//		PrintArrayList(newAcceptStates);
		// CONSTRUCT DFA
		String dfa = "";
		for (int q = 0; q < states.size(); q++) {
			//if(!states.get(q).contains("d")){
				
			if (q == states.size() - 1) {
				dfa += "" + states.get(q) + "|" + ZeroTransitions.get(q) + "|"
						+ OneTransitions.get(q) + "#";

			} else
				dfa += "" + states.get(q) + "|" + ZeroTransitions.get(q) + "|"
						+OneTransitions.get(q) + ";";
			//}
			}
		for (int u = 0; u < newAcceptStates.size(); u++) {
			if (u == newAcceptStates.size() - 1) {
				dfa += "" + newAcceptStates.get(u);

			} else
				dfa += "" + newAcceptStates.get(u) + "|";
		}
//		System.out.println(dfa);
		
	}
	public static void PrintArrayList( ArrayList<String> arr) {
		  for (String str : arr)
	      { 		      
	           System.out.println(str); 		
	      }
	}
	public static String AllTrans(String state, String Trans,
			String epsilon[]) {
		String temp="";
		String[] states=state.split(",");
		String[] zeros=Trans.split(";");
		for (int i=0;i<states.length;i++) {
			for(int j=0;j<zeros.length;j++) {
				String[] eps=zeros[j].split(",");
				if(states[i]!="d") {
				if(Integer.parseInt(eps[0])==Integer.parseInt(states[i])) {
					temp+=eps[1]+",";
				}
				}
			}
		}
		if(temp.length()==0) {
			return "d";
		}
		String finalState="";
			String[] temp2=temp.substring(0, temp.length()-1).split(",");
			for(int j=0;j<temp2.length;j++) {
				int current=Integer.parseInt(temp2[j]);
				String currentEpsilons=epsilon[current];
				finalState+=currentEpsilons+",";
			}
		String[] split3=finalState.split(",");	
		String[] array = new HashSet<String>(Arrays.asList(split3)).toArray(new String[0]);	
		String St=ConvertArray(array);
//		if(St.length()==0) {
//			return "d";
//		}
		return St.substring(0,St.length()-1);
	}
	public static boolean ContainValue(String[] arr ,String x) {
		List valid = Arrays.asList(arr);
				if (valid.contains(x)) {
				    return true;
				} else {
				    return false;
				}
	}
	public static boolean IsIdentical(String x, String y) {
		String tempArrayX[] = x.split(",");
		Arrays.sort(tempArrayX);
		String tempArrayY[] = y.split(",");
		Arrays.sort(tempArrayY);
		return Arrays.equals(tempArrayX,tempArrayY);
	}
	public static boolean IsPresent( ArrayList<String> arr ,String x) {
		boolean temp=false;
		for (int i=0;i<arr.size();i++) {
			if(IsIdentical(arr.get(i),x)) {
				temp=true;
				break;
			}
		}
		return temp;
	}
	public static String ConvertArray(String arr[]) {
		String temp="";
		for (String string : arr) {
			temp+=string+",";
		}
		return temp;
	}
	public static void PrintArray(String[] array){
		 for (String element: array) {
	            System.out.println(element);
	        }
	}
	public static int NumberofStates(String input) {
		String[] split1=input.split("#");
		String[] split2=ConvertArray(split1).split(";");
		String[] split3=ConvertArray(split2).split(",");
		String[] array = new HashSet<String>(Arrays.asList(split3)).toArray(new String[0]);
		return array.length;
	} 
	
	/**
	 * Returns true if the string is accepted by the NFA and false otherwise.
	 * 
	 * @param input is the string to check by the NFA.
	 * @return if the string is accepted or not.
	 */
	public boolean run(String input) {
		//test string
		
				int currentState = 0;
				String state=epsilonTransitions[0];
				
				for (int i = 0 ; i < input.length() ; i++){
					if(input.charAt(i) == '0'){
					  String tmp = ZeroTransitions.get(states.indexOf(state));
					  state=tmp;
					  currentState = states.indexOf(tmp);
					}
					else if (input.charAt(i) == '1'){

						  String tmp = OneTransitions.get(states.indexOf(state));
						  state=tmp;
						  currentState = states.indexOf(tmp);
						  }
				
				}
				boolean contains = false;
				for (String c : newAcceptStates) {
				    if (c.equals(state)) {
				        contains = true;
				        break;
				    }
				}		
		return contains;
	}
	public static void main(String[] args) {
		NumberofStates("1,2;4,5;8,9#3,4;6,7#0,1;0,3;2,1;2,3;5,6;5,8;7,10;9,10#10");
		NFA nfa1 = new NFA("2,3#4,5;7,8#0,1;0,7;1,2;1,4;3,6;5,6;6,1;6,7#8");
		nfa1.run("1001");

	}
}
