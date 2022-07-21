package csen1002.main.task1;



/**
 * Write your info here
 * 
 * Samar Ahmed Shokry
 * 43-1746
 * 011
 */
public class DFA {
	/**
	 * DFA constructor
	 
	 * 
	 * @param description is the string describing a DFA
	 */
	int StartState=0;
	int AllStates[];
	int AcceptStates[];
	int Alphabet[];
	int Transitions0[];
	int Transitions1[];
	public DFA(String description) {
		System.out.println(description);
		String[] allStates = description.split("#");
		String[] eachState=allStates[0].split(";");
		String[] acceptStates=allStates[1].split(",");
		
		Alphabet=new int[]{0,1}; 
		AllStates=new int[eachState.length];
		AcceptStates=new int[acceptStates.length];
		Transitions0= new int[eachState.length];
		Transitions1= new int[eachState.length];
		for (int i = 0; i < AllStates.length; i++) {
			AllStates[i]=i;	
		}
		for (int i = 0; i < AcceptStates.length; i++) {
			AcceptStates[i]=Integer.parseInt(acceptStates[i]);  
		}
		for (int i = 0; i < eachState.length; i++) {
			Transitions0[i]=Integer.parseInt(eachState[i].split(",")[1]);
		}
		for (int i = 0; i < eachState.length; i++) {
			Transitions1[i]=Integer.parseInt(eachState[i].split(",")[2]);
		}
		
		PrintArrayInt(AcceptStates);
		System.out.println();
		PrintArrayInt(Transitions0);
		System.out.println();
		PrintArrayInt(Transitions1);
		
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
	 * Returns true if the string is accepted by the DFA and false otherwise.
	 * 
	 * @param input is the string to check by the DFA.
	 * @return if the string is accepted or not.
	 */
	public boolean run(String input) {
		System.out.println(input);	
		int currentState=0;
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i)=='0'){
				int temp=Transitions0[currentState];
				currentState=temp;
			}
			if(input.charAt(i)=='1'){
				int temp=Transitions1[currentState];
				currentState=temp;
			}
			
		}
		boolean contains = false;
		for (int s : AcceptStates) {
		    if (s == currentState) {
		        contains = true;
		        break;
		    }
		}
		return contains;
	}
	public static void main(String[] args) {
		System.out.println("Hello world!!!");
		DFA dfa1 = new DFA("0,3,1;1,2,1;2,2,1;3,3,3#2");
	
		System.out.println(	dfa1.run("010010"));

	}

	
}
