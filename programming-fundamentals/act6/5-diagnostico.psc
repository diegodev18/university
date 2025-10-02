Algoritmo SistemaDiagnosticoPorPuntuacion
    // Declaración de variables
    Definir puntos Como Entero
    Definir puntajeEnfermedades Como Entero
    Definir respuesta Como Caracter
    Definir i, j, maxPuntaje, contadorMaximo Como Entero
    Definir nombresSintomas, nombresEnfermedades Como Caracter
    Definir hayEmpate Como Logico
    
    // Dimensionamiento de estructuras de datos
    Dimension puntos[3, 5]              // Matriz de puntos [enfermedad, síntoma]
    Dimension puntajeEnfermedades[3]    // Arreglo para acumular puntajes
    Dimension nombresSintomas[5]         // Nombres de los síntomas
    Dimension nombresEnfermedades[3]     // Nombres de las enfermedades
    
    // Presentación del programa
    Escribir "========================================================"
    Escribir "      SISTEMA DE DIAGNÓSTICO POR PUNTUACIÓN"
    Escribir "========================================================"
    Escribir ""
    Escribir "Este sistema evalúa 5 síntomas para diagnosticar"
    Escribir "una de tres posibles enfermedades (A, B, C)."
    Escribir ""
    Escribir "Cada síntoma tiene un peso diferente para cada"
    Escribir "enfermedad. El diagnóstico se basa en la puntuación"
    Escribir "total acumulada."
    Escribir ""
    Escribir "========================================================"
    Escribir ""
    
    // Inicializar nombres de enfermedades
    nombresEnfermedades[1] <- "Enfermedad A"
    nombresEnfermedades[2] <- "Enfermedad B"
    nombresEnfermedades[3] <- "Enfermedad C"
    
    // Inicializar nombres de síntomas
    nombresSintomas[1] <- "Fiebre alta persistente"
    nombresSintomas[2] <- "Tos seca continua"
    nombresSintomas[3] <- "Dolor de cabeza intenso"
    nombresSintomas[4] <- "Fatiga y debilidad"
    nombresSintomas[5] <- "Dificultad para respirar"
    
    // Inicializar matriz de puntos según la tabla proporcionada
    // Enfermedad A
    puntos[1, 1] <- 5  // Síntoma 1
    puntos[1, 2] <- 1  // Síntoma 2
    puntos[1, 3] <- 1  // Síntoma 3
    puntos[1, 4] <- 3  // Síntoma 4
    puntos[1, 5] <- 0  // Síntoma 5
    
    // Enfermedad B
    puntos[2, 1] <- 1  // Síntoma 1
    puntos[2, 2] <- 4  // Síntoma 2
    puntos[2, 3] <- 0  // Síntoma 3
    puntos[2, 4] <- 2  // Síntoma 4
    puntos[2, 5] <- 5  // Síntoma 5
    
    // Enfermedad C
    puntos[3, 1] <- 2  // Síntoma 1
    puntos[3, 2] <- 2  // Síntoma 2
    puntos[3, 3] <- 5  // Síntoma 3
    puntos[3, 4] <- 0  // Síntoma 4
    puntos[3, 5] <- 1  // Síntoma 5
    
    // Mostrar tabla de puntuación
    Escribir "TABLA DE PUNTUACIÓN:"
    Escribir "========================================================="
    Escribir "|            | Sínt.1 | Sínt.2 | Sínt.3 | Sínt.4 | Sínt.5 |"
    Escribir "|---------------------------------------------------------|"
    
    Para i <- 1 Hasta 3 Con Paso 1 Hacer
        Escribir Sin Saltar "| Enferm. ", Subcadena("ABC", i, i), " |"
        Para j <- 1 Hasta 5 Con Paso 1 Hacer
            Escribir Sin Saltar "   ", puntos[i, j], "    |"
        FinPara
        Escribir ""
    FinPara
    Escribir "========================================================="
    Escribir ""
    
    // Inicializar puntajes en cero
    Para i <- 1 Hasta 3 Con Paso 1 Hacer
        puntajeEnfermedades[i] <- 0
    FinPara
    
    // Realizar evaluación de síntomas
    Escribir "EVALUACIÓN DE SÍNTOMAS:"
    Escribir "Por favor, responda SÍ o NO a cada pregunta:"
    Escribir "========================================================="
    Escribir ""
    
    // Arreglo para guardar respuestas (para la prueba de escritorio)
    Definir respuestas Como Caracter
    Dimension respuestas[5]
    
    Para i <- 1 Hasta 5 Con Paso 1 Hacer
        Escribir "Síntoma ", i, ": ", nombresSintomas[i]
        
        // Validar entrada
        respuesta <- ""
        Mientras respuesta <> "S" Y respuesta <> "N" Y respuesta <> "SI" Y respuesta <> "NO" Hacer
            Escribir Sin Saltar "¿Presenta este síntoma? (S/N): "
            Leer respuesta
            respuesta <- Mayusculas(respuesta)
            
            Si respuesta <> "S" Y respuesta <> "N" Y respuesta <> "SI" Y respuesta <> "NO" Entonces
                Escribir "Respuesta inválida. Por favor, ingrese S o N."
            FinSi
        FinMientras
        
        // Guardar respuesta
        Si respuesta = "S" O respuesta = "SI" Entonces
            respuestas[i] <- "SÍ"
        SiNo
            respuestas[i] <- "NO"
        FinSi
        
        // Si la respuesta es Sí, sumar puntos correspondientes
        Si respuesta = "S" O respuesta = "SI" Entonces
            Escribir "   -> Sumando puntos..."
            Para j <- 1 Hasta 3 Con Paso 1 Hacer
                puntajeEnfermedades[j] <- puntajeEnfermedades[j] + puntos[j, i]
                Si puntos[j, i] > 0 Entonces
                    Escribir "      Enfermedad ", Subcadena("ABC", j, j), ": +", puntos[j, i], " puntos"
                FinSi
            FinPara
        SiNo
            Escribir "   -> No se suman puntos."
        FinSi
        
        Escribir ""
    FinPara
    
    // Mostrar prueba de escritorio
    Escribir "========================================================"
    Escribir "   PRUEBA DE ESCRITORIO - SEGUIMIENTO DE CÁLCULO"
    Escribir "========================================================"
    Escribir ""
    Escribir "Respuestas registradas: ", Sin Saltar
    Para i <- 1 Hasta 5 Con Paso 1 Hacer
        Si i < 5 Entonces
            Escribir Sin Saltar respuestas[i], ", "
        SiNo
            Escribir respuestas[i]
        FinSi
    FinPara
    Escribir ""
    Escribir "Cálculo detallado:"
    Escribir "-----------------------------------------------------------"
    
    Para i <- 1 Hasta 3 Con Paso 1 Hacer
        Escribir Sin Saltar "Puntaje ", Subcadena("ABC", i, i), ": "
        
        Para j <- 1 Hasta 5 Con Paso 1 Hacer
            Si respuestas[j] = "SÍ" Entonces
                Escribir Sin Saltar puntos[i, j], " (S", j, ")"
            SiNo
                Escribir Sin Saltar "0 (S", j, ")"
            FinSi
            
            Si j < 5 Entonces
                Escribir Sin Saltar " + "
            FinSi
        FinPara
        
        Escribir " = ", puntajeEnfermedades[i]
    FinPara
    
    Escribir ""
    Escribir "========================================================"
    Escribir "   RESULTADOS DEL DIAGNÓSTICO"
    Escribir "========================================================"
    Escribir ""
    Escribir "Puntajes finales:"
    
    Para i <- 1 Hasta 3 Con Paso 1 Hacer
        Escribir "  • ", nombresEnfermedades[i], ": ", puntajeEnfermedades[i], " puntos"
    FinPara
    
    Escribir ""
    Escribir "-----------------------------------------------------------"
    
    // Encontrar el puntaje máximo
    maxPuntaje <- puntajeEnfermedades[1]
    Para i <- 2 Hasta 3 Con Paso 1 Hacer
        Si puntajeEnfermedades[i] > maxPuntaje Entonces
            maxPuntaje <- puntajeEnfermedades[i]
        FinSi
    FinPara
    
    // Verificar si hay empate
    contadorMaximo <- 0
    Para i <- 1 Hasta 3 Con Paso 1 Hacer
        Si puntajeEnfermedades[i] = maxPuntaje Entonces
            contadorMaximo <- contadorMaximo + 1
        FinSi
    FinPara
    
    hayEmpate <- contadorMaximo > 1
    
    // Mostrar diagnóstico
    Si maxPuntaje = 0 Entonces
        Escribir "DIAGNÓSTICO: No se detectaron síntomas significativos."
        Escribir "No es posible determinar una enfermedad con los datos"
        Escribir "proporcionados. Se recomienda consultar a un médico."
    SiNo
        Si hayEmpate Entonces
            Escribir "DIAGNÓSTICO: Se detectó un EMPATE entre:"
            Escribir ""
            Para i <- 1 Hasta 3 Con Paso 1 Hacer
                Si puntajeEnfermedades[i] = maxPuntaje Entonces
                    Escribir "  • ", nombresEnfermedades[i], " (", maxPuntaje, " puntos)"
                FinSi
            FinPara
            Escribir ""
            Escribir "Se recomienda realizar estudios adicionales para"
            Escribir "determinar el diagnóstico preciso."
        SiNo
            Escribir "DIAGNÓSTICO: El diagnóstico más probable es:"
            Escribir ""
            Para i <- 1 Hasta 3 Con Paso 1 Hacer
                Si puntajeEnfermedades[i] = maxPuntaje Entonces
                    Escribir "  ► ", nombresEnfermedades[i], " (", maxPuntaje, " puntos)"
                FinSi
            FinPara
            Escribir ""
            Escribir "Se recomienda consultar a un profesional de la salud"
            Escribir "para confirmar el diagnóstico."
        FinSi
    FinSi
    
    Escribir ""
    Escribir "========================================================"
    Escribir ""
    Escribir "ADVERTENCIA: Este es un sistema de diagnóstico básico"
    Escribir "con fines educativos. NO reemplaza la opinión de un"
    Escribir "profesional médico cualificado."
    Escribir "========================================================"
    Escribir ""
    
FinAlgoritmo
