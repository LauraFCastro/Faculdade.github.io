from threading import Semaphore, Thread, Lock, Event
import time
import random

semaforo = Semaphore()
mutex = Lock()
cadeiras = 4
numClientes = 0
espera = 0
filaClientes = []



def Barbeiro():
    if len(filaClientes) == 0:
        print("0 clientes - Barbeiro dormindo")
    else:
        print("Barbeiro acordou")
        mutex.locked()
        print("Barbeiro - Cortando cabelo")
        time.sleep(5)
        mutex.release()


def Clientes():
    print("Cliente entra na barbearia")
    if len(filaClientes) >= cadeiras:
        print("Espera cheia - cliente vai embora")
    else:
        print("Cliente na sala de espera")
        filaClientes.append("Cliente{0}".format(numClientes+1))
        mutex.acquire()
        

mutex.acquire()
barbeiro = Thread(target=Barbeiro).start()
clientes = Thread(target=Clientes).start()

Lock()


def tarefa1():
    print("thread 1 - sleeping")
    time.sleep(random.randint(1,10))
    print("T1-deve acabar primeiro")
    Lock().release()

def tarefa2():
    print("thread 2 - sleeping")
    time.sleep(random.randint(1,10))
    Lock().acquire()
    print("T2-deve acabar por ultimo")


Lock().acquire()
Thread(target=tarefa1).start()
Thread(target=tarefa2).start()