package csen1002.main.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Write your info here
 * 
 * @name Samar Shokry
 * @id 43-1746
 * @labNumber 11
 */
public class FDFA {
	/**
	 * FDFA constructor
	 * 
	 * @param description is the string describing a FDFA
	 */
	int StartState=0;
	int AcceptStates[];
	String Actions[];
	int Transitions0[];
	int Transitions1[];
	String output="";
	public FDFA(String description) {
		// TODO Write Your Code Here
		String[] allStates = description.split("#");
		String[] eachState=allStates[0].split(";");
		String[] acceptStates=allStates[1].split(",");
		Actions=new String[eachState.length]; 
		AcceptStates=new int[acceptStates.length];
		Transitions0= new int[eachState.length];
		Transitions1= new int[eachState.length];
	
	for (int i = 0; i < AcceptStates.length; i++) {
		AcceptStates[i]=Integer.parseInt(acceptStates[i]);  
	}
	for (int i = 0; i < eachState.length; i++) {
		Transitions0[i]=Integer.parseInt(eachState[i].split(",")[1]);
	}
	for (int i = 0; i < eachState.length; i++) {
		Transitions1[i]=Integer.parseInt(eachState[i].split(",")[2]);
	}
	for (int i = 0; i < eachState.length; i++) {
		Actions[i]=eachState[i].split(",")[3];
	}
	}
	public void PrintArray(String[] array){
		 for (String element: array) {
	            System.out.println(element+" ;");
	        }
	}
	public void PrintArrayInt(int[] array){
		 for (int element: array) {
	            System.out.println(element+" ;");
	        } 
	}
	/**
	 * Returns a string of actions.
	 * 
	 * @param input is the string to simulate by the FDFA.
	 * @return string of actions.
	 */
	public String run(String input) {
		// TODO Write Your Code Here
		String t=input;
		boolean check = false;
		while (!check) {
			String r = TraverseString(t);
			if (r.isEmpty()) {
				check = true;
			} else {
				t = r;
			}
		}
		return output;
	}
		
	public String TraverseString(String t) {
		int currentState = 0;
		Stack stackOfStates = new Stack();
		stackOfStates.push(0);
		for (int j = 0; j < t.length(); j++) {
			if (t.charAt(j) == '0') {
				int tmp = Transitions0[currentState];
				currentState = tmp;
				stackOfStates.push(tmp);

			} else if (t.charAt(j) == '1') {
				int tmp = Transitions1[currentState];
				currentState = tmp;
				stackOfStates.push(tmp);
			}
		}
		String ActionOfLastAccept = "";
		boolean contains = false;
		int pointer=stackOfStates.size()-1;
		String TempAction=Actions[(Integer)stackOfStates.peek()];
		while (!stackOfStates.isEmpty() && !contains) {
			int x=(Integer)stackOfStates.pop();
			pointer--;
			for (int c : AcceptStates) {
				if (c==x) {
					contains = true;
					ActionOfLastAccept = Actions[c];
					break;
				}
			}
		}
		String theRest = "";
		if (contains){
			output+=t.substring(0,pointer+1)+","+ActionOfLastAccept+";";
			theRest = t.substring(pointer + 1);
		}
		else {
			output+=t+","+TempAction+";";
		}
		return theRest;
	}
	
	public static void main(String[] args) {


	}
}
