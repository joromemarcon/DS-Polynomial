package src;

public class Term {
    /*
        Term x = new Term(); //creates an instance of Term called x
        x contains coefficient and exponent


     */

    protected int coefficient;
    protected int exponent;

    public Term(){
        this.coefficient = 0;
        this.exponent = 0;
    }

    public Term(int coefficient, int exponent){
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    //constructor with Term as parameter
    public Term(Term other){
        this.exponent = other.exponent;
        this.coefficient = other.coefficient;;

    }

    //constructor with string parameter
    public Term(String term){
        String[] p1arr = term.split("[x^]+");

        this.coefficient = Integer.parseInt(p1arr[0]);
        this.exponent = Integer.parseInt(p1arr[1]);
    }

    public void setCoefficient(int value){
        coefficient = value;
    }
    public void setExponent(int value){
        exponent = value;
    }

    public int getCoefficient(){
        return coefficient;
    }
    public int getExponent(){
        return exponent;
    }


    public int compareTo(Object other){
    }

    //toString converts linkedList into string
    public String toString(){

    }

    public Term plus(Term other){

    }
    public Term sumOf(Term termA, Term term8){

    }
}
