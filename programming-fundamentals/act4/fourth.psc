Proceso ConseguirPromedio
    Escribir "Ingresa la primera nota"
    Leer nota1
    Escribir "Ingresa la segunda nota"
    Leer nota2
    Escribir "Ingresa la tercera nota"
    Leer nota3

    promedio <- (nota1 + nota2 + nota3) / 3

    Si promedio >= 7 Entonces
        Escribir "El estudiante ha aprobado con un promedio de: ", promedio
    SiNo
        Escribir "El estudiante ha reprobado con un promedio de: ", promedio
    FinSi
FinProceso