class Visitor {

    private String name, lastName, birthdate, curp, admissionDate;
    private int numberVisits;
    
    public Visitor (String name, String lastName, String birthdate, String curp, int numberVisits, String admissionDate){
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.curp = curp;
        this.numberVisits = numberVisits; //NO PODEMOS INGRESAR VISITAS AHORA
        this.admissionDate = admissionDate;
    }

    String getCurp(){
        return curp;
    }

    String visitorGetData(){ //datos de visitante
        return String.format("Name: %s %s \nBirthdate: %s \nAdmission date: %s \nCURP: %s \nNumber of visits: %d \nAdmission date: %s",
            this.name, this.lastName, this.birthdate, this.admissionDate, this.curp, this.numberVisits, this.admissionDate);
    }

}
