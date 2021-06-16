from threading import Thread, Lock
import time, random

mutex = Lock()
esperaClientes = []


def Barbeiro():
    global mutex
    global esperaClientes
    dormindo = [] # validacao para finalizar a thread
    while True:
        print("thread barbeiro")
        if len(dormindo) >= 3:
            break

        if len(esperaClientes) > 0:
            print("Tem cliente")
            if len(dormindo)>0:
                dormindo.pop()
            clienteAleatorioNaEspera = random.choice(esperaClientes)
            esperaClientes.remove(clienteAleatorioNaEspera)
            print("Barbeiro - Cortando cabelo de {0}".format(clienteAleatorioNaEspera))
            mutex.acquire() # cadeira do barbeiro ocupada
            time.sleep(6) # random.randrange(4,6)
            mutex.release()
        else:
            print("Barbeiro dormindo")
            dormindo.append(1)


def Clientes():
    global mutex
    global esperaClientes
    cadeiras = 3
    numClientes, desistentes = 0, 0
    while numClientes-desistentes < 8:
        # if mutex.acquire():
        #     print('Cliente{0} cortando cabelo'.format(numClientes))
        if numClientes > cadeiras:
            print("Espera cheia - cliente{0} vai embora".format(numClientes+1))
            time.sleep(10)
            desistentes=desistentes+1
        else:
            numClientes=numClientes+1
            print("###Cliente{0} entra na barbearia###".format(numClientes))
            esperaClientes.append("Cliente{0}".format(numClientes))
            print("Espera de clientes", (esperaClientes))
            time.sleep(4) # random.randrange(2,4)



mutex.acquire() # comeca Locked
Thread(target=Barbeiro).start()
print('BARBEARIA ABRIU')
Thread(target=Clientes).start()
