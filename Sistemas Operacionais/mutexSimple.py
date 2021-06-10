from threading import Thread, Lock
import time, random

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

# MUTEX - vai dar Lock em uma das thread para esperar a outra finalizar