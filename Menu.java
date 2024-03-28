import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        
        Scanner string = new Scanner(System.in); //scanner strings
        Scanner doubleRead = new Scanner (System.in); //scanner double
        Scanner intRead = new Scanner (System.in); //scanner int
        Zoo zoo = new Zoo(); //acceso a la clase Zoo
        int option, id;

        do {
            System.out.println("\n");
            System.out.println("*** BIENVENIDO AL PROGRAMA ***\n");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Mostrar informacion de empleados");
            System.out.println("3. Registrar visitante");
            System.out.println("4. Mostrar informacion del visitante");
            System.out.println("5. Registrar visita al zoo");
            System.out.println("6. Registrar animal");
            System.out.println("7. Mostrar informacion del animal");
            System.out.println("8. Realizar mantenimiento de animal");
            System.out.println("9. Salir");
            System.out.print("\nIngrese opción: ");
            option = intRead.nextInt();
            System.out.println("\n");

            switch (option) {

                case 1:
                    // Aqui seria la opcion 1.- Registrar empleado
                    System.out.println("\n---- Employee information ----\n");
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
                    System.out.print("Horario (Dias y horas): ");
                    String schedule = string.nextLine();
                    System.out.print("Rol: ");
                    String rol = string.nextLine();
                    // Crear el objeto empleado con los datos ingresados y agregarlo al ArrayList
                    Employee employee = new Employee(name, lastName, birthdate, admissionDate, rfc.toUpperCase(), curp.toUpperCase(),
                            salary, schedule, rol);
                    zoo.addEmployee(employee); // agrega al empleado
                    break;
                    
                case 2:
                    // mostrar info de todos los empleados 
                    System.out.println("\n1. Show employees info"); //mostrar todos los empleados
                    System.out.println("2. Consult employee"); // mostrar un empleado en especifico
                    System.out.print("\nChoose a option: ");
                    int decision = intRead.nextInt();
                    if (decision == 1){
                        zoo.showEmployees();
                    }
                    else{
                        System.out.print("\nEnter the ID of the employee you want to consult: ");
                        id = intRead.nextInt();
                        zoo.consultEmployee(id);
                    }
                    break;

                case 3:
   
                    // Aqui seria la opcion 3.- Registrar visitante
                    System.out.println("\n---- Visitor information ----\n");
                    System.out.print("Name: ");
                    name = string.nextLine();
                    System.out.print("Last name: ");
                    lastName = string.nextLine();
                    System.out.print("Birthdate (DD-MM-YYYY): ");
                    birthdate = string.nextLine();
                    System.out.print("CURP: ");
                    curp = string.nextLine();
                    System.out.print("Admission date (DD-MM-YYYY): ");
                    admissionDate = string.nextLine();
                    Visitor visitor = new Visitor(name, lastName, birthdate, curp.toUpperCase(), admissionDate);
                    zoo.addVisitor(visitor);
                    break;

                case 4:
                
                    // Aqui seria la opcion 4.- Mostrar informacion del visitante

                    System.out.println("\n1. Show visitors info"); //mostrar todos los animales
                    System.out.println("2. Consult visitor"); // mostrar un animal en especifico
                    System.out.print("\nChoose a option: ");
                    decision = intRead.nextInt();
                    if (decision == 1) {
                        zoo.showVisitors();
                    }
                    else {
                        System.out.print("\nEnter the ID of the visitor you want to consult: ");
                        id = intRead.nextInt();
                        zoo.consultVisitor(id);
                    }
                    break;

                case 5:

                    // Aqui seria la opcion 5.- Registrar visita al zoo

                    Visit visit = new Visit();
                    visit.addVisitors();
                    zoo.addVisit(visit);
                    break;

                case 6:

                    // Aqui seria la opcion 6.- Registrar animal

                    System.out.println("\n---- Animal information ----\n");
                    System.out.print("Kind: ");
                    String kind = string.nextLine();
                    System.out.print("Arrival date (DD-MM-YYYY): ");
                    String arrivalDate = string.nextLine();
                    System.out.print("Type of food: ");
                    String typeFood = string.nextLine();
                    System.out.print("Birthdate (DD-MM-YYYY): ");
                    birthdate = string.nextLine();
                    System.out.print("Weight: ");
                    String weight = string.nextLine();
                    System.out.print("Feeding frequency: ");
                    String feedingFrequency = string.nextLine();
                    System.out.print("Vaccines? (1 = true): ");
                    decision = intRead.nextInt();
                    boolean vaccines = false; 
                    if (decision == 1){
                        vaccines = true;
                    }
                    Animal animal = new Animal(kind, arrivalDate, typeFood, birthdate, weight, feedingFrequency, vaccines);
                    System.out.print("Diseases? (1 = yes): "); //pregunta si tiene enfermedades en caso de no tenerlas
                    decision = intRead.nextInt();
                    if (decision == 1){
                        do{
                        System.out.print("Disease: "); 
                        String disease = string.nextLine();
                        animal.setDiseases(disease);
                        System.out.print("\nAdd another disease? (1 = yes): ");
                        decision = intRead.nextInt();
                        }
                        while (decision == 1); //while para agregar las enfermedades que quiera
                    }
                    zoo.addAnimal(animal);
                    break;

                case 7:

                    // Aqui seria la opcion 7.- Mostrar info animal

                    System.out.println("\n1. Show animals info"); //mostrar todos los animales
                    System.out.println("2. Consult animal"); // mostrar un animal en especifico
                    System.out.print("\nChoose a option: ");
                    decision = intRead.nextInt();
                    if (decision == 1){
                        zoo.showAnimals();
                    }
                    else{
                        System.out.print("\nEnter the ID of the animal you want to consult: ");
                        int animalId = intRead.nextInt();
                        zoo.consultAnimal(animalId);
                    }
                    break;

                case 8:
                    // Aqui seria la opcion 8.- Realizar mantenimiento del animal
                    
                    break;

                case 9:
                    System.out.println("\nSaliendo del programa.... ¡Hasta luego!");
                    System.out.println("\nLeaving the program.... See you later!\n");
                    // Opcion.- Salir
                    break;

            }

        } while (option != 9);
    }
}

