Algoritmo CompresorTextoRLE
    // Declaración de variables
    Definir cadenaOriginal, cadenaComprimida Como Caracter
    Definir caracterActual, caracterSiguiente Como Caracter
    Definir contador, i, longitudCadena Como Entero
    Definir valida Como Logico
    
    // Presentación del programa
    Escribir "========================================================"
    Escribir "     COMPRESOR DE TEXTO - RUN-LENGTH ENCODING (RLE)"
    Escribir "========================================================"
    Escribir ""
    Escribir "Este algoritmo comprime texto reemplazando secuencias"
    Escribir "de caracteres repetidos con: NÚMERO + CARÁCTER"
    Escribir ""
    Escribir "Ejemplo: AAAABBBCCDAA --> 4A3B2C1D2A"
    Escribir ""
    Escribir "========================================================"
    Escribir ""
    
    // Solicitar cadena de entrada con validación
    valida <- Falso
    Mientras valida = Falso Hacer
        Escribir Sin Saltar "Ingrese la cadena de texto a comprimir (sin números): "
        Leer cadenaOriginal
        
        // Validar que no contenga números
        valida <- ValidarCadena(cadenaOriginal)
        
        Si valida = Falso Entonces
            Escribir "Error: La cadena no debe contener números. Intente nuevamente."
            Escribir ""
        FinSi
    FinMientras
    
    // Obtener longitud de la cadena
    longitudCadena <- Longitud(cadenaOriginal)
    
    // Validar que la cadena no esté vacía
    Si longitudCadena = 0 Entonces
        Escribir ""
        Escribir "Error: La cadena está vacía."
        Escribir ""
    SiNo
        Escribir ""
        Escribir "========================================================"
        Escribir "   PROCESO DE COMPRESIÓN (PASO A PASO)"
        Escribir "========================================================"
        Escribir ""
        Escribir "Cadena Original: ", cadenaOriginal
        Escribir "Longitud: ", longitudCadena, " caracteres"
        Escribir ""
        Escribir "-----------------------------------------------------"
        Escribir "| Pos | Car.Actual | Car.Leído | Cont | Resultado  |"
        Escribir "-----------------------------------------------------"
        
        // Inicializar variables
        cadenaComprimida <- ""
        contador <- 1
        caracterActual <- Subcadena(cadenaOriginal, 1, 1)
        
        // Mostrar primer paso
        Escribir "| ", 1, "   | (inicio)   |    ", caracterActual, "      |  ", contador, "   | ", cadenaComprimida, Sin Saltar
        Escribir " |"
        
        // Recorrer la cadena una sola vez
        Para i <- 2 Hasta longitudCadena Con Paso 1 Hacer
            caracterSiguiente <- Subcadena(cadenaOriginal, i, i)
            
            // Si el siguiente carácter es igual al actual, incrementar contador
            Si caracterSiguiente = caracterActual Entonces
                contador <- contador + 1
                
                // Mostrar paso
                Escribir "| ", i, "   |     ", caracterActual, "      |    ", caracterSiguiente, "      |  ", contador, "   | ", cadenaComprimida, Sin Saltar
                Escribir " |"
            SiNo
                // Si es diferente, agregar al resultado y reiniciar contador
                cadenaComprimida <- Concatenar(cadenaComprimida, ConvertirATexto(contador))
                cadenaComprimida <- Concatenar(cadenaComprimida, caracterActual)
                
                // Mostrar paso (escritura)
                Escribir "| ", i, "   |     ", caracterActual, "      |    ", caracterSiguiente, "      | (", contador, caracterActual, ")", " | ", cadenaComprimida, Sin Saltar
                Escribir " |"
                
                // Reiniciar para el nuevo carácter
                caracterActual <- caracterSiguiente
                contador <- 1
            FinSi
        FinPara
        
        // Agregar el último grupo de caracteres
        cadenaComprimida <- Concatenar(cadenaComprimida, ConvertirATexto(contador))
        cadenaComprimida <- Concatenar(cadenaComprimida, caracterActual)
        
        // Mostrar último paso
        Escribir "| FIN |     ", caracterActual, "      |   (fin)   | (", contador, caracterActual, ")", " | ", cadenaComprimida, Sin Saltar
        Escribir " |"
        
        Escribir "-----------------------------------------------------"
        Escribir ""
        
        // Mostrar resultados finales
        Escribir "========================================================"
        Escribir "   RESULTADOS DE LA COMPRESIÓN"
        Escribir "========================================================"
        Escribir ""
        Escribir "Cadena Original:    ", cadenaOriginal
        Escribir "Cadena Comprimida:  ", cadenaComprimida
        Escribir ""
        Escribir "Longitud Original:     ", longitudCadena, " caracteres"
        Escribir "Longitud Comprimida:   ", Longitud(cadenaComprimida), " caracteres"
        Escribir ""
        
        // Calcular tasa de compresión
        Si Longitud(cadenaComprimida) < longitudCadena Entonces
            Escribir "Ahorro: ", longitudCadena - Longitud(cadenaComprimida), " caracteres ("
            Escribir "        ", trunc(((longitudCadena - Longitud(cadenaComprimida)) * 100) / longitudCadena), "% de compresión)"
        SiNo Si Longitud(cadenaComprimida) = longitudCadena Entonces
                Escribir "Sin cambio en el tamaño"
            SiNo
                Escribir "Expansión: +", Longitud(cadenaComprimida) - longitudCadena, " caracteres"
                Escribir "(La cadena original tiene pocos caracteres repetidos)"
            FinSi
        FinSi
        
        Escribir ""
        Escribir "========================================================"
        Escribir ""
        
        // Ofrecer descompresión
        DescomprimirTexto(cadenaComprimida)
    FinSi
    
