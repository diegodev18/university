import pandas as pd

# Cargar el archivo CSV
df = pd.read_csv('games_details.csv')

# Eliminar columnas con muchos valores nulos (opcional, ajusta el umbral si es necesario)
df = df.dropna(axis=1, thresh=len(df) * 0.5)  # Elimina columnas con más del 50% de valores nulos

# Rellenar valores nulos con la media (para columnas numéricas)
df.fillna(df.mean(numeric_only=True), inplace=True)

# Eliminar duplicados
df.drop_duplicates(inplace=True)

# Eliminar espacios en blanco de nombres de columnas
df.columns = df.columns.str.strip()

# Convertir tipos de datos correctamente (ajústalo según tu necesidad)
for col in df.select_dtypes(include=['object']).columns:
    df[col] = df[col].str.strip()  # Eliminar espacios extra en strings

# Guardar el archivo limpio
df.to_csv('archivo_limpio.csv', index=False)

print("Limpieza completada. Archivo guardado como 'archivo_limpio.csv'.")
