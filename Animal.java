import java.util.ArrayList;

class Animal {

    //private Zoo zoo = new Zoo();
    private int animalId;
    private String animalType, birthdate, arrivalDate, feedingFrequency, feedingType;;
    private ArrayList<String> diseases = new ArrayList<String>();
    private boolean hasVaccines;
    private double weight;

    public Animal(String typeAnimal, String arrivalDate, String feedingType, String birthdate, double weight, String feedingFrequency, boolean hasVaccines, int id) {
        this.animalType = typeAnimal;
        this.birthdate = birthdate;
        this.arrivalDate = arrivalDate;
        this.weight = weight;
        this.feedingFrequency = feedingFrequency;
        this.feedingType = feedingType;
        this.hasVaccines = hasVaccines;
        this.animalId = id;
    }

    // Getters y Setters

    String getAnimalType() {
        return animalType;
    }

    void setDiseases(String disease){ //lista de enferemedades
        diseases.add(disease);
    }

    int getAnimalId(){
        return animalId;
    }

    void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    String getData(){
        if (diseases.isEmpty()){
            return String.format("Animal ID: %d \nTipo de Animal: %s \nFecha de nacimiento: %s \nFecha de ingreso: %s \nPeso: %.2f kg \nEnfermedades: No diseases \nFrecuencia de alimentación: %s \nTipo de alimentación: %s \nCuenta con vacunas: %s\n",
             animalId, animalType, birthdate, arrivalDate, weight, feedingFrequency, feedingType, hasVaccines);
        }
        else{
            return String.format("Animal ID: %s \nTipo de Animal: %s \nFecha de nacimiento: %s \nFecha de ingreso: %s \nPeso: %.2f kg \nEnfermedades: %s \nFrecuencia de alimentación: %s \nTipo de alimentación: %s \nCuenta con vacunas: %b\n",
             animalId, animalType, birthdate, arrivalDate, weight, diseases, feedingFrequency, feedingType, hasVaccines);
        }
    }
        
}
