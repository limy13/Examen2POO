import java.util.ArrayList;

class Zoo {

    // ESTA CLASE SE UTILIZZA PARA GUARDAR VISITANTES, EMPLEADOS, ANIMALES, ETC ADEMAS DE MOSTRAR DICHOS OBJETOS.
    
    private ArrayList<Employee> employees = new ArrayList<Employee>(); // ArrayList para almacenar empleados
    private ArrayList<Animal> animals = new ArrayList<Animal>(); // ArrayList para almacenar animales
    private ArrayList<Visitor> visitors = new ArrayList<Visitor>(); // ArrayList para almacenar visitantes
    private ArrayList<Employee> guides = new ArrayList<Employee>(); // ArrayList para almacenar empleados guias
    private ArrayList<Visit> visit = new ArrayList<Visit>(); // ArrayList para almacenar empleados guias


    void addEmployee(Employee newEmployee){ //esta funcion agrega un empleado
        employees.add(newEmployee);
        if (newEmployee.getRol().equalsIgnoreCase("Guide")){
            guides.add(newEmployee);
        }
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

    void addVisit(Visit newVisit) { //para registrar visitas
        visit.add(newVisit);
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

    void consultEmployee(int employeeId){ //info de un empleado en especifico
        boolean band = false;
        for (Employee i : employees){
            if (employeeId == i.getId()){
                System.out.println("\n---- Employee ----\n");
                System.out.println(i.employeeGetData());
                band = true;
            }
        }
        if (band == false){
            System.out.println("\nThis ID does not belong to any employee\n");
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

    int getEmployeeId(){
        int id = 0;
        id++;
        return id;
    }

    int getAnimalId(){
        int id = 0;
        id++;
        return id;
    }

    int getVisitorId(){
        int id = 0;
        id++;
        return id;
    }

    ArrayList<Employee> getGuides(){ //obtiene la lista de guias
        return guides;
    }

    ArrayList<Visitor> getVisitors(){ 
        return visitors;
    } 

    void consultAnimal(int animalId){ //info de un animal en especifico
        boolean band = false;
        for (Animal i : animals){
            if (animalId == i.getAnimalId()){
                System.out.println("\n---- Animal ----\n");
                System.out.println(i.getData());
                band = true;
            }
        }
        if (band == false){
            System.out.println("\nThis ID does not belong to any animal\n");
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

    void consultVisitor(int visitorId){ //info de un animal en especifico
        boolean band = false;
        for (Visitor i : visitors){
            if (visitorId == i.getId()){
                System.out.println("\n---- Visitor ----\n");
                System.out.println(i.visitorGetData());
                band = true;
            }
        }
        if (band == false){
            System.out.println("\nThis ID does not belong to any visitor\n");
        }
    }
}