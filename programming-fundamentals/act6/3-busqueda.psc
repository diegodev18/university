Algoritmo BusquedaNumerosVampiro
    // Declaración de variables
    Definir numero, colmillo1, colmillo2, producto Como Entero
    Definir digitosNumero, digitosColmillos Como Entero
    Definir contadorVampiros Como Entero
    Definir esVampiro Como Logico
    
    // Arreglos para almacenar dígitos
    Dimension digitosNumero[4]
    Dimension digitosColmillos[4]
    
    // Inicialización
    contadorVampiros <- 0
    
    // Presentación del programa
    Escribir "========================================================"
    Escribir "    BÚSQUEDA DE NÚMEROS VAMPIRO (1000 - 9999)"
    Escribir "========================================================"
    Escribir ""
    Escribir "Un Número Vampiro de 4 dígitos es un número que es el"
    Escribir "producto de dos" colmillos "de 2 dígitos formados con"
    Escribir "todos los dígitos del número original."
    Escribir ""
    Escribir "Ejemplo: 1260 = 21 × 60 (dígitos: 1,2,6,0)"
    Escribir ""
    Escribir "Buscando números vampiro..."
    Escribir "========================================================"
    Escribir ""
    
    // Iterar a través de todos los números de 4 dígitos
    Para numero <- 1000 Hasta 9999 Con Paso 1 Hacer
        
        // Extraer dígitos del número original
        ExtraerDigitos(numero, digitosNumero)
        
        // Ordenar los dígitos del número original
        OrdenarDigitos(digitosNumero, 4)
        
        // Probar todos los pares posibles de colmillos de 2 dígitos
        Para colmillo1 <- 10 Hasta 99 Con Paso 1 Hacer
            Para colmillo2 <- colmillo1 Hasta 99 Con Paso 1 Hacer
                
                // Calcular el producto
                producto <- colmillo1 * colmillo2
                
                // Verificar si el producto es igual al número original
                Si producto = numero Entonces
                    
                    // Extraer dígitos de los colmillos combinados
                    ExtraerDigitosColmillos(colmillo1, colmillo2, digitosColmillos)
                    
                    // Ordenar los dígitos de los colmillos
                    OrdenarDigitos(digitosColmillos, 4)
                    
                    // Comparar si los dígitos son una permutación
                    esVampiro <- CompararDigitos(digitosNumero, digitosColmillos, 4)
                    
                    Si esVampiro Entonces
                        contadorVampiros <- contadorVampiros + 1
                        Escribir contadorVampiros, ". ", numero, " = ", colmillo1, " × ", colmillo2
                        
                        // Mostrar verificación de dígitos
                        Escribir "   Dígitos de " numero ": {" Sin Saltar
                        MostrarDigitosOrdenados(numero)
                        Escribir "}"
                        
                        Escribir "   Dígitos de " colmillo1 "," colmillo2 ": {" Sin Saltar
                        MostrarDigitosOrdenadosColmillos(colmillo1, colmillo2)
                        Escribir "}"
                        Escribir ""
                    FinSi
                FinSi
                
            FinPara
        FinPara
        
    FinPara
    
    // Resumen final
    Escribir "========================================================"
    Escribir "RESUMEN:"
    Escribir "Se encontraron ", contadorVampiros, " números vampiro entre 1000 y 9999"
    Escribir "========================================================"
    Escribir ""
    
FinAlgoritmo

// Subproceso para extraer los 4 dígitos de un número
SubProceso ExtraerDigitos(num, digitos Por Referencia)
    Definir i, temp Como Entero
    temp <- num
    
    Para i <- 4 Hasta 1 Con Paso -1 Hacer
        digitos[i] <- temp MOD 10
        temp <- trunc(temp / 10)
    FinPara
FinSubProceso

// Subproceso para extraer dígitos de dos colmillos
SubProceso ExtraerDigitosColmillos(col1, col2, digitos Por Referencia)
    Definir temp Como Entero
    
    // Extraer dígitos del primer colmillo
    temp <- col1
    digitos[2] <- temp MOD 10
    digitos[1] <- trunc(temp / 10)
    
    // Extraer dígitos del segundo colmillo
    temp <- col2
    digitos[4] <- temp MOD 10
    digitos[3] <- trunc(temp / 10)
FinSubProceso

// Subproceso para ordenar un arreglo de dígitos (método burbuja)
SubProceso OrdenarDigitos(digitos Por Referencia, n)
    Definir i, j, temp Como Entero
    
    Para i <- 1 Hasta n - 1 Con Paso 1 Hacer
        Para j <- 1 Hasta n - i Con Paso 1 Hacer
            Si digitos[j] > digitos[j + 1] Entonces
                temp <- digitos[j]
                digitos[j] <- digitos[j + 1]
                digitos[j + 1] <- temp
            FinSi
        FinPara
    FinPara
FinSubProceso

// Función para comparar dos arreglos de dígitos
Funcion resultado <- CompararDigitos(arr1, arr2, n)
    Definir i Como Entero
    Definir resultado Como Logico
    
    resultado <- Verdadero
    
    Para i <- 1 Hasta n Con Paso 1 Hacer
        Si arr1[i] <> arr2[i] Entonces
            resultado <- Falso
        FinSi
    FinPara
FinFuncion

// Subproceso auxiliar para mostrar dígitos ordenados de un número
SubProceso MostrarDigitosOrdenados(num)
    Definir digitos Como Entero
    Definir i Como Entero
    Dimension digitos[4]
    
    ExtraerDigitos(num, digitos)
    OrdenarDigitos(digitos, 4)
    
    Para i <- 1 Hasta 4 Con Paso 1 Hacer
        Si i < 4 Entonces
            Escribir Sin Saltar digitos[i], ","
        SiNo
            Escribir Sin Saltar digitos[i]
        FinSi
    FinPara
FinSubProceso

// Subproceso auxiliar para mostrar dígitos ordenados de dos colmillos
SubProceso MostrarDigitosOrdenadosColmillos(col1, col2)
    Definir digitos Como Entero
    Definir i Como Entero
    Dimension digitos[4]
    
    ExtraerDigitosColmillos(col1, col2, digitos)
    OrdenarDigitos(digitos, 4)
    
    Para i <- 1 Hasta 4 Con Paso 1 Hacer
        Si i < 4 Entonces
            Escribir Sin Saltar digitos[i], ","
        SiNo
            Escribir Sin Saltar digitos[i]
        FinSi
    FinPara
FinSubProceso