import java.util.ArrayList;

class Zoo {

    // ESTA CLASE SE UTILIZZA PARA GUARDAR VISITANTES, EMPLEADOS, ANIMALES, ETC ADEMAS DE MOSTRAR DICHOS OBJETOS.
    
    private ArrayList<Employee> employees = new ArrayList<Employee>(); // ArrayList para almacenar empleados
    private ArrayList<Animal> animals = new ArrayList<Animal>(); // ArrayList para almacenar animales
    private ArrayList<Visitor> visitors = new ArrayList<Visitor>(); // ArrayList para almacenar visitantes
    private ArrayList<Employee> guides = new ArrayList<Employee>(); // ArrayList para almacenar empleados guias
    private ArrayList<Employee> busyGuides = new ArrayList<Employee>(); //guias ocupados
    private ArrayList<Employee> maintenanceEmployee = new ArrayList<Employee>(); // ArrayList para almacenar empleados de mantenimiento //HUBO CAMBIOS AQUI 
    private ArrayList<Employee> busyMaintenance = new ArrayList<Employee>(); // ArrayList para almacenar empleados de mantenimiento //HUBO CAMBIOS AQUI 
    private ArrayList<Maintenance> maintenance = new ArrayList<Maintenance>(); // ArrayList para almacenar mantenimiento //HUBO CAMBIOS AQUI 
    private ArrayList<Visit> visit = new ArrayList<Visit>(); // ArrayList para almacenar visitas
    private int employeeId = 0, animalId = 0, vistorId = 0, visitId = 0, maintenanceId = 0;
    private Employee guideDeleted ; 


    void addEmployee(Employee newEmployee){ //esta funcion agrega un empleado
        employees.add(newEmployee);
        if (newEmployee.getRol().equalsIgnoreCase("Guia") || newEmployee.getRol().equalsIgnoreCase("Guía")){ //CAMBIOS AQUI
            guides.add(newEmployee);
        }
        else if (newEmployee.getRol().equalsIgnoreCase("Mantenimiento")) { //HUBO CAMBIOS AQUI
            maintenanceEmployee.add(newEmployee);
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

    void addMainteance(Maintenance newMaintenance) {
        this.maintenance.add(newMaintenance);
        System.out.println("\nRegistro exitoso\n");
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

    int getMaintenanceId(){
        maintenanceId++;
        return maintenanceId;
    }

    ArrayList<Animal> getAnimals(){ //obtiene la lista de los animales
        return animals;
    }

    ArrayList<Employee> getMaintenance(){ //obtiene la lista de mantenimiento
        return maintenanceEmployee;
    }

    ArrayList<Employee> getGuides(){ //obtiene la lista de guias
        return guides;
    }

    ArrayList<Visitor> getVisitors(){ 
        return visitors;
    } 

    void setMaintenanceEmployee(Employee newMaintenanceEmployee) {
        this.maintenanceEmployee.remove(newMaintenanceEmployee);
    }

    void setBusyMaintenance(Employee newBusyMaintenance) {
        this.busyGuides.add(newBusyMaintenance);
    }

    void setGuides(Employee newGuides) {
        this.guides.remove(newGuides);
    }

    void setBusyGuides(Employee newBusyGuides) {
        this.busyGuides.add(newBusyGuides);
    }

    void setAnimalId() {
        animalId = 0;
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
                System.out.println("\n---- Animal " + x + " ----\n"); //CAMBIOS AQUI
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
                System.out.println("\n\n---- Visita " + x + " ----\n");
                i.getVisitData();
                x++;
            }
        }
    }

    void consulVisit(int visitId){ //info de una visita en especifico
        boolean band = false;
        for (Visit i : visit){
            if (visitId == i.getVisitId()){
                System.out.println("\n\n---- Visita ----\n");
                i.getVisitData();
                band = true;
            }
        }
        if (band == false){
            System.out.println("\nEste ID no pertenece a ninguna visita\n");
        }
    }

    void showMaintenance(){ //muestra info de todos los mantenimientos
        int x = 1;
        if (maintenance.isEmpty()){
            System.out.println("\nNo hay mantenimientos registrados\n");
        }
        else{ 
            for (Maintenance i : maintenance){
                System.out.println("\n---- Mantenimiento " + x + " ----\n"); 
                System.out.println(i.getData());
                x++;
            }
        }
    }

    void consulMaintenance(int id){ //info de un mantenimiento en especifico
        boolean band = false;
        for (Maintenance i : maintenance){
            if (id == i.getId()){
                System.out.println("\n\n---- Mantenimiento ----\n");
                i.getData();
                band = true;
            }
        }
        if (band == false){
            System.out.println("\nEste ID no pertenece a ningún mantenimiento realizado\n");
        }
    }

    void endVisit(int id) { //verificar esto
        boolean band = false;
        if(visit.isEmpty()) {
            System.out.println("\nNo hay visitas registradas");
            return;
        }
        else {
            for (Visit i : visit) {
                if (id == i.getVisitId()) {
                    for (Employee x : busyGuides) {
                        if(i.getGuideId() == x.getId()) {
                            guideDeleted = x;
                            guides.add(x);
                            i.setProgress(true);
                            band = true;
                            System.out.println("\nVisita finalizada"); //CAMBIOS AQUI
                        }
                    }
                }
            }
            if(band == false) {
                System.out.println("\nEste ID no pertenece a ninguna visita en proceso"); //CAMBIOS AQUI 
            }
            else {
                busyGuides.remove(guideDeleted);
            }
        }    
    }

     // METODOS PARA ELIMINAR ANIMALES
     void deleteAnimal(int animalId) {
        for (Animal animal : animals) {
            if (animal.getAnimalId() == animalId) {
                animals.remove(animal);
                System.out.println("\nEl animal con ID: " + animalId + " ha sido eliminado.");
                return;
            }
        }
        System.out.println("\nEl animal con ID: " + animalId + " no se encuentra");
    }

    void deleteEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employees.remove(employee);
                System.out.println("\nEl empleado con ID: " + employeeId + " ha sido eliminado.");
                return;
            }
        }
        System.out.println("\nEl empleado con ID: " + employeeId + " no se encuentra");
    }

    void deleteVisitor(int visitorId) {
        for (Visitor visitor : visitors) {
            if (visitor.getId() == visitorId) {
                visitors.remove(visitor);
                System.out.println("\nEl Visitante con ID: " + visitorId + " ha sido eliminado.");
                return;
            }
        }
        System.out.println("\nEl Visitante con ID: " + visitorId + " no se encuentra");
    }
}