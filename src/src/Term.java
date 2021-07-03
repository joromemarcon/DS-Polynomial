package src;

public class Term implements Comparable<Term>{
    /*
        Term x = new Term(); //creates an instance of Term called x
        x contains coefficient and exponent


     */

    protected int coefficient;
    protected int exponent;

    public Term(){
        this.coefficient = 1;
        this.exponent = 1;
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
    //+x^-2
    //constructor with string parameter
    public Term(String term){
        String[] p1arr = term.split("[x^]+");
        if(term == "") {
            this.coefficient = 0;
            this.exponent = 0;
        }
        if(term.contains("+x") || term.contains("-x")){
            if(term.contains("+") && !term.contains("^")) {
                this.coefficient = 1;
                this.exponent = 1;
            }
            else if(term.contains("-") && !term.contains("^")) {
                this.coefficient = -1;
                this.exponent = 1;
            }
            else if(p1arr[0].contains("-") && term.contains("^")){
                this.coefficient = -1;
                this.exponent = Integer.parseInt(p1arr[1]);
            }
            else if(p1arr[0].contains("+") && term.contains("^")){
                this.coefficient = 1;
                this.exponent = Integer.parseInt(p1arr[1]);
            }

        }
        else if(term.contains("x^")){
            this.exponent = Integer.parseInt(p1arr[1]);
            this.coefficient = Integer.parseInt(p1arr[0]);
        }
        else if(term.contains("x") && !term.contains("^")){
            this.exponent = 1;
            this.coefficient = Integer.parseInt(p1arr[0]);
        }
        else {
            this.exponent = 0;
            this.coefficient = Integer.parseInt(term);
        }
    }

    public void setCoefficient(int value){
        this.coefficient = value;
    }
    public void setExponent(int value){
        this.exponent = value;
    }

    public int getCoefficient(){
        return coefficient;
    }
    public int getExponent(){
        return exponent;
    }

    //toString converts linkedList into string
    public String toString() {
        String term = "";
        if (this.coefficient == 0) return term;
        if (this.exponent == 0) {
            if (this.coefficient > 0) return term = "+" + this.coefficient;
            else return term = term + this.coefficient;
        } else if (this.exponent == 1) {
            if (this.coefficient == 1) return term = "+x";
            else if (this.coefficient == -1) return term = "-x";
            else if (this.coefficient > 1) return term = "+" + this.coefficient + "x";
            else if (this.coefficient < -1) return term = this.coefficient + "x";
        } else if (this.exponent > 1 || this.exponent < 0) {
            if (this.coefficient == 1) return term = "+x^" + this.exponent;
            else if (this.coefficient == -1) return term = "-x^" + this.exponent;
            else if (this.coefficient > 1) return term = "+" + this.coefficient + "x^" + this.exponent;
            else if (this.coefficient < -1) return term = this.coefficient + "x^" + this.exponent;
        }

        return term;
    }

//    public Term plus(Term other){
//
//    }
    public Term sumOf(Term termA, Term term8){
        Term sum = new Term();
        sum.coefficient = termA.coefficient + term8.coefficient;
        sum.exponent = termA.exponent;
        return sum;
    }

    public void setAll(int c, int e) {
        this.coefficient = c;
        this.exponent = e;
    }

    @Override
    public boolean equals(Object object) {
        Term t = (Term) object;

        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        return (this.coefficient == t.coefficient) && (this.exponent == t.exponent);
    }

    //clone term
    @Override
    public Object clone(){
        return new Term(this.coefficient, this.exponent);
    }

    @Override
    public int compareTo(Term o) {
        if(this.exponent > o.exponent) return 1;
        else if(this.exponent < o.exponent) return -1;
        //compare exponent then coefficient
        else {
            if(this.coefficient == o.coefficient) return 0;
            else if(this.coefficient < o.coefficient) return -1;
            else return 1;
        }

    }
}
