import time

def tarea():
    print("Tarea iniciada")
    time.sleep(2)
    print("Tarea terminada")

inicio = time.time()
for i in range(5):
    tarea()
fin = time.time()
print(f"Tiempo de ejecución sin hilos: {fin - inicio} segundos")
