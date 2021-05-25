from threading import Thread, Lock, Event
import time, random

# Nao ha clientes, barbeiro dorme
# cadeira livre, cliente atendido imediatamente
# se nao tiver cadeira vazia (onde cliente sentar) ele vai embora

mutex = Lock()

#Intervalo em segundos
intervaloClienteMin = 5
intervaloClienteMax = 15
duracaoCorteMin = 3
duracaoCorteMax = 30

class Barbearia:
    esperandoClientes = []

    def __init__(self, barbeiro, numeroCadeiras):
        self.barbeiro = barbeiro
        self.numeroCadeiras = numeroCadeiras
        print("Barbearia iniciou com {0} cadeiras".format(numeroCadeiras))
        print("Cliente min intervalo {0}".format(intervaloClienteMin))
        print("Cliente max intervalo {0}".format(intervaloClienteMax))
        print("Corte de cabelo min duracao {0}".format(duracaoCorteMin))
        print("Corte de cabelo max duracao {0}".format(intervaloClienteMax))
        print("---------------------------------------")

    def openShop(self):
        print("Barbearia esta abrindo")
        workingThread = Thread(target=self.barbeiroVaiTrabalhar)
        workingThread.start()

    def barbeiroVaiTrabalhar(self):
        while True:
            mutex.acquire()

            if len(self.esperandoClientes) > 0:
                c = self.esperandoClientes[0]
                del self.esperandoClientes[0]
                mutex.release()
                self.barbeiro.cutHair(c)
            else:
                mutex.release()
                print("Finalizado - barbeiro indo dormir")
                barbeiro.sleep()
                print("Barbeiro acordou")

    def entraBarbearia(self, cliente):
        mutex.acquire()
        print(">> {0} entrou na barbearia e procura uma cadeira".format(cliente.name))

        if len(self.esperandoClientes) == self.numeroCadeiras:
            print("Sala de espera cheia, {0} esta indo embora.".format(cliente.name))
            mutex.release()
        else:
            print("{0} sentou na sala de espera".format(cliente.name))
            self.esperandoClientes.append(c)
            mutex.release()
            barbeiro.wakeUp()


class Cliente:
    def __init__(self, name):
        self.name = name


class Barbeiro:
    barbeiroTrabalhandoEvent = Event()

    def sleep(self):
        self.barbeiroTrabalhandoEvent.wait()

    def wakeUp(self):
        self.barbeiroTrabalhandoEvent.set()

    def cutHair(self, cliente):
        # Definir barbeiro como "ocupado"
        self.barbeiroTrabalhandoEvent.clear()

        print("{0} esta cortando o cabelo".format(cliente.name))

        randTempoCorteCabelo = random.randrange(duracaoCorteMin, duracaoCorteMax + 1)
        time.sleep(randTempoCorteCabelo)
        print("{0} finalizou\n".format(cliente.name))



if __name__ == "__main__":
    clientes = [Cliente("Nome01"), Cliente("Nome02"), Cliente("Nome03"), Cliente("Nome04"), Cliente("Nome05"), Cliente("Nome06"), Cliente("Nome07"), Cliente("Nome08"), Cliente("Nome09"), Cliente("Nome10")]

    barbeiro = Barbeiro()
    barbearia = Barbearia(barbeiro, numeroCadeiras=2)
    barbearia.openShop()

    while len(clientes) > 0:
        c = clientes.pop()
        # Novo cliente entra na barbearia
        barbearia.entraBarbearia(c)
        intervaloClientes = random.randrange(intervaloClienteMin, intervaloClienteMax + 1)
        time.sleep(intervaloClientes)
