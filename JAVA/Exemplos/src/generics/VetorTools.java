package generics;


public class VetorTools<T> {

    private T[] vetor;

    public VetorTools(T[] vetor) {
        this.vetor = vetor;
    }

    public T getFirstItem() {
        return this.vetor[0];
    }

    public void imprimir(){
        for(T e: this.vetor) {
            System.out.println(e);
        }
    }
    
    
}