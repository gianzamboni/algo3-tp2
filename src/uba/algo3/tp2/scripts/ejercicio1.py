import random


def mejorcaso(a, b, salto):
    f = open("ejercicio1_mejorcaso.in", "w")
    for i in range(a, b+salto, salto):
        # i es cantidad de pisos
        f.write(str(i) + "\n") # cantidad de pisos
        f.write("0 " + str(i) + "\n") # unico portal
    f.close()

def peorcaso(a, b, salto):
    f = open("ejercicio1_peorcaso.in", "w")
    for i in range(a, b+salto, salto):
        f.write(str(i) + "\n") # cantidad de pisos
        total = i*(i+1)/2
        print("Caso " + str(i) + "\n")
        for p in enumerate((str(piso) + " " + str(sig) + "; " for piso in range(0, i+1) for sig in range(piso+1,i+1))):
            if p[0] == total-1:
                f.write(p[1].replace("; ", ""))
            else:
                f.write(p[1])

        f.write("\n")

    f.close()

def promediocaso(a, b, salto):
    f = open("ejercicio1_promediocaso.in", "w")
    for i in range(a, b+salto, salto):
        print("Caso " + str(i) + "\n")
        f.write(str(i) + "\n") # cantidad de pisos

        portales = dict()
        for j in range(0,i):
            portales[j] = set()

        # genero listas de conexiones
        # la lista 0 es la lista de a que pisos te podes conectar desde el piso 0
        for lista in enumerate( random.sample(range(piso+1, i+1), random.randint(0, i-piso)) for piso in range(0, i)):
            for floor in lista[1]:
                portales[lista[0]].add(floor)

        camino = armarcamino(i)

        # agregamos el camino
        for k, v in camino.items():
            portales[k].add(v)

        #imprimimos los portales
        for k, v in portales.items():
            for p in enumerate(v): # p es un piso adyacente a k
                if k == i-1 and p[0] == len(v)-1:
                    f.write(str(k) + " " + str(p[1]))
                else:
                    f.write(str(k) + " " + str(p[1]) + "; ")

        f.write("\n")
    f.close()

# devuelve diccionario de como se conectan los pisos
# armar camino aleatorio entre el piso 0 y el ultimo
def armarcamino(i):
    # desde el piso 0 debemos llegar al piso i
    # armamos un camino aleatorio
    portales = dict()
    j = random.randint(1, i) # un primer portal
    portales[0] = j # hay un portal del 0 al piso j

    while (j != i): # hasta que no alcancemos el ultimo piso seguimos armando el camino
        temp = j
        j = random.randint(j+1,i)
        portales[temp] = j

    return portales

print("Imprimiendo mejor caso\n")
mejorcaso(100,2000,100)
print("Imprimiendo peor caso\n")
peorcaso(100,2000,100)
print("Imprimiendo caso promedio\n")
promediocaso(100,2000,100)
