class Employee:
    def __init__(self, name, last_name, birthdate, admission_date, rfc, curp, salary, schedule, rol, id):
        self.name = name
        self.last_name = last_name
        self.birthdate = birthdate
        self.admission_date = admission_date
        self.rfc = rfc
        self.curp = curp
        self.salary = salary
        self.schedule = schedule
        self.rol = rol
        self.id = id

    def get_name(self):
        return self.name

    def get_last_name(self):
        return self.last_name

    def get_id(self):
        return self.id

    def get_rol(self):
        return self.rol

    def get_schedule(self):
        return self.schedule

    def print_schedule(self):
        print("\n---- Horario ----\n")
        for x in range(7):
            print(self.schedule[0][x] + ": " + self.schedule[1][x])

    def set_id(self, id):
        self.id = id

    def set_name(self, name):
        self.name = name

    def set_last_name(self, last_name):
        self.last_name = last_name

    def set_birthdate(self, birthdate):
        self.birthdate = birthdate

    def set_admission_date(self, admission_date):
        self.admission_date = admission_date

    def set_rfc(self, rfc):
        self.rfc = rfc

    def set_curp(self, curp):
        self.curp = curp

    def set_salary(self, salary):
        self.salary = salary

    def set_schedule(self, schedule):
        self.schedule = schedule

    def set_rol(self, rol):
        self.rol = rol

    def employee_get_data(self):
        return f"Nombre: {self.name} {self.last_name} \nID: {self.id} \nFecha de nacimiento: {self.birthdate} \nFecha de ingreso: {self.admission_date} \nRFC: {self.rfc} \nCURP: {self.curp} \nSalario: {self.salary:.2f} MX \nRol: {self.rol}"
