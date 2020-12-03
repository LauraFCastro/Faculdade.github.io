import pandas as pd

base = pd.read_csv('credit-data.csv')

## estatística descritiva básica
estatistica = base.describe()

media = base['age'][base.age > 0].mean()
base.loc[base.age < 0, 'age'] = media

# visualização do pairplot
import seaborn as sns; sns.set(style="ticks", color_codes=True)
g = sns.pairplot(base)

# pre-processamento dos dados
previsores = base.iloc[:, 1:4].values
classe = base.iloc[:, 4].values

from sklearn.preprocessing import Imputer
imputer = Imputer(missing_values = 'NaN', strategy = 'mean', axis = 0)
imputer = imputer.fit(previsores)
previsores = imputer.transform(previsores)

# NORMALIZAÇÃO DA BASE DE DADOS 
from sklearn.preprocessing import StandardScaler
scaler = StandardScaler()
previsores = scaler.fit_transform(previsores)


# DIVISAO DA BASE EM CONJUNTOS DE TREINAMENTO E TESTE
from sklearn.model_selection import train_test_split
previsores_treinamento, previsores_teste, classe_treinamento, classe_teste = train_test_split(previsores, classe, test_size=0.25, random_state=0)

# CLASSIFICAÇÃO USANDO KNN
from sklearn.neighbors import KNeighborsClassifier

knn1 = KNeighborsClassifier(n_neighbors=5)
knn1.fit(previsores_treinamento, classe_treinamento) 
res1 = knn1.predict(previsores_teste)

#MATRIZ DE CONFUSÃO
from sklearn.metrics import confusion_matrix
confusion_matrix(classe_teste, res1)


####################################################
####################################################

from sklearn.neighbors import KNeighborsRegressor
knn_regres = KNeighborsRegressor(n_neighbors=5)
knn_regres.fit(previsores_treinamento, classe_treinamento)
res_regres = knn_regres.predict(previsores_teste)

from sklearn.metrics import mean_absolute_error
mean_absolute_error(classe_teste, res_regres)
