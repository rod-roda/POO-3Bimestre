import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String opcao;
        String[] opcoesValidas = {"1", "2", "3", "4", "5"};

        do {
            System.out.println("\n--- Menu do Pet Shop ---");
            System.out.println("1 - Agendar banho");
            System.out.println("2 - Consultar agenda");
            System.out.println("3 - Editar agendamento");
            System.out.println("4 - Excluir agendamento");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = scanner.nextLine();
                while(!Arrays.asList(opcoesValidas).contains(opcao)){
                    System.out.print("Opção inválida! Escolha uma opção válida: ");
                    opcao = scanner.nextLine();
                }

                switch (opcao) {
                    case "1":
                        System.out.print("Digite o horario (1-10): ");
                        String horariostr = scanner.nextLine();
                        horariostr = horariostr.trim();

                        while (
                            horariostr.isEmpty()                       
                            || (!horariostr.matches("\\d+"))                    
                            || (!AgendaManager.verificarDisponibilidade(Integer.parseInt(horariostr))) 
                        ) {
                            System.out.println("Aviso: horário já ocupado ou inválido! Selecione outro horário: ");
                            horariostr = scanner.nextLine();
                        }
                        int horario = Integer.parseInt(horariostr);

                        System.out.print("Nome do Pet: ");
                        String nomePet = scanner.nextLine();
                        while(!(nomePet.length() > 3 )){
                            System.out.println("Aviso: Insira um nome válido para o Pet! Informe um novo nome: ");
                            nomePet = scanner.nextLine();
                        }

                        System.out.print("Especie do Pet: ");
                        String especiePet = scanner.nextLine();
                        while(!(especiePet.length() > 3 )){
                            System.out.println("Aviso: Insira uma espécie válida para o Pet! Informe uma nova espécie: ");
                            especiePet = scanner.nextLine();
                        }

                        System.out.print("Nome do Dono: ");
                        String nomeDono = scanner.nextLine();
                        while(!(nomeDono.length() > 3 )){
                            System.out.println("Aviso: Insira um nome válido! Informe um novo nome: ");
                            nomeDono = scanner.nextLine();
                        }

                        System.out.print("Telefone do Dono (digite apenas os números): ");
                        String telefoneDono = scanner.nextLine();
                        while(!(telefoneDono.matches("\\d{11}"))){
                            System.out.println("Aviso: Telefone inválido! Informe um novo telefone: ");
                            telefoneDono = scanner.nextLine();
                        }

                        String subOpcaostr = "";

                        while (
                            subOpcaostr.isEmpty()                       
                            || (!subOpcaostr.matches("\\d+"))    
                            || (!(Integer.parseInt(subOpcaostr) >= 1 && Integer.parseInt(subOpcaostr) <= 2))                  
                        ) {
                            System.out.print("Digite o tipo de banho (1: Banho Simples, 2: Banho com Tosa): ");
                            subOpcaostr = scanner.nextLine();
                        }
                        int subOpcao = Integer.parseInt(subOpcaostr);

                        Agendamento novoAgendamento;
                        if(subOpcao == 1)novoAgendamento = new BanhoSimples(nomePet, especiePet, nomeDono, telefoneDono, horario);
                        else novoAgendamento = new BanhoComTosa(nomePet, especiePet, nomeDono, telefoneDono, horario);
                        AgendaManager.agendar(novoAgendamento); 
                        break;
                    case "2":
                        if(!AgendaManager.agendaComRegistro()){
                            System.out.println("Todos os horários estão disponíveis! Aproveite e agende já o seu!");
                            break;
                        }
                    
                        AgendaManager.consultarAgenda();
                        break;
                    case "3":
                        if(!AgendaManager.agendaComRegistro()){
                            System.out.println("Ainda não foi realizado nenhum agendamento para ser editado!");
                            break;
                        }    

                        System.out.print("Digite o horario do agendamento que deseja editar (1-10): ");
                        horariostr = scanner.nextLine();
                        horariostr = horariostr.trim();

                        while (
                            horariostr.isEmpty()                       
                            || (!horariostr.matches("\\d+"))
                            || (!(Integer.parseInt(horariostr) >= 1 && Integer.parseInt(horariostr) <= 10))                    
                            || AgendaManager.verificarDisponibilidade(Integer.parseInt(horariostr))
                        ) {
                            System.out.println("Aviso: horário vazio ou inválido, não é possível editar! Selecione outro horário: ");
                            horariostr = scanner.nextLine();
                        }
                        horario = Integer.parseInt(horariostr);

                        System.out.println("--- Editar Agendamento do Horário " + horario + " ---");
                        
                        System.out.print("Novo Nome do Pet: ");
                        String novoNomePet = scanner.nextLine();
                        while(!(novoNomePet.length() > 3 )){
                            System.out.println("Aviso: Insira um nome válido para o Pet! Informe um novo nome: ");
                            novoNomePet = scanner.nextLine();
                        }

                        System.out.print("Nova Espécie do Pet: ");
                        String novaEspeciePet = scanner.nextLine();
                        while(!(novaEspeciePet.length() > 3 )){
                            System.out.println("Aviso: Insira uma espécie válida para o Pet! Informe uma nova espécie: ");
                            novaEspeciePet = scanner.nextLine();
                        }

                        System.out.print("Novo Nome do Dono: ");
                        String novoNomeDono = scanner.nextLine();
                        while(!(novoNomeDono.length() > 3 )){
                            System.out.println("Aviso: Insira um nome válido! Informe um novo nome: ");
                            novoNomeDono = scanner.nextLine();
                        }

                        System.out.print("Novo Telefone do Dono: ");
                        String novoTelefoneDono = scanner.nextLine();
                        while(!(novoTelefoneDono.matches("\\d{11}"))){
                            System.out.println("Aviso: Telefone inválido! Informe um novo telefone: ");
                            novoTelefoneDono = scanner.nextLine();
                        }

                        AgendaManager.editar(horario, novoNomePet, novaEspeciePet, novoNomeDono, novoTelefoneDono);
                        break;
                    case "4":
                        if(!AgendaManager.agendaComRegistro()){
                            System.out.println("Ainda não foi realizado nenhum agendamento para ser excluído!");
                            break;
                        } 
                        
                        System.out.print("Digite o horario que deseja excluir (1-10): ");
                        horariostr = scanner.nextLine();
                        horariostr = horariostr.trim();

                        while (
                            horariostr.isEmpty()                       
                            || (!horariostr.matches("\\d+"))    
                            || (!(Integer.parseInt(horariostr) >= 1 && Integer.parseInt(horariostr) <= 10))                  
                        ) {
                            System.out.println("Aviso: horário vinválido! Selecione outro horário: ");
                            horariostr = scanner.nextLine();
                        }
                        int horarioExcluir = Integer.parseInt(horariostr);

                        AgendaManager.excluir(horarioExcluir);
                        break;
                    case "5":
                        System.out.println("Saindo do sistema. Ate mais!");
                        break;
                    default:
                        System.out.println("Opcao invalida. Tente novamente.");
                }
            } catch (Exception e) {
                scanner.nextLine();
                opcao = "0";
            }

        } while (opcao != "5");

        scanner.close();
    }
}
