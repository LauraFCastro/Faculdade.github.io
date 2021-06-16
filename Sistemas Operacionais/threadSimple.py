from threading import Thread
from time import sleep

def MyThread1():
    i=0
    while(i<8):
        print(i, "thread 1")
        i=i+1


def MyThread2():
    i=0
    while(i<12):
        print(i,"thread 2")
        i=i+1


Thread(target=MyThread1).start() # cria outra linha de execucao para executar funcao 1
MyThread2() # executa na linha principal

t1 = Thread(target=MyThread1, args=[])
t2 = Thread(target=MyThread2, args=[])
t1.start()
t2.start()

