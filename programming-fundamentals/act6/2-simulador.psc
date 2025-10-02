Algoritmo SimuladorAscensorInteligente
    // Declaración de variables
    Definir llamadas, llamadasArriba, llamadasAbajo Como Entero
    Definir piso, pisoActual, totalPisos, numLlamadas Como Entero
    Definir i, j, temp, distanciaTotal Como Entero
    Definir contArriba, contAbajo Como Entero
    Definir valido Como Logico
    
    // Inicialización de constantes
    totalPisos <- 10
    numLlamadas <- 5
    pisoActual <- 1
    distanciaTotal <- 0
    
    // Dimensionamiento de arreglos
    Dimension llamadas[5]
    Dimension llamadasArriba[5]
    Dimension llamadasAbajo[5]
    
    // Inicializar contadores
    contArriba <- 0
    contAbajo <- 0
    
    // Presentación del programa
    Escribir "================================================"
    Escribir "   SIMULADOR DE ASCENSOR INTELIGENTE"
    Escribir "================================================"
    Escribir ""
    Escribir "El ascensor parte del piso: ", pisoActual
    Escribir "Edificio de ", totalPisos, " pisos"
    Escribir ""
    
    // Solicitar las 5 llamadas
    Escribir "Ingrese ", numLlamadas, " pisos de destino (1-", totalPisos, "):"
    Escribir ""
    
    Para i <- 1 Hasta numLlamadas Con Paso 1 Hacer
        valido <- Falso
        Mientras valido = Falso Hacer
            Escribir Sin Saltar "Llamada ", i, ": "
            Leer piso
            
            // Validar que el piso esté en el rango correcto
            Si piso >= 1 Y piso <= totalPisos Entonces
                llamadas[i] <- piso
                valido <- Verdadero
            SiNo
                Escribir "Error: El piso debe estar entre 1 y ", totalPisos
            FinSi
        FinMientras
    FinPara
    
    Escribir ""
    Escribir "================================================"
    Escribir "Llamadas recibidas: " Sin Saltar
    Para i <- 1 Hasta numLlamadas Con Paso 1 Hacer
        Si i < numLlamadas Entonces
            Escribir Sin Saltar "[", llamadas[i], "], "
        SiNo
            Escribir "[", llamadas[i], "]"
        FinSi
    FinPara
    Escribir "================================================"
    Escribir ""
    
    // Separar llamadas en dos grupos: arriba y abajo
    Para i <- 1 Hasta numLlamadas Con Paso 1 Hacer
        Si llamadas[i] > pisoActual Entonces
            // Llamadas hacia arriba
            contArriba <- contArriba + 1
            llamadasArriba[contArriba] <- llamadas[i]
        SiNo Si llamadas[i] < pisoActual Entonces
                // Llamadas hacia abajo
                contAbajo <- contAbajo + 1
                llamadasAbajo[contAbajo] <- llamadas[i]
            FinSi
        FinSi
    FinPara
    
    // Ordenar llamadas hacia arriba (menor a mayor) - Método burbuja
    Si contArriba > 1 Entonces
        Para i <- 1 Hasta contArriba - 1 Con Paso 1 Hacer
            Para j <- 1 Hasta contArriba - i Con Paso 1 Hacer
                Si llamadasArriba[j] > llamadasArriba[j + 1] Entonces
                    temp <- llamadasArriba[j]
                    llamadasArriba[j] <- llamadasArriba[j + 1]
                    llamadasArriba[j + 1] <- temp
                FinSi
            FinPara
        FinPara
    FinSi
    
    // Ordenar llamadas hacia abajo (mayor a menor) - Método burbuja
    Si contAbajo > 1 Entonces
        Para i <- 1 Hasta contAbajo - 1 Con Paso 1 Hacer
            Para j <- 1 Hasta contAbajo - i Con Paso 1 Hacer
                Si llamadasAbajo[j] < llamadasAbajo[j + 1] Entonces
                    temp <- llamadasAbajo[j]
                    llamadasAbajo[j] <- llamadasAbajo[j + 1]
                    llamadasAbajo[j + 1] <- temp
                FinSi
            FinPara
        FinPara
    FinSi
    
    // Mostrar análisis de llamadas
    Escribir "ANÁLISIS DE LLAMADAS:"
    Escribir "---------------------"
    Escribir "Piso actual: ", pisoActual
    Escribir ""
    
    Si contArriba > 0 Entonces
        Escribir "Llamadas ARRIBA (ordenadas): " Sin Saltar
        Para i <- 1 Hasta contArriba Con Paso 1 Hacer
            Si i < contArriba Entonces
                Escribir Sin Saltar "[", llamadasArriba[i], "], "
            SiNo
                Escribir "[", llamadasArriba[i], "]"
            FinSi
        FinPara
    SiNo
        Escribir "Llamadas ARRIBA: Ninguna"
    FinSi
    
    Si contAbajo > 0 Entonces
        Escribir "Llamadas ABAJO (ordenadas): " Sin Saltar
        Para i <- 1 Hasta contAbajo Con Paso 1 Hacer
            Si i < contAbajo Entonces
                Escribir Sin Saltar "[", llamadasAbajo[i], "], "
            SiNo
                Escribir "[", llamadasAbajo[i], "]"
            FinSi
        FinPara
    SiNo
        Escribir "Llamadas ABAJO: Ninguna"
    FinSi
    
    Escribir ""
    Escribir "================================================"
    Escribir "   RECORRIDO DEL ASCENSOR"
    Escribir "================================================"
    Escribir ""
    
    // Mostrar la ruta optimizada
    Escribir "RUTA ÓPTIMA:"
    Escribir Sin Saltar "Piso ", pisoActual
    
    // Primero atender llamadas hacia ARRIBA (SUBIENDO)
    Si contArriba > 0 Entonces
        Escribir " (Estado: SUBIENDO)"
        Para i <- 1 Hasta contArriba Con Paso 1 Hacer
            distanciaTotal <- distanciaTotal + abs(llamadasArriba[i] - pisoActual)
            pisoActual <- llamadasArriba[i]
            Escribir Sin Saltar " -> Piso ", pisoActual
        FinPara
    FinSi
    
    // Luego atender llamadas hacia ABAJO (BAJANDO)
    Si contAbajo > 0 Entonces
        Si contArriba > 0 Entonces
            Escribir ""
            Escribir Sin Saltar "         (Estado: BAJANDO)"
        SiNo
            Escribir " (Estado: BAJANDO)"
        FinSi
        
        Para i <- 1 Hasta contAbajo Con Paso 1 Hacer
            distanciaTotal <- distanciaTotal + abs(llamadasAbajo[i] - pisoActual)
            pisoActual <- llamadasAbajo[i]
            Escribir Sin Saltar " -> Piso ", pisoActual
        FinPara
    FinSi
    
    Escribir ""
    Escribir ""
    Escribir "================================================"
    Escribir "   RESULTADO FINAL"
    Escribir "================================================"
    Escribir "Piso final del ascensor: ", pisoActual
    Escribir "Distancia total recorrida: ", distanciaTotal, " pisos"
    Escribir "================================================"
    Escribir ""
    
FinAlgoritmo