# Faculdade

Trabalhos e Projetos da Faculdade - Engenharia de Software

## Sistemas Operacionais - Disciplina de Engenharia de Software

### Aprendendo sobre Sistemas Operacionais, seu funcionamento e componentes

(em desenvolvimento)

- #### Pontos principais estudados

  - Componentes principais (escalonador, kernel, memórias e )
  - Algoritmos de Escalonamento
  - Regras e problemas no escalonamento
  - Threads

- #### Algoritmos implementados

- ##### Problema dos Filósofos: filosofos.py

  - O problema é estabelecido em uma comunidade isolada de 5 filósofos (0-4);
  - Os filósofos engajam-se somente em duas atividades: pensar e comer;
  - Implemente a solução evitando situações indesejadas como deadlocks e starvation;

- ##### Barbeiro dorminhoco: barbeiro.py

  - Se não há clientes, o barbeiro dorme;
  - Se a cadeira do barbeiro estiver livre, um cliente pode ser atendido imediatamente;
  - O cliente espera pelo barbeiro se houver uma cadeira de espera vazia;
  - Se não tiver onde sentar o cliente vai embora;
  - Para implementar o problema, mantenha o barbeiro ocupado enquanto há clientes e descansando caso não haja nenhum;
  - O barbeiro e seus clientes correspondem a threads.

- ##### Trafégo aéreo: aeroporto.py

  - Considere um aeroporto que tem somente uma pista de pouso e decolagem

    - aeronaves estacionadas no pátio do aeroporto;
    - aeronaves taxiando (de chegada ou saída) no aeroporto;
    - aeronaves precisando aterrissar (descer);
    - aeronaves precisando decolar (subir), ou seja, que estão prontas para subir, preparadas na cabeceira da pista, aguardando a ordem da torre de controle para o procedimento de decolagem;

  - Para controlar o movimento deste aeroporto, existe uma torre de controle, que “escalona”, segundo prioridades pré-estabelecidas, o tráfego de aeronaves;
  - Mais precisamente, aquelas que estão em procedimento de aterrissagem e aquelas que estão em procedimento para decolar deverão ter prioridades definidas como:
    - O procedimento de aterrisagem (A) tem prioridade maior que o procedimento de decolagem (D);
    - Num dado tempo, somente uma aeronave pode estar ocupando a pista para aterrissar ou para decolar;
  - Você pode escolher o valor das prioridades como for mais conveniente.
  - A pista de aterrissagem ou decolagem é a região crítica para cada thread (aeronave).
