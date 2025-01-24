import threading
import time

def tarea():
    print("Hilo iniciado")
    time.sleep(2)
    print("Hilo terminado")

hilos = []
inicio = time.time()
for i in range(5):
    hilo = threading.Thread(target=tarea)
    hilos.append(hilo)
    hilo.start()

for hilo in hilos:
    hilo.join()

fin = time.time()
print(f"Tiempo de ejecución con hilos: {fin - inicio} segundos")
