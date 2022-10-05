class Arvore<Tipo extends Comparable> { //extends comparacao

    private Elemento<Tipo> raiz;
    private boolean atual;

    public Arvore() {
        this.raiz = null;
    }
    public void adicionar(Tipo valor) { //1° metodo
        Elemento<Tipo> novoElemento = new Elemento<Tipo>(valor);

        if (raiz == null) { //verifica se a raiz ta vazia ou n
            this.raiz = novoElemento;
        } else {
            Elemento<Tipo> atual = this.raiz;
            while (true) {       // laço
                if (novoElemento.getValor().compareTo(atual.getValor()) == -1) { //verifica se o valor do elemento é menor do que o valor atual, se sim fica -1
                    if (atual.getEsquerda() != null) {
                        atual = atual.getEsquerda(); //atual vai p esquerda "menor"
                    } else {         //se n tiver ninguem, cai no else
                        atual.setEsquerda(novoElemento);
                        break;
                    }
                }else{
                        //aq caso for maior ou igual
                        if (atual.getDireita() != null) { //verifica se o atual tem filho a direita
                            atual = atual.getDireita();
                        } else { //se n tiver ninguem, cai no else dnv
                            atual.setDireita(novoElemento);
                            break;
                        }
                    }
                }
            }
        }


    public void emOrdem(Elemento<Tipo> atual) {//2° metodo de impressao (es,querda - cima - direita)
        if (atual != null) { //se tual for diferente de null
            emOrdem(atual.getEsquerda()); //emordem a esquerda
            System.out.println(atual.getValor()); // pega o elemento e
            emOrdem(atual.getDireita()); // emordem a direita dele
        }
    }

    public Elemento<Tipo> getRaiz() {
        return raiz;
    }

    public void preOrdem(Elemento<Tipo> atual) { //2° metodo de impressao (cima-esquerda-direita)
        if (atual != null) {
            System.out.println(atual.getValor()); //imprimem o elemento
            preOrdem(atual.getEsquerda()); //pre orden a esquerda
            preOrdem(atual.getDireita());//pre ordem a direita

        }
    }

    public void posOrdem(Elemento<Tipo> atual) {  //2° metodo de impressao(esquerda-direita-cima)
        if (atual != null) {
            posOrdem(atual.getEsquerda());// faz pos ordem esquerda
            posOrdem(atual.getDireita());// pos ordem direita
            System.out.println(atual.getValor());// dps q pega o elemento
        }
    }

    public boolean remover(Tipo valor) { //3° metodo
        //buscar o elemento da arvore
        Elemento<Tipo> atual = this.raiz;
        Elemento<Tipo> paiAtual = this.raiz;
        while (atual != null) {
            if (atual.getValor().equals(valor)) {
                break;

            } else if (valor.compareTo(atual.getValor()) == -1) {
                paiAtual = atual;
                atual = atual.getEsquerda();
            } else {
                paiAtual = atual;
                atual = atual.getDireita();
            }
        }
        if (atual != null) {

            if (atual.getDireita() != null) {//ele te 2 filhos ou só a direita

                Elemento<Tipo> substituto = atual.getDireita();
                Elemento<Tipo> paiSubstituto = atual;
                while (substituto.getEsquerda() != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.getEsquerda();
                }
                substituto.setEsquerda(atual.getEsquerda());
                if (paiAtual != null) {
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1) {
                        paiAtual.setEsquerda(substituto);
                    } else {
                        paiAtual.setDireita(substituto);
                    }
                } else { // caso n tenha paiAtual entao e a raiz
                    this.raiz = substituto;
                }

                if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1) { //removeu o elemento da arvore
                    paiSubstituto.setEsquerda(null);
                } else {
                    paiSubstituto.setDireita(null);
                }

            } else if (atual.getEsquerda() != null) {
                Elemento<Tipo> substituto = atual.getEsquerda();
                Elemento<Tipo> paiSubstituto = atual;
                while (substituto.getDireita() != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.getDireita();
                }
                if (paiAtual != null) {
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1) {
                        paiAtual.setEsquerda(null);
                    } else {
                        paiAtual.setDireita(null);
                    }
                } else {//se for a raiz
                    this.raiz = substituto;
                }


                if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1) {
                    paiSubstituto.setEsquerda(substituto);
                } else {
                    paiSubstituto.setDireita(substituto);
                }

            } else {
                if (paiAtual != null) {
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1) {
                        paiAtual.setEsquerda(null);
                    } else {
                        paiAtual.setDireita(null);
                    }
                } else {
                    this.raiz = null;
                }
            }
            return true;
        } else {

            return false;
        }
    }

    public boolean buscar(Tipo valor) {
        Elemento<Tipo> atual = this.raiz;
        Elemento<Tipo> paiAtual = null;
        while (atual != null) {
            if (atual.getValor().equals(valor)) {
                break;
            } else if (valor.compareTo(atual.getValor()) == -1) {
                paiAtual = atual;
                atual = atual.getEsquerda();
            } else {
                paiAtual = atual;
                atual = atual.getDireita();
            }
        }

        if (atual != null) {
            System.out.println("Foi encontradoo");
            return true;
        } else {
            System.out.println("N foi encontradoo");
            return false;
        }
    }

    //método calcular a altura = n° de nos da maior distancia (da raiz ate a folha)

    public int altura() {
        return altura(raiz);
    }

    public int altura(Elemento atual) {
        if (atual != null) {
            int he, hd;

            he = altura(atual.getEsquerda()); //visita subarvore esquerda
            hd = altura(atual.getDireita()); //visita subarvore direita

            if (he > hd)
                return he + 1;
            else return hd + 1;
        }
        return 0; // se for nulo
    }


}

