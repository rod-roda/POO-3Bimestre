public class BanhoSimples extends Agendamento {
    public BanhoSimples(String nome, String especie, String dono, String telefone, int horario){
        super(nome, especie, dono, telefone, horario);
        super.setAdicional("Banho Simples");
    }
}