FinAlgoritmo

// Función para validar que la cadena no contenga números
Funcion resultado <- ValidarCadena(cadena)
    Definir i, long Como Entero
    Definir caracter Como Caracter
    Definir resultado Como Logico
    
    resultado <- Verdadero
    long <- Longitud(cadena)
    
    Para i <- 1 Hasta long Con Paso 1 Hacer
        caracter <- Subcadena(cadena, i, i)
        
        // Verificar si es un dígito (0-9)
        Si caracter >= "0" Y caracter <= "9" Entonces
            resultado <- Falso
        FinSi
    FinPara
FinFuncion

// Subproceso para descomprimir el texto (demostración)
SubProceso DescomprimirTexto(cadenaComprimida)
    Definir opcion Como Caracter
    Definir cadenaDescomprimida Como Caracter
    Definir i, j, longitud, numero Como Entero
    Definir caracter, numeroStr Como Caracter
    
    Escribir "¿Desea ver la descompresión del texto? (S/N): ", Sin Saltar
    Leer opcion
    
    Si Mayusculas(opcion) = "S" Entonces
        Escribir ""
        Escribir "========================================================"
        Escribir "   DESCOMPRESIÓN DEL TEXTO"
        Escribir "========================================================"
        Escribir ""
        
        cadenaDescomprimida <- ""
        longitud <- Longitud(cadenaComprimida)
        i <- 1
        
        Mientras i <= longitud Hacer
            // Leer el número (pueden ser múltiples dígitos)
            numeroStr <- ""
            Mientras i <= longitud Y Subcadena(cadenaComprimida, i, i) >= "0" Y Subcadena(cadenaComprimida, i, i) <= "9" Hacer
                numeroStr <- Concatenar(numeroStr, Subcadena(cadenaComprimida, i, i))
                i <- i + 1
            FinMientras
            
            // Convertir a número
            numero <- ConvertirANumero(numeroStr)
            
            // Leer el carácter
            Si i <= longitud Entonces
                caracter <- Subcadena(cadenaComprimida, i, i)
                
                // Repetir el carácter 'numero' veces
                Para j <- 1 Hasta numero Con Paso 1 Hacer
                    cadenaDescomprimida <- Concatenar(cadenaDescomprimida, caracter)
                FinPara
                
                i <- i + 1
            FinSi
        FinMientras
        
        Escribir "Cadena Comprimida:    ", cadenaComprimida
        Escribir "Cadena Descomprimida: ", cadenaDescomprimida
        Escribir ""
        Escribir "¡Descompresión exitosa!"
        Escribir "========================================================"
        Escribir ""
    FinSi
FinSubProceso
