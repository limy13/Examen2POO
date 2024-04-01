class Visitor {

    //private Zoo zoo = new Zoo();
    private String name, lastName, birthdate, curp, admissionDate;
    private int numberVisits = 0, id, descuento; //NO PODEMOS INGRESAR VISITAS AHORA
    
    public Visitor (String name, String lastName, String birthdate, String curp, String admissionDate, int id) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.curp = curp;
        this.admissionDate = admissionDate;
        this.id = id;
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
        String[] parts = birthdate.split("-");
        return Integer.parseInt(parts[2]);
    }

    int getBirthdate(){
        String date;
        String[] parts = birthdate.split("-");
        date = parts[1]+parts[0];
        return Integer.parseInt(date);
    }

    //CAMBIOS EN EL GET DATA
    String visitorGetData() { //datos de visitante
        return String.format("\nNombre: %s %s \nID: %d \nFecha de nacimiento: %s \nCURP: %s \nNúmero de visitas: %d \nFecha de ingreso: %s", 
            this.name, this.lastName, this.id, this.birthdate, this.curp, this.numberVisits, this.admissionDate);
    }

}
