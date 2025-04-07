abstract class Animal {
  public abstract void animalSound();
  public void sleep() {
    System.out.println("Aaaa");
  }
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println(" Pig is a animal");
  }
}

class Program1 {
  public static void main(String[] args) {
    Pig myPig = new Pig();
    myPig.animalSound();
    myPig.sleep();
  }
}