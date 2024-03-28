import java.util.ArrayList;
import java.util.Scanner;

class Visit {

    //CLASE SOLO PARA LIZETH
    
    Scanner intRead = new Scanner(System.in);
    Scanner string = new Scanner(System.in);
    private Zoo zoo = new Zoo();
    private ArrayList<Employee> guides = new ArrayList<Employee>(); //contiene los empleaods guias
    private ArrayList<Visitor> visitor = new ArrayList<Visitor>(); // contiene a los visitantes
    private ArrayList<String> visitors = new ArrayList<String>(); // contiene a los personas que estan realizando la visita
    private String visitDate;
    private double totalprice, price;
    private int kids = 0, adults = 0, age;

    int getAgeVisitDate() { //obtiene el año de la fecha de nacimiento
        String[] parts = visitDate.split("-");
        return age = Integer.parseInt(parts[3]);
    }

    int getBirthdate(){
        String date;
        String[] parts = visitDate.split("-");
        date = parts[2]+parts[1];
        return Integer.parseInt(date);
    }
    
    void addVisitors() {
        guides = zoo.getGuides();
        visitor = zoo.getVisitors();
        int age;
        System.out.print("Fecha de la visita (DD-MM-YYYY): ");
        visitDate = string.nextLine();
        boolean band = false;
        int decision;
        
        do {
            System.out.print("Ingresa ID del visitante: ");
            int id = intRead.nextInt();
            for (Visitor i : visitor) {
                if (id == i.getId()) {
                    String x = String.format("Nombre: %s %s \nID: %d", i.getName(), i.getLastName(), i.getId());
                    visitors.add(x);
                    band = true;
                    age = getAgeVisitDate() - 11;
                    i.addNumberVisits();
                    if (i.getAgeBirthdate() < age) { //adultos
                        if (getBirthdate() < i.getBirthdate()) { //por si nacio ese año y todavia es un niño
                            kids++;
                            if (i.getNumberVisits() == 5) { //por si tienen 5 visitas
                                price = 50 - (50 * .2);
                                totalprice = totalprice + price;
                            }
                            else {   
                                price = 50;
                                totalprice = totalprice + price;
                            }                                       
                        }
                        else {              //adultos definitivos
                            adults++;       
                            if (i.getNumberVisits() == 5) { //si tiene 5 visitas
                                price = 100 - (100 * .2);
                                totalprice = totalprice + price;
                            }
                            else {
                                price = 100;
                                totalprice = totalprice + price;
                            }
                        }       
                    }
                    else {
                        kids++;
                        if (i.getNumberVisits() == 5) { //por si tienen 5 visitas
                            price = 50 - (50 * .2);
                            totalprice = totalprice + price;
                        }
                        else {   
                            price = 50;
                            totalprice = totalprice + price;
                        }                                       
                    }
                }
            }
            if (band == false) {
                System.out.println("\nEste ID no pertenece a ningún visitante o este visitante ya está de visita\n");
            }
            System.out.println("\n¿Agregar otro visitante? (1 = si): ");
            decision = intRead.nextInt();
        }
        while (decision == 1);
    }
}

