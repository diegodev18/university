from random import randint, choice
from faker import Faker
from pymongo import MongoClient
# import pandas as pd

"""
columns_of_basket_players = {
    'numeric': ['age', 'height', 'weight', 'salary'],
    'categorical': ['team', 'position'],
    'structured': ['name', 'country'],
    'text': ['description', 'bio']
    }
"""

PLAYERS_LIMIT = 5000

POSICIONS = ['Base', 'Escolta', 'Alero', 'Ala-pivot', 'Pivot']
TEAMS = ['Bulls', 'Celtics', 'Clippers', 'Grizzlies', 'Hawks', 'Heat', 'Hornets', 'Jazz', 'Kings']
NAMES = {
    'first_name': ['Michael', 'LeBron', 'Kobe', 'Shaquille', 'Larry', 'Magic', 'Tim', 'Kevin', 'Stephen', 'Dwyane', 'Kawhi', 'Giannis', 'Dirk', 'Allen', 'Paul'],
    'last_name': ['Jordan', 'James', 'Bryant', 'O\'Neal', 'Bird', 'Johnson', 'Duncan', 'Durant', 'Curry', 'Wade', 'Leonard', 'Antetokounmpo', 'Nowitzki', 'Iverson', 'Paul']
}
COUNTRIES = ["USA", "Spain", "France", "Italy", "Germany", "Argentina", "Brazil", "Canada", "Australia", "Lithuania"]

fake = Faker()
client = MongoClient('mongodb://localhost:27017/')

db = client['act_2_uni']
collection = db['basket_players']

def get_basket_player():
    numerical_values = {
        'age': randint(18, 40),
        'height': randint(170, 220),
        'weight': randint(60, 120),
        'salary': randint(10000, 1000000)
    }
    categorical_values = {
        'team': choice(TEAMS),
        'position': choice(POSICIONS)
    }
    structured_values = {
        'name': f'{choice(NAMES["first_name"])} {choice(NAMES["last_name"])}',
        'country': choice(COUNTRIES)
    }
    text_values = {
        'description': 'The best player in the history of basketball',
        'bio': fake.paragraph(nb_sentences=3)
    }
    return {
        **numerical_values,
        **categorical_values,
        **structured_values,
        **text_values
    }

def main():
    players_data = []
    for _ in range(0, PLAYERS_LIMIT):
        players_data.append(get_basket_player())
    # df_basket_player = pd.DataFrame(players_data)
    collection.insert_many(players_data)
    print(f"Se insertaron {collection.count_documents({})} documentos en MongoDB.")


if __name__ == '__main__':
    main()
