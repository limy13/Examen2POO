import java.util.ArrayList;

class Animal {

    private Zoo zoo = new Zoo();
    private int animalId;
    private String typeAnimal, birthdate, arrivalDate, weight, feedingFrequency, feedingType;;
    private ArrayList<String> diseases = new ArrayList<String>();
    private boolean hasVaccines;

    public Animal(String typeAnimal, String arrivalDate, String feedingType, String birthdate, String weight, String feedingFrequency, boolean hasVaccines, int id) {
        this.typeAnimal = typeAnimal;
        this.birthdate = birthdate;
        this.arrivalDate = arrivalDate;
        this.weight = weight;
        this.feedingFrequency = feedingFrequency;
        this.feedingType = feedingType;
        this.hasVaccines = hasVaccines;
        this.animalId = id;
    }

    // Getters y Setters

    void setDiseases(String disease){ //lista de enferemedades
        diseases.add(disease);
    }

    int getAnimalId(){
        return animalId;
    }

    String getData(){
        if (diseases.isEmpty()){
            return String.format("Animal ID: %d \nTipo de Animal: %s \nFecha de nacimiento: %s \nFecha de ingreso: %s \nPeso: %s \nEnfermedades: No diseases \nFrecuencia de alimentación: %s \nTipo de alimentación: %s \nCuenta con vacunas: %s\n",
             animalId, typeAnimal, birthdate, arrivalDate, weight, feedingFrequency, feedingType, hasVaccines);
        }
        else{
            return String.format("Animal ID: %s \nTipo de Animal: %s \nFecha de nacimiento: %s \nFecha de ingreso: %s \nPeso: %s \nEnfermedades: %s \nFrecuencia de alimentación: %s \nTipo de alimentación: %s \nCuenta con vacunas: %b\n",
             animalId, typeAnimal, birthdate, arrivalDate, weight, diseases, feedingFrequency, feedingType, hasVaccines);
        }
    }
        
}
