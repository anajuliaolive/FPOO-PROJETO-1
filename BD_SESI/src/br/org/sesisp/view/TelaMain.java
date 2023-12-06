package br.org.sesisp.view;


import java.util.Scanner;
import javax.swing.JOptionPane;

import br.org.sesisp.dao.CrudDAO;
import br.org.sesisp.model.Aluno;

public class TelaMain {
	public static void main(String[] args) {
		//instanciar um obj da classe crudDAO
		CrudDAO inserir_aluno = new CrudDAO();
		
		//instanciar um obj aluno	
		Aluno aluno1 = new Aluno();

		/*al1.setNome("Jose");
		al1.setIdade(17);
		inserir_aluno.create(al1);
		System.out.println("Nome: " + al1.getNome() +"\nIdade: " + al1.getIdade());*/
		//***********************************************

		//Atualizar valores
		aluno1.setNome("Marcelo Vieira");
		aluno1.setIdade(18);
		aluno1.setRa(1);
		inserir_aluno.update(aluno1);
		System.out.println("Nome: " + aluno1.getNome() +"\nIdade: " + aluno1.getIdade());
		//***********************************************

		/*CrudDAO remover_aluno = new CrudDAO();
		remover_aluno.delete(5);*/
		//***********************************************

		
		Scanner entrada = new Scanner(System.in);
		String valor;
		valor = JOptionPane.showInputDialog("O que deseja realizar?" +
		"\n 1-CREATE \n 2-UPDATE \n 3-READ \n 4-DELETE");
		int opcao = Integer.parseInt(valor);
		do {
			exibirMenu(); // metodo (acao)
			opcao = entrada.nextInt();
			switch(opcao) {
			case 1:
				System.out.println("Nome:");
				String n;
				n = JOptionPane.showInputDialog("Digite o nome do aluno para criar:");
				aluno1.setNome(n);
				System.out.println("Idade:");
				String idade;
		    	idade = JOptionPane.showInputDialog("Digite a idade do aluno para criar:");
		    	int i = Integer.parseInt(idade);
				aluno1.setIdade(i);
				aluno1.setIdade(i);
				inserir_aluno.create(aluno1);
				System.out.println("Aluno adicionado " + n);
				break;
			case 2:
				String ra;
		    	ra = JOptionPane.showInputDialog("Digite o numero do RA que voce deseja atualizar:");
		    	int r = Integer.parseInt(ra);
				aluno1.setRa(r);
		    	n = JOptionPane.showInputDialog("Digite o nome novo:");
		    	aluno1.setNome(n);
		    	idade = JOptionPane.showInputDialog("Digite a idade nova:");
		    	i = Integer.parseInt(idade);
				aluno1.setIdade(i);
				System.out.println("Dados atualizados com sucesso!");
				inserir_aluno.update(aluno1);
				
				break;
			
			case 3:
				JOptionPane.showMessageDialog(null, "lendo a lista...");
				for(Aluno olho : inserir_aluno.read()) {
					JOptionPane.showMessageDialog(null, "Dados do aluno: "+ olho.getRa()
					+ olho.getNome() + olho.getIdade());}
				break;
			
			 case 4:
			    	CrudDAO remover_aluno = new CrudDAO();
			    	String ra1;
			    	ra1 = JOptionPane.showInputDialog("Digite o numero do RA que voce deseja deletar:");
			    	int r1 = Integer.parseInt(ra1);
					aluno1.setRa(r1);
					remover_aluno.delete(r1);
					break;
			}
			System.out.println();
		}while(opcao != 4);
	}//fim main
	public static void exibirMenu() {
		System.out.println("Selecione uma opcao");
		System.out.println("1 - Adicionar aluno");
		System.out.println("2 - Deletar aluno");
		System.out.println("3 - Atualizar aluno");
		System.out.println("0 - SAIR");
	}

}

 
  