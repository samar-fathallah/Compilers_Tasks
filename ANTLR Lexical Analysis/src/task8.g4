grammar task8;

//Parser Rule start to parse the input and check whether it is accepted or rejected
start: (Q2 | Q3 | Q4) + EOF ;

fragment Q0: Q4 ZERO ZERO Q0E | Q0E;

fragment Q0E: |ONE Q0E | ZERO ONE Q0E | ZERO ZERO ZERO ZERO Q0E;

fragment Q1: Q4 ZERO ZERO Q0E ZERO | Q0E ZERO ;

Q2: Q4 ZERO ZERO Q0E ZERO ZERO | Q0E ZERO ZERO ;

Q3: Q4 ZERO ZERO Q0E ZERO ZERO ZERO | Q0E ZERO ZERO ZERO | Q4 ZERO;

Q4: Q0E ZERO ZERO ONE Q4E | Q0E ZERO ZERO ZERO ONE Q4E;

fragment Q4E: | ZERO ZERO Q0E ZERO ZERO ONE Q4E | ZERO ZERO Q0E ZERO ZERO ZERO ONE Q4E | ZERO ONE Q4E | ONE Q4E;
//Fragments representing the zeros and ones
fragment ZERO: '0' ;

fragment ONE: '1' ;

