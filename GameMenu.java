/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tamagotchi_UTS;

import java.util.Scanner;

/**
 *
 * @author USER
 */


public class GameMenu {
    private final Scanner scanner = new Scanner(System.in); 
    private PetOwner owner; 

    public void startGame() {
        System.out.println("=== GAME PET/TAMAGOTCHI (JAVA OOP) ==="); 
        System.out.print("Masukkan nama owner: "); 
        String ownerName = scanner.nextLine().trim(); 

        Pet pet = createPet(); 
        owner = new PetOwner(ownerName, pet); 

        System.out.println("\nSelamat datang, " + ownerName);
        System.out.println("Kamu merawat " + pet.getName() + ". Jaga agar tetap sehat!"); 

        while (owner.getPet().isAlive()) { 
            showMenu(); 
            int choice = readInt("Pilih aksi: "); 

            if (choice == 0) { 
                System.out.println("Game selesai. Sampai jumpa!"); 
                break;
            }

            handleChoice(choice); 
            
            // Waktu berlalu kecuali saat liat status atau suara
            if (choice != 4 && choice != 6) { 
                owner.getPet().passTime(); 
            }
            
            owner.getPet().showStatus(); 
        }

        if (!owner.getPet().isAlive()) { 
            System.out.println("Pet kamu sakit parah/mati. Game over."); 
        }
    }

    public void showMenu() { 
        System.out.println("Menu:"); 
        System.out.println("1. Feed pet (makanan biasa)"); 
        System.out.println("2. Play with pet"); 
        System.out.println("3. Put pet to sleep");
        System.out.println("4. Make sound"); 
        System.out.println("5. Feed pet (pilih makanan)"); 
        System.out.println("6. Lihat status"); 
        System.out.println("0. Exit"); 
    }

    private Pet createPet() { 
        System.out.println("Pilih jenis pet:"); 
        System.out.println("1. Cat"); 
        System.out.println("2. Dog"); 
        System.out.println("3. Bird"); 
        
        int petChoice = readInt("Pilihan: "); 
        System.out.print("Masukkan nama pet: "); 
        String petName = scanner.nextLine().trim(); 

        if (petChoice == 1) return new Cat(petName); 
        if (petChoice == 2) return new Dog(petName); 
        return new Bird(petName); 
    }

    private void handleChoice(int choice) { 
        switch (choice) { 
            case 1 -> owner.feedPet(); 
            case 2 -> owner.playWithPet(); 
            case 3 -> owner.putPetToSleep();
            case 4 -> owner.getPet().makeSound(); 
            case 5 -> owner.feedPet(chooseFood()); 
            case 6 -> {} // Hanya showStatus di loop utama
            default -> System.out.println("Pilihan tidak valid."); 
        }
    }

    private Food chooseFood() { 
        System.out.println("Pilih makanan:"); 
        System.out.println("1. Ikan (nutrition 25)"); 
        System.out.println("2. Daging (nutrition 30)"); 
        System.out.println("3. Biji-bijian (nutrition 18)"); 
        int foodChoice = readInt("Pilihan makanan: "); 
        
        if (foodChoice == 1) return new Food("Ikan", 25); 
        if (foodChoice == 2) return new Food("Daging", 30); 
        return new Food("Biji-bijian", 18); 
    }

    private int readInt(String prompt) { 
        while (true) {
            System.out.print(prompt); 
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Input harus berupa angka."); 
            }
        }
    }

    public static void main(String[] args) { 
        new GameMenu().startGame(); 
    }
}
