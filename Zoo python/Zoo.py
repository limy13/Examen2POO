class Zoo:
    def __init__(self):
        self.employees = []             # Lista para almacenar empleados
        self.animals = []               # Lista para almacenar animales
        self.visitors = []              # Lista para almacenar visitantes
        self.guides = []                # Lista para almacenar empleados guías
        self.busy_guides = []           # Lista para almacenar guías ocupados
        self.maintenance_employee = []  # Lista para almacenar empleados de mantenimiento
        self.busy_maintenance = []      # Lista para almacenar empleados de mantenimiento ocupados
        self.maintenance = []           # Lista para almacenar mantenimiento
        self.visit = []                 # Lista para almacenar visitas
        self.employee_id = 0
        self.animal_id = 0
        self.visitor_id = 0
        self.visit_id = 0
        self.maintenance_id = 0
        self.guide_deleted = None
        self.maintenance_deleted = None

    def add_employee(self, new_employee):  # Esta función agrega un empleado
        self.employees.append(new_employee)
        if new_employee.rol.lower() == "guia":  # Se agregan guías a la lista de guías
            self.guides.append(new_employee)
        elif new_employee.rol.lower() == "mantenimiento":  # Se agregan empleados de mantenimiento
            self.maintenance_employee.append(new_employee)
        print("\nRegistro exitoso\n")

    def add_animal(self, new_animal):  # Esta función agrega un animal
        self.animals.append(new_animal)
        print("\nRegistro exitoso\n")

    def add_visitor(self, new_visitor):  # Esta función agrega un visitante
        self.visitors.append(new_visitor)
        print("\nRegistro exitoso\n")

    def add_visit(self, new_visit):  # Para registrar visitas
        self.visit.append(new_visit)

    def add_maintenance(self, new_maintenance):
        self.maintenance.append(new_maintenance)
        print("\nRegistro exitoso\n")

    def get_employee_id(self):
        self.employee_id += 1
        return self.employee_id

    def get_animal_id(self):
        self.animal_id += 1
        return self.animal_id

    def get_visitor_id(self):
        self.visitor_id += 1
        return self.visitor_id

    def get_visit_id(self):
        self.visit_id += 1
        return self.visit_id

    def get_maintenance_id(self):
        self.maintenance_id += 1
        return self.maintenance_id

    def get_animals(self):  # Obtiene la lista de los animales
        return self.animals

    def get_maintenance(self):  # Obtiene la lista de mantenimiento
        return self.maintenance_employee

    def get_guides(self):  # Obtiene la lista de guías
        return self.guides

    def get_employees(self):  # Obtiene la lista de empleados
        return self.employees

    def get_visitors(self):  # Obtiene la lista de visitantes
        return self.visitors

    def set_maintenance_employee(self, new_maintenance_employee):
        self.maintenance_employee.remove(new_maintenance_employee)

    def set_busy_maintenance(self, new_busy_maintenance):
        self.busy_maintenance.append(new_busy_maintenance)

    def set_guides(self, new_guides):
        self.guides.remove(new_guides)

    def set_busy_guides(self, new_busy_guides):
        self.busy_guides.append(new_busy_guides)

    def set_animal_id(self):
        self.animal_id = animalId - 1

    def show_employees(self):  # Muestra información de todos los empleados
        if not self.employees:
            print("\nNo hay empleados registrados\n")
        else:
            for x, employee in enumerate(self.employees, 1):
                print(f"\n\n---- Empleado {x} ----\n")
                print(employee.employee_get_data())
                employee.print_schedule()

    def consult_employee(self, employee_id):  # Info de un empleado en específico
        found = False
        for employee in self.employees:
            if employee_id == employee.id:
                print("\n---- Empleado ----\n")
                print(employee.employee_get_data())
                employee.print_schedule()
                found = True
                break
        if not found:
            print("\nEste ID no pertenece a ningún empleado\n")

    
    
    def show_animals(self):  # Muestra información de todos los animales
        if not self.animals:
            print("\nNo hay animales registrados\n")
        else:
            for x, animal in enumerate(self.animals, 1):
                print(f"\n---- Animal {x} ----\n")
                print(animal.getData())

    def consult_animal(self, animal_id):  # Info de un animal en específico
        found = False
        for animal in self.animals:
            if animal_id == animal.get_animal_id():
                print("\n---- Animal ----\n")
                print(animal.getData())
                found = True
                break
        if not found:
            print("\nEste ID no pertenece a ningún animal\n")

    def show_visitors(self):  # Muestra información de todos los visitantes
        if not self.visitors:
            print("\nNo hay visitantes registrados\n")
        else:
            for x, visitor in enumerate(self.visitors, 1):
                print(f"\n---- Visitante {x} ----")
                print(visitor.visitorGetData())

    def consult_visitor(self, visitor_id):  # Info de un visitante en específico
        found = False
        for visitor in self.visitors:
            if visitor_id == visitor.get_id():
                print("\n---- Visitante ----")
                print(visitor.visitor_get_data())
                found = True
                break
        if not found:
            print("\nEste ID no pertenece a ningún visitante\n")

    def show_visits(self):
        if not self.visit:
            print("\nNo hay visitas registradas\n")
        else:
            for x, visit in enumerate(self.visit, 1):
                print(f"\n\n---- Visita {x} ----\n")
                visit.get_visit_data()

    def consult_visit(self, visit_id):  # Info de una visita en específico
        found = False
        for visit in self.visit:
            if visit_id == visit.get_visit_id():
                print("\n\n---- Visita ----\n")
                visit.get_visit_data()
                found = True
                break
        if not found:
            print("\nEste ID no pertenece a ninguna visita\n")

    def show_maintenance(self):  # Muestra información de todos los mantenimientos
        if not self.maintenance:
            print("\nNo hay mantenimientos registrados\n")
        else:
            for x, maintenance in enumerate(self.maintenance, 1):
                print(f"\n---- Mantenimiento {x} ----\n")
                print(maintenance.get_data())

    def consult_maintenance(self, maintenance_id):  # Info de un mantenimiento en específico
        found = False
        for maintenance in self.maintenance:
            if maintenance_id == maintenance.get_id():
                print("\n\n---- Mantenimiento ----\n")
                print(maintenance.get_data())
                found = True
                break
        if not found:
            print("\nEste ID no pertenece a ningún mantenimiento realizado\n")

    def end_visit(self, visit_id):  # Verificar esto
        found = False
        if not self.visit:
            print("\nNo hay visitas registradas")
            return
        else:
            for visit in self.visit:
                if visit_id == visit.get_visit_id():
                    for employee in self.busy_guides:
                        if visit.get_guide_id() == employee.get_id():
                            self.guide_deleted = employee
                            self.guides.append(employee)
                            visit.set_progress(True)
                            found = True
                            print("\nVisita finalizada")
                    break
            if not found:
                print("\nEste ID no pertenece a ninguna visita en proceso")
            else:
                self.busy_guides.remove(self.guide_deleted)

    def end_maintenance(self, maintenance_id):  # Verificar esto
        found = False
        if not self.maintenance:
            print("\nNo hay mantenimientos registrados")
            return
        else:
            for maintenance in self.maintenance:
                if maintenance_id == maintenance.get_id():
                    for employee in self.busy_maintenance:
                        if maintenance.get_employee_id() == employee.get_id():
                            self.maintenance_deleted = employee
                            self.maintenance_employee.append(employee)
                            maintenance.set_progress(True)
                            found = True
                            print("\nMantenimiento finalizado")
                    break
            if not found:
                print("\nEste ID no pertenece a ningún mantenimiento en proceso")
            else:
                self.busy_maintenance.remove(self.maintenance_deleted)

    def delete_animal(self, animal_id):
        remove_animal = -1
        for i in range(len(self.animals)):  # Buscar el animal por su ID
            if self.animals[i].getAnimalId() == animal_id:
                remove_animal = i
                break
        if remove_animal != -1:  # Si se encontró el animal
            self.animals.pop(remove_animal)
            print("\nEl animal con ID:", animal_id, "ha sido eliminado.")
            for i in range(remove_animal, len(self.animals)):  # Reorganizar los IDs de los animales restantes
                self.animals[i].set_animal_id(self.animals[i].get_animal_id() - 1)
            self.animal_id = len(self.animals)
        else:
            print("\nNo se encontró ningún animal con el ID:", animal_id)

    def delete_employee(self, employee_id):
        remove = -1  # Variable para almacenar el índice del empleado que se eliminará
        for i in range(len(self.employees)):  # Buscar el empleado por su ID
            if self.employees[i].get_id() == employee_id:
                remove = i
                break
        if remove != -1:  # Si se encontró el empleado
            self.employees.pop(remove)  # Eliminar al empleado
            print("\nEl empleado con ID:", employee_id, "ha sido eliminado.")
            for i in range(remove, len(self.employees)):  # Ajustar los IDs de los empleados restantes
                self.employees[i].set_id(i + 1)
            self.employee_id = len(self.employees)
        else:
            print("\nNo se encontró ningún empleado con el ID:", employee_id)

    def delete_visitor(self, visitor_id):
        remove_visitor = -1
        for i in range(len(self.visitors)):  # Buscar el visitante por su ID
            if self.visitors[i].getId() == visitor_id:
                remove_visitor = i
                break
        if remove_visitor != -1:  # Si se encontró el visitante
            self.visitors.pop(remove_visitor)  # Eliminar el visitante
            print("\nEl visitante con ID:", visitor_id, "ha sido eliminado.")
            for i in range(remove_visitor, len(self.visitors)):  # Reorganizar los IDs de los visitantes restantes
                self.visitors[i].set_id(self.visitors[i].get_id() - 1)
            self.visitor_id = len(self.visitors)
        else:
            print("\nNo se encontró ningún visitante con el ID:", visitor_id)
