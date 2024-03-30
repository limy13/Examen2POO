import java.util.ArrayList;

class Zoo {

    // ESTA CLASE SE UTILIZZA PARA GUARDAR VISITANTES, EMPLEADOS, ANIMALES, ETC ADEMAS DE MOSTRAR DICHOS OBJETOS.
    
    private ArrayList<Employee> employees = new ArrayList<Employee>(); // ArrayList para almacenar empleados
    private ArrayList<Animal> animals = new ArrayList<Animal>(); // ArrayList para almacenar animales
    private ArrayList<Visitor> visitors = new ArrayList<Visitor>(); // ArrayList para almacenar visitantes
    private ArrayList<Employee> guides = new ArrayList<Employee>(); // ArrayList para almacenar empleados guias
    private ArrayList<Employee> busyGuides = new ArrayList<Employee>(); //guias ocupados
    private ArrayList<Visit> visit = new ArrayList<Visit>(); // ArrayList para almacenar visitas
    private int employeeId = 0, animalId = 0, vistorId = 0, visitId = 0;


    void addEmployee(Employee newEmployee){ //esta funcion agrega un empleado
        employees.add(newEmployee);
        if (newEmployee.getRol().equalsIgnoreCase("Guia")){
            guides.add(newEmployee);
        }
        System.out.println("\nRegistro exitoso\n");
    }

    void addAnimal(Animal newAnimal){ //esta funcion agrega un animal
        animals.add(newAnimal);
        System.out.println("\nRegistro exitoso\n");
    }

    void addVisitor(Visitor newVisitor){ //esta funcion agrega un visitante
        visitors.add(newVisitor);
        System.out.println("\nRegistro exitoso\n");
    }

    void addVisit(Visit newVisit) { //para registrar visitas
        visit.add(newVisit);
    }

    int getEmployeeId(){
        employeeId++;
        return employeeId;
    }

    int getAnimalId(){
        animalId++;
        return animalId;
    }

    int getVisitorId(){
        vistorId++;
        return vistorId;
    }

    int getVisitId(){
        visitId++;
        return visitId;
    }

    ArrayList<Employee> getGuides(){ //obtiene la lista de guias
        return guides;
    }

    ArrayList<Visitor> getVisitors(){ 
        return visitors;
    } 

    void setGuides(ArrayList<Employee> newGuides) {
        this.guides = newGuides;
    }

    void setBusyGuides(ArrayList<Employee> newBusyGuides) {
        this.busyGuides = newBusyGuides;
    }

    void showEmployees(){ //muestra info de todos los empleados
        if (employees.isEmpty()){
            System.out.println("\nNo hay empleados registrados\n");
        }
        else{
            int x = 1; 
            for (Employee i : employees){
                System.out.println("\n---- Empleado " + x + " ----\n");
                System.out.println(i.employeeGetData());
                i.printSchedule();
                x++;
            }
        }
    }

    void consultEmployee(int employeeId){ //info de un empleado en especifico
        boolean band = false;
        for (Employee i : employees){
            if (employeeId == i.getId()){
                System.out.println("\n---- Empleado ----\n");
                System.out.println(i.employeeGetData());
                i.printSchedule();
                band = true;
            }
        }
        if (band == false){
            System.out.println("\nEste ID no pertenece a ningún empleado\n");
        }
    }

    void showAnimals(){ //muestra info de todos los animales
        int x = 1;
        if (animals.isEmpty()){
            System.out.println("\nNo hay animales registrados\n");
        }
        else{ 
            for (Animal i : animals){
                System.out.println("\n---- Animal " + x + " ----");
                System.out.println(i.getData());
                x++;
            }
        }
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
            System.out.println("\nEste ID no pertenece a ningún animal\n");
        }
    }

    void showVisitors(){ //muestra info de todos los visitors
        int x = 1;
        if (visitors.isEmpty()){
            System.out.println("\nNo hay visitantes registrados\n");
        }
        else{ 
            for (Visitor i : visitors){
                System.out.println("\n---- Visitante " + x + " ----");
                System.out.println(i.visitorGetData());
                x++;
            }
        }
    }

    void consultVisitor(int visitorId){ //info de un animal en especifico
        boolean band = false;
        for (Visitor i : visitors){
            if (visitorId == i.getId()){
                System.out.println("\n---- Visitante ----");
                System.out.println(i.visitorGetData());
                band = true;
            }
        }
        if (band == false){
            System.out.println("\nEste ID no pertenece a ningún visitante\n");
        }
    }

    void showVisits() {
        int x = 1;
        if (visit.isEmpty()){
            System.out.println("\nNo hay visitas registradas\n");
        }
        else{ 
            for (Visit i : visit){
                System.out.println("\n\n---- Visit " + x + " ----\n");
                i.getVisitData();
                x++;
            }
        }
    }

    void consulVisit(int visitId){ //info de una visita en especifico
        boolean band = false;
        for (Visit i : visit){
            if (visitId == i.getVisitId()){
                System.out.println("\n\n---- Visit ----\n");
                i.getVisitData();
                band = true;
            }
        }
        if (band == false){
            System.out.println("\nEste ID no pertenece a ninguna visita\n");
        }
    }

    void endVisit(int id) { //verificar esto
        for (Visit i : visit) {
            if (id == i.getVisitId()) {
                for (Employee x : busyGuides) {
                    if(i.getGuideId() == x.getId()) {
                        busyGuides.remove(x);
                        guides.add(x);
                    }
                }
            }
        }
    }

     // METODOS PARA ELIMINAR ANIMALES
     void deleteAnimal(int animalId) {
        for (Animal animal : animals) {
            if (animal.getAnimalId() == animalId) {
                animals.remove(animal);
                System.out.println("El animal con ID: " + animalId + " ha sido eliminado.");
                return;
            }
        }
        System.out.println("El animal con ID: " + animalId + " no se encuentra");
    }

    void deleteEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employees.remove(employee);
                System.out.println("El empleado con ID: " + employeeId + " ha sido eliminado.");
                return;
            }
        }
        System.out.println("El empleado con ID: " + employeeId + " no se encuentra");
    }

    void deleteVisitor(int visitorId) {
        for (Visitor visitor : visitors) {
            if (visitor.getId() == visitorId) {
                visitors.remove(visitor);
                System.out.println("El Visitante con ID: " + visitorId + " ha sido eliminado.");
                return;
            }
        }
        System.out.println("El Visitante con ID: " + visitorId + " no se encuentra");
    }
}