import random
import collections


def mejorcaso_corr(a, b, salto):
    f = open("ejercicio2_mejorcaso.in", "w")
    for i in range(a, b+salto, salto):
        # i es cantidad de pisos
        f.write(str(i) + " " + str(i-1) + "\n") # cantidad de pisos

        for j in range(0, i):
            f.write("0 0 " + str(i) + " " + str(j) + ("\n" if j+1 == i else "; ")) # unico portal

    f.close()

def peorcaso_corr(a, b, salto):
    f = open("ejercicio2_peorcaso.in", "w")
    for i in range(a, b+salto, salto):
        L = i-1
        # i es cantidad de pisos
        f.write(str(i) + " " + str(L) + "\n") # cantidad de pisos

        for j in range(1, i+1):
            f.write("0 0 " + str(j) + " 0" + ("\n" if j+1 == i+1 else "; ")) # unico portal

    f.close()

def promedio_corr(a, b, salto):
    f = open("ejercicio2_promediocaso.in", "w")
    for i in range(a, b+salto, salto):
        L = i-1

        # i es cantidad de pisos
        f.write(str(i) + " " + str(L) + "\n") # cantidad de pisos
        f.write("0 0 " + str(i) + " 0; ") # aseguramos un camino.

        totalAristasElegir = L
        res = set()
        res.add((0,0, i, 0))

        while len(res) < L:
            pisos = range(0, i+1)
            pos = range(0, L+1)

            A = random.randint(0, i)
            DA = random.randint(0, L+1)

            Blist = {j for j in range(0,i+1)}
            DBlist = {j for j in range(0, L+2)}
            Blist.remove(A)
            DBlist.remove(DA)

            B = random.sample(Blist, 1)[0]
            DB = random.sample(DBlist, 1)[0]

            if ((A, DA, B, DB) not in res):
                res.add((A, DA, B, DB))

        for (idx, (A, DA, B, DB)) in enumerate(res):
            f.write(str(A) + " " + str(DA) + " " + str(B) + " " + str(DB) + ("\n" if idx+1 == len(res) else "; ")) # unico portal

    f.close()



#print(generarcamino(1,3))

print("Imprimiendo mejor caso\n")
mejorcaso_corr(100, 500, 50)
print("Imprimiendo peor caso\n")
peorcaso_corr(100, 500, 50)
print("Imprimiendo caso promedio\n")
promedio_corr(100, 500, 50)


