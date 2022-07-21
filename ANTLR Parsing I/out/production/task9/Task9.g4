/**
 * Write your info here
 *
 * @name John Smith
 * @id 43-0234
 * @labNumber 07
 */

grammar Task9;


@members {
	/**
	 * Compares two integer numbers
	 *
	 * @param x the first number to compare
	 * @param y the second number to compare
	 * @return 1 if x is equal to y, and 0 otherwise
	 */
	public static int equals(int x, int y) {
	    return x == y ? 1 : 0;
	}
}

s returns [int check]:
 // Write the definition of parser rule "s" here
a c b  {$check=equals($a.len,$b.len)*equals($a.len,$c.len);};

a returns [int len]: 'a' a1=a {$len=$a1.len+1;} | {$len=0;};

b returns [int len]: 'b' b1=b {$len=$b1.len+1;} | {$len=0;};

c returns [int len]: 'c' c1=c {$len=$c1.len+1;} | {$len=0;};

// Write additional lexer and parser rules here

//A : 'a';
//B: 'b';
//C: 'c';