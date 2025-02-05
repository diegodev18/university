import threading
import time


def leer_input():
    input_data = input("Ingrese un texto: ")
    print("Haz ingresado: ", input_data)


hilo_input = threading.Thread(target=leer_input)
hilo_input.start()

for i in range(5):
    print("Realizando otra tarea", i)
    time.sleep(1)

hilo_input.join()
