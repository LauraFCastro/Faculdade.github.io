from threading import Thread, Lock
import time, random

mutex = Lock()

def tarefa1():
    global mutex
    print("thread 1 - sleeping")
    time.sleep(10)
    print("T1-deve acabar primeiro")
    mutex.release()
    

def tarefa2():
    global mutex
    print("thread 2 - sleeping")
    time.sleep(5)
    mutex.acquire()
    print("T2-deve acabar por ultimo")


mutex.acquire()

Thread(target=tarefa1).start()
Thread(target=tarefa2).start()

# MUTEX - vai dar Lock em uma das thread para esperar a outra finalizar