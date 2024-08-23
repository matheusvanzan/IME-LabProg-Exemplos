interface Animal {
    public void animalSound(); // método da interface (não tem corpo)
    public void sleep(); // método da interface (não tem corpo)
}

class Pig implements Animal { // implementa" a interface Animal

    public void animalSound() { // O corpo de animalSound() é fornecido aqui        
        System.out.println("O porco diz: wee wee");
    }
    public void sleep() { // O corpo de sleep() é fornecido aqui
        System.out.println("Zzz");
    }
}

class ExemploInterface {
    public static void main(String[] args) {

        Pig myPig = new Pig(); // Cria um objeto Pig
        myPig.animalSound();
        myPig.sleep();
    }
}
