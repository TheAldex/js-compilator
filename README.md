# JS-COMPILATOR
A mini Language Processor for pseudo JavaScript language developed in Java because of OOP facilities.

### DESCRIPTION
This Processor supports a pseudo language based on Javascript with some modifications. To make the process easier, below are the valid language tokens, as well as the free context grammar for the recursive descending parser (there is a certain function for each grammar rule) and a brief demonstration of the logic followed in the semantic parser implementation. There is an error controller too (see the code for more information).

### TOKENS
<id, posTS>

<cadena, lexema>

<suma, ->

<resta, ->

<igual, ->

<asigDiv, ->

<and, ->

<menor, ->

<mayor, ->

<pAbierto, ->

<pCerrado ->

<kAbierta, ->

<kCerrada, ->

<coma, ->

<puntoComa, ->

<cadena, ->

<int, ->

<boolean, ->

<let, ->

<print, ->

<input, ->

<return, ->

<function, ->

<NumEnt, valor>

<If, ->

<else, ->

### DETERMINISTIC FINITE AUTOMATON'S GRAMMAR
S →  l A | d B| - C | / D | = | < | >| “ E | & G | + | ( | ) | { | } | , |  ; | del S 

A → l A | d A | _ A | λ

B → d B | λ

C → = | λ

D → = | * F

E → c E | “

F → c’ F | eol S

G → &

### PARSER FREE CONTEXT GRAMMAR
Terminals = { let id ; if int string boolean ( ) { } else print input return - = /= , function && < > + entero cadena }

Non-Terminals = { P B T G C O S W Z M X L Q F H A K E E_ R R_ U U_ V D }

Axiom = P

Productions = {

    P -> B P | F P | lambda

    B -> let T id ; | if ( E ) G | S

    T -> int | string | boolean

    G -> S | { C } O | B C | lambda

    O -> else { C } | lambda

    S -> id W | print ( E ) ; | input ( id ) ; | return X ; 

    W -> /= E ; | = E ; |  ( L ) ;

    X -> E | lambda

    L -> E Q | lambda

    Q -> , E Q | lambda

    F -> function id H ( A ) { C }

    H -> T | lambda

    A -> T id K | lambda

    K -> , T id K | lambda

    E -> R E_

    E_ -> && R E_ | lambda

    R -> U R_

    R_ -> < U R_ | > U R_ | lambda

    U -> V U_

    U_ -> + V U_ | - V U_ | lambda

    V -> id D | ( E ) | entero | cadena

    D -> ( L ) | lambda
    
}

### SEMANTIC RULES
It has been decided to implement a translation design directed by the syntax (implemented in the code).

