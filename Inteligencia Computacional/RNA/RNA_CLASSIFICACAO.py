import pandas as pd
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
from sklearn.neural_network import MLPClassifier

base = pd.read_excel('iris.xlsx')
base.columns = ['LS', 'CS', 'LP', 'CP', 'Classe']

# Separação das variáveis Previsoras e a Classe
previsores = base.iloc[:, 0:4].values
classe = base.iloc[:, 4].values


# NORMALIZAÇÃO DA BASE DE DADOS 
scaler = StandardScaler()
previsores = scaler.fit_transform(previsores)


# DIVISAO DA BASE EM CONJUNTOS DE TREINAMENTO E TESTE
previsores_treinamento, previsores_teste, classe_treinamento, classe_teste = train_test_split(previsores, classe, test_size=0.20, random_state=0)

# BIBLIOTECA DE REDE NEURAL PARA CLASSIFICAÇÃO - nn é arquitetura da rede desejada
"""
hidden_layer_size = tamanho da camada intermediaria
activation = função de ativação (logistic, tanh, identity, relu)
max_iter = numero de iterações (problemas simples costumam nem precisar de 1000)
tol = tolerância permitida
"""
nn = MLPClassifier(hidden_layer_sizes=(10,),  activation='logistic', max_iter=1000,tol=0.001)

treino = nn.fit(previsores_treinamento, classe_treinamento)

teste = nn.predict(previsores_teste)

#MATRIZ DE CONFUSÃO
from sklearn.metrics import confusion_matrix
cm=confusion_matrix(classe_teste, teste)
