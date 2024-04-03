import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        
        //AGREGAR CONTRASEÑA
        Scanner string = new Scanner(System.in); //scanner strings
        Scanner doubleRead = new Scanner (System.in); //scanner double
        Scanner intRead = new Scanner (System.in); //scanner int
        Scanner booleanRead = new Scanner (System.in); //scanner boolean
        Zoo zoo = new Zoo(); //acceso a la clase Zoo
        int option, id;

        for(int y = 1; y == 1; ) {
            System.out.println("\n");
            System.out.println("*** BIENVENIDO AL PROGRAMA ***\n");
            System.out.print("Ingresa la contraseña para acceder al sistema: ");
            String password = string.nextLine();
            if(password.equals("zooMRL24")) {
                do {
                    System.out.println("\n");
                    System.out.println("*** ZOO DE MORELIA ***\n");
                    System.out.println("1. Registrar empleado");
                    System.out.println("2. Mostrar informacion de empleados");
                    System.out.println("3. Registrar visitante");
                    System.out.println("4. Mostrar informacion del visitante");
                    System.out.println("5. Registrar visita al zoo");
                    System.out.println("6. Finalizar visita");
                    System.out.println("7. Mostrar información de visitas");
                    System.out.println("8. Registrar animal");
                    System.out.println("9. Mostrar informacion del animal");
                    System.out.println("10. Realizar mantenimiento de animal");
                    System.out.println("11. Finalizar mantenimiento");
                    System.out.println("12. Mostrar información de mantenimientos realizados");
                    System.out.println("13. Eliminar o modificar datos de un Animal");
                    System.out.println("14. Eliminar o modificar datos de un Empleado");
                    System.out.println("15. Eliminar o modificar datos de un Visitante");
                    System.out.println("16. Salir");
                    System.out.print("\nIngrese opción: ");
                    option = intRead.nextInt();
                    System.out.println("\n");

                    switch(option) {

                        case 1:
                            // Aqui seria la opcion 1.- Registrar empleado
                                System.out.println("\n---- Información del empleado ----\n");
                                System.out.print("Nombre: ");
                                String name = string.nextLine();
                                System.out.print("Apellidos: ");
                                String lastName = string.nextLine();
                                System.out.print("Fecha de nacimiento (DD-MM-YYYY): ");
                                String birthdate = string.nextLine();
                                System.out.print("Fecha de ingreso como trabajador (DD-MM-YYYY): ");
                                String admissionDate = string.nextLine();
                                System.out.print("RFC: ");
                                String rfc = string.nextLine();
                                System.out.print("CURP: ");
                                String curp = string.nextLine();
                                System.out.print("Salario: ");
                                double salary = doubleRead.nextDouble();
                                System.out.print("Rol: ");
                                String rol = string.nextLine();
                                System.out.println("\nIngrese los horarios de trabajo (Dejar vacío si es que no trabaja ese día): ");
                                String [] vector = {"\n---- Lunes ----\n", "\n---- Martes ----\n", "\n---- Miércoles ----\n", "\n---- Jueves ----\n", "\n---- Viernes ----\n", "\n---- Sábado ----\n", "\n---- Domingo ----\n"};
                                String schedule [][] =  {{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"}, {"", "", "", "", "", "", ""}};
                                for (int x = 0; x < 7; x++) {
                                    System.out.println(vector[x]);
                                    System.out.print("Horas de trabajo (00:00-24:00): "); //hacer la matrizz aqui 
                                    schedule [1][x] = string.nextLine();
                                }
                                System.out.print("\n¿Cancelar registro? (1 = si), (2 = no): ");
                                option = intRead.nextInt();
                                if(option == 1) {
                                    System.out.println("\nRegistro cancelado"); //CAMBIOS AQUI
                                }
                                else {
                                    Employee employee = new Employee(name, lastName, birthdate, admissionDate, rfc.toUpperCase(), curp.toUpperCase(),
                                    salary, schedule, rol, zoo.getEmployeeId()); //HUBO CAMMBIOS EN ESTA LINEA
                                    zoo.addEmployee(employee); // agrega al empleado
                                }
                            break;
                            
                        case 2:
                            // mostrar info de todos los empleados 
                            System.out.println("\n1. Mostrar información de todos los empleados"); //mostrar todos los empleados
                            System.out.println("2. Consultar empleado"); // mostrar un empleado en especifico
                            System.out.print("\nIngrese opción: ");
                            int decision = intRead.nextInt();
                            if (decision == 1){
                                zoo.showEmployees();
                            }
                            else{
                                System.out.print("\nIngrese el ID del empleado que quieres consultar: ");
                                id = intRead.nextInt();
                                zoo.consultEmployee(id);
                            }
                            break;

                        case 3:
        
                            // Aqui seria la opcion 3.- Registrar visitante
                            System.out.println("\n---- Información del visitante ----\n");
                            System.out.print("Nombre: ");
                            name = string.nextLine();
                            System.out.print("Apellido: ");
                            lastName = string.nextLine();
                            System.out.print("Fecha de nacimiento (DD-MM-YYYY): ");
                            birthdate = string.nextLine();
                            System.out.print("CURP: ");
                            curp = string.nextLine();
                            System.out.print("Fecha de ingreso como visitante (DD-MM-YYYY): ");
                            admissionDate = string.nextLine();
                            System.out.print("\n¿Cancelar registro? (1 = si), (2 = no): ");
                            decision = intRead.nextInt();
                            if(decision == 1) { //en esta línea hubieron cambios
                                System.out.println("\nRegistro cancelado"); //en esta linea hubieron cambios
                            }
                            else { //HUBO CAMBIOS EN ESTA LINEA
                                Visitor visitor = new Visitor(name, lastName, birthdate, curp.toUpperCase(), admissionDate, zoo.getVisitorId());
                                zoo.addVisitor(visitor); 
                            }            
                            break;

                        case 4:
                        
                            // Aqui seria la opcion 4.- Mostrar informacion del visitante

                            System.out.println("\n1. Mostrar información de todos los visitantes"); //mostrar todos los animales
                            System.out.println("2. Consultar visitante"); // mostrar un animal en especifico
                            System.out.print("\nIngrese opción: ");
                            decision = intRead.nextInt();
                            if (decision == 1) {
                                zoo.showVisitors();
                            }
                            else {
                                System.out.print("\nIngrese el ID del visitante que quieres consultar: ");
                                id = intRead.nextInt();
                                zoo.consultVisitor(id);
                            }
                            break;

                        case 5:

                            // Aqui seria la opcion 5.- Registrar visita al zoo

                            Visit visit = new Visit(zoo.getVisitors(), zoo.getGuides()); //CAMBIOS AQUII
                            if(visit.addVisitors() == true) {
                                visit.setId(zoo.getVisitId()); //CAMBIOS AQUI
                                System.out.println("\n\n---- Datos de la visita ----\n"); //CAMBIOS AQUI
                                visit.getVisitData();
                                zoo.setGuides(visit.getGuideDeleted());
                                zoo.setBusyGuides(visit.getGuideDeleted());
                                zoo.addVisit(visit);
                                System.out.println("\nRegistro exitoso, ¡Disfrute su visita!\n");
                            }
                            break;

                        case 6:

                            //Finalzar visita

                            System.out.print("Ingrese el ID de la visita que desea finalizar: ");
                            id = intRead.nextInt();
                            zoo.endVisit(id);
                            break;

                        case 7:
                            
                            System.out.println("\n1. Mostrar información de las visitas realizadas"); //mostrar todos los animales
                            System.out.println("2. Consultar visita"); // mostrar un animal en especifico
                            System.out.print("\nIngrese opción: ");
                            decision = intRead.nextInt();
                            if (decision == 1) {
                                zoo.showVisits();
                            }
                            else {
                                System.out.print("\nIngrese el ID de la visita que quieres consultar: ");
                                id = intRead.nextInt();
                                zoo.consulVisit(id);
                            }

                            break;

                        case 8:

                            // Aqui seria la opcion 6.- Registrar animal
                        
                            System.out.println("\n---- Información del animal ----\n");
                            System.out.print("Especie: ");
                            String kind = string.nextLine();
                            System.out.print("Fecha de llegada (DD-MM-YYYY): ");
                            String arrivalDate = string.nextLine();
                            System.out.print("Tipo de alimentación: ");
                            String typeFood = string.nextLine();
                            System.out.print("Fecha de nacimiento (DD-MM-YYYY): ");
                            birthdate = string.nextLine();
                            System.out.print("Peso: ");
                            double weight = doubleRead.nextDouble(); 
                            System.out.print("Frecuencia de alimentación: ");
                            String feedingFrequency = string.nextLine();
                            System.out.print("¿Dispone de vacunas? (1 = si), (2 = no): ");
                            decision = intRead.nextInt();
                            boolean vaccines = false; 
                            if(decision == 1){
                                vaccines = true;
                            }
                            Animal animal = new Animal(kind, arrivalDate, typeFood, birthdate, weight, feedingFrequency, vaccines, zoo.getAnimalId());
                            System.out.print("¿Padece de alguna enfermedad? (1 = si), (2 = no): "); //pregunta si tiene enfermedades en caso de no tenerlas
                            decision = intRead.nextInt();
                            if(decision == 1){
                                do{
                                System.out.print("\nEnfermedad: "); //CAMBIOS AQUI
                                String disease = string.nextLine();
                                animal.setDiseases(disease);
                                System.out.print("\n¿Agregar otra enfermedad? (1 = si), (2 = no): ");
                                decision = intRead.nextInt();
                                }
                                while(decision == 1); //while para agregar las enfermedades que quiera
                            }
                            System.out.print("\n¿Cancelar registro? (1 = si), (2 = no): ");
                            decision = intRead.nextInt();
                            if(decision == 1) { //HUBIERON CAMBIOS AQUI
                                zoo.setAnimalId(); //HUBIERON CAMBIOS AQUI
                                System.out.println("\nRegistro cancelado"); //CAMBIOS AQUI
                            }
                            else {
                                zoo.addAnimal(animal); // agrega el animal
                            }         
                            break;

                        case 9:

                            // Aqui seria la opcion 7.- Mostrar info animal

                            System.out.println("\n1. Mostrar información de todos los animales"); //mostrar todos los animales
                            System.out.println("2. Consultar animal"); // mostrar un animal en especifico
                            System.out.print("\nIngrese opción: ");
                            decision = intRead.nextInt();
                            if(decision == 1){
                                zoo.showAnimals();
                            }
                            else{
                                System.out.print("\nIngrese el ID del animal que quieres consultar: ");
                                id = intRead.nextInt();
                                zoo.consultAnimal(id);
                            }
                            break;

                        case 10:
                            // Aqui seria la opcion 8.- Realizar mantenimiento del animal

                            Maintenance maintenance = new Maintenance(zoo.getMaintenance(), zoo.getAnimals());
                            maintenance.addMainteance();
                            if(maintenance.getBand() == true) {
                                maintenance.setId(zoo.getMaintenanceId());
                                zoo.setMaintenanceEmployee(maintenance.getMaintenanceDeleted());
                                zoo.setBusyMaintenance(maintenance.getMaintenanceDeleted());
                                System.out.println("\n\n---- Datos sobre el mantenimiento ----\n");
                                System.out.println(maintenance.getData());
                                zoo.addMainteance(maintenance);
                            }
                            break;

                        case 11: 
                            System.out.print("\nIngrese el ID del mantenimiento que desea finalizar: ");
                            id = intRead.nextInt();
                            zoo.endMaintenance(id);;
                            break;

                        case 12: 
                            System.out.println("\n1. Mostrar información de todos los mantenimientos"); //mostrar todos los mantenimientos
                            System.out.println("2. Consultar algún mantenimiento"); // mostrar un mantenimiento en especifico
                            System.out.print("\nIngrese opción: ");
                            decision = intRead.nextInt();
                            if (decision == 1){
                                zoo.showMaintenance();
                            }
                            else{
                            System.out.print("\nIngrese el ID del mantenimiento que quieres consultar: ");
                            id = intRead.nextInt();
                            zoo.consulMaintenance(id);
                            }  
                            break;

                        case 13:
                            System.out.println("\n1. Eliminar Animal");
                            System.out.println("2. Modificar Animal");
                            System.out.print("\nIngrese opción: ");
                            decision = intRead.nextInt();
                            switch(decision) {
                                
                                case 1:
                                    System.out.print("\nIntroduce el ID del animal que deseas eliminar: ");
                                    int deleteAnimalId = intRead.nextInt();
                                    zoo.deleteAnimal(deleteAnimalId);
                                    break;

                                    case 2:
                                    System.out.println("\n1. Modificar todo");
                                    System.out.println("2. Modificar un campo en especifico");
                                    System.out.print("\nIngrese opción: ");
                                    decision = intRead.nextInt();
                                    switch(decision) {

                                        case 1:
                                            System.out.println("\n---- Modificar animal ----\n");
                                            System.out.print("Introduce el ID del animal que deseas modificar: ");
                                            int modifyAnimalId = intRead.nextInt();
                                            Animal animalToModify = null;
                                            for(Animal animalTemp : zoo.getAnimals()) {
                                                if(animalTemp.getAnimalId() == modifyAnimalId) {
                                                    animalToModify = animalTemp;
                                                    break;
                                                }
                                            }
                                            if (animalToModify != null) {
                                                System.out.print("\nNuevo tipo de Animal: ");
                                                String newType = string.nextLine();
                                                animalToModify.setTypeAnimal(newType);
                                                System.out.print("Nueva fecha de nacimiento (DD-MM-YYYY): ");
                                                String newBirthdate = string.nextLine();
                                                animalToModify.setBirthdate(newBirthdate);
                                                System.out.print("Nueva fecha de ingreso (DD-MM-YYYY): ");
                                                String newArrivalDate = string.nextLine();
                                                animalToModify.setArrivalDate(newArrivalDate);
                                                System.out.print("Nuevo peso: ");
                                                double newWeight = doubleRead.nextDouble();
                                                animalToModify.setWeight(newWeight);
                                                System.out.print("Nueva frecuencia de alimentación: ");
                                                String newFeedingFrequency = string.nextLine();
                                                animalToModify.setFeedingFrequency(newFeedingFrequency);
                                                System.out.print("Nuevo tipo de alimentación: ");
                                                String newFeedingType = string.nextLine();
                                                animalToModify.setFeedingType(newFeedingType);
                                                System.out.print("¿Cuenta con vacunas? (true/false): ");
                                                boolean newHasVaccines = booleanRead.nextBoolean();
                                                animalToModify.setHasVaccines(newHasVaccines);
                                                System.out.print("Nuevas enfermedades (separadas por coma): ");
                                                String diseasesInput = string.nextLine();
                                                String[] diseasesArray = diseasesInput.split(",");
                                                ArrayList<String> newDiseases = new ArrayList<>(Arrays.asList(diseasesArray));
                                                animalToModify.setDiseases(newDiseases);
                                                System.out.println("\nAnimal modificado exitosamente.");
                                            } 
                                            else {
                                                System.out.println("\nAnimal no encontrado.");
                                            }
                                            break;

                                        case 2:
                                        System.out.println("\n---- Modificar animal ----\n");
                                            System.out.print("Introduce el ID del animal que deseas modificar: ");
                                            int modifyAnimalIdInput = intRead.nextInt(); // Cambiamos el nombre de la                                                    // variable modifyAnimalId
                                            Animal foundAnimalToModify = null; // Cambiamos el nombre de la variable         // animalToModify
                                            for(Animal animalTemp : zoo.getAnimals()) {
                                                if(animalTemp.getAnimalId() == modifyAnimalIdInput) {
                                                    foundAnimalToModify = animalTemp;
                                                    break;
                                                }
                                            }
                                            if(foundAnimalToModify != null) {
                                                System.out.println("\nSeleccione el campo que desea modificar:");
                                                System.out.println("\n1. Tipo de Animal");
                                                System.out.println("2. Fecha de nacimiento");
                                                System.out.println("3. Fecha de ingreso");
                                                System.out.println("4. Peso");
                                                System.out.println("5. Frecuencia de alimentación");
                                                System.out.println("6. Tipo de alimentación");
                                                System.out.println("7. ¿Cuenta con vacunas?");
                                                System.out.println("8. Enfermedades");
                                                System.out.print("\nIngrese opción: ");
                                                decision = intRead.nextInt();
                                                switch(decision) {

                                                    case 1:
                                                        System.out.print("\nNuevo tipo de Animal: ");
                                                        String newType = string.nextLine();
                                                        foundAnimalToModify.setTypeAnimal(newType);
                                                        break;

                                                    case 2:
                                                        System.out.print("\nNueva fecha de nacimiento (DD-MM-YYYY): ");
                                                        String newBirthdate = string.nextLine();
                                                        foundAnimalToModify.setBirthdate(newBirthdate);
                                                        break;

                                                    case 3:
                                                        System.out.print("\nNueva fecha de ingreso (DD-MM-YYYY): ");
                                                        String newArrivalDate = string.nextLine();
                                                        foundAnimalToModify.setArrivalDate(newArrivalDate);
                                                        break;

                                                    case 4:
                                                        System.out.print("\nNuevo peso: ");
                                                        double newWeight = doubleRead.nextDouble();
                                                        foundAnimalToModify.setWeight(newWeight);
                                                        break;

                                                    case 5:
                                                        System.out.print("\nNueva frecuencia de alimentación: ");
                                                        String newFeedingFrequency = string.nextLine();
                                                        foundAnimalToModify.setFeedingFrequency(newFeedingFrequency);
                                                        break;

                                                    case 6:
                                                        System.out.print("\nNuevo tipo de alimentación: ");
                                                        String newFeedingType = string.nextLine();
                                                        foundAnimalToModify.setFeedingType(newFeedingType);
                                                        break;

                                                    case 7:
                                                        System.out.print("\n¿Cuenta con vacunas? (true/false): ");
                                                        boolean newHasVaccines = booleanRead.nextBoolean();
                                                        foundAnimalToModify.setHasVaccines(newHasVaccines);
                                                        break;

                                                    case 8:
                                                        System.out.print("\nNuevas enfermedades (separadas por coma): ");
                                                        String diseasesInput = string.nextLine();
                                                        String[] diseasesArray = diseasesInput.split(",");
                                                        ArrayList<String> newDiseases = new ArrayList<>(Arrays.asList(diseasesArray));
                                                        foundAnimalToModify.setDiseases(newDiseases);
                                                        break;

                                                    default:
                                                        System.out.println("\nOpción inválida.");
                                                        break;
                                                }
                                                System.out.println("\nAnimal modificado exitosamente.");
                                            } 
                                            else {
                                                System.out.println("\nAnimal no encontrado.");
                                            }
                                        }
                                        break;

                                default:
                                    break;
                            }
                            break;

                        case 14:
                            System.out.println("\n1. Eliminar Empleado");
                            System.out.println("2. Modificar Empleado");
                            System.out.print("\nIngrese opción: ");
                            decision = intRead.nextInt();
                            switch(decision) {

                                case 1:
                                    System.out.print("\nIntroduce el ID del Empleado que deseas eliminar: ");
                                    int deleteEmployee = intRead.nextInt();
                                    zoo.deleteEmployee(deleteEmployee);
                                    break;

                                case 2:
                                    System.out.println("\n1. Modificar todos los datos");
                                    System.out.println("2. Modificar un dato en especifico");
                                    System.out.print("\nIngrese opción: ");
                                    decision = intRead.nextInt();
                                    switch(decision) {

                                        case 1:
                                            System.out.println("\n---- Modificar empleado ----\n");
                                            System.out.print("Introduce el ID del empleado que deseas modificar: ");
                                            int modifyEmployeeId = intRead.nextInt();
                                            Employee employeeToModify = null;
                                            for(Employee emp : zoo.getEmployees()) { // Cambiamos el nombre de la  // variable employee
                                                if(emp.getId() == modifyEmployeeId) { // Usamos el nuevo nombre de la     // variable
                                                    employeeToModify = emp;
                                                    break;
                                                }
                                            }
                                            if(employeeToModify != null) {
                                                System.out.print("\nNuevo nombre: ");
                                                String newName = string.nextLine();
                                                System.out.print("Nuevo apellido: ");
                                                String newLastName = string.nextLine();
                                                System.out.print("Nueva fecha de nacimiento (DD-MM-YYYY): ");
                                                String newBirthdate = string.nextLine();
                                                System.out.print("Nueva fecha de ingreso (DD-MM-YYYY): ");
                                                String newAdmissionDate = string.nextLine();
                                                System.out.print("Nuevo RFC: ");
                                                String newRfc = string.nextLine();
                                                System.out.print("Nueva CURP: ");
                                                String newCurp = string.nextLine();
                                                System.out.print("Nuevo salario: ");
                                                double newSalary = doubleRead.nextDouble();
                                                System.out.print("Nuevo rol: ");
                                                String newRol = string.nextLine();
                                                System.out.println("\nIngrese los nuevos horarios de trabajo (Dejar vacío si no trabaja ese día): ");
                                                String[][] newSchedule = new String[2][7];
                                                String[] days = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
                                                for(int i = 0; i < 7; i++) {
                                                    System.out.println("\n---- " + days[i] + " ----\n");
                                                    System.out.print("Nuevas horas de trabajo (00:00-24:00): ");
                                                    newSchedule[0][i] = days[i];
                                                    newSchedule[1][i] = string.nextLine();
                                                }

                                                // Actualizar los datos del empleado
                                                employeeToModify.setName(newName);
                                                employeeToModify.setLastName(newLastName);
                                                employeeToModify.setBirthdate(newBirthdate);
                                                employeeToModify.setAdmissionDate(newAdmissionDate);
                                                employeeToModify.setRfc(newRfc.toUpperCase());
                                                employeeToModify.setCurp(newCurp.toUpperCase());
                                                employeeToModify.setSalary(newSalary);
                                                employeeToModify.setRol(newRol);
                                                employeeToModify.setSchedule(newSchedule);
                                                System.out.println("\nEmpleado modificado exitosamente.");
                                            } 
                                            else {
                                                System.out.println("\nEmpleado no encontrado.");
                                            }
                                            break;

                                        case 2: // Modificar empleado
                                            System.out.println("\n---- Modificar empleado ----\n");
                                            System.out.print("Introduce el ID del empleado que deseas modificar: ");
                                            int modifyEmployeeIdInput = intRead.nextInt();
                                            intRead.nextLine(); // Consumir la nueva línea después de leer el entero          
                                            Employee femployeeToModify = null; // Buscar empleado por ID
                                            for(Employee emp : zoo.getEmployees()) {
                                                if(emp.getId() == modifyEmployeeIdInput) {
                                                    femployeeToModify = emp;
                                                    break;
                                                }
                                            }
                                            if(femployeeToModify != null) {  // Recopilar información actualizada del empleado
                                                System.out.println("\nSeleccione el campo que desea modificar:");
                                                System.out.println("\n1. Nombre");
                                                System.out.println("2. Apellidos");
                                                System.out.println("3. Fecha de nacimiento");
                                                System.out.println("4. Fecha de ingreso");
                                                System.out.println("5. RFC");
                                                System.out.println("6. CURP");
                                                System.out.println("7. Salario");
                                                System.out.println("8. Rol");
                                                System.out.println("9. Horario de trabajo");
                                                System.out.print("\nIngrese opción: ");
                                                decision = intRead.nextInt();
                                                switch(decision) {

                                                    case 1:
                                                        System.out.print("\nNuevo nombre: ");
                                                        String newName = string.nextLine();
                                                        femployeeToModify.setName(newName);
                                                        break;

                                                    case 2:
                                                        System.out.print("\nNuevos apellidos: ");
                                                        String newLastName = string.nextLine();
                                                        femployeeToModify.setLastName(newLastName);
                                                        break;

                                                    case 3:
                                                        System.out.print("\nNueva fecha de nacimiento (DD-MM-YYYY): ");
                                                        String newBirthdate = string.nextLine();
                                                        femployeeToModify.setBirthdate(newBirthdate);
                                                        break;

                                                    case 4:
                                                        System.out.print("\nNueva fecha de ingreso (DD-MM-YYYY): ");
                                                        String newAdmissionDate = string.nextLine();
                                                        femployeeToModify.setAdmissionDate(newAdmissionDate);
                                                        break;

                                                    case 5:
                                                        System.out.print("\nNuevo RFC: ");
                                                        String newRfc = string.nextLine();
                                                        femployeeToModify.setRfc(newRfc.toUpperCase());
                                                        break;

                                                    case 6:
                                                        System.out.print("\nNueva CURP: ");
                                                        String newCurp = string.nextLine();
                                                        femployeeToModify.setCurp(newCurp.toUpperCase());
                                                        break;

                                                    case 7:
                                                        System.out.print("\nNuevo salario: ");
                                                        double newSalary = doubleRead.nextDouble();
                                                        femployeeToModify.setSalary(newSalary);
                                                        break;

                                                    case 8:
                                                        System.out.print("\nNuevo rol: ");
                                                        String newRol = string.nextLine();
                                                        String oldRol = femployeeToModify.getRol(); // Guarda el rol actual del empleado
                                                        femployeeToModify.setRol(newRol);
                                                        // Verificar si el empleado cambió de rol de Mantenimiento a
                                                        // Guía o viceversa
                                                        if (oldRol.equalsIgnoreCase("Mantenimiento") && (newRol.equalsIgnoreCase("Guia") || newRol.equalsIgnoreCase("Guia"))) {
                                                            zoo.getMaintenance().remove(femployeeToModify); // Elimina al empleado de la lista de mantenimiento
                                                            zoo.getGuides().add(femployeeToModify); //  empleado a la lista de guías
                                                        } else if (oldRol.equalsIgnoreCase("Guia") && (newRol.equalsIgnoreCase("Mantenimiento"))) {
                                                            zoo.getGuides().remove(femployeeToModify); // Elimina al empleado de la lista de guías
                                                            zoo.getMaintenance().add(femployeeToModify); // Agrega al empleado a la lista de mantenimiento
                                                        }
                                                        break;
                                                        

                                                    case 9:
                                                        System.out.println("\nIngrese los nuevos horarios de trabajo (Dejar vacío si no trabaja ese día): ");
                                                        String[][] newSchedule = new String[2][7];
                                                        String[] days = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
                                                        for (int i = 0; i < 7; i++) {
                                                            System.out.println("\n---- " + days[i] + " ----\n");
                                                            System.out.print("Nuevas horas de trabajo (00:00-24:00): ");
                                                            newSchedule[0][i] = days[i];
                                                            newSchedule[1][i] = string.nextLine();
                                                        }
                                                        femployeeToModify.setSchedule(newSchedule);
                                                        break;

                                                    default:
                                                        System.out.println("\nOpción inválida.");
                                                        break;
                                                }
                                                System.out.println("\nEmpleado modificado exitosamente.");
                                            } 
                                            else {
                                                System.out.println("\nEmpleado no encontrado.");
                                            }
                                            break;

                                        default:
                                            break;
                                    }
                                    break;
                            }
                            break;

                        case 15:
                            System.out.println("\n1. Eliminar Visitante");
                            System.out.println("2. Modificar Visitante");
                            System.out.print("\nIngrese opción: ");
                            decision = intRead.nextInt();
                            switch(decision) {
                                
                                case 1:
                                    System.out.print("\nIntroduce el ID del visitante que deseas eliminar: ");
                                    int deleteVisitor = intRead.nextInt();
                                    zoo.deleteVisitor(deleteVisitor);
                                    break;

                                case 2:
                                    System.out.println("\n1. Modificar todos los datos");
                                    System.out.println("2. Modificar un dato en especifico");
                                    System.out.print("\nIngrese opción: ");
                                    decision = intRead.nextInt();
                                    switch(decision) {

                                        case 1:
                                            System.out.println("\n---- Modificar visitante ----\n");
                                            System.out.print("Introduce el ID del visitante que deseas modificar: ");
                                            int modifyVisitorId = intRead.nextInt();
                                            Visitor VisitorModify = null;
                                            for(Visitor emp : zoo.getVisitors()) { // Cambiamos el nombre de la // variable employee
                                                if (emp.getId() == modifyVisitorId) { // Usamos el nuevo nombre de la// variable
                                                    VisitorModify = emp;
                                                    break;
                                                }
                                            }
                                            if(VisitorModify != null) {
                                                System.out.print("\nNuevo nombre: ");
                                                String newName = string.nextLine();
                                                System.out.print("Nuevo apellido: ");
                                                String newLastName = string.nextLine();
                                                System.out.print("Nueva fecha de nacimiento (DD-MM-YYYY): ");
                                                String newBirthdate = string.nextLine();
                                                System.out.print("Nueva fecha de ingreso (DD-MM-YYYY): ");
                                                String newAdmissionDate = string.nextLine();
                                                System.out.print("Nueva CURP: ");
                                                String newCurp = string.nextLine();  // Actualizar los datos del empleado
                                                VisitorModify.setName(newName);
                                                VisitorModify.setLastName(newLastName);
                                                VisitorModify.setBirthdate(newBirthdate);
                                                VisitorModify.setAdmissionDate(newAdmissionDate);
                                                VisitorModify.setCurp(newCurp.toUpperCase());
                                                System.out.println("\nVisitante modificado exitosamente.");
                                            } 
                                            else {
                                                System.out.println("\nVisitante no encontrado.");
                                            }
                                            break;

                                        case 2:
                                            System.out.println("\n---- Modificar visitante ----\n");
                                            System.out.print("Introduce el ID del visitante que deseas modificar: ");
                                            int modifyVisitorIdInput = intRead.nextInt();
                                            intRead.nextLine(); // Consumir la nueva línea después de leer el entero
                                            Visitor visitorToModify = null;     // Buscar visitante por ID
                                            for(Visitor fvisitor : zoo.getVisitors()) {
                                                if(fvisitor.getId() == modifyVisitorIdInput) {
                                                    visitorToModify = fvisitor;
                                                    break;
                                                }
                                            }
                                            if(visitorToModify != null) {   // Recopilar información actualizada del empleado
                                                System.out.println("\nSeleccione el campo que desea modificar:");
                                                System.out.println("\n1. Nombre");
                                                System.out.println("2. Apellidos");
                                                System.out.println("3. Fecha de nacimiento");
                                                System.out.println("4. Fecha de Ingreso");
                                                System.out.println("5. CURP");
                                                System.out.print("\nIngrese opción: ");
                                                decision = intRead.nextInt();
                                                switch(decision) {

                                                    case 1:
                                                        System.out.print("\nNuevo nombre: ");
                                                        String newName = string.nextLine();
                                                        visitorToModify.setName(newName);
                                                        break;

                                                    case 2:
                                                        System.out.print("\nNuevos apellidos: ");
                                                        String newLastName = string.nextLine();
                                                        visitorToModify.setLastName(newLastName);
                                                        break;

                                                    case 3:
                                                        System.out.print("\nNueva fecha de nacimiento (DD-MM-YYYY): ");
                                                        String newBirthdate = string.nextLine();
                                                        visitorToModify.setBirthdate(newBirthdate);
                                                        break;

                                                    case 4:
                                                        System.out.print("\nNueva fecha de ingreso (DD-MM-YYYY): ");
                                                        String newAdmissionDate = string.nextLine();
                                                        visitorToModify.setAdmissionDate(newAdmissionDate);
                                                        break;

                                                    case 5:
                                                        System.out.print("\nNueva CURP: ");
                                                        String newCurp = string.nextLine();
                                                        visitorToModify.setCurp(newCurp.toUpperCase());
                                                        break;

                                                    default:
                                                        System.out.println("\nOpción inválida.");
                                                        break;
                                                }
                                                System.out.println("\nVisitante modificado exitosamente.");
                                            } 
                                            else {
                                                System.out.println("\nVisitante no encontrado.");
                                            }
                                            break;
                                            
                                        default:
                                            break;
                                    }
                            }
                            break;

                        case 16:
                            y = 16;
                            // Opcion.- Salir
                            break;

                    }

                } while (option != 16);
            }
            else {
                System.out.println("\nContraseña incorrecta");
                System.out.println("\n1. Intentar de nuevo");
                System.out.println("2. Salir");
                System.out.print("\nIngrese opción: ");
                y = intRead.nextInt();
            }
        }
        System.out.println("\nSaliendo del programa.... ¡Hasta luego!\n");
    }
}

