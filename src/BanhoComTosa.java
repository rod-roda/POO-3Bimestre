public class BanhoComTosa extends Agendamento {
    public BanhoComTosa(String nome, String especie, String dono, String telefone, int horario){
        super(nome, especie, dono, telefone, horario);
        super.setAdicional("Banho Com Tosa");
    }
}
