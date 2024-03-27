import java.util.ArrayList;

class Zoo {

    // ESTA CLASE SE UTILIZZA PARA GUARDAR VISITANTES, EMPLEADOS, ANIMALES, ETC ADEMAS DE MOSTRAR DICHOS OBJETOS.
    
    private int id;
    private ArrayList<Employee> employees = new ArrayList<Employee>(); // ArrayList para almacenar empleados
    private ArrayList<Animal> animals = new ArrayList<Animal>(); // ArrayList para almacenar animales
    private ArrayList<Visitor> visitors = new ArrayList<Visitor>(); // ArrayList para almacenar visitantes

    void addEmployee(Employee newEmployee){ //esta funcion agrega un empleado
        employees.add(newEmployee);
        System.out.println("\nSuccessful registration\n");
    }

    void addAnimal(Animal newAnimal){ //esta funcion agrega un animal
        animals.add(newAnimal);
        System.out.println("\nSuccessful registration\n");
    }

    void addVisitor(Visitor newVisitor){ //esta funcion agrega un visitante
        visitors.add(newVisitor);
        System.out.println("\nSuccessful registration\n");
    }

    void showEmployees(){ //muestra info de todos los empleados
        if (employees.isEmpty()){
            System.out.println("\nThere are no registered employees\n");
        }
        else{
            int x = 1; 
            for (Employee i : employees){
                System.out.println("\n---- Employee " + x + " ----\n");
                System.out.println(i.employeeGetData());
                x++;
            }
        }
    }

    void consultEmployee(String rfc){ //info de un empleado en especifico
        boolean band = false;
        for (Employee i : employees){
            if (rfc.equals(i.getRfc())){
                System.out.println(i.employeeGetData());
                band = true;
            }
        }
        if (band == false){
            System.out.println("This RFC does not belong to any employee");
        }
    }

    void showAnimals(){ //muestra info de todos los animales
        int x = 1;
        if (animals.isEmpty()){
            System.out.println("\nThere are no registered animals\n");
        }
        else{ 
            for (Animal i : animals){
                System.out.println("\n---- Animal " + x + " ----");
                System.out.println(i.getData());
                x++;
            }
        }
    }

    int getAnimalId(){
        id++;
        return id;
    }

    void consultAnimal(int animalId){ //info de un animal en especifico
        boolean band = false;
        for (Animal i : animals){
            if (animalId == i.getAnimalId()){
                System.out.println(i.getData());
                band = true;
            }
        }
        if (band == false){
            System.out.println("This ID does not belong to any animal");
        }
    }

    void showVisitors(){ //muestra info de todos los visitors
        int x = 1;
        if (visitors.isEmpty()){
            System.out.println("\nThere are no registered visitors\n");
        }
        else{ 
            for (Visitor i : visitors){
                System.out.println("\n---- Visitor " + x + " ----");
                System.out.println(i.visitorGetData());
                x++;
            }
        }
    }

    void consultVisitor(String curp){ //info de un animal en especifico
        boolean band = false;
        for (Visitor i : visitors){
            if (curp.equals(i.getCurp())){
                System.out.println(i.visitorGetData());
                band = true;
            }
        }
        if (band == false){
            System.out.println("This CURP does not belong to any visitor");
        }
    }
}