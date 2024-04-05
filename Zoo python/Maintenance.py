class Maintenance:
    def __init__(self, maintenance, animals):
        self.string = input
        self.intRead = int
        self.day = ""
        self.date = ""
        self.activity = ""
        self.observations = ""
        self.employee = ""
        self.hour = ""
        self.animal = ""
        self.animalId = 0
        self.employeeId = 0
        self.id = 0
        self.maintenance = maintenance
        self.animals = animals
        self.maintenanceDeleted = None
        self.guideSchedule = []
        self.band2 = False
        self.progress = False

    def addMainteance(self):
        print("\n---- Datos sobre el mantenimiento ----\n")
        self.day = input("Día de la semana en la que se aplica el proceso: ")
        if self.day.lower() == "miercoles":
            self.day = "Miércoles"
        elif self.day.lower() == "sabado":
            self.day = "Sábado"
        self.date = input("Fecha en que se aplica el proceso (DD-MM-YYYY): ")
        self.hour = input("Hora de inicio del mantenimiento (00:00): ")
        if not self.addMaintenenceEmployee():
            return
        self.animalId = int(input("ID del animal al que se le realiza el mantenimiento: "))
        band = False
        for animal in self.animals:
            if self.animalId == animal.getAnimalId():
                self.animal = f"{animal.getAnimalType()} \nID del animal: {self.animalId}"
                band = True
                break
        if not band:
            print("\nEste ID no pertenece a ningún animal")
            return
        self.activity = input("Nombre del proceso a realizar: ")
        decision = int(input("¿Observaciones? (1 = si), (2 = no): "))
        if decision == 1:
            self.observations = input("\nDescriba sus observaciones: ")
        else:
            self.observations = "No hay observaciones"
        decision = int(input("\n¿Cancelar registro? (1 = si), (2 = no): "))
        if decision == 1:
            print("\nRegistro cancelado")
            return
        else:
            self.band2 = True

    def addMaintenenceEmployee(self):
        band = False
        if self.maintenance:
            for employee in self.maintenance:
                self.guideSchedule = employee.getSchedule()
                for x in range(7):
                    if self.day.lower() == self.guideSchedule[0][x].lower():
                        band1 = True
                        if self.guideSchedule[1][x]:
                            if self.getMaintenanceHour() >= self.getHours(self.guideSchedule[1][x], band1) and self.getMaintenanceHour() <= self.getHours(self.guideSchedule[1][x], band1):
                                self.employeeId = employee.getId()
                                self.employee = f"{employee.getName()} {employee.getLastName()} \nID del empleado encargado: {self.employeeId}"
                                self.maintenanceDeleted = employee
                                band = True
        if not band:
            print("\nNo hay empleados de mantenimiento disponibles en este momento")
        return band

    def setProgress(self, band):
        self.progress = band

    def getEmployeeId(self):
        return self.employeeId

    def getMaintenanceDeleted(self):
        return self.maintenanceDeleted

    def getMaintenanceHour(self):
        parts = self.hour.split(":")
        return int(parts[0] + parts[1])

    def setId(self, id):
        self.id = id

    def getId(self):
        return self.id

    def getBand(self):
        return self.band2

    def getHours(self, schedule, band):
        hour3 = ""
        hour1, hour2 = schedule.split("-")
        hour1Parts = hour1.split(":")
        startHour = int(hour1Parts[0] + hour1Parts[1])
        hour2Parts = hour2.split(":")
        if band:
            return startHour
        else:
            if int(hour2Parts[1]) == 30:
                hour2Parts[1] = "00"
                finalHour = int(hour2Parts[0] + hour2Parts[1])
            elif int(hour2Parts[1]) < 30:
                hour3 = str(60 - (30 - int(hour2Parts[1])))
                hour2Parts[0] = str(int(hour2Parts[0]) - 1)
                if len(hour2Parts[0]) == 1:
                    hour2Parts[0] = "0" + hour2Parts[0]
                finalHour = int(hour2Parts[0] + hour3)
            else:
                hour3 = str(int(hour2Parts[1]) - 30)
                if len(hour3) == 1:
                    hour3 = "0" + hour3
                finalHour = int(hour2Parts[0] + hour3)
            return finalHour

    def getData(self):
        return f"Fecha en que se aplicó el proceso: {self.day} {self.date} \nHora de inicio del mantenimiento: {self.hour}" \
               f"\nID del mantenimiento: {self.id} \nEspecie: {self.animal} \nEmpleado encargado del mantenimiento: {self.employee}" \
               f"\nProceso que se realizó: {self.activity} \nFinalizado: {self.progress} \nObservaciones: {self.observations}"
