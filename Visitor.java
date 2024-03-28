class Visitor {

    private Zoo zoo = new Zoo();
    private String name, lastName, birthdate, curp, admissionDate;
    private int numberVisits = 0, id, descuento; //NO PODEMOS INGRESAR VISITAS AHORA
    
    public Visitor (String name, String lastName, String birthdate, String curp, String admissionDate) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.curp = curp;
        this.admissionDate = admissionDate;
        this.id = zoo.getVisitorId();
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getLastName() {
        return lastName;
    }

    void addNumberVisits() {
        this.numberVisits++;
        this.descuento++;
        if (descuento == 6) {
            this.descuento = 1;
        }
    }

    int getNumberVisits() {
        return descuento;
    }

    int getAgeBirthdate() { //obtiene el año de la fecha de nacimiento
        int age;
        String[] parts = birthdate.split("-");
        return age = Integer.parseInt(parts[3]);
    }

    int getBirthdate(){
        String date;
        String[] parts = birthdate.split("-");
        date = parts[2]+parts[1];
        return Integer.parseInt(date);
    }

    String visitorGetData() { //datos de visitante
        return String.format("\nName: %s %s \nID: %d \nBirthdate: %s \nAdmission date: %s \nCURP: %s \nNumber of visits: %d \nAdmission date: %s",
            this.name, this.lastName, this.id, this.birthdate, this.admissionDate, this.curp, this.numberVisits, this.admissionDate);
    }

}
