class Employee {
  
    private String name, lastName, birthdate, admissionDate, rfc, curp, rol;
    private String [][] schedule;
    private double salary;
    private int id;
    
    public Employee(String name, String lastName, String birthdate, String dateAdmission, String rfc, String curp, double salary, String [][] schedule, String rol, int id) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.admissionDate = dateAdmission;
        this.rfc = rfc;
        this.curp = curp;
        this.salary = salary;
        this.schedule = schedule;
        this.rol = rol;
        this.id = id;
    }

    String getName() {
        return name;
    }

    String getLastName() {
        return lastName;
    }

    int getId() { //obtiene id
        return id;
    }

    String getRol() {
        return rol;
    }

    String [][] getSchedule() {
        return schedule;
    }

    void printSchedule() {
        System.out.println("\n---- Horario ----\n");
        for(int x = 0; x < 7; x++) {
            System.out.println(schedule[0][x] + ": " + schedule[1][x]);
        }
    }

    void setId(int id) {
        this.id = id;
    }

    String employeeGetData() { //datos de empleado 
        return String.format("Nombre: %s %s \nID: %d \nFecha de nacimiento: %s \nFecha de ingreso: %s \nRFC: %s \nCURP: %s \nSalario: %.2f MX \nRol: %s",
            this.name, this.lastName, this.id, this.birthdate, this.admissionDate, this.rfc, this.curp, this.salary, this.rol);
    }
}
    

