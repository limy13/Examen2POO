import java.util.ArrayList;
import java.util.Scanner;

class Visit {

    //CLASE SOLO PARA LIZETH

    
    Scanner intRead = new Scanner(System.in);
    Scanner string = new Scanner(System.in);
    private ArrayList<Employee> guides = new ArrayList<Employee>(); //contiene los empleaods guias
    private ArrayList<Visitor> visitortVisitors = new ArrayList<Visitor>(); // contiene a los visitantes
    private ArrayList<String> visitors = new ArrayList<String>(); // contiene a los personas que estan realizando la visita
    private String visitDate, visitHour, guide, visitDay;
    private double totalprice, price;
    private Employee guideDeleted;
    //AGREGAR VARIABLE EN PROCESO
    private int kids = 0, adults = 0, age, id, guideId;
    private String [][] guideSchedule;

    public Visit(ArrayList<Visitor> visitorsList, ArrayList<Employee> guides, int id) {
        this.visitortVisitors = visitorsList;
        this.guides = guides;
        this.id = id;
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
        System.out.print("Fecha de la visita (DD-MM-YYYY): ");
        visitDate = string.nextLine();
        System.out.print("Hora de inicio la visita (00:00): ");
        visitHour = string.nextLine();
        if(addGuide(visitDay, visitHour) == true) {
        boolean band = false;
        int decision;

            do {
                System.out.print("Ingresa ID del visitante que quieres agregar: ");
                int id = intRead.nextInt();
                for (Visitor i : visitortVisitors) {
                    if (id == i.getId()) {
                        String x = String.format("\nNombre: %s %s \nID: %d", i.getName(), i.getLastName(), i.getId());
                        visitors.add(x);
                        band = true;
                        age = getAgeVisitDate() - 11;
                        i.addNumberVisits();
                        if (i.getAgeBirthdate() < age) { //adultos
                            if (getBirthdate() < i.getBirthdate()) { //por si nacio ese año y todavia es un niño
                                kids++;
                                if (i.getNumberVisits() == 5) { //por si tienen 5 visitas
                                    price = 50 - (50 * .2);
                                }
                                else {   
                                    price = 50;
                                }                                       
                            }
                            else {              //adultos definitivos
                                adults++;       
                                if (i.getNumberVisits() == 5) { //si tiene 5 visitas
                                    price = 100 - (100 * .2);
                                }
                                else {
                                    price = 100;
                                }
                            }       
                        }
                        else {
                            kids++;
                            if (i.getNumberVisits() == 5) { //por si tienen 5 visitas
                                price = 50 - (50 * .2);
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
                System.out.print("\n¿Agregar otro visitante? (1 = si): ");
                decision = intRead.nextInt();
            }
            while (decision == 1);
            System.out.println("\n---- Datos de la visita ----\n");
            getVisitData();
            System.out.print("\n¿Cancelar visita? (1 = yes): ");
            decision = intRead.nextInt();
            if(decision == 1){
                System.out.println("Visita cancelada");
            }
            else {
                band1 = true;
            }
        }
        else {
            System.out.println("\nNo hay guías disponibles en este momento");
        }
        return band1;
    }

    boolean addGuide(String visitDay, String visitHour) {
        boolean band = false;
        if(guides.isEmpty() == false) {
            for(Employee i : guides) {
                guideSchedule = i.getSchedule();
                for(int x = 0; x < 7; x++) {
                    if(visitDay.equalsIgnoreCase(guideSchedule[0][x])) {
                        boolean band1 = true;
                        if (guideSchedule[1][x].isEmpty() == false) {
                            if(geVisitHour(visitHour) >= getHours(guideSchedule[1][x], band1) && geVisitHour(visitHour) <= getHours(guideSchedule[1][x], band1 = false)) { //puede fallar en la condicion
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
        //if (band == true) {
         //   guides.remove(guideDeleted); //VER SI SI SE ELIMINAN
        //}
        return band;
    }

    int geVisitHour(String hour) { 
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

    void getVisitData() {   
        System.out.println("Fecha de la visita: " + this.visitDate);
        System.out.println("Hora de la visita: " + this.visitHour);
        System.out.println("Cantidad de niños: " + this.kids);
        System.out.println("Cantidad de adultos: " + this.adults);
        System.out.println("Guía: " + this.guide);
        System.out.println("Precio total: " + this.totalprice + " MX");
        System.out.println("\n---- Visitantes ----");
        printVisitors();   
    }
}

