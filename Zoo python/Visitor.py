class Visitor:
    def __init__(self, name, lastName, birthdate, curp, admissionDate, id):
        self.name = name
        self.lastName = lastName
        self.birthdate = birthdate
        self.curp = curp
        self.admissionDate = admissionDate
        self.id = id
        self.numberVisits = 0
        self.descuento = 0

    def getId(self):
        return self.id

    def getName(self):
        return self.name

    def getLastName(self):
        return self.lastName

    def addNumberVisits(self):
        self.numberVisits += 1
        self.descuento += 1
        if self.descuento == 6:
            self.descuento = 1

    def getNumberVisits(self):
        return self.descuento

    def getAgeBirthdate(self):
        parts = self.birthdate.split("-")
        return int(parts[2])

    def getBirthdate(self):
        parts = self.birthdate.split("-")
        date = parts[1] + parts[0]
        return int(date)

    def setId(self, id):
        self.id = id

    def setName(self, name):
        self.name = name

    def setLastName(self, lastName):
        self.lastName = lastName

    def setBirthdate(self, birthdate):
        self.birthdate = birthdate

    def setAdmissionDate(self, admissionDate):
        self.admissionDate = admissionDate

    def setCurp(self, curp):
        self.curp = curp

    def visitorGetData(self):
        return f"\nNombre: {self.name} {self.lastName} \nID: {self.id} \nFecha de nacimiento: {self.birthdate} \nCURP: {self.curp} \nNúmero de visitas: {self.numberVisits} \nFecha de ingreso: {self.admissionDate}"
