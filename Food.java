/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tamagotchi_UTS;

/**
 *
 * @author USER
 */
public class Food {
    private final String foodName; 
    private final int nutrition; 

    public Food(String foodName, int nutrition) {
        this.foodName = foodName; 
        this.nutrition = nutrition; 
    }
    public int getNutrition() { return nutrition; }
    public String getFoodName() { return foodName; }
}
