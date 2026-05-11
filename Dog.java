/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tamagotchi_UTS;

/**
 *
 * @author USER
 */
public class Dog extends Pet {
    public Dog(String name){ 
        super(name);
    } 
    @Override 
    public void makeSound() { System.out.println(getName() + " berkata: Guk guk!"); 
    } 
    @Override 
    public void play() {
        super.play();
        System.out.println(getName() + " berlari mengejar bola dengan semangat.");
    }
}
