package csen1002.main.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Write your info here
 * 
 * @name Samar Shokry
 * @id 43-1746
 * @labNumber 11
 */
public class CFG {
	/**
	 * CFG constructor
	 * 
	 * @param description is the string describing a CFG
	 */
	ArrayList<String> vars;
	ArrayList<String> seenVars;
	String[] allVars;
	String[] allVarsSeen;
	public CFG(String description) {
		// TODO Write Your Code Here
		vars= new ArrayList<String>();
		seenVars= new ArrayList<String>();
		allVars=description.split(";");
		for (int i=0;i<allVars.length;i++) {
			String[] singleVar=allVars[i].split(",");
			vars.add(singleVar[0]);
		}
		seenVars.add(vars.get(0));
	}
	public void PrintArray(String[] array){
		 for (String element: array) {
	            System.out.println(element);
	        }
	}
	/**
	 * Returns a string of elimnated left recursion.
	 * 
	 * @param input is the string to simulate by the CFG.
	 * @return string of elimnated left recursion.
	 */
	public String lre() {
		// TODO Write Your Code Here
		String FinalString="";
		boolean noClean=true;
		for(int i=0;i<allVars.length ;i++) {
			// One Rule
			//check if rule has sub
			char currentVar=vars.get(i).charAt(0);
			allVars[i]=LeftRecursion(allVars[i]);
			if(i!=0) {
				seenVars.add(vars.get(i));
			}
		}
		String fin=FormulateResult(allVars);
		if(fin.charAt(fin.length()-1)==',') {
			fin.substring(0,fin.length()-1);
		}

		return fin;
	}
	public boolean hasVariables(String allVars) {
			String[] singleVar;
			if(allVars.contains(";")) {
				String[] sv=allVars.split(";");
				singleVar=sv[0].split(",");
			}
			else {
				singleVar=allVars.split(",");
			}
			char StartVar=singleVar[0].charAt(0);
			for(int j=1;j<singleVar.length;j++) {
				for(int k=0;k<seenVars.size();k++) {
					if(singleVar[j].charAt(0)==seenVars.get(k).charAt(0)|| singleVar[j].charAt(0)==StartVar) {
						return true;
			}
				}
			}
		
		return false;
	
	}
	public boolean OnlyVariable(String allVars) {
		String[] singleVar;
		if(allVars.contains(";")) {
			String[] sv=allVars.split(";");
			singleVar=sv[0].split(",");
		}
		else {
			singleVar=allVars.split(",");
		}
		char StartVar=singleVar[0].charAt(0);
		for(int j=1;j<singleVar.length;j++) {
			for(int k=0;k<seenVars.size();k++) {
				if(singleVar[j].charAt(0)==seenVars.get(k).charAt(0) && singleVar[j].charAt(0)!=StartVar) {
					return false;
		}
			}
		}
	
	return true;

}
	public String LeftRecursion(String allVars) {
		String[] singleVar;
		String remain="";
		if(allVars.contains(";")) {
			String[] sv=allVars.split(";");
			singleVar=sv[0].split(",");
			remain=sv[1];
		}
		else {
			singleVar=allVars.split(",");
		}
		char currentVar=singleVar[0].charAt(0);
		String temp="";
		boolean dontTouch=false;
		for(int j=1;j<singleVar.length;j++) {
			// Left Recursion Substitution
			boolean self=false;
			boolean rec=false;
			for(int k=0;k<seenVars.size();k++) {
				if(singleVar[j].charAt(0)==seenVars.get(k).charAt(0) && singleVar[j].charAt(0)!=currentVar) {
					rec=true;
					dontTouch=true;
					temp+=SubstituteVar(singleVar[j])+",";
				}
			}
			String tro=currentVar+",";
			if(temp.length()!=0 && !temp.substring(0,2).equals(tro)) {
				temp=tro+temp;
			}

		//Self Recursion
			else{
				if(singleVar[j].charAt(0)==currentVar && !dontTouch && OnlyVariable(allVars)) {
				temp=SelfRecursion(allVars);
				dontTouch=true;
				self=true;
				break;
			}
			
			else {
				if(!rec && !self) {
				if(temp.length()==0) {
					temp+=currentVar+","+singleVar[j]+",";
				}
				else {
					if(j==singleVar.length-1) {
						if(remain.length()>0) {
							temp+=singleVar[j]+";"+remain+",";
						}
						else {
							temp+=singleVar[j]+",";
						}
					}
					else {
					temp+=singleVar[j]+",";
					}
				}
			}
			}
			}
			
			if(remain.length()>0 && temp.length()==0) {
				temp=temp.substring(0,temp.length()-1)+";"+remain+",";
			}
		}
		String r=temp.substring(0,temp.length()-1);
		if(hasVariables(r)&& currentVar!= seenVars.get(0).charAt(0)) {
			return LeftRecursion(r);
		}
		else {
			return r;
		}

		}
	public String FormulateResult(String[] allVars) {
		String fin="";
		for (String str : allVars) {
			fin+=str+";";
		}
		fin=fin.substring(0,fin.length()-1);
		if(fin.charAt(fin.length()-1)==',') {
			fin.substring(0,fin.length()-1);
		}
		return fin;
	}
	public String SelfRecursion(String rule) {
		String[] singleVar=rule.split(",");
		char currentVar=singleVar[0].charAt(0);
		ArrayList<String> alpha=new ArrayList<String>();
		ArrayList<String> beta=new ArrayList<String>();
		for(int k=1;k<singleVar.length;k++) {
			if(singleVar[k].charAt(0)==currentVar) {
				alpha.add(singleVar[k].substring(1,singleVar[k].length()));
			}
			else {
				beta.add(singleVar[k]);
			}
		}
		String newRule="";
		String newRuleSub="";
		for(int j=0;j<beta.size();j++) {
			newRule+=beta.get(j)+currentVar+"'"+",";
		}
		for(int j=0;j<alpha.size();j++) {
			newRuleSub+=alpha.get(j)+currentVar+"'"+",";
		}
		newRuleSub+="e";
		String finalRule=currentVar+","+newRule.substring(0,newRule.length()-1);
		String finalRuleSub=currentVar+"'"+","+newRuleSub;
		return finalRule+";"+finalRuleSub+",";
	}
	public String SubstituteVar(String rule) {
		String var1=allVars[seenVars.indexOf(String.valueOf(rule.charAt(0)))];
		String[] var0=var1.split(";");
		if(var0.length>0) {
			var1=var0[0];
		}
		String[] var2=var1.split(",");
		String  newRule="";
		for (int i=1;i<var2.length;i++) {
			newRule+=","+var2[i]+rule.substring(1, rule.length());
		}
		return newRule.substring(1);
	}
	public static void main(String[] args) {
//		CFG cfg = new CFG("S,ScT,Sa,T,b;T,aSb,iaLb,i;L,SdL,S");
		CFG cfg = new CFG("S,TYU,u;T,Tyu,Yu,Uu,uU;Y,Yy,Tu,tu,ut;U,Tu,Yu,uTu,yuT");
//		CFG cfg = new CFG("S,AmS',MaS';M,AsA,a,AmS',MaS',AmS'a,MaS'a;A,sSaA,AsAma,ama,AmS'ma,MaS'ma,AmS'ama,MaS'ama,AsAs,as,AmS's,MaS's,AmS'as,MaS'as");
		
		cfg.lre();
	}
}
