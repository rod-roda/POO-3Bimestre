public class Agendamento {
    private String nomePet;
    private String especiePet;
    private String nomeDono;
    private String telefoneDono;
    private int horarioDoBanho;
    private String adicional; 
    
    public Agendamento(){
        
    }
    
    public Agendamento(String nome, String especie, String dono, String telefone, int horario){
        setNomePet(nome);
        setEspeciePet(especie);
        setNomeDono(dono);
        setTelefoneDono(telefone);
        setHorarioDoBanho(horario);
        setAdicional("Nenhum");
    }
    
    @Override
    public String toString() {
        return "Horario " + horarioDoBanho + " - Pet: " + nomePet + 
               ", Dono: " + nomeDono + ", Telefone: " + telefoneDono + 
               ", Servico Adicional: " + adicional;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getEspeciePet() {
        return especiePet;
    }

    public void setEspeciePet(String especiePet) {
        this.especiePet = especiePet;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public String getTelefoneDono() {
        return telefoneDono;
    }

    public void setTelefoneDono(String telefoneDono) {
        this.telefoneDono = telefoneDono;
    }

    public int getHorarioDoBanho() {
        return horarioDoBanho;
    }

    public void setHorarioDoBanho(int horarioDoBanho) {
        this.horarioDoBanho = horarioDoBanho;
    }

    public String getAdicional() {
        return adicional;
    }

    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }
}
