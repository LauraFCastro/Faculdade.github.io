import pandas as pd
base = pd.read_excel('airfoil.xlsx')
base.columns = ['Freq', 'Ang', 'Cord', 'Veloc', 'Espess', 'F']
estatistica = base.describe()

# Separação das variáveis previsoras e f(x)
previsores = base.iloc[:, 0:5].values
f = base.iloc[:, 5].values

# NORMALIZAÇÃO DA BASE DE DADOS 
from sklearn.preprocessing import StandardScaler
scaler = StandardScaler()
previsores = scaler.fit_transform(previsores)

# DIVISAO DA BASE EM CONJUNTOS DE TREINAMENTO E TESTE
from sklearn.model_selection import train_test_split
previsores_treinamento, previsores_teste, f_treinamento, f_teste = train_test_split(
    previsores, f, test_size=0.25, random_state=0)


# BIBLIOTECA DE REDE NEURAL PARA REGRESSÃO - nn é arquitetura da rede desejada
"""
hidden_layer_size = tamanho da camada intermediaria
activation = função de ativação (logistic, tanh, identity, relu)
max_iter=numero de iterações (problemas simples costumam nem precisar de 1000)
tol = tolerância permitida
"""
from sklearn.neural_network import MLPRegressor
nn = MLPRegressor(hidden_layer_sizes=(10,),  activation='relu', 
                  max_iter=10000,tol=0.001)

treino = nn.fit(previsores_treinamento, f_treinamento)

teste = nn.predict(previsores_teste)

from sklearn import metrics
"""
Não consigo avaliar o erro sem avaliar a variavel F (ultima coluna)
- A media dessa variavel é de 125 mil, então um erro de 1000 é pequeno
-- erro em torno de 10.000 é uma faixa aceitável
note_to_self: colocar em porcentagem!

MAE = MEAN ABSOLUT ERROR - Media do módulo dos erros
MSE = Eleva o erro ao quadrado e depois tira a média
"""
media_base = base['F'].mean()

mae = (metrics.mean_absolute_error(f_teste,teste))
mse = (metrics.mean_squared_error(f_teste,teste))

media_mse = 100*mse/(media_base*media_base)
media_mae = 100*mae/media_base

print('MAE = {}% e MSE = {}% \n'.format(
    round(media_mae, 4), round(media_mse, 4)))

print(media_base)
print('MAE = {} e MSE = {}'.format(round(mae, 4), round(mse, 4)))