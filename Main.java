import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cancion c1 = new Cancion("Moscow Mule", 3.09);
        Cancion c2 = new Cancion("Después de la Playa", 2.54);
        Cancion c3 = new Cancion("Tití Me Preguntó", 3.23);


        Cancion c4 = new Cancion("Safaera", 4.55);
        Cancion c5 = new Cancion("Yo Perreo Sola", 3.04);
        Cancion c6 = new Cancion("La Difícil", 3.36);


        LinkedList<Cancion> playList = new LinkedList<>();
        playList.add(c1);
        playList.add(c3);
        playList.add(c5);
        playList.add(c4);

        imprimirPlayList(playList);
        play(playList);
    }

    public static void imprimirPlayList(LinkedList<Cancion> playList) {
        System.out.println("=== PLAYLIST ===");
        int i = 1;
        for (Cancion c : playList) {
            System.out.println(i + ". " + c);
            i++;
        }
        System.out.println("================");
    }

    public static void play(LinkedList<Cancion> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int index = 0;

        if (playList.size() == 0) {
            System.out.println("La playlist no tiene canciones.");
            return;
        } else {
            System.out.println("Reproduciendo: " + playList.get(index));
        }

        imprimirMenu();

        while (!salir) {
            System.out.print("Introduce una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                case 1: // Siguiente canción
                    if (index < playList.size() - 1) {
                        index++;
                        System.out.println("Reproduciendo: " + playList.get(index));
                    } else {
                        System.out.println("Estas en el final de la playlist.");
                    }
                    break;
                case 2: // Canción anterior
                    if (index > 0) {
                        index--;
                        System.out.println("Reproduciendo: " + playList.get(index));
                    } else {
                        System.out.println("Estás al inicio de la playlist.");
                    }
                    break;
                case 3: // Repetir canción que estas escuhando
                    System.out.println("Reproduciendo: " + playList.get(index));
                    break;
                case 4: // playlist
                    imprimirPlayList(playList);
                    break;
                case 5: // Mostrar menú
                    imprimirMenu();
                    break;
                case 6: // Eliminar canción actual
                    if (playList.size() > 0) {
                        System.out.println("Eliminando: " + playList.get(index));
                        playList.remove(index);
                        if (index >= playList.size()) {
                            index = playList.size() - 1; // Ajustar índice si se elimina la última
                        }
                        if (playList.size() > 0) {
                            System.out.println("Ahora reproduciendo: " + playList.get(index));
                        } else {
                            System.out.println("La playlist está vacía.");
                        }
                    }
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public static void imprimirMenu() {
        System.out.println("Opciones:");
        System.out.println("0 - Salir");
        System.out.println("1 - Siguiente canción");
        System.out.println("2 - Canción anterior");
        System.out.println("3 - Repetir canción");
        System.out.println("4 - Mostrar playlist");
        System.out.println("5 - Mostrar menú");
        System.out.println("6 - Eliminar canción actual");
    }
}
