//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // 1. Creación del arreglo de módulos (independientes del analizador)
            Modulo[] modulos = new Modulo[5];
            modulos[0] = new Modulo("Autenticacion", "Java", 100, true);
            modulos[1] = new Modulo("Inventario", "Java", 75, false);
            modulos[2] = new Modulo("Pagos", "Python", 100, true);
            modulos[3] = new Modulo("Reportes", "JavaScript", 40, false);
            modulos[4] = new Modulo("Notificaciones", "Java", 15, false);

            // 2. Asociación con el analizador a través del constructor[cite: 1]
            AnalizadorProyecto analizador = new AnalizadorProyecto(modulos);

            int opcion;
            do {
                System.out.println("\n--- GESTIÓN DE PROYECTO DE SOFTWARE ---");
                System.out.println("1. Listar módulos");
                System.out.println("2. Ver cantidad de módulos terminados");
                System.out.println("3. Calcular progreso promedio del proyecto");
                System.out.println("4. Buscar módulo por nombre");
                System.out.println("5. Ver módulo con menor progreso (Desafío)");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("\n=== LISTADO DE MÓDULOS ===");
                        System.out.println(analizador.listarModulos());
                        break;
                    case 2:
                        System.out.println("\nMódulos terminados: " + analizador.contarTerminados());
                        break;
                    case 3:
                        System.out.println("\nProgreso promedio del proyecto: " + analizador.calcularProgresoPromedio() + "%");
                        break;
                    case 4:
                        System.out.print("\nIngrese el nombre del módulo a buscar: ");
                        String nombreBuscado = sc.nextLine();
                        Modulo encontrado = analizador.buscarModulo(nombreBuscado);

                        if (encontrado != null) {
                            System.out.println("¡Encontrado!: " + encontrado.mostrarInformacion());
                        } else {
                            System.out.println("El módulo buscado no existe en el sistema (retornó null).");
                        }
                        break;
                    case 5:
                        Modulo menorProgreso = analizador.obtenerMenorProgreso();
                        if (menorProgreso != null) {
                            System.out.println("\nMódulo con menor avance: " + menorProgreso.mostrarInformacion());
                        }
                        break;
                    case 6:
                        System.out.println("\nSaliendo del programa. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("\nOpción inválida. Intente de nuevo.");
                }
            } while (opcion != 6);

            sc.close();
        }
    }
