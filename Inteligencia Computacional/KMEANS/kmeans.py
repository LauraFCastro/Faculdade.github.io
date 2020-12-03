# -*- coding: utf-8 -*-
"""
Created on Sun Jul 26 18:58:03 2020

@author: ricar
"""
import numpy as np
import pandas as pd
import matplotlib.pyplot as pl
import seaborn as sb

df = pd.read_csv("iris.csv")

sb.pairplot(df, hue="variety")

X = np.array(df.drop("variety",axis = 1))

from sklearn.cluster import KMeans

kmeans = KMeans(n_clusters=3,random_state=0)

kmeans.fit(X)

y = kmeans.labels_

df["k-classes"] = y