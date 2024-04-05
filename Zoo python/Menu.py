from Zoo import Zoo
from Employee import Employee
from Visitor import Visitor
from Visit import Visit
from Animal import Animal
from Maintenance import Maintenance
class Menu:
    def __init__(self):
        self.zoo = Zoo()
    
    def run(self):
        option = 0
        while option != 16:
            print("\n*** BIENVENIDO AL PROGRAMA ***\n")
            password = input("Ingresa la contraseña para acceder al sistema: ")
            if password == "z":
                while True:
                    print("\n*** ZOO DE MORELIA ***\n")
                    print("1. Registrar empleado")
                    print("2. Mostrar informacion de empleados")
                    print("3. Registrar visitante")
                    print("4. Mostrar informacion del visitante")
                    print("5. Registrar visita al zoo")
                    print("6. Finalizar visita")
                    print("7. Mostrar información de visitas")
                    print("8. Registrar animal")
                    print("9. Mostrar informacion del animal")
                    print("10. Realizar mantenimiento de animal")
                    print("11. Finalizar mantenimiento")
                    print("12. Mostrar información de mantenimientos realizados")
                    print("13. Eliminar o modificar datos de un Animal")
                    print("14. Eliminar o modificar datos de un Empleado")
                    print("15. Eliminar o modificar datos de un Visitante")
                    print("16. Salir")
                    option = int(input("\nIngrese opción: "))
                    print("\n")

                    if option == 1:
                        print("\n---- Información del empleado ----\n")
                        name = input("Nombre: ")
                        lastName = input("Apellidos: ")
                        birthdate = input("Fecha de nacimiento (DD-MM-YYYY): ")
                        admissionDate = input("Fecha de ingreso como trabajador (DD-MM-YYYY): ")
                        rfc = input("RFC: ")
                        curp = input("CURP: ")
                        salary = float(input("Salario: "))
                        rol = input("Rol: ")
                        print("\nIngrese los horarios de trabajo (Dejar vacío si es que no trabaja ese día): ")
                        schedule = [["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"],
                                    ["", "", "", "", "", "", ""]]
                        for x in range(7):
                            print("\n----", schedule[0][x], "----\n")
                            schedule[1][x] = input("Horas de trabajo (00:00-24:00): ")
                        option = int(input("\n¿Cancelar registro? (1 = si), (2 = no): "))
                        
                        
                        
                        if option == 1:
                            print("\nRegistro cancelado")
                        else:
                            employee = Employee(name, lastName, birthdate, admissionDate, rfc.upper(), curp.upper(),
                                                salary, schedule, rol, self.zoo.get_employee_id())
                            self.zoo.add_employee(employee)
                            
                            
                            
                    elif option == 2:
                        print("\n1. Mostrar información de todos los empleados")
                        print("2. Consultar empleado")
                        decision = int(input("\nIngrese opción: "))
                        if decision == 1:
                            self.zoo.show_employees()
                        else:
                            id = int(input("\nIngrese el ID del empleado que quieres consultar: "))
                            self.zoo.consultEmployee(id)
                            
                            
                            
                            
                    elif option == 3:
                                         
                        print("\n---- Información del visitante ----\n")
                        name = input("Nombre: ")
                        lastName = input("Apellido: ")
                        birthdate = input("Fecha de nacimiento (DD-MM-YYYY): ")
                        curp = input("CURP: ")
                        admissionDate = input("Fecha de ingreso como visitante (DD-MM-YYYY): ")
                        decision = int(input("\n¿Cancelar registro? (1 = si), (2 = no): "))
                        if decision == 1:
                            print("\nRegistro cancelado")
                        else:
                            visitor = Visitor(name, lastName, birthdate, curp.upper(), admissionDate, self.zoo.get_visitor_id())
                            self.zoo.add_visitor(visitor)




                    elif option == 4:
                        print("\n1. Mostrar información de todos los visitantes")
                        print("2. Consultar visitante")
                        decision = int(input("\nIngrese opción: "))
                        if decision == 1:
                            self.zoo.show_visitors()
                        else:
                            id = int(input("\nIngrese el ID del visitante que quieres consultar: "))
                            self.zoo.consult_visitor(id)






                    elif option == 5:
                        visit = Visit(self.zoo.get_visitors(), self.zoo.get_guides())
                        if visit.addVisitors():
                            visit.setId(self.zoo.get_visit_id())
                            print("\n\n---- Datos de la visita ----\n")
                            visit.getVisitData()
                            self.zoo.set_guides(visit.getGuideDeleted())
                            self.zoo.set_busy_guides(visit.getGuideDeleted())
                            self.zoo.add_visit(visit)
                            print("\nRegistro exitoso, ¡Disfrute su visita!\n")


                    elif option == 6:
                        id = int(input("Ingrese el ID de la visita que desea finalizar: "))
                        self.zoo.end_visit(id)




                    elif option == 7:
                        print("\n1. Mostrar información de las visitas realizadas")
                        print("2. Consultar visita")
                        decision = int(input("\nIngrese opción: "))
                        if decision == 1:
                            self.zoo.show_visits()
                        else:
                            id = int(input("\nIngrese el ID de la visita que quieres consultar: "))
                            self.zoo.consult_visit(id)
                            
                            
                            
                            
                    elif option == 8:
                        print("\n---- Información del animal ----\n")
                        kind = input("Especie: ")
                        arrivalDate = input("Fecha de llegada (DD-MM-YYYY): ")
                        typeFood = input("Tipo de alimentación: ")
                        birthdate = input("Fecha de nacimiento (DD-MM-YYYY): ")
                        weight = float(input("Peso: "))
                        feedingFrequency = input("Frecuencia de alimentación: ")
                        decision = int(input("¿Dispone de vacunas? (1 = si), (2 = no): "))
                        vaccines = decision == 1
                        animal = Animal(kind, arrivalDate, typeFood, birthdate, weight, feedingFrequency, vaccines, self.zoo.get_animal_id())
                        decision = int(input("¿Padece de alguna enfermedad? (1 = si), (2 = no): "))
                        if decision == 1:
                            while decision == 1:
                                disease = input("\nEnfermedad: ")
                                animal.setDiseases(disease)
                                decision = int(input("\n¿Agregar otra enfermedad? (1 = si), (2 = no): "))
                        decision = int(input("\n¿Cancelar registro? (1 = si), (2 = no): "))
                        if decision == 1:
                            self.zoo.set_animal_id()
                            print("\nRegistro cancelado")
                        else:
                            self.zoo.add_animal(animal)




                    elif option == 9:
                        print("\n1. Mostrar información de todos los animales")
                        print("2. Consultar animal")
                        decision = int(input("\nIngrese opción: "))
                        if decision == 1:
                            self.zoo.show_animals()
                        else:
                            id = int(input("\nIngrese el ID del animal que quieres consultar: "))
                            self.zoo.consult_animal(id)




                    elif option == 10:
                        print("\n---- Realizar mantenimiento del animal ----\n")
                        maintenance = Maintenance(self.zoo.get_maintenance(), self.zoo.get_animals())
                        maintenance.addMainteance()
                        if maintenance.getBand():
                            maintenance.setId(self.zoo.get_maintenance_id())
                            self.zoo.set_maintenance_employee(maintenance.getMaintenanceDeleted())
                            self.zoo.set_busy_maintenance(maintenance.getMaintenanceDeleted())
                            print("\n\n---- Datos sobre el mantenimiento ----\n")
                            print(maintenance.getData())
                            self.zoo.add_maintenance(maintenance)



                    elif option == 11:
                        id = int(input("\nIngrese el ID del mantenimiento que desea finalizar: "))
                        self.zoo.end_maintenance(id)
                        
                        
                        

                    elif option == 12:
                        print("\n1. Mostrar información de todos los mantenimientos")
                        print("2. Consultar algún mantenimiento")
                        decision = int(input("\nIngrese opción: "))
                        if decision == 1:
                            self.zoo.show_maintenance()
                        else:
                            id = int(input("\nIngrese el ID del mantenimiento que quieres consultar: "))
                            self.zoo.consult_maintenance(id)
                      
                      
                      
                            
                    elif option == 13:
                        print("\n1. Eliminar Animal")
                        print("2. Modificar Animal")
                        decision = int(input("\nIngrese opción: "))
                        if decision == 1:
                            deleteAnimalId = int(input("\nIntroduce el ID del animal que deseas eliminar: "))
                            self.zoo.delete_animal(deleteAnimalId)
                        elif decision == 2:
                            print("\n1. Modificar todo")
                            print("2. Modificar un campo en especifico")
                            decision = int(input("\nIngrese opción: "))
                            if decision == 1:
                                print("\n---- Modificar animal ----\n")
                                modifyAnimalId = int(input("Introduce el ID del animal que deseas modificar: "))
                                animalToModify = None
                                for animalTemp in self.zoo.get_animals():
                                    if animalTemp.getAnimalId() == modifyAnimalId:
                                        animalToModify = animalTemp
                                        break
                                if animalToModify:
                                    newType = input("Nuevo tipo de Animal: ")
                                    animalToModify.setTypeAnimal(newType)
                                    newBirthdate = input("Nueva fecha de nacimiento (DD-MM-YYYY): ")
                                    animalToModify.setBirthdate(newBirthdate)
                                    newArrivalDate = input("Nueva fecha de ingreso (DD-MM-YYYY): ")
                                    animalToModify.setArrivalDate(newArrivalDate)
                                    newWeight = float(input("Nuevo peso: "))
                                    animalToModify.setWeight(newWeight)
                                    newFeedingFrequency = input("Nueva frecuencia de alimentación: ")
                                    animalToModify.setFeedingFrequency(newFeedingFrequency)
                                    newFeedingType = input("Nuevo tipo de alimentación: ")
                                    animalToModify.setFeedingType(newFeedingType)
                                    newHasVaccines = input("¿Cuenta con vacunas? (true/false): ").lower() == 'true'
                                    animalToModify.setHasVaccines(newHasVaccines)
                                    diseasesInput = input("Nuevas enfermedades (separadas por coma): ")
                                    diseasesArray = diseasesInput.split(",")
                                    newDiseases = [disease.strip() for disease in diseasesArray]
                                    animalToModify.setDiseases(newDiseases)
                                else:
                                    print("\nAnimal no encontrado.")
                            elif decision == 2:
                                print("\n---- Modificar animal ----\n")
                                modifyAnimalIdInput = int(input("Introduce el ID del animal que deseas modificar: "))
                                foundAnimalToModify = None
                                for animalTemp in self.zoo.get_animals():
                                    if animalTemp.getAnimalId() == modifyAnimalIdInput:
                                        foundAnimalToModify = animalTemp
                                        break
                                if foundAnimalToModify:
                                    print("\nSeleccione el campo que desea modificar:")
                                    print("\n1. Tipo de Animal")
                                    print("2. Fecha de nacimiento")
                                    print("3. Fecha de ingreso")
                                    print("4. Peso")
                                    print("5. Frecuencia de alimentación")
                                    print("6. Tipo de alimentación")
                                    print("7. ¿Cuenta con vacunas?")
                                    print("8. Enfermedades")
                                    decision = int(input())
                                    if decision == 1:
                                        newType = input("\nNuevo tipo de Animal: ")
                                        foundAnimalToModify.setTypeAnimal(newType)
                                    elif decision == 2:
                                        newBirthdate = input("\nNueva fecha de nacimiento (DD-MM-YYYY): ")
                                        foundAnimalToModify.setBirthdate(newBirthdate)
                                    elif decision == 3:
                                        newArrivalDate = input("\nNueva fecha de ingreso (DD-MM-YYYY): ")
                                        foundAnimalToModify.setArrivalDate(newArrivalDate)
                                    elif decision == 4:
                                        newWeight = float(input("\nNuevo peso: "))
                                        foundAnimalToModify.setWeight(newWeight)
                                    elif decision == 5:
                                        newFeedingFrequency = input("\nNueva frecuencia de alimentación: ")
                                        foundAnimalToModify.setFeedingFrequency(newFeedingFrequency)
                                    elif decision == 6:
                                        newFeedingType = input("\nNuevo tipo de alimentación: ")
                                        foundAnimalToModify.setFeedingType(newFeedingType)
                                    elif decision == 7:
                                        newHasVaccines = input("\n¿Cuenta con vacunas? (true/false): ").lower() == 'true'
                                        foundAnimalToModify.setHasVaccines(newHasVaccines)
                                    elif decision == 8:
                                        diseasesInput = input("\nNuevas enfermedades (separadas por coma): ")
                                        diseasesArray = diseasesInput.split(",")
                                        newDiseases = [disease.strip() for disease in diseasesArray]
                                        foundAnimalToModify.setDiseases(newDiseases)
                                    else:
                                        print("\nOpción inválida.")
                                else:
                                    print("\nAnimal no encontrado.")
                        else:
                            print("\nOpción inválida.")
                            
                      
                            
                    elif option == 14:
                        print("\n1. Eliminar Empleado")
                        print("2. Modificar Empleado")
                        decision = int(input("\nIngrese opción: "))
                        if decision == 1:
                            deleteEmployee = int(input("\nIntroduce el ID del Empleado que deseas eliminar: "))
                            self.zoo.delete_employee(deleteEmployee)
                        elif decision == 2:
                            print("\n1. Modificar todos los datos")
                            print("2. Modificar un dato en especifico")
                            decision = int(input("\nIngrese opción: "))
                            if decision == 1:
                                print("\n---- Modificar empleado ----\n")
                                modifyEmployeeId = int(input("Introduce el ID del empleado que deseas modificar: "))
                                employeeToModify = None
                                for emp in self.zoo.get_employees():
                                    if emp.get_id() == modifyEmployeeId:
                                        employeeToModify = emp
                                        break
                                if employeeToModify:
                                    newName = input("Nuevo nombre: ")
                                    newLastName = input("Nuevo apellido: ")
                                    newBirthdate = input("Nueva fecha de nacimiento (DD-MM-YYYY): ")
                                    newAdmissionDate = input("Nueva fecha de ingreso (DD-MM-YYYY): ")
                                    newRfc = input("Nuevo RFC: ")
                                    newCurp = input("Nueva CURP: ")
                                    newSalary = float(input("Nuevo salario: "))
                                    newRol = input("Nuevo rol: ")
                                    print("\nIngrese los nuevos horarios de trabajo (Dejar vacío si no trabaja ese día): ")
                                    newSchedule = [["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"], [""] * 7]
                                    for i in range(7):
                                        print("\n---- " + newSchedule[0][i] + " ----\n")
                                        newSchedule[1][i] = input("Nuevas horas de trabajo (00:00-24:00): ")
                                    # Actualizar los datos del empleado
                                    employeeToModify.set_name(newName)
                                    employeeToModify.set_last_name(newLastName)
                                    employeeToModify.set_birthdate(newBirthdate)
                                    employeeToModify.set_admission_date(newAdmissionDate)
                                    employeeToModify.set_rfc(newRfc.upper())
                                    employeeToModify.set_curp(newCurp.upper())
                                    employeeToModify.set_salary(newSalary)
                                    employeeToModify.set_rol(newRol)
                                    employeeToModify.set_schedule(newSchedule)
                                    print("\nEmpleado modificado exitosamente.")
                                else:
                                    print("\nEmpleado no encontrado.")
                            elif decision == 2:
                                print("\n---- Modificar empleado ----\n")
                                modifyEmployeeIdInput = int(input("Introduce el ID del empleado que deseas modificar: "))
                                employeeToModify = None
                                for emp in self.zoo.get_guides():
                                    if emp.get_id() == modifyEmployeeIdInput:
                                        employeeToModify = emp
                                        break
                                if employeeToModify:
                                    print("\nSeleccione el campo que desea modificar:")
                                    print("\n1. Nombre")
                                    print("2. Apellidos")
                                    print("3. Fecha de nacimiento")
                                    print("4. Fecha de ingreso")
                                    print("5. RFC")
                                    print("6. CURP")
                                    print("7. Salario")
                                    print("8. Rol")
                                    print("9. Horario de trabajo")
                                    decision = int(input("\nIngrese opción: "))
                                    if decision == 1:
                                        newName = input("\nNuevo nombre: ")
                                        employeeToModify.set_name(newName)
                                    elif decision == 2:
                                        newLastName = input("\nNuevos apellidos: ")
                                        employeeToModify.set_last_name(newLastName)
                                    elif decision == 3:
                                        newBirthdate = input("\nNueva fecha de nacimiento (DD-MM-YYYY): ")
                                        employeeToModify.set_birthdate(newBirthdate)
                                    elif decision == 4:
                                        newAdmissionDate = input("\nNueva fecha de ingreso (DD-MM-YYYY): ")
                                        employeeToModify.set_admission_date(newAdmissionDate)
                                    elif decision == 5:
                                        newRfc = input("\nNuevo RFC: ")
                                        employeeToModify.set_rfc(newRfc.upper())
                                    elif decision == 6:
                                        newCurp = input("\nNueva CURP: ")
                                        employeeToModify.set_curp(newCurp.upper())
                                    elif decision == 7:
                                        newSalary = float(input("\nNuevo salario: "))
                                        employeeToModify.set_salary(newSalary)
                                    elif decision == 8:
                                        newRol = input("\nNuevo rol: ")
                                        employeeToModify.set_rol(newRol)
                                    elif decision == 9:
                                        print("\nIngrese los nuevos horarios de trabajo (Dejar vacío si no trabaja ese día): ")
                                        newSchedule = [["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"], [""] * 7]
                                        for i in range(7):
                                            print("\n---- " + newSchedule[0][i] + " ----\n")
                                            newSchedule[1][i] = input("Nuevas horas de trabajo (00:00-24:00): ")
                                        employeeToModify.set_schedule(newSchedule)
                                    else:
                                        print("\nOpción inválida.")
                                    print("\nEmpleado modificado exitosamente.")
                                else:
                                    print("\nEmpleado no encontrado.")
                            else:
                                print("\nOpción inválida.")
                                
                                
                                
                                
                                
                                
                    elif option == 15:
                        print("\n1. Eliminar Visitante")
                        print("2. Modificar Visitante")
                        decision = int(input("\nIngrese opción: "))
                        if decision == 1:
                            deleteVisitor = int(input("\nIntroduce el ID del visitante que deseas eliminar: "))
                            self.zoo.delete_visitor(deleteVisitor)
                        elif decision == 2:
                            print("\n1. Modificar todos los datos")
                            print("2. Modificar un dato en especifico")
                            decision = int(input("\nIngrese opción: "))
                            if decision == 1:
                                print("\n---- Modificar visitante ----\n")
                                modifyVisitorId = int(input("Introduce el ID del visitante que deseas modificar: "))
                                visitorToModify = None
                                for visitor in self.zoo.get_visitors():
                                    if visitor.getd() == modifyVisitorId:
                                        visitorToModify = visitor
                                        break
                                if visitorToModify:
                                    newName = input("Nuevo nombre: ")
                                    newLastName = input("Nuevo apellido: ")
                                    newBirthdate = input("Nueva fecha de nacimiento (DD-MM-YYYY): ")
                                    newAdmissionDate = input("Nueva fecha de ingreso (DD-MM-YYYY): ")
                                    newCurp = input("Nueva CURP: ")
                                    visitorToModify.setName(newName)
                                    visitorToModify.setLastName(newLastName)
                                    visitorToModify.setBirthdate(newBirthdate)
                                    visitorToModify.setAdmissionDate(newAdmissionDate)
                                    visitorToModify.setCurp(newCurp.upper())
                                    print("\nVisitante modificado exitosamente.")
                                else:
                                    print("\nVisitante no encontrado.")
                            elif decision == 2:
                                print("\n---- Modificar visitante ----\n")
                                modifyVisitorIdInput = int(input("Introduce el ID del visitante que deseas modificar: "))
                                visitorToModify = None
                                for fvisitor in self.zoo.get_visitors():
                                    if fvisitor.get_id() == modifyVisitorIdInput:
                                        visitorToModify = fvisitor
                                        break
                                if visitorToModify:
                                    print("\nSeleccione el campo que desea modificar:")
                                    print("\n1. Nombre")
                                    print("2. Apellidos")
                                    print("3. Fecha de nacimiento")
                                    print("4. Fecha de Ingreso")
                                    print("5. CURP")
                                    decision = int(input("\nIngrese opción: "))
                                    if decision == 1:
                                        newName = input("\nNuevo nombre: ")
                                        visitorToModify.setName(newName)
                                    elif decision == 2:
                                        newLastName = input("\nNuevos apellidos: ")
                                        visitorToModify.setLastName(newLastName)
                                    elif decision == 3:
                                        newBirthdate = input("\nNueva fecha de nacimiento (DD-MM-YYYY): ")
                                        visitorToModify.setBirthdate(newBirthdate)
                                    elif decision == 4:
                                        newAdmissionDate = input("\nNueva fecha de ingreso (DD-MM-YYYY): ")
                                        visitorToModify.setAdmissionDate(newAdmissionDate)
                                    elif decision == 5:
                                        newCurp = input("\nNueva CURP: ")
                                        visitorToModify.setCurp(newCurp.upper())
                                    else:
                                        print("\nOpción inválida.")
                                    print("\nVisitante modificado exitosamente.")
                                else:
                                    print("\nVisitante no encontrado.")
                            else:
                                print("\nOpción inválida.")

                    elif option == 16:
                        print("Saliendo del programa...")
                        break
                    else:
                        print("Opción no válida. Por favor, seleccione una opción válida.")
            else:
                print("Contraseña incorrecta. Inténtelo de nuevo.")

if __name__ == "__main__":
    menu = Menu()
    menu.run()