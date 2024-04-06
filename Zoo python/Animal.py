class Animal:
    def __init__(self, animalType, arrivalDate, feedingType, birthdate, weight, feedingFrequency, hasVaccines, animalId):
        self.animalType = animalType
        self.birthdate = birthdate
        self.arrivalDate = arrivalDate
        self.weight = weight
        self.feedingFrequency = feedingFrequency
        self.feedingType = feedingType
        self.hasVaccines = hasVaccines
        self.animalId = animalId
        self.diseases = []

    def getAnimalType(self):
        return self.animalType

    def addDisease(self, disease):
        self.diseases.append(disease)

    def getAnimalId(self):
        return self.animalId

    def setAnimalId(self, animalId):
        self.animalId = animalId

    def setTypeAnimal(self, typeAnimal):
        self.animalType = typeAnimal

    def setBirthdate(self, birthdate):
        self.birthdate = birthdate

    def setArrivalDate(self, arrivalDate):
        self.arrivalDate = arrivalDate

    def setWeight(self, weight):
        self.weight = weight

    def setFeedingFrequency(self, feedingFrequency):
        self.feedingFrequency = feedingFrequency

    def setFeedingType(self, feedingType):
        self.feedingType = feedingType

    def setHasVaccines(self, hasVaccines):
        self.hasVaccines = hasVaccines

    def setDiseases(self, diseases):
        self.diseases = diseases

    def getData(self):
        if not self.diseases:
            return f"Animal ID: {self.animalId} \nTipo de Animal: {self.animalType} \nFecha de nacimiento: {self.birthdate} \nFecha de ingreso: {self.arrivalDate} \nPeso: {self.weight:.2f} kg \nEnfermedades: Sin enfermedades \nFrecuencia de alimentación: {self.feedingFrequency} \nTipo de alimentación: {self.feedingType} \nCuenta con vacunas: {self.hasVaccines}\n"
        else:
            return f"Animal ID: {self.animalId} \nTipo de Animal: {self.animalType} \nFecha de nacimiento: {self.birthdate} \nFecha de ingreso: {self.arrivalDate} \nPeso: {self.weight:.2f} kg \nEnfermedades: {', '.join(self.diseases)} \nFrecuencia de alimentación: {self.feedingFrequency} \nTipo de alimentación: {self.feedingType} \nCuenta con vacunas: {self.hasVaccines}\n"
