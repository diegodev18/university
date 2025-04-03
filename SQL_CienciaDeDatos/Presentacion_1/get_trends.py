import pandas as pd

# Cargar el archivo CSV (cambia 'archivo.csv' por el nombre de tu archivo)
df = pd.read_csv('archivo_limpio.csv')

# Selecciona solo las columnas numéricas
df_numeric = df.select_dtypes(include=['number'])

# Cálculo de medidas de tendencia central y dispersión
descripcion = df_numeric.describe()  # Incluye media, cuartiles, etc.
moda = df_numeric.mode().iloc[0]  # Moda (puede haber más de una)
media = df_numeric.mean()  # Media
mediana = df_numeric.median()  # Mediana
varianza = df_numeric.var()  # Varianza
desviacion_estandar = df_numeric.std()  # Desviación estándar

output = f"""\
Análisis Descriptivo:
{descripcion}

Moda:
{moda}

Media:
{media}

Mediana:
{mediana}

Varianza:
{varianza}

Desviación Estándar:
{desviacion_estandar}\
"""

# Mostrar resultados
print(output)

with open('analisis_descriptivo.txt', 'w') as f:
    f.write(output)
