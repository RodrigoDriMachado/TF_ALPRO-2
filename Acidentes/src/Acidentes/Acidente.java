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

    public Acidente(String nome_rua, String tp_acidente, String data){
        this.nome_rua = nome_rua;
        this.tp_acidente = tp_acidente;
        this.data = data;
    }
    
   /* public String getPref_rua() {
        return pref_rua;
    }*/

    public String getNome_rua() {
        return nome_rua;
    }

    public String getTp_acidente() {
        return tp_acidente;
    }

 /*   public String getData() {
        return data;
    }*/
/*
    public String getDia_sem() {
        return dia_sem;
    }

    public String getTempo() {
        return tempo;
    }

    public String getTurno() {
        return turno;
    }

    public String getRegiao() {
        return regiao;
    }

    public int getQntd_feriados() {
        return qntd_feriados;
    }

    public int getQntd_morte() {
        return qntd_morte;
    }

    public int getQntd_morte_post() {
        return qntd_morte_post;
    }

    public int getQntd_fatais() {
        return qntd_fatais;
    }

    public int getQntd_auto() {
        return qntd_auto;
    }

    public int getQntd_taxi() {
        return qntd_taxi;
    }

    public int getQntd_lotc() {
        return qntd_lotc;
    }

    public int getQntd_onibus_urb() {
        return qntd_onibus_urb;
    }

    public int getQntd_onb_int() {
        return qntd_onb_int;
    }

    public int getQntd_caminhao() {
        return qntd_caminhao;
    }

    public int getQntd_moto() {
        return qntd_moto;
    }

    public int getQntd_carroca() {
        return qntd_carroca;
    }

    public int getQntd_bicicleta() {
        return qntd_bicicleta;
    }
*/
    @Override
    public String toString() {
        return "Acidente{" + "nome_rua= " + nome_rua + " tp_acidente= " + tp_acidente + " data= " + data;
    }

}
