# -*- coding: utf-8 -*-
"""
@author: Laura
"""
import pandas as pd
import matplotlib.pyplot as plt

from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
from sklearn.neural_network import MLPClassifier
from sklearn.preprocessing import LabelEncoder
from sklearn.metrics import confusion_matrix

base_dados = pd.read_csv('bd_tarefa5.csv', sep=';')
estatistica = base_dados.describe() #apenas de colunas numericas

# Separação das variáveis Previsoras e a Classe
previsores = base_dados.iloc[:, 0:16].values
classe = base_dados.iloc[:, 16].values

# NORMALIZAÇÃO DA BASE DE DADOS 
#converter dados textuais em numericos para interpretação do programa
le = LabelEncoder()
for i in range(0, 16):
    previsores[:, i] = le.fit_transform(previsores[:, i])

# colocar as bases numericas em unidades proximas
scaler = StandardScaler()
previsores = scaler.fit_transform(previsores)

# DIVISAO DA BASE EM CONJUNTOS DE TREINAMENTO E TESTE
previsores_treino, previsores_teste, classe_treino, classe_teste = train_test_split(
    previsores, classe, test_size=0.20, random_state=0)

# BIBLIOTECA DE REDE NEURAL PARA CLASSIFICAÇÃO - nn é arquitetura da rede desejada
"""
FOR para verificar eficiencia com diferentes funcoes e diferentes valores 
para camada intermediaria
Valores camada intermediaria indo de 10 a 1000, em passos de 20
"""

funcoes = ['logistic', 'tanh', 'identity', 'relu'] #vetor com as funcoes possiveis
eficiencia_funcoes = []
eficiencia_camadas = []
eficiencia_total = [[]]
camadas = [20,110,200,260,320,360,400,460,500]
"""
hidden_layer_size = tamanho da camada intermediaria
activation = função de ativação (logistic, tanh, identity, relu)
max_iter = numero de iterações (problemas simples costumam nem precisar de 1000)
tol = tolerância permitida
"""
for j in range(len(funcoes)):
    print('j = ',funcoes[j])
    eficiencia_camadas.clear()
    for k in range(len(camadas)):
        print(camadas[k])
        nn = MLPClassifier(hidden_layer_sizes=(camadas[k],),  
                           activation=funcoes[j], max_iter=1000, tol=0.001)
        
        treino = (nn.fit(previsores_treino, classe_treino))        
        teste = nn.predict(previsores_teste)
        #MATRIZ DE CONFUSÃO
        matriz = confusion_matrix(classe_teste, teste)
        
        #vetor com as eficiencias para variação do num de camadas
        acerto = (matriz[0,0]+matriz[1,1])/len(classe_teste)*100
        eficiencia_camadas.append(acerto)
        
    eficiencia_funcoes.insert(j, eficiencia_camadas)
    eficiencia_total.append(list(eficiencia_funcoes[0]))

del(eficiencia_total[0]) #apagar colchetes iniciais

max(eficiencia_total[1])
camadas[eficiencia_total[1].index(max(eficiencia_total[1]))]

plt.plot(eficiencia_total[0], label="Logistic")
plt.plot(eficiencia_total[1], label="Tanh")
plt.plot(eficiencia_total[2], label="Identity")
plt.plot(eficiencia_total[3], label="Relu")
plt.title('Eficiencia com camadas intermediaria variando de 4 a 225')
plt.legend(loc='lower right')
plt.show()