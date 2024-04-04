import java.util.ArrayList;
import java.util.Scanner;

class Maintenance {
    
    private Scanner string = new Scanner (System.in);
    private Scanner intRead = new Scanner (System.in);
    private String day, date, activity, observations, employee, hour, animal;
    private int animalId, employeeId, id;
    private ArrayList<Employee> maintenance = new ArrayList<>();
    private ArrayList<Animal> animals = new ArrayList<>();
    private Employee maintenanceDeleted;
    private String [][] maintenanceSchedule;
    private boolean band2 = false, progress = false;

    public Maintenance(ArrayList<Employee> maintenance, ArrayList<Animal> animals) {
        this.maintenance = maintenance;
        this.animals = animals;
    }

    void addMainteance() {
        System.out.println("\n---- Datos sobre el mantenimiento ----\n");
        System.out.print("Día de la semana en la que se aplica el proceso: ");
        day = string.nextLine();
        if(day.equalsIgnoreCase("Miercoles")) {
            day = "Miércoles";
        }
        else if(day.equalsIgnoreCase("Sabado")) {
            day = "Sábado";
        }
        System.out.print("Fecha en que se aplica el proceso (DD-MM-YYYY): ");
        date = string.nextLine();
        System.out.print("Hora de inicio del mantenimiento (00:00): ");
        hour = string.nextLine();
        if(addMaintenenceEmployee() == false) {
            return;
        }
        System.out.print("ID del animal al que se le realiza el mantenimiento: ");
        id = intRead.nextInt();
        boolean band = false;
        for(Animal i : animals) {
            if (id == i.getAnimalId()) {
                animal = String.format("%s \nID del animal: %d", i.getAnimalType(), id);
                band = true;
            }
        }
        if (band == false) {
            System.out.println("\nEste ID no pertenece a ningún animal");
            return;
        }
        System.out.print("Nombre del proceso a realizar: ");
        activity = string.nextLine();
        System.out.print("¿Observaciones? (1 = si), (2 = no): ");
        int decision = intRead.nextInt();
        if (decision == 1) {
            System.out.print("\nDescriba sus observaciones: ");
            observations = string.nextLine();
        }
        else {
            observations = "No hay observaciones";
        } 
        System.out.print("\n¿Cancelar registro? (1 = si), (2 = no): ");
        decision = intRead.nextInt();
        if(decision == 1) {
            System.out.println("\nRegistro cancelado"); //CAMBIOS AQUI
            return;
        }
        else {
            band2 = true;
        }
    }

    boolean addMaintenenceEmployee() { //MODIFICAR EL ARRAY
        boolean band = false;
        if(maintenance.isEmpty() == false) {
            for(Employee i : maintenance) {
                maintenanceSchedule = i.getSchedule();
                for(int x = 0; x < 7; x++) {
                    if(day.equalsIgnoreCase(maintenanceSchedule[0][x])) {
                        boolean band1 = true;
                        if (maintenanceSchedule[1][x].isEmpty() == false) {
                            if( getMaintenanceHour() >= getHours(maintenanceSchedule[1][x], band1) && getMaintenanceHour() <= getHours(maintenanceSchedule[1][x], band1 = false)) { 
                                employeeId = i.getId();
                                employee = String.format("%s %s \nID del empleado encargado: %d",  i.getName(), i.getLastName(), employeeId);   
                                maintenanceDeleted = i;
                                band = true;
                            } 
                        }
                    }
                }
            }
        }
        if (band == false) {
            System.out.println("\nNo hay empleados de mantenimiento disponibles en este momento");
        }
        return band;
    }

    void setProgress(boolean band) {
        progress = band;
    }

    int getEmployeeId() {
        return employeeId;
    }

    Employee getMaintenanceDeleted() {
        return maintenanceDeleted;
    }

    int getMaintenanceHour() { 
        String [] parts = hour.split(":");
        return Integer.parseInt(parts[0] + parts[1]);
    }

    void setId(int id) {
        this.id = id;
    }

    int getId() {
        return id;
    }

    boolean getBand() {
        return band2;
    }

    int getHours(String schedule, boolean band) {
        String hour3, hour1, hour2;
        int startHour, finalHour;
        String[] parts = schedule.split("-");
        hour1 = parts[0];
        hour2 = parts[1];
        String[] hour1Parts = hour1.split(":");
        startHour = Integer.parseInt(hour1Parts[0] + hour1Parts[1]);
        String[] hour2Parts = hour2.split(":");
        if (band == true) {
            return startHour;
        }
        else{
            if (Integer.parseInt(hour2Parts[1]) == 30) {
                hour2Parts[1] = "00";
                finalHour = Integer.parseInt(hour2Parts[0] + hour2Parts[1]);
            } 
            else if (Integer.parseInt(hour2Parts[1]) < 30) {
                hour3 = String.valueOf(60 - (30 - Integer.parseInt(hour2Parts[1]))); 
                hour2Parts[0] = String.valueOf(Integer.parseInt(hour2Parts[0]) - 1);
                if (hour2Parts[0].length() == 1) {
                    hour2Parts[0] = "0" + hour2Parts[0];
                }
                finalHour = Integer.parseInt(hour2Parts[0] + hour3);
            }
            else {
                hour3 = String.valueOf(Integer.parseInt(hour2Parts[1]) - 30);
                if (hour3.length() == 1) { 
                    hour3 = "0" + hour3;
                }
                finalHour = Integer.parseInt(hour2Parts[0] + hour3);                   
            }
            return finalHour;
        }
    }

    String getData() {
        return String.format("Fecha en que se aplicó el proceso: %s %s \nHora de inicio del mantenimiento: %s"
        + "\nID del mantenimiento: %d \nEspecie: %s \nEmpleado encargado del mantenimiento: %s \nProceso que se realizó: %s \nFinalizado: %b \nObservaciones: %s",
        this.day, this.date, this.hour, this.id, this.animal, this.employee, this.activity, this.progress, this.observations);
    }
}
