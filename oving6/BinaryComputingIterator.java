package oving6;
 
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BinaryOperator;
 
public class BinaryComputingIterator implements Iterator<Double> {
 
    Iterator<Double> it1, it2;
    Double def1, def2;
    BinaryOperator<Double> operator;
   
    BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> op){
        this.it1 = iterator1;
        this.it2 = iterator2;
        this.operator = op;
        this.def1 = (double) 0;
        this.def2 = (double) 0;
    }
    BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2,Double def1, Double def2, BinaryOperator<Double> op){
        this.it1 = iterator1;
        this.it2 = iterator2;
        this.operator = op;
        this.def1 = def1;
        this.def2 = def2;
       
    }
   
    public Double apply(Double u,Double t){
        return operator.apply(u,t);
    }
   
    @Override
    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }
 
    @Override
    public Double next() {
        if(!it1.hasNext() && it2.hasNext()){
            return apply(def1,it2.next());
        }
        else if(!it2.hasNext() && it1.hasNext()){
            return apply(it1.next(),def2);
        }
        else if(!hasNext()){
            throw new NoSuchElementException("oi m8 aint got no elements no more");
        }
        return apply(it1.next(),it2.next());
    }
   
    public static void main(String[] args) {
        Iterator<Double> iterator1 = Arrays.asList(2.0, 3.0).iterator();
        Iterator<Double> iterator2 = Arrays.asList(5.0).iterator();
        BinaryComputingIterator a = new BinaryComputingIterator(iterator1, iterator2, null, 10.0, (x, y) -> x+y);
        System.out.println(a.hasNext());
        System.out.println(a.next());
        System.out.println(a.hasNext());
        System.out.println(a.next());
        System.out.println(a.hasNext());
    }
 
}