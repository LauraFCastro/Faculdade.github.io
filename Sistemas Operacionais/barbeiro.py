from math import pi
from threading import Thread, Lock, Event
import time
from random import randrange

# Nao ha clientes, barbeiro dorme
# cadeira livre, cliente atendido imediatamente
# se nao tiver cadeira vazia (onde cliente sentar) ele vai embora

mutex = Lock() # variavel para prender uma thread ate que outra finalize

class Barbearia:
    # abre (comecar o trabalho), barbeiro trabalhando/dormindo, cliente entrando/saindo
    clientesEsperando = [] # vetor com os clientes na sala de espera

    # funcao de inicializacao da classe
    def __init__(self, barbeiro, numeroCadeiras):
        self.barbeiro = barbeiro
        self.numeroCadeiras = numeroCadeiras # da sala de espera
        print("Barbearia iniciou com {0} cadeiras".format(numeroCadeiras))

    # inicia o trabalho/acoes do barbeiro
    def abrirBarbearia(self):
        print("### Barbearia esta abrindo ### \ninicia a thread do barbeiro")
        Thread(target=self.barbeiroVaiTrabalhar).start() # inicia thread para trabalho do barbeiro

    # ocorre processo do corte - barbeiro acorda quando cliente chega, corta cabelo, volta a domir
    def barbeiroVaiTrabalhar(self):
        print("### barbeiro ve se tem clientes na fila ###")
        # inicia-se 2 processos ao mesmo tempo: a thread do barbeiro e a verificacao de clientes
        while True:
            mutex.acquire() # pega o valor do Lock
            if len(self.clientesEsperando) > 0:  # se tiver cliente esperando
                c = self.clientesEsperando[0] # primeiro cliente da fila de espera
                del self.clientesEsperando[0] # apaga sempre o primeiro cliente
                mutex.release() # libera o lock - barbeiro finalizou o corte
                print("## barbeiro cortando cabelo ##")
                self.barbeiro.cortandoCabelo(c)
            else:
                mutex.release() # libera lock
                print("Finalizado - barbeiro indo dormir (nao ha clientes na fila)")
                Barbeiro().dormindo() # barbeiro vai dormir
                # print("Barbeiro acordou")

    # cliente entra na barbearia
    def entraBarbearia(self, cliente):
        print("### Cliente entra na Barbearia ###")
        desistentes = [] # vetor de clientes que desistiram por falta de cadeira
        mutex.acquire()
        print("{0} entrou na barbearia e procura uma cadeira".format(cliente.nome))

        if len(self.clientesEsperando) == self.numeroCadeiras:
            print("Sala de espera cheia, {0} esta indo embora.".format(cliente.nome))
            desistentes.append(cliente.nome)
            mutex.release()
        else:
            print("{0} sentou na sala de espera".format(cliente.nome))
            self.clientesEsperando.append(c)
            mutex.release()
            Barbeiro().acordou()
        return desistentes


class Cliente:
    # inicializacao - unico atributo do cliente
    def __init__(self, nome):
        self.nome = nome 


class Barbeiro:
    # tres estados - Dormindo, Acordando, Cortando
    barbeiroTrabalhandoEvento = Event() # evento (barbeiro esta trabalhando) que ira desbloquear a thread - 

    def dormindo(self):
        print("Barbeiro dormindo - evento.wait")
        self.barbeiroTrabalhandoEvento.wait() # espera o evento ser iniciado

    def acordou(self):
        print("barbeiro acordou - evento.set")
        self.barbeiroTrabalhandoEvento.set() # da o gatilho no evento, que acorda a thread

    def cortandoCabelo(self, cliente):
        print("barbeiro trabalhando - evento.clear")
        # Definir barbeiro como "ocupado"
        self.barbeiroTrabalhandoEvento.clear() # remove o evento (limpa) - para reinciar o processo
        print("{0} - cortando o cabelo".format(cliente.nome))
        time.sleep(randrange(3, 31)) # dorme durante o corte de cabelo - 3 a 30s
        print("{0} finalizou\n".format(cliente.nome))


# PROGRAMA
clientes = [
    Cliente("Nome01"),
    Cliente("Nome02"),
    Cliente("Nome03"),
    Cliente("Nome04"),
    Cliente("Nome05"),
    Cliente("Nome06"),
    Cliente("Nome07"),
    Cliente("Nome08"),
    Cliente("Nome09"),
    Cliente("Nome10"),
]


barbearia = Barbearia(Barbeiro(), 2)
barbearia.abrirBarbearia()

while len(clientes) > 0:
    c = clientes.pop()
    # Novo cliente entra na barbearia
    desitentes = barbearia.entraBarbearia(c)
    intervaloClientes = randrange(4, 8) # intervalo da entrada de clientes na barbearia 5 a 15
    time.sleep(intervaloClientes)
    print("Clientes que foram embora: ", desitentes)
    
