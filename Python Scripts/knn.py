import numpy as np 
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.neighbors import KNeighborsClassifier

url = "/tmp/mood.csv"

# Assign colum names to the dataset
names = ['Temperature', 'Pulse', 'Mood']

# Read dataset to pandas dataframe
dataset = pd.read_csv(url, names=names)

print(dataset)

dataset.head()
"""
X = dataset.iloc[:, :-1].values  
y = dataset.iloc[:, 2].values  

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.0)  

scaler = StandardScaler()  
scaler.fit(X_train)

X_train = scaler.transform(X_train)  
X_test = scaler.transform(X_test) 

classifier = KNeighborsClassifier(n_neighbors=5)  
classifier.fit(X_train, y_train)

y_pred = classifier.predict(X_test)

print y_pred
"""