#-*-encoding: utf-8 -*-

import csv
import nltk
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize

#Read the .CSV and put it in a matrix

ds = csv.reader(open('Neutras.csv'))

lines = [l for l in ds]

#Retrieve the column comment_text

comment_text = []

for i in range(len(lines)):
	comment_text.append(lines[i][0])

#Remove stopwords (with a list retrieved from the nltk one) and change to lower case

stop_words = set(stopwords.words('portuguese'))
stop_words.update(['.', ',', '?', '!', '"'])

cleared_text = []

for i in range(len(comment_text)):
	cleared_text.append([j for j in comment_text[i].replace('ç','c').lower().replace('á','a').replace('Á','a').replace('ã','a').replace('Ã','a').replace('à','a').replace('À','a').replace('Ó','o').replace('é','e').replace('É','e').replace('õ','o').replace('í','i').replace('ú','u').replace('*','').replace('-','').replace('!','').replace('.','').replace('?','').replace(',','').split() if j not in stop_words])

#Returning to only a string and updating the original matrix lines

for i in range(len(cleared_text)):
	aux2 = ""
	for j in range(len(cleared_text[i])):
		aux = cleared_text[i][j] + " "
		aux2 += aux 
	cleared_text[i] = aux2

for i in range(len(lines)):
	lines[i][0] = cleared_text[i]

#Writing the .CSV file with the updated comment_text column
 
new_file = open('neutras_clean.csv', 'w')
with new_file:
    writer = csv.writer(new_file)
    writer.writerows(lines)

print "Done!"
     







