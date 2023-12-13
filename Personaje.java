public class Personaje {
    //Atributos de la clase.
    private String nombre;
    private int fuerza;
    private int experiencia;
    private int vida;
    private int energia;

    //Constructor completo menos experiencia, que siempre empieza en 0.
    // Y energia, por defecto en 100
    public Personaje( String nombre,int fuerza, int vida) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.vida = vida;
        this.experiencia = 0;
        this.energia = 100;
    }
    //Getters y Setters
    public String getNombre(){
        return this.nombre;
    }
    public int getFuerza() {
        return this.fuerza;
    }
    public int getVida() {
        return this.vida;
    }
    public int getExperiencia() {
        return this.experiencia;
    }
    public int getEnergia() {
        return this.energia;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
        checkNivel();
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }

    //-------Funciones de la Clase--------

    //Funcion para comprobar experiencia despues de una pelea.
    //Si llega a 100 utiliza la función subirNivel.
    private void checkNivel() {
        if (experiencia >= 100) {
            subirNivel();
            experiencia = 0;
        }
    }
    private void subirNivel() {
        fuerza += 5;
        vida += 10;
        System.out.println("¡Has subido de nivel! Nueva fuerza: " + fuerza + ", Nueva vida: " + vida);
    }
    public void atacar(Personaje objetivo) {
        int ataque = this.getFuerza();
        int vidaRestante = objetivo.getVida();
        //Comprobamos si puede recibir daño
        if (objetivo.getVida() > 0) {
            objetivo.setVida(vidaRestante - ataque);
            System.out.println(this.getNombre() + " ataca a " + objetivo.getNombre() +
                    " y le hace " + ataque + " puntos de daño.");
            System.out.println(objetivo.getNombre() + " ahora tiene " + objetivo.getVida() +
                    " puntos de vida.");
            //Comprobamos si despues del golpe ha muerto.
            if (objetivo.getVida() <= 0){
                System.out.println(objetivo.getNombre() + " ha muerto, ganas 35 de experiencia");
                setExperiencia(getExperiencia() + 35);
                checkNivel();
            }
        }
    }

    public void recibirAtaque(Personaje objetivo) {
        if (vida > 0) {
            setVida(getVida() - objetivo.getFuerza());
            System.out.println(objetivo.getNombre() + " ataca a  " + getNombre() +
                    " y causa " + objetivo.fuerza + " de daño.\n" +
                    "Te quedan " + getVida() + " puntos de vida");
            if (vida <= 0) {
                vida = 0;
                System.out.println("¡Has muerto!");
            }
        }
    }

    public void usarHabilidad(int costoEnergia) {
        if (this.energia >= costoEnergia) {
            System.out.println("¡Has usado una habilidad!");
            setEnergia(-costoEnergia);
        } else {
            System.out.println("No tienes suficiente energía para usar esta habilidad.");
        }
    }

    public void superGolpe(Personaje objetivo) {

        //Comprobamos antes de usar la habilidad si el objetivo
        //tiene vida y "Heroe" energia.
        if ((objetivo.getVida() > 0) && (getEnergia() > 30)) {
            usarHabilidad(30);
            int ataque = this.getFuerza() + 25;
            int vidaRestante = objetivo.getVida();
            objetivo.setVida(vidaRestante - ataque);
            System.out.println("Has usado SUPERGOLPE a " + objetivo.getNombre() +
                    " y le has hecho " + ataque + " puntos de daño.");
            System.out.println(objetivo.getNombre() + " ahora tiene " + objetivo.getVida() +
                    " puntos de vida.");

            //Si despues del golpe se queda sin vida...
            if (objetivo.getVida() <= 0){
                System.out.println(objetivo.getNombre() + " ha muerto, ganas 35 de experiencia");
                setExperiencia(getExperiencia() + 35);
                checkNivel();
            }
        }
    }
}
