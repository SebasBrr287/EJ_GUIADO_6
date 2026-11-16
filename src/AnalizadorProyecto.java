public class AnalizadorProyecto {
    private Modulo[] modulos;

    public AnalizadorProyecto(Modulo[] modulos) {
        this.modulos = modulos;
    }

    public String listarModulos() {
        String resultado = "";
        for (int i = 0; i < modulos.length; i++) {
            if (modulos[i] != null) {
                resultado += modulos[i].mostrarInformacion() + "\n";
            }
        }
        return resultado;

    }

    public int contarTerminados() {
        int contador = 0;
        for (int i = 0; i < modulos.length; i++) {
            if (modulos[i] != null && modulos[i].isTerminado()) {
                contador++;
            }
        }
        return contador;
    }

    public double calcularProgresoPromedio() {
        double suma = 0;
        int totalValidos = 0;
        for (int i = 0; i < modulos.length; i++) {
            if (modulos[i] != null) {
                suma += modulos[i].getProgreso();
                totalValidos++;
            }
        }
        if (totalValidos == 0) {
            return 0.0;
        }
        return suma / totalValidos;
    }

    public Modulo buscarModulo(String nombre) {
        for (int i = 0; i < modulos.length; i++) {
            if (modulos[i] != null && modulos[i].getNombre().equalsIgnoreCase(nombre)) {
                return modulos[i];
            }
        }
        return null; // Retorna null si no se encuentra
    }

    // Desafío adicional: Retorna el módulo con menor progreso
    public Modulo obtenerMenorProgreso() {
        Modulo menor = null;
        for (int i = 0; i < modulos.length; i++) {
            if (modulos[i] != null) {
                if (menor == null || modulos[i].getProgreso() < menor.getProgreso()) {
                    menor = modulos[i];
                }
            }
        }
        return menor;
    }
}
