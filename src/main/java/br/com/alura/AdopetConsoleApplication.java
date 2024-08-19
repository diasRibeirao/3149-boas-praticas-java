package br.com.alura;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.AbrigoService;
import br.com.alura.service.PetService;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {
        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");

        CommandoExecutor executor = new CommandoExecutor();

        try {
            int opcaoEscolhida = 0;

            while (opcaoEscolhida != 5) {
                exibirMenu();

                String textoDigitado = new Scanner(System.in).nextLine();
                opcaoEscolhida = Integer.parseInt(textoDigitado);

                switch (opcaoEscolhida) {
                    case 1 -> executor.executarCommand(new ListarAbrigoCommand());
                    case 2 -> executor.executarCommand(new CadastrarAbrigoCommand());
                    case 3 -> executor.executarCommand(new ListarPetsDoAbrigoCommand());
                    case 4 -> executor.executarCommand(new ImportarPetsDoAbrigoCommand());
                    case 5 -> System.exit(0);
                    default -> opcaoDefault(opcaoEscolhida);
                }
            }

            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void exibirMenu() {
        System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
        System.out.println("1 -> Listar abrigos cadastrados");
        System.out.println("2 -> Cadastrar novo abrigo");
        System.out.println("3 -> Listar pets do abrigo");
        System.out.println("4 -> Importar pets do abrigo");
        System.out.println("5 -> Sair");
    }

    private static void opcaoDefault(int opcaoEscolhida) {
        System.out.println("NÚMERO INVÁLIDO!");
        opcaoEscolhida = 0;
    }

}
