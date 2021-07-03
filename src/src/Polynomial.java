package src;

import java.util.LinkedList;
import java.util.Queue;

public class Polynomial {

    protected LinkedList<Term> eq = new LinkedList<Term>();

    public Polynomial(Polynomial polynomial){
        for (Term term : polynomial.eq) {
            this.eq.add(new Term(term.getCoefficient(), term.getExponent()));
        }
    }

    public Polynomial() {
        eq.addFirst(new Term());
    }

    public void add(Polynomial polynomial){
        for (Term term : polynomial.eq) {

            addTerm(term);
        }
    }
    public void addTerm(Term polynomial){
        int i = 0;
        boolean add = false;

        if(eq.size() == 0){
            this.eq.add(polynomial);
        }
        while(add != true && i < eq.size()) {
            if (this.eq.get(i).exponent == polynomial.getExponent()) {
                Term addedTerm = new Term();
                addedTerm.setCoefficient(this.eq.get(i).coefficient + polynomial.getCoefficient());
                addedTerm.setExponent(polynomial.getExponent());
                this.eq.set(i,addedTerm);
                add = true;
            }
            else if(this.eq.get(i).exponent < polynomial.getExponent()){
                if(this.eq.get(i) == this.eq.getFirst()){
                    this.eq.addFirst(polynomial);
                }
                else{
                    this.eq.add(i,polynomial);

                }
                add = true;
            }
            i++;
        }
    }
    public Term remove(int index){
        Term temp = this.eq.get(index);
        this.eq.remove(index);
        return temp;
    }
    public Term getTerm(int index){
        return this.eq.get(index);
    }
    public int getNumTerms(){
        return this.eq.size();
    }
    public String toString(){
        return new String();
    }

    public void clear() {
        this.eq.clear();
    }
}
