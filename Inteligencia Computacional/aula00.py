# -*- coding: utf-8 -*-
"""
@author: Laura
"""

import pandas as pd

base = pd.read_csv('exemplo.csv')

##Estatistica descritiva basica
estatistica = base.describe()

media = base['age'][base.age > 0].mean()
base.loc[base.age > 0, 'age'] = media

#visualização do pairplot
import seaborn as sns; sns.set(style="ticks", color_codes=True)
g = sns.pairplot(base)

#pre processamento dos dados
previsores = base.iloc[:,1:4].values #as outras colunas até a 3 - exclui a 4
classe = base.iloc[:, 1:4].values #infomração da classe - ultima coluna (0 e 1)

from sklearn.impute import SimpleImputer
import numpy as np
imputer = SimpleImputer(missing_values= np.nan, strategy='mean')
imputer = imputer.fit(previsores)
previsores = imputer.transform(previsores) #normalizar a base de dados

#Normailzação das bases de dados
#IMPORTANTE: Nunca treinar com os dados usados no teste
from sklearn.model_selection import train_test_split
#previsores_treinamento, previsores_teste, classe_treinamento, classe_teste = 

