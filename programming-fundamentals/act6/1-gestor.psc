Algoritmo GestorAsignacionTareas
    // Declaración de variables
    Definir tiempos Como Entero
    Definir i, j, k Como Entero
    Definir combinacion, mejorCombinacion Como Entero
    Definir tiempoTotal, tiempoMinimo Como Entero
    Definir numCombinacion Como Entero
    
    // Dimensionar matrices
    Dimension tiempos[3,3]
    Dimension combinacion[3]
    Dimension mejorCombinacion[3]
    
    // Inicializar la matriz de tiempos según el caso de prueba
    Escribir "=== GESTOR DE ASIGNACIÓN DE TAREAS ==="
    Escribir ""
    Escribir "Matriz de Tiempos (Empleados x Tareas):"
    Escribir "     T1  T2  T3"
    
    // Llenar la matriz con los datos del problema
    tiempos[1,1] <- 5  // E1-T1
    tiempos[1,2] <- 8  // E1-T2
    tiempos[1,3] <- 4  // E1-T3
    
    tiempos[2,1] <- 7  // E2-T1
    tiempos[2,2] <- 3  // E2-T2
    tiempos[2,3] <- 6  // E2-T3
    
    tiempos[3,1] <- 2  // E3-T1
    tiempos[3,2] <- 5  // E3-T2
    tiempos[3,3] <- 8  // E3-T3
    
    // Mostrar la matriz
    Para i <- 1 Hasta 3 Con Paso 1 Hacer
        Escribir Sin Saltar "E", i+1, ": "
        Para j <- 1 Hasta 3 Con Paso 1 Hacer
            Escribir Sin Saltar "  ", tiempos[i,j]
        FinPara
        Escribir ""
    FinPara
    
    Escribir ""
    Escribir "=== EVALUANDO TODAS LAS COMBINACIONES ==="
    Escribir ""
    
    // Inicializar variables para encontrar el mínimo
    tiempoMinimo <- 999
    numCombinacion <- 0
    
    // Generar todas las permutaciones posibles (3! = 6 combinaciones)
    // Cada empleado debe tener una tarea diferente
    
    Para i <- 1 Hasta 3 Con Paso 1 Hacer  // Tarea para E1
        Para j <- 1 Hasta 3 Con Paso 1 Hacer  // Tarea para E2
            Para k <- 1 Hasta 3 Con Paso 1 Hacer  // Tarea para E3
                // Verificar que no haya tareas repetidas
                Si i <> j Y i <> k Y j <> k Entonces
                    numCombinacion <- numCombinacion + 1
                    
                    // Asignar la combinación actual
                    combinacion[1] <- i  // E1 -> Ti
                    combinacion[2] <- j  // E2 -> Tj
                    combinacion[3] <- k  // E3 -> Tk
                    
                    // Calcular el tiempo total para esta combinación
                    tiempoTotal <- tiempos[1,i] + tiempos[2,j] + tiempos[3,k]
                    
                    // Mostrar la combinación actual
                    Escribir Sin Saltar "Combinación ", numCombinacion, ": "
                    Escribir Sin Saltar "E1->T", i+1, " (", tiempos[1,i], "h), "
                    Escribir Sin Saltar "E2->T", j+1, " (", tiempos[2,j], "h), "
                    Escribir Sin Saltar "E3->T", k+1, " (", tiempos[3,k], "h)"
                    Escribir " | Tiempo Total: ", tiempoTotal, " horas"
                    
                    // Verificar si es la mejor combinación hasta ahora
                    Si tiempoTotal < tiempoMinimo Entonces
                        tiempoMinimo <- tiempoTotal
                        mejorCombinacion[1] <- i
                        mejorCombinacion[2] <- j
                        mejorCombinacion[3] <- k
                    FinSi
                FinSi
            FinPara
        FinPara
    FinPara
    
    // Mostrar el resultado óptimo
    Escribir ""
    Escribir "=== RESULTADO ÓPTIMO ==="
    Escribir ""
    Escribir "La asignación óptima es:"
    Escribir "? E1 asignado a T", mejorCombinacion[1]+1, " (", tiempos[1,mejorCombinacion[1]], " horas)"
    Escribir "? E2 asignado a T", mejorCombinacion[2]+1, " (", tiempos[2,mejorCombinacion[2]], " horas)"
    Escribir "? E3 asignado a T", mejorCombinacion[3]+1, " (", tiempos[3,mejorCombinacion[3]], " horas)"
    Escribir ""
    Escribir "Tiempo total mínimo: ", tiempoMinimo, " horas"
    Escribir ""
    Escribir "=== FIN DEL PROGRAMA ==="
    
FinAlgoritmo