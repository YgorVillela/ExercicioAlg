/*Fa�a um programa em JAVA que efetue reserva de passagens a�reas de uma determinada companhia.
 *  O programa dever� ler os n�meros dos avi�es e o n�mero de lugares dispon�veis em cada um. 

=> Utilize um vetor de 4 (quatro) posi��es, no qual cada posi��o representa um avi�o, 
e outro vetor tamb�m de 4 (quatro) posi��es para armazenar os lugares dispon�veis.

O programa dever� mostrar o seguinte menu de op��es:

������������ MENU ������������
1.	Cadastrar n�meros dos avi�es
2.	Cadastrar n�mero de lugares dispon�veis em cada avi�o
3.	Reservar passagem
4.	Consultar por avi�o
5.	Consultar por passageiro
6.	Finalizar
����������������������������-

PARA REALIZAR A OP��O 1:
Dever� ser solicitado ao usu�rio o n�mero dos 4 (quatro) avi�es dispon�veis.
Importante: A op��o 1 pode ser acessada apenas 1 (uma) vez. 
Caso o usu�rio digite novamente a op��o 1 deve aparecer a mensagem: �N�meros dos avi�es j� cadastrados�

PARA REALIZAR A OP��O 2:
Dever� ser solicitado ao usu�rio o n�mero de lugares dispon�veis em cada avi�o cadastrados na op��o 1. 
Importante: 
a) A op��o 2 pode ser acessada apenas 1 (uma) vez. 
Caso o usu�rio digite novamente a op��o 2 deve aparecer a mensagem: �N�meros de lugares dispon�veis j� cadastrados�
b) Os n�meros de lugares dispon�veis em cada avi�o dever�o ser cadastrados 
AP�S o cadastro dos n�meros dos avi�es, ou seja, N�O PERMITIR realizar a op��o 2 antes da op��o 1.

PARA REALIZAR A OP��O 3:
Dever� ser verificado se o n�mero do avi�o digitado � v�lido.
 Posteriormente, checar se, no avi�o escolhido, ainda existe lugar dispon�vel.
  Caso exista, o programa dever� diminuir o total de vagas e mostrar a mensagem "Reserva confirmada". 
  Caso contr�rio, dever� mostrar a mensagem �V�o lotado�. Voltar para o menu de op��es.
Importante:  
a) Cada reserva dever� possuir o n�mero do avi�o e o c�digo de identifica��o do passageiro.
b) A op��o 3 n�o poder� mais ser acessada ap�s lota��o dos 4 (quatro) v�os.

PARA REALIZAR A OP��O 4:
Dever� ser solicitado o n�mero do avi�o desejado e, posteriormente, exibir:
-	Quantidade de reservas realizadas para o avi�o escolhido.
-	Quantidade de lugares dispon�veis para o avi�o escolhido.
Importante:  Validar se o n�mero do avi�o existe no cadastro.

PARA REALIZAR A OP��O 5:
Dever� ser solicitado o c�digo de identifica��o do passageiro e, posteriormente, mostrar um relat�rio com:

-	C�digo de Identifica��o do passageiro
-	Reservas realizadas pelo Passageiro (C�digo(s) do(s) avi�o(�es) e Quantidade de reservas por c�digo do avi�o)

Exemplo de relat�rio: 


C�digo de Identifica��o do usu�rio: 100
RESERVAS REALIZADAS:
C�digo do avi�o	Quantidade de reservas
901	4
902	2
905	1



Importante:  
a)	Validar se o c�digo de identifica��o do passageiro existe no cadastro.
b)	Mostrar a quantidade de reservas do passageiro por avi�o.

A OP��O 6:
Encerra o programa.
*/

package br.com.fiap.logica;

import java.util.Scanner;

public class Exercicio {

	public static void main(String[] args) {

		int cont = 0, opcoes = 0, i = 0, numReserva = 0;
		int numAviao[] = new int[4];
		int numLugarDisponivel[] = new int[4];
		int qtdReserv = 0;
		boolean consulta = false;
		int codCli[] = new int[4];
		boolean vaz[] = new boolean[3];
		boolean existe = false;
		boolean voltar = false, voltaLugar = false;

		Scanner teclado = new Scanner(System.in);

		do {
			System.out.println("1 - Cadastrar n�mero de avi�es");
			System.out.println("2 - Cadastrar n�mero de lugares dispon�veis em cada avi�o");
			System.out.println("3 - Reservar passagem");
			System.out.println("4 - Consultar por avi�o");
			System.out.println("5 - Consultar por passageiro");
			System.out.println("6 - Finalizar");
			opcoes = teclado.nextInt();

			switch (opcoes) {
			case 1:
				if (voltar) {
					System.err.println("N�meros de avi�es j� cadastrados!!!");
					System.out.println();
				} else {
					for (i = 0; i < numAviao.length; i++) {
						System.out.println("Entre com o n�mero do " + (i + 1) + "�avi�o:");
						numAviao[i] = teclado.nextInt();
						voltar = true;
						consulta = true;

					}
				}
				break;
			case 2:
				if (voltar) {
					if (voltaLugar) {
						System.err.println("N�meros de lugares dispon�veis j� cadastrados!!!");
						System.out.println();

					} else {
						for (i = 0; i < numLugarDisponivel.length; i++) {
							System.out.println("Entre com os lugares dispon�veis no n�mero do avi�o " + numAviao[i]);
							numLugarDisponivel[i] = teclado.nextInt();
							voltaLugar = true;
							
						}
					}
				} else {
					System.err.println("Cadastre primeiro os n�meros dos avi�es!!!");
				}
				break;
			case 3:
				System.out.println("Entre com o n�mero do avi�o que deseja reservar a passagem:");
				numReserva = teclado.nextInt();

				if (voltar) {
					if (numLugarDisponivel[numReserva - 1] > 0) {
						System.out.print("Informe o c�digo do cliente:");
						codCli[numReserva - 1] = teclado.nextInt();
						numLugarDisponivel[numReserva - 1] -= 1;
						System.out.println("Reserva confirmada!");
						codCli[numReserva - 1] = 0;
						qtdReserv++;
						existe = true;

					} else {
						System.err.println("V�o lotado!!!");
					}

				}
				break;
			case 4:
				int numCons = 0;

				System.out.println("Entre com o n�mero do avi�o para consult�-lo:");
				numCons = teclado.nextInt();

				if (consulta) {
					for (i = 0; i < 1; i++) {
						if (numLugarDisponivel[numReserva] > 0) {
							System.out.println(
									"Numero de lugares disponiveis do avi�o: " + numLugarDisponivel[numReserva]);
							if (existe) {
								System.out.println("Quantidade de reservas realizadas para o avi�o "
										+ numLugarDisponivel[qtdReserv]);
							}
						} else {
							System.err.println("N�mero inv�lido!!!");
						}
					}
				}

				break;
			case 5:
				for (i = 0; i < codCli.length; i++) {
					if (voltar) {
						System.out.println("C�digo do cliente" + codCli[i]);
						System.out.println("Avi�o" + numAviao[i]);
						System.out.println("N�mero de reservas feitas" + numLugarDisponivel[qtdReserv]);
					} 
				}
				break;
			case 6:
				System.exit(0);
			default:
				System.err.println("Op��o Inv�lida!!!");
				break;
			}

		} while (cont <= 6);

		teclado.close();
	}

}
