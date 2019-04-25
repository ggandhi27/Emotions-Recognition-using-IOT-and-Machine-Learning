import os


def fileExists(filepath):
    exists = os.path.isfile(filepath)
    return exists

def createCsv(filepath):
    if fileExists(filepath) == False:
        f = open(filepath,"w")
        f.write("Temperature,Pulse,Mood\n")
        f.close()

