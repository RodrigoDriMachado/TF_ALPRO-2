/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RODRIGO
 */
package Acidentes;

public class Acidente {

//    private String pref_rua;
    private String nome_rua;
    private String tp_acidente;
    private String data;
   /* private String dia_sem;
    private String tempo;
    private String turno;
    private String regiao;
    private int qntd_feriados;
    private int qntd_morte;
    private int qntd_morte_post;
    private int qntd_fatais;
    private int qntd_auto;
    private int qntd_taxi;
    private int qntd_lotc;
    private int qntd_onibus_urb;
    private int qntd_onb_int;
    private int qntd_caminhao;
    private int qntd_moto;
    private int qntd_carroca;
    private int qntd_bicicleta;*/
    public Acidente(String nome_rua, String tp_acndt, String data) {
        
        //this.pref_rua = pref_rua;
        this.nome_rua = nome_rua;
        this.data = data;
        this.tp_acidente = tp_acndt;
      
        /*this.dia_sem = dia_sem;
        this.tempo = tmp;
        this.turno = turn;
        this.regiao = reg;
        this.qntd_feriados = qntd_fer;
        this.qntd_morte = qntd_morte;
        this.qntd_morte_post = qntd_morte_post;
        this.qntd_fatais = qntd_fatais;
        this.qntd_auto = qntd_auto;
        this.qntd_taxi = qntd_taxi;
        this.qntd_lotc = qntd_lotc;
        this.qntd_onibus_urb = qntd_onbs_urb;
        this.qntd_onb_int = qntd_onb_int;
        this.qntd_caminhao = qntd_caminhao;
        this.qntd_moto = qntd_moto;
        this.qntd_carroca = qntd_carroca;
        this.qntd_bicicleta = qntd_bicicleta;*/
    }

   /* public String getPref_rua() {
        return pref_rua;
    }

    public void setPref_rua(String pref_rua) {
        this.pref_rua = pref_rua;
    }*/

    public String getNome_rua() {
        return nome_rua;
    }

    public void setNome_rua(String nome_rua) {
        this.nome_rua = nome_rua;
    }

    public String getData() {
        return data;
    }
    
    public String getTp_acidente() {
        return tp_acidente;
    }

     public void setTp_acidente(String tp_acidente) {
        this.tp_acidente = tp_acidente;
    }
       
    public void setData(String data) {
        this.data = data;
    }
/*
    public String getDia_sem() {
        return dia_sem;
    }

    public void setDia_sem(String dia_sem) {
        this.dia_sem = dia_sem;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public int getQntd_feriados() {
        return qntd_feriados;
    }

    public void setQntd_feriados(int qntd_feriados) {
        this.qntd_feriados = qntd_feriados;
    }

    public int getQntd_morte() {
        return qntd_morte;
    }

    public void setQntd_morte(int qntd_morte) {
        this.qntd_morte = qntd_morte;
    }

    public int getQntd_morte_post() {
        return qntd_morte_post;
    }

    public void setQntd_morte_post(int qntd_morte_post) {
        this.qntd_morte_post = qntd_morte_post;
    }

    public int getQntd_fatais() {
        return qntd_fatais;
    }

    public void setQntd_fatais(int qntd_fatais) {
        this.qntd_fatais = qntd_fatais;
    }

    public int getQntd_auto() {
        return qntd_auto;
    }

    public void setQntd_auto(int qntd_auto) {
        this.qntd_auto = qntd_auto;
    }

    public int getQntd_taxi() {
        return qntd_taxi;
    }

    public void setQntd_taxi(int qntd_taxi) {
        this.qntd_taxi = qntd_taxi;
    }

    public int getQntd_lotc() {
        return qntd_lotc;
    }

    public void setQntd_lotc(int qntd_lotc) {
        this.qntd_lotc = qntd_lotc;
    }

    public int getQntd_onibus_urb() {
        return qntd_onibus_urb;
    }

    public void setQntd_onibus_urb(int qntd_onibus_urb) {
        this.qntd_onibus_urb = qntd_onibus_urb;
    }

    public int getQntd_onb_int() {
        return qntd_onb_int;
    }

    public void setQntd_onb_int(int qntd_onb_int) {
        this.qntd_onb_int = qntd_onb_int;
    }

    public int getQntd_caminhao() {
        return qntd_caminhao;
    }

    public void setQntd_caminhao(int qntd_caminhao) {
        this.qntd_caminhao = qntd_caminhao;
    }

    public int getQntd_moto() {
        return qntd_moto;
    }

    public void setQntd_moto(int qntd_moto) {
        this.qntd_moto = qntd_moto;
    }

    public int getQntd_carroca() {
        return qntd_carroca;
    }

    public void setQntd_carroca(int qntd_carroca) {
        this.qntd_carroca = qntd_carroca;
    }

    public int getQntd_bicicleta() {
        return qntd_bicicleta;
    }

    public void setQntd_bicicleta(int qntd_bicicleta) {
        this.qntd_bicicleta = qntd_bicicleta;
    }*/

    @Override
    public String toString() {
        return "Acidente{" + "nome_rua=" + nome_rua + ", tp_acidente=" + tp_acidente + ", data=" + data + '}';
    }


}
