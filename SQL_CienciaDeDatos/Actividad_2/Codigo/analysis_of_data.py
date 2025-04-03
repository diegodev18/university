from pymongo import MongoClient
import matplotlib.pyplot as plt
import pandas as pd
import seaborn as sns

client = MongoClient('mongodb://localhost:27017/')

db = client['act_2_uni']
collection = db['basket_players']


def main():
    data = list(collection.find({}, {"_id": 0}))  # Excluir el campo _id
    df = pd.DataFrame(data)

    # Mostrar las primeras filas del DataFrame
    print("Primeras filas del DataFrame:")
    print(df.head())

    # 🔹 Resumen estadístico de las columnas numéricas
    print("\nResumen estadístico:")
    print(df.describe())

    # 🔹 Contar valores faltantes
    print("\nValores faltantes por columna:")
    print(df.isnull().sum())

    # 🔹 Distribución de jugadores por posición
    print("\nConteo de jugadores por posición:")
    print(df["position"].value_counts())

    # 🔹 Distribución de jugadores por equipo
    print("\nConteo de jugadores por equipo:")
    print(df["team"].value_counts())

    # 📊 **Visualización de Datos**
    plt.figure(figsize=(12, 6))

    # Histograma de edades
    plt.subplot(2, 2, 1)
    sns.histplot(df["age"], bins=20, kde=True, color='blue')
    plt.title("Distribución de Edad")

    # Diagrama de cajas de altura
    plt.subplot(2, 2, 2)
    sns.boxplot(x=df["height"], color='green')
    plt.title("Diagrama de Cajas - Altura")

    # Dispersión entre altura y peso
    plt.subplot(2, 2, 3)
    sns.scatterplot(x=df["height"], y=df["weight"], alpha=0.6)
    plt.xlabel("Altura (cm)")
    plt.ylabel("Peso (kg)")
    plt.title("Altura vs Peso")

    # Histograma de puntos por partido
    # plt.subplot(2, 2, 4)
    # sns.histplot(df["salary"], bins=20, kde=True, color='red')
    # plt.title("Distribución de Salario")

    plt.tight_layout()
    plt.show()


if __name__ == '__main__':
    try:
        main()
    except Exception as e:
        print(e)
    finally:
        client.close()
