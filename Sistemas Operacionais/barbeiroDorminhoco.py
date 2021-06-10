from threading import Semaphore, Thread, Lock, Event
import time
import random
from datetime import datetime


mutex = Lock()
cadeiras = 3
filaClientes = []

data_atual = date.today()
print(data_atual)

def Barbeiro(self):
    while True:
        if len(filaClientes) == 0:
            print("Barbeiro dormindo")
        else:
            print("Barbeiro acordou")
            mutex.locked()
            clienteAleatorioNaEspera = random.choice(filaClientes)
            filaClientes.remove(clienteAleatorioNaEspera)
            print("Barbeiro - Cortando cabelo de {0}".format(clienteAleatorioNaEspera))
            time.sleep(random.randrange(4,6))
            mutex.release()


def Clientes():
    numClientes = 0
    while numClientes <= 8:
        print("######Cliente entra na barbearia")
        random.randrange(2,4)
        numClientes=numClientes+1
        if len(filaClientes) >= cadeiras:
            print("Espera cheia - cliente vai embora")
        else:
            print("Cliente na sala de espera")
            filaClientes.append("Cliente{0}".format(numClientes))
            # print("fila de clientes", len(filaClientes))
            # print("numClientes= ", numClientes)
            mutex.acquire()
    if numClientes == 8:
        terminate()
        barbeiro.join()


def terminate(self):
    self._running = False


def __init__(self):
    self._running = True


mutex.acquire()
barbeiro = Thread(target=Barbeiro).start()
clientes = Thread(target=Clientes).start()
