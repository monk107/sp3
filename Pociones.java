public class Pociones {
    public void pocionVida(Personaje personaje) {
        int vidaCurada = 50;

        if (personaje.getVida() + vidaCurada > 100) {
            personaje.setVida(100);
            System.out.println("¡Has usado una poción de vida! Te has curado " + vidaCurada +
                    " puntos de vida.");
        } else {
            personaje.setVida(personaje.getVida() + vidaCurada);
            System.out.println("¡Has usado una poción de vida! Te has curado " +
                    vidaCurada + " puntos de vida.");
        }
    }

    public void pocionFuerza(Personaje objetivo) {
        int fuerzaOriginal = objetivo.getFuerza();
        //Multiplicador de fuerza
        objetivo.setFuerza(fuerzaOriginal * 2);
        System.out.println("¡Has usado una poción de fuerza! Tus ataques hacen el doble de daño.");

    }
}