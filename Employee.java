class Employee {
  
    private Zoo zoo = new Zoo();
    private String name, lastName, birthdate, admissionDate, rfc, curp, schedule, rol;
    private double salary;
    private int id;
    
    public Employee(String name, String lastName, String birthdate, String dateAdmission, String rfc, String curp, double salary, String schedule, String rol) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.admissionDate = dateAdmission;
        this.rfc = rfc;
        this.curp = curp;
        this.salary = salary;
        this.schedule = schedule;
        this.rol = rol;
        this.id = zoo.getEmployeeId();
    }

    int getId(){ //obtiene id
        return id;
    }

    String getRol(){
        return rol;
    }
    
    String employeeGetData(){ //datos de empleado 
        return String.format("Nombre: %s %s \nID: %d \nFecha de nacimiento: %s \nFecha de ingreso: %s \nRFC: %s \nCURP: %s \nSalario: %.2f \nHorario: %s \nRol: %s",
            this.name, this.lastName, this.id, this.birthdate, this.admissionDate, this.rfc, this.curp, this.salary, this.schedule, this.rol);
    }
}
    

