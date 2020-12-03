import pandas as pd
base = pd.read_csv("census.csv")

# Separação do conjunto de input e target (previsores e classe)
previsores = base.iloc[:,0:14].values
classe = base.iloc[:,14].values

# tratamento dos dados categóricos

#Tranformando dados categóricos em valores numéricos
from sklearn.preprocessing import LabelEncoder, OneHotEncoder
LEprevisores = LabelEncoder()

previsores[:,1] = LEprevisores.fit_transform(previsores[:,1])
previsores[:,3] = LEprevisores.fit_transform(previsores[:,3])
previsores[:,5] = LEprevisores.fit_transform(previsores[:,5])
previsores[:,6] = LEprevisores.fit_transform(previsores[:,6])
previsores[:,7] = LEprevisores.fit_transform(previsores[:,7])
previsores[:,8] = LEprevisores.fit_transform(previsores[:,8])
previsores[:,9] = LEprevisores.fit_transform(previsores[:,9])
previsores[:,13] = LEprevisores.fit_transform(previsores[:,13])

# transformando dados categóricos em matrizes de zeros e um
OHencoder = OneHotEncoder(categorical_features = [1,3,5,6,7,8,9,13])
previsores = OHencoder.fit_transform(previsores).toarray()

# Normalização dos Dados
from sklearn.preprocessing import StandardScaler

scaler = StandardScaler()
previsores_normalizado = scaler.fit_transform(previsores)

from sklearn.neighbors import KNeighborsClassifier

knn1 = KNeighborsClassifier(n_neighbors=5)
knn1.fit(previsores, classe) 
res1 = knn1.predict(previsores)

knn2 = KNeighborsClassifier(n_neighbors=5)
knn2.fit(previsores_normalizado, classe) 
res2 = knn2.predict(previsores_normalizado)

from sklearn.metrics import confusion_matrix
confusion_matrix(classe, res1)
confusion_matrix(classe, res2)