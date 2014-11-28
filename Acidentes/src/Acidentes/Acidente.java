
package Acidentes;

import java.util.Date;

public class Acidente {

    private String pref_rua;
    private String nome_rua;
    private String tp_acidente;
    private Date data;
    private String dia_sem;
    private int feriados;
    private String tempo;
    private String turno;
    private String regiao;
    private int morte;
    private int morte_post;
    private int fatais;
    private int auto;
    private int taxi;
    private int lotacao;
    private int onb_urb;
    private int onb_int;
    private int caminhao;
    private int moto;
    private int carroca;
    private int bicicleta;

    public Acidente(String pref_rua, String nome_rua, String tp_acidente, Date data, String dia_sem, int fer
            , String turno, String reg, int morte, int morte_post, int fatais, int auto, int taxi
            , int lotacao, int onb_urb, int onb_int, int caminhao, int moto, int carroca, int bicicleta, String temp) {
        this.pref_rua = pref_rua;
        this.nome_rua = nome_rua;
        this.tp_acidente = tp_acidente;
        this.data = data;
        this.dia_sem = dia_sem;
        this.feriados = fer;
        this.morte = morte;
        this.morte_post = morte_post;
        this.fatais = fatais;
        this.auto = auto;
        this.taxi = taxi;
        this.lotacao = lotacao;
        this.onb_urb = onb_urb;
        this.onb_int = onb_int;
        this.caminhao = caminhao;
        this.moto = moto;
        this.carroca = carroca;
        this.bicicleta = bicicleta;
        this.turno = turno;
        this.tempo = temp;
        this.regiao = reg;
    }

    
    public String getPref_rua() {
        return pref_rua;
    }

    public String getNome_rua() {
        return nome_rua;
    }

    public String getTp_acidente() {
        return tp_acidente;
    }

  public Date getData() {
        return this.data;
    }

    public String getDia_sem() {
        return dia_sem;
    }
    
     public int getQntd_feriados() {
        return feriados;
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

   
    public int getQntd_morte() {
        return morte;
    }

    public int getQntd_morte_post() {
        return morte_post;
    }

    public int getQntd_fatais() {
        return fatais;
    }

    public int getQntd_auto() {
        return auto;
    }

    public int getQntd_taxi() {
        return taxi;
    }

    public int getQntd_lotc() {
        return lotacao;
    }

    public int getQntd_onibus_urb() {
        return onb_urb;
    }

    public int getQntd_onb_int() {
        return onb_int;
    }

    public int getQntd_caminhao() {
        return caminhao;
    }

    public int getQntd_moto() {
        return moto;
    }

    public int getQntd_carroca() {
        return carroca;
    }

    public int getQntd_bicicleta() {
        return bicicleta;
    }

    @Override
    public String toString() {
        return "Acidente: " + "pref_rua=" + pref_rua + ", nome_rua=" + nome_rua + ", tp_acidente=" + tp_acidente + ", data=" + data + ", dia_sem=" + dia_sem + ", feriados=" + feriados + ", tempo=" + tempo + ", turno=" + turno + ", regiao=" + regiao + ", morte=" + morte + ", morte_post=" + morte_post + ", fatais=" + fatais + ", auto=" + auto + ", taxi=" + taxi + ", lotacao=" + lotacao + ", onb_urb=" + onb_urb + ", onb_int=" + onb_int + ", caminhao=" + caminhao + ", moto=" + moto + ", carroca=" + carroca + ", bicicleta=" + bicicleta;
    }

        
    
}
