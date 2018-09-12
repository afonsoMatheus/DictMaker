#-*-encoding: utf-8 -*-
import sys  

reload(sys)  
sys.setdefaultencoding('utf8')

import math
from textblob import TextBlob as tb

def tf(word, blob):
    return (float)(blob.words.count(word)) / (float)(len(blob.words))

def n_containing(word, bloblist):
    return sum(1 for blob in bloblist if word in blob.words)

def idf(word, bloblist):
    return math.log(len(bloblist) / (float)(1 + n_containing(word, bloblist)))

def tfidf(word, blob, bloblist):
    return tf(word, blob) * idf(word, bloblist)

for i in range(10): 

	arquivoOpenPos = open('/home/afonso/workspace/DictMaker/Bases/Arquivo' + str(i+1) + '/Treinamento_Positivas_' + str(i+1) + '.txt', 'r')
	arquivoOpenNeu = open('/home/afonso/workspace/DictMaker/Bases/Arquivo' + str(i+1) + '/Treinamento_Neutras_' + str(i+1) + '.txt', 'r')
	arquivoOpenNeg = open('/home/afonso/workspace/DictMaker/Bases/Arquivo' + str(i+1) + '/Treinamento_Negativas_' + str(i+1) + '.txt', 'r')

	positivas = arquivoOpenPos.read()
	neutras = arquivoOpenNeu.read()
	negativas = arquivoOpenNeg.read()

	document1 = tb(positivas)
	
	document2 = tb(neutras)

	document3 = tb(negativas)

	bloblist = [document1, document2, document3]

	arquivoPos = open('/home/afonso/workspace/DictMaker/TF_IDF/Arquivo' + str(i+1) + '/tf_idf_positivas.txt', 'w')
	arquivoNeg = open('/home/afonso/workspace/DictMaker/TF_IDF/Arquivo' + str(i+1) + '/tf_idf_negativas.txt', 'w')


	for i, blob in enumerate(bloblist):
	    print("Top words in document {}".format(i + 1))
	    scores = {word: tfidf(word, blob, bloblist) for word in blob.words}
	    sorted_words = sorted(scores.items(), key=lambda x: x[1], reverse=True)
	    for word, score in sorted_words[:40]:
		if i == 0:
			
	        	arquivoPos.write("{}	{}".format(word, round(score, 5)))
			arquivoPos.write("\n")
		if i == 2:
	        	arquivoNeg.write("{}	{}".format(word, round(score, 5)))
			arquivoNeg.write("\n")

	arquivoOpenPos.close()
	arquivoOpenNeu.close()
	arquivoOpenNeg.close()
	
	arquivoPos.close()
	arquivoNeg.close()

