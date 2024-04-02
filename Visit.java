import java.util.ArrayList;
import java.util.Scanner;

class Visit {

    //CLASE SOLO PARA LIZETH

    
    Scanner intRead = new Scanner(System.in);
    Scanner string = new Scanner(System.in);
    private ArrayList<Employee> guides = new ArrayList<Employee>(); //contiene los empleaods guias
    private ArrayList<Visitor> visitortoVisitors = new ArrayList<Visitor>(); // contiene a los visitantes
    private ArrayList<Visitor> visitorsToAdd = new ArrayList<Visitor>(); // contiene a los visitantes para agregar sus visitas
    private ArrayList<String> visitors = new ArrayList<String>(); // contiene a los personas que estan realizando la visita
    private String visitDate, visitHour, guide, visitDay;
    private double totalprice, price;
    private Employee guideDeleted;
    private boolean progress = false; //CAMBIOS AQUI
    private int kids = 0, adults = 0, age, id, guideId;
    private String [][] guideSchedule;

    public Visit(ArrayList<Visitor> visitorsList, ArrayList<Employee> guides) { //CAMBIOS AQUI
        this.visitortoVisitors = visitorsList;
        this.guides = guides;
    }

    int getAgeVisitDate() { //obtiene el año de la fecha de nacimiento
        String[] parts = visitDate.split("-");
        return age = Integer.parseInt(parts[2]);
    }

    int getBirthdate(){
        String date;
        String[] parts = visitDate.split("-");
        date = parts[1] + parts[0];
        return Integer.parseInt(date);
    }
    
    boolean addVisitors() {
        int age;
        boolean band1 = false;
        System.out.println("\n---- Datos de la visita ----\n");
        System.out.print("Día de la semana en la que se realiza la visita: ");
        visitDay = string.nextLine();
        if(visitDay.equalsIgnoreCase("Miercoles")) {
            visitDay = "Miércoles";
        }
        else if(visitDay.equalsIgnoreCase("Sabado")) {
            visitDay = "Sábado";
        }
        System.out.print("Fecha de la visita (DD-MM-YYYY): ");
        visitDate = string.nextLine();
        System.out.print("Hora de inicio la visita (00:00): ");
        visitHour = string.nextLine();
        if(addGuide(visitDay, visitHour) == true) {
        int decision;
            do {
                boolean band = false;
                System.out.print("\nIngresa ID del visitante que quieres agregar: "); //CAMBIOS AQUI
                int id = intRead.nextInt();
                for (Visitor i : visitortoVisitors) {
                    if (id == i.getId()) {
                        String x = String.format("\nNombre: %s %s \nID: %d", i.getName(), i.getLastName(), i.getId());
                        visitors.add(x);
                        band = true;
                        age = getAgeVisitDate() - 11;
                        visitorsToAdd.add(i);
                        if (i.getAgeBirthdate() < age) { //adultos
                            if (getBirthdate() < i.getBirthdate()) { //por si nacio ese año y todavia es un niño
                                kids++;
                                if (i.getNumberVisits() == 4) { //por si tienen 5 visitas
                                    price = 50 - 10;
                                }
                                else {   
                                    price = 50;
                                }                                       
                            }
                            else {              //adultos definitivos
                                adults++;       
                                if (i.getNumberVisits() == 4) { //si tiene 5 visitas
                                    price = 100 - 20;
                                }
                                else {
                                    price = 100;
                                }
                            }       
                        }
                        else {
                            kids++;
                            if (i.getNumberVisits() == 4) { //por si tienen 5 visitas
                                price = 50 - 10;
                            }
                            else {   
                                price = 50;
                            }                                       
                        }   
                        totalprice = totalprice + price;
                    }
                }
                if (band == false) {
                    System.out.println("\nEste ID no pertenece a ningún visitante\n");
                }
                System.out.print("\n¿Agregar otro visitante? (1 = si), (2 = no): ");
                decision = intRead.nextInt();
            }
            while (decision == 1); //CAMBOS AQUI
            System.out.print("\n¿Cancelar visita? (1 = si), (2 = no): ");
            decision = intRead.nextInt();
            if(decision == 1){
                System.out.println("\nVisita cancelada"); //CAMCIOS AQUI
            }
            else {
                band1 = true;
                for (Visitor x : visitorsToAdd) { //CAMBIOS AQUI
                    x.addNumberVisits();
                }
            }
        }
        else {
            System.out.println("\nNo hay guías disponibles en este momento");
        }
        return band1;
    }

    boolean addGuide(String visitDay, String visitHour) { //MODIFICAR EL ARRAY
        boolean band = false;
        if(guides.isEmpty() == false) {
            for(Employee i : guides) {
                guideSchedule = i.getSchedule();
                for(int x = 0; x < 7; x++) {
                    if(visitDay.equalsIgnoreCase(guideSchedule[0][x])) {
                        boolean band1 = true;
                        if (guideSchedule[1][x].isEmpty() == false) {
                            if(getVisitHour(visitHour) >= getHours(guideSchedule[1][x], band1) && getVisitHour(visitHour) <= getHours(guideSchedule[1][x], band1 = false)) { //puede fallar en la condicion
                                guideId = i.getId();
                                guide = String.format("%s %s \nID del guía: %d",  i.getName(), i.getLastName(), guideId);   
                                guideDeleted = i;
                                band = true;
                            } 
                        }
                    }
                }
            }
        }
        return band;
    }

    int getVisitHour(String hour) { 
        String [] parts = hour.split(":");
        return Integer.parseInt(parts[0] + parts[1]);
    }

    int getHours(String schedule, boolean band) {
        String hour, hour1, hour2;
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
                hour = String.valueOf(60 - (30 - Integer.parseInt(hour2Parts[1]))); //podria fallar esto
                hour2Parts[0] = String.valueOf(Integer.parseInt(hour2Parts[0]) - 1);
                if (hour2Parts[0].length() == 1) {
                    hour2Parts[0] = "0" + hour2Parts[0];
                }
                finalHour = Integer.parseInt(hour2Parts[0] + hour);
            }
            else {
                hour = String.valueOf(Integer.parseInt(hour2Parts[1]) - 30);
                if (hour.length() == 1) { //podria fallar el length
                    hour = "0" + hour;
                }
                finalHour = Integer.parseInt(hour2Parts[0] + hour);                     //necesito poner paraque sean 2 digitos porque me puede dar 4
            }
            return finalHour;
        }
    }

    int getGuideId() {
        return guideId;
    }

    Employee getGuideDeleted() {
        return guideDeleted;
    }

    int getVisitId() {
        return id;
    }

    void printVisitors() {
        for (String i : visitors) {
            System.out.println(i);
        }
    }

    void setId(int visitId) { //CAMBIOS AQUI
        id = visitId;
    }

    void setProgress(boolean band) {
        this.progress = band;
    }

    void getVisitData() {   
        System.out.println("Fecha de la visita: " + this.visitDay + " " + this.visitDate);
        System.out.println("Hora de la visita: " + this.visitHour);
        System.out.println("ID: " + this.id);                           //CAMBIOS AQUI
        System.out.println("Finalizada: " + this.progress); //CAMBIOS AQUU
        System.out.println("Cantidad de niños: " + this.kids);
        System.out.println("Cantidad de adultos: " + this.adults);
        System.out.println("Guía: " + this.guide);
        System.out.println("Precio total: " + this.totalprice + " MX");
        System.out.println("\n---- Visitantes ----");
        printVisitors();   
    }
}

