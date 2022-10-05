import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Arvore<Integer> arvore = new Arvore<Integer>();
        int valor = 0, op = 0;

            while (op != -1) {

                System.out.println("Menu");
                System.out.println("1- Adicionar ");
                System.out.println("2- Remover ");
                System.out.println("3- Buscar ");
                System.out.println("4- Imprimir em Ordem ");
                System.out.println("5- Imprimir pre Ordem ");
                System.out.println("6- Imprimir pos Ordem ");
                System.out.println("7- Calcular altura ");
                System.out.println("Escolha :");
                op = sc.nextInt();


                switch (op) {

                    case 1:
                        System.out.println("Valor:");
                        valor = sc.nextInt();
                        arvore.adicionar(valor);
                        break;

                    case 2:
                        System.out.println("Qual Valor deseja remover:");
                        valor = sc.nextInt();
                        arvore.remover(valor);
                        break;

                    case 3:
                        System.out.println("Valor:");
                        valor = sc.nextInt();
                        arvore.buscar(valor);
                        break;

                    case 4:
                        System.out.println("\n\nIn order:");
                        arvore.emOrdem(arvore.getRaiz());
                        break;

                    case 5:
                        System.out.println("\n\nPre order:");
                        arvore.preOrdem(arvore.getRaiz());
                        break;

                    case 6:
                        System.out.println("\n\nPos order:");
                        arvore.posOrdem(arvore.getRaiz());
                        break;

                    case 7:
                        System.out.println("\n\nAlturinha " + arvore.altura()  );
                        //arvore.getRaiz();
                        break;

                    default:
                        System.out.println("Opcao invalida!\n");
                        break;
                }
            }
        }

    }

