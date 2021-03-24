
package PruebasRapidas;

public class Controlador {
    
    //Obtiene el numero de restricciones indicados en el JSpinner
    public static void getNumRestricciones(String pNumRes){
        int numRes= Integer.parseInt(pNumRes);
        //Aca se llamaria a las funciones con ese determinado numero de restricciones
        System.out.println("El numero de restricciones es: "+numRes);
    }
    
    public static String getTexto(char cod){
        switch(cod){
            case 's':
                //Para mostrar la solucion
                return "Solución";
            case 'r':
                //Para mostrar las restricciones
                return "Restricciones";
            case 'b':
                //Para mostrar el resultado del backtracking
                return "Backtracking";
            case 'f':
                //Para mostrar el resultado del de fuerza bruta
                return "Fuerza Bruta";
            case 'x':
                //Para mostrar el tiempo que tarda el backtracking
                return "123";
            case 'y':
                //Para mostrar el tiempo que tarda el de fuerza bruta
                return "456";
            default:
                //En caso de que ocurra algo inesperado
                return "Un error ha ocurrido";
        }
    }
}
