import java.util.InputMismatchException;
import java.util.Scanner;

public class Invernadero {
    
    private Float   areaInvernadero;
    private int     numCultivos;
    private String  modeloSistemaDeRiego;
    private Boolean estadoVentilacion;
    private Scanner scanner = new Scanner(System.in);
    
    public Invernadero(){

        while (true) {
            try {
                System.out.println("Ingrese el área del invernadero en metros cuadrados");
                this.areaInvernadero = scanner.nextFloat();
                break;
            } catch (InputMismatchException e) {
                helper();
            }
        }
        while (true) {
            try {
                System.out.println("Ingrese el número de cultivos que tiene este invernadero");
                this.numCultivos = scanner.nextInt();
                scanner.nextLine(); 
                break;
            } catch (InputMismatchException e) {
                helper();
            }
        }
        
        System.out.println("Ingrese el modelo del sistema de riego");
        this.modeloSistemaDeRiego = scanner.nextLine();
        System.out.println("En estos momentos la ventilación se encuentra apagada");
        this.estadoVentilacion = false;

        System.out.println("\033[H\033[2J");
        System.out.println("\tCONTROL DE INVERNADERO AUTOMATIZADO");
        while (true) {
            try{
                System.out.println("Acciones que puede hacer\n"
                                    +"1. Encender la ventilacion"
                                    +"\n2. Apagar la ventilacion"
                                    +"\n3. Actualizar area del invernadero"
                                    +"\n4. Actualizar el numero de cultivos"
                                    +"\n5. Actualizar el modelo de sistema de riego"
                                    +"\n6. Informacion completa del sistema"
                                    +"\n7. Salir");
                int menu = scanner.nextInt();
                if (menu < 1 || menu > 7) {
                    throw new InputMismatchException();
                } 
                switch (menu) {
                    case 1:
                        System.out.println(this.estadoVentilacion == true ? "La ventilacion ya estaba encendida" : "Ventilacion encendida con exito");
                        encenderVentilacion();
                        break;
                
                    case 2:
                        System.out.println(this.estadoVentilacion== true ? "Ventilacion apagada con exito" : "La ventilacion ya estaba apagada");
                        apagarVentilacion();
                        break;
                    case 3:
                        System.out.println("Area del invernadero actual: "+ this.areaInvernadero);
                        System.out.println("Ingrese el nuevo area: ");
                        this.areaInvernadero = scanner.nextFloat();
                        System.out.println("Area del invernadero actualizada a: "+ this.areaInvernadero);
                        break;
                    case 4:
                        System.out.println("Numero de cultivos actual: "+ this.numCultivos);
                        System.out.println("Ingrese el nuevo numero de cultivos: ");
                        this.numCultivos = scanner.nextInt();
                        System.out.println("Numero de cultivos actualizado a: "+ this.numCultivos);
                        break;
                    case 5:
                        System.out.println("Modelo de sistema de riego actual: "+ this.modeloSistemaDeRiego);
                        System.out.println("Ingrese el nuevo modelo de sistema de riego: ");
                        this.modeloSistemaDeRiego = scanner.nextLine();
                        System.out.println("Modelo de sistema de riego a: "+ this.modeloSistemaDeRiego);

                        break;
                    case 6:
                        helper();
                        System.out.println("Area del invernadero: " + areaInvernadero+
                                        "\nNumero de cultivos: "+ numCultivos+
                                        "\nModelode sistema de riego: "+ modeloSistemaDeRiego+
                                        "\nEstado de la ventilacion: " + estado());
                        break;
                    case 7:
                        System.exit(0);
                        break;
                }

            } catch(InputMismatchException e){
                helper();
            }
        }
    }
        
        
    public int obtenerNumeroDeCultivos(){
        return this.numCultivos;
    }
    public Float obtenerAreaDelInvernadero(){
        return this.areaInvernadero;
    }
    public Boolean encenderVentilacion(){
        this.estadoVentilacion = true;
        return true;
    }
    public Boolean apagarVentilacion(){
        this.estadoVentilacion = false;
        return false;
    }
    public String estado(){
        return this.estadoVentilacion ? "Ventilacion encendida" : "Ventilacion apagada";

    }
    public void helper(){
        System.out.println("\033[H\033[2J");
        System.out.println("\tCONTROL DE INVERNADERO AUTOMATIZADO");
        System.out.println("Error: Ingrese un dato válido por favor");
        scanner.nextLine();
    }
    
}
