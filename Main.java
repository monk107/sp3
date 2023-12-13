
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opcion = 0;
        int opcionSwitch1 = 0;
        int opcionSwitch2 = 0;
        Scanner entrada = new Scanner(System.in);

        //Creacion de objetos de la clase Personaje.
        Personaje heroe = new Personaje("Heroe",15,100);
        Personaje enemigo = new Personaje("Orco", 10,50);
        Personaje enemigo2 = new Personaje("Mago Negro", 30,35);
        Personaje enemigo3 = new Personaje("Rata", 2,15);

        //Creacion de objetos de la clase Pociones.
        Pociones pocion = new Pociones();

        System.out.println("Te encuentras en el camino a 3 enemigos");

        do {
            //Reseteamos opciones
            opcion = 0;
            opcionSwitch1 = 0;
            opcionSwitch2 = 0;

            System.out.print("Que deseas hacer?\n" +
                    "1. Atacar.\n" +
                    "2. Usar habilidad.\n" +
                    "3. Usar pocio de vida\n" +
                    "4. Huir.");
            opcion = entrada.nextInt();
            entrada.nextLine();


            switch (opcion){
                //ATACAR
                case 1:
                    System.out.println("A que enemigo atacas?\n" +
                            //nombres de los enemigos
                            "1." + enemigo.getNombre() + "?\n" +
                            "2." + enemigo2.getNombre() + "?\n" +
                            "3." + enemigo3.getNombre() + "?");
                    opcionSwitch1 = entrada.nextInt();
                    entrada.nextLine();
                    switch (opcionSwitch1){
                        //Ataque a
                        case 1:
                           if (enemigo.getVida() > 0) {
                               heroe.atacar(enemigo);
                           } else {
                               System.out.println("Objetivo invalido. está muerto.");
                           }
                            break;
                        case 2:
                           if (enemigo2.getVida() > 0) {
                               heroe.atacar(enemigo2);
                           }else {
                               System.out.println("Objetivo invalido. está muerto.");
                           }
                               break;
                       case 3:
                           if (enemigo3.getVida() > 0) {
                               heroe.atacar(enemigo3);
                           }else {
                               System.out.println("Objetivo invalido. está muerto.");
                           }
                           break;
                    }
                //USAR HABILIDAD
                case 2:

                    System.out.println("A que enemigo atacas?\n" +
                            "1." + enemigo.getNombre() + "?\n" +
                            "2." + enemigo2.getNombre() + "?\n" +
                            "3." + enemigo3.getNombre() + "?");
                    opcionSwitch2 = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcionSwitch2) {
                        //Habilidad a
                        case 1:
                            if (enemigo.getVida() > 0) {
                                heroe.superGolpe(enemigo);
                            } else {
                                System.out.println("Objetivo invalido. está muerto.");
                            }
                            break;
                        case 2:
                            if (enemigo2.getVida() > 0) {
                                heroe.superGolpe(enemigo2);
                            } else {
                                System.out.println("Objetivo invalido. está muerto.");
                            }
                            break;
                        case 3:
                            if (enemigo3.getVida() > 0) {
                                heroe.superGolpe(enemigo3);
                            } else {
                                System.out.println("Objetivo invalido. está muerto.");
                            }
                            break;
                    }
                    break;
                case 3:
                    //objeto pocion de la clase Pociones funcion pocionVida(objetivo)
                    pocion.pocionVida(heroe);
                    break;
                case 4:
                    System.out.println("***Has huido***");
                    break;
            }
            //Despues de las interacciones del "Heroe" comprobamos
            // si los enemigos estan vivos o no. Si están vivos atacan.
            //Si has huido no pueden atacar.
            if (opcion != 4) {
                if (enemigo.getVida() > 0) {
                    heroe.recibirAtaque(enemigo);
                }
                if (enemigo2.getVida() > 0) {
                    heroe.recibirAtaque(enemigo2);
                }
                if (enemigo3.getVida() > 0) {
                    heroe.recibirAtaque(enemigo3);
                }
            }
            //El bucle acaba si la opcion es 4, Los enemigos han muerto o el heroe
        } while (opcion != 4 && (enemigo.getVida() > 0 || enemigo2.getVida() > 0 ||
                enemigo3.getVida() > 0) && heroe.getVida() > 0);

    }
}
