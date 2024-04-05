class Visit:
    def __init__(self, visitorsList, guides): 
        self.guides = guides
        self.visitortoVisitors = visitorsList
        self.visitorsToAdd = []
        self.visitors = []
        self.visitDate = ""
        self.visitHour = ""
        self.visitDay = ""
        self.totalprice = 0
        self.price = 0
        self.guide = ""
        self.progress = False
        self.kids = 0
        self.adults = 0
        self.age = 0
        self.id = 0
        self.guideId = 0
        self.guideSchedule = []

    def getAgeVisitDate(self): 
        parts = self.visitDate.split("-")
        return int(parts[2])

    def getBirthdate(self):
        parts = self.visitDate.split("-")
        date = parts[1] + parts[0]
        return int(date)

    def addVisitors(self): 
        band1 = False
        print("\n---- Datos de la visita ----\n")
        visitDay = input("Día de la semana en la que se realiza la visita: ")
        if visitDay.lower() == "miercoles":
            visitDay = "Miércoles"
        elif visitDay.lower() == "sabado":
            visitDay = "Sábado"
        self.visitDay = visitDay
        self.visitDate = input("Fecha de la visita (DD-MM-YYYY): ")
        self.visitHour = input("Hora de inicio la visita (00:00): ")
        if self.addGuide(visitDay, self.visitHour):
            decision = 0
            while decision == 0:
                id = int(input("Ingresa ID del visitante que quieres agregar: "))
                for visitor in self.visitortoVisitors:
                    if id == visitor.getId():
                        x = f"\nNombre: {visitor.getName()} {visitor.getLastName()} \nID: {visitor.getId()}"
                        self.visitors.append(x)
                        self.visitorsToAdd.append(visitor)
                        age = self.getAgeVisitDate() - 11
                        if visitor.getAgeBirthdate() < age: 
                            if self.getBirthdate() < visitor.getBirthdate(): 
                                self.kids += 1
                                self.price = 50 - 10 if visitor.getNumberVisits() == 4 else 50
                            else:              
                                self.adults += 1       
                                self.price = 100 - 20 if visitor.getNumberVisits() == 4 else 100
                        else:
                            self.kids += 1
                            self.price = 50 - 10 if visitor.getNumberVisits() == 4 else 50
                        self.totalprice += self.price
                        break
                else:
                    print("\nEste ID no pertenece a ningún visitante\n")
                decision = int(input("\n¿Agregar otro visitante? (1 = si), (2 = no): "))
            decision = int(input("\n¿Cancelar visita? (1 = si), (2 = no): "))
            if decision == 1:
                print("\nVisita cancelada")
            else:
                band1 = True
                for x in self.visitorsToAdd:
                    x.addNumberVisits()
        else:
            print("\nNo hay guías disponibles en este momento")
        return band1

    def addGuide(self, visitDay, visitHour): 
            band = False
            if self.guides:
                for guide in self.guides:
                    self.guideSchedule = guide.get_schedule()
                    for x in range(7):
                        if visitDay.lower() == self.guideSchedule[0][x].lower():
                            if self.guideSchedule[1][x]:
                                if self.getVisitHour(visitHour) >= self.getHours(self.guideSchedule[1][x], True) and self.getVisitHour(visitHour) <= self.getHours(self.guideSchedule[1][x], False):
                                    self.guideId = guide.getId()
                                    self.guide = f"{guide.getName()} {guide.getLastName()} \nID del guía: {self.guideId}"
                                    self.guideDeleted = guide
                                    band = True
            return band


    def getVisitHour(self, hour): 
            parts = hour.split(":")
            if len(parts) >= 2:  # Verificar que la lista tenga al menos 2 elementos
                return int(parts[0] + parts[1])
            else:
                # Manejar el caso en el que la cadena no tenga el formato esperado
                print("Error: Formato de hora incorrecto")
                return None  # O devuelve un valor predeterminado según sea necesario

    def getHours(self, schedule, band): 
        hour1, hour2 = schedule.split("-")
        startHour = int(hour1)
        if band:
            return startHour
        else:
            parts = hour2.split(":")
            if int(parts[1]) == 30:
                hour2 = parts[0] + "00"
                finalHour = int(hour2)
            elif int(parts[1]) < 30:
                hour = str(60 - (30 - int(parts[1]))).zfill(2)
                hour2Parts = str(int(parts[0]) - 1).zfill(2)
                finalHour = int(hour2Parts + hour)
            else:
                hour = str(int(parts[1]) - 30).zfill(2)
                finalHour = int(parts[0] + hour)
            return finalHour


    def getGuideId(self): 
        return self.guideId

    def getGuideDeleted(self): 
        return self.guideDeleted

    def getVisitId(self): 
        return self.id

    def printVisitors(self): 
        for visitor in self.visitors:
            print(visitor)

    def setId(self, visitId): 
        self.id = visitId

    def setProgress(self, band): 
        self.progress = band

    def getVisitData(self): 
        print(f"Fecha de la visita: {self.visitDay} {self.visitDate}")
        print(f"Hora de la visita: {self.visitHour}")
        print(f"ID: {self.id}") 
        print(f"Finalizada: {self.progress}") 
        print(f"Cantidad de niños: {self.kids}")
        print(f"Cantidad de adultos: {self.adults}")
        print(f"Guía: {self.guide}")
        print(f"Precio total: {self.totalprice} MX")
        print("\n---- Visitantes ----")
        self.printVisitors() 
