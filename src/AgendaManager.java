public class AgendaManager {
    private static int CAPACIDADE_AGENDA = 10;
    private static Agendamento[] agenda = new Agendamento[CAPACIDADE_AGENDA];
    
    public static boolean agendaComRegistro(){
        for(int c = 0; c <= CAPACIDADE_AGENDA - 1; c++){
            if(agenda[c] != null) return true;
        }
        return false;
    }

    public static void agendar(Agendamento novoAgendamento){
        int horario = novoAgendamento.getHorarioDoBanho();
        if(horario > 0 && horario <= CAPACIDADE_AGENDA){
            if(agenda[horario-1] == null){
                agenda[horario-1] = novoAgendamento;       
                System.out.println("Agendamento realizado com sucesso para o horario " + horario + "!");
            }else {
                System.out.println("Erro: Horário " + horario + " já está ocupado.");
            }
        }else {
            System.out.println("Erro: Horário inválido. Escolha um número entre 1 e 10.");
        }
    }
    
    public static void consultarAgenda() {
        System.out.println("\n--- Agenda de Banho ---");
        for (int i = 0; i < CAPACIDADE_AGENDA; i++) {
            if (agenda[i] != null) {
                System.out.println(agenda[i].toString());
            } else {
                System.out.println("Horário " + (i + 1) + " - Disponível");
            }
        }
        System.out.println("-----------------------\n");
    }

    public static void editar(int horario, String novoNomePet, String novaEspecie, String novoNomeDono, String novoTelefone) {
        if (horario > 0 && horario <= CAPACIDADE_AGENDA) {
            if (agenda[horario-1] != null) {
                agenda[horario-1].setNomePet(novoNomePet);
                agenda[horario-1].setEspeciePet(novaEspecie);
                agenda[horario-1].setNomeDono(novoNomeDono);
                agenda[horario-1].setTelefoneDono(novoTelefone);
                System.out.println("Agendamento do horário " + horario + " editado com sucesso!");
            } else {
                System.out.println("Erro: O horário " + horario + " está vazio e não pode ser editado.");
            }
        } else {
            System.out.println("Erro: Horário inválido. Escolha um horário entre 1 e 10.");
        }
    }

    public static void excluir(int horario) {
        if (horario > 0 && horario <= CAPACIDADE_AGENDA) {
            if (agenda[horario-1] != null) {
                agenda[horario-1] = null;
                System.out.println("Agendamento do horario " + horario + " excluido com sucesso!");
            } else {
                System.out.println("Erro: O horario " + horario + " ja está vazio.");
            }
        } else {
            System.out.println("Erro: Horário inválido. Escolha um numero entre 1 e 10.");
        }
    }
    
    public static boolean verificarDisponibilidade(int horario) {
        if (horario > 0 && horario <= CAPACIDADE_AGENDA) {
            return agenda[horario - 1] == null;
        }
        return false;
    }
}
